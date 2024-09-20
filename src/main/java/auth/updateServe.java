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

@WebServlet("/UpdateProductServlet")
public class updateServe extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve parameters from the request
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String cat = request.getParameter("cat");
        String date = request.getParameter("date");
        String path = "updatesales/updatesales.jsp?id="  + id;

        Connection conn = null;
		PreparedStatement pstmt = null;

		try {
		    // Get a database connection
		    conn = DbConn.getConnection();

		    // Prepare the SQL UPDATE statement
		    String sql = "UPDATE products SET prodName=?, Quantity=?, Price=?, ProductCategory=?, TotalDate=? WHERE prodId=?";
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, title);
		    pstmt.setString(2, quantity);
		    pstmt.setString(3, price);
		    pstmt.setString(4, cat);
		    pstmt.setString(5, date);
		    pstmt.setString(6, id);

		    // Execute the SQL statement
		    int rowsAffected = pstmt.executeUpdate();
		    
		    if (rowsAffected > 0) {
		        response.sendRedirect(path + "?message=Product+updated+successfully");
		    } else {
		        response.sendRedirect(path + "?message=Product+not+found");
		    }
		} catch (SQLException | ClassNotFoundException e) {
		    e.printStackTrace();
		    response.sendRedirect(path + "?message=Error+updating+product");
		} finally {
		    // Ensure resources are closed
		    if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
		    if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
    }
}
