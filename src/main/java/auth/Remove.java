package auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Remove extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String tableName = request.getParameter("table");
        String idColumn = request.getParameter("idColumn");
        String recordId = request.getParameter("id");
        String Return =  request.getParameter("para");

        // Validate parameters
        if (tableName != null && !tableName.isEmpty() &&
            idColumn != null && !idColumn.isEmpty() &&
            recordId != null && !recordId.isEmpty()) {
            try {
                // Attempt to delete the record
                boolean success = deleteRecord(tableName, idColumn, recordId);

                // Redirect based on success or failure
                if (success) {
                    response.sendRedirect(Return + "?message=Record+deleted+successfully");
                } else {
                    response.sendRedirect(Return +"?message=Record+not+found");
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                response.sendRedirect(Return + "message=Error+deleting+record");
            }
        } else {
            response.sendRedirect(Return + "message=Invalid+request");
        }
    }

    // Method to delete a record from the specified table
    private boolean deleteRecord(String tableName, String idColumn, String recordId) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Get a database connection
            conn = DbConn.getConnection();

            // Prepare the SQL DELETE statement
            String sql = "DELETE FROM " + tableName + " WHERE " + idColumn + " = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, recordId);

            // Execute the SQL statement
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } finally {
            // Ensure resources are closed
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
