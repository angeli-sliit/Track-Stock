package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductSearchServlet")
public class ProductSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String search = request.getParameter("search");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try (Connection conn = DbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT prodId, prodName FROM products WHERE prodName LIKE ?")) {
            
            pstmt.setString(1, "%" + search + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    out.println("<li class='list-group-item' data-prodid='" + rs.getInt("prodId") + "'>"
                            + rs.getString("prodName") + "</li>");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
    }
}
