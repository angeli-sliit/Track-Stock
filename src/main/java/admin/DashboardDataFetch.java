package admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import auth.DbConn;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DashboardDataFetch extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DbConn.getConnection()) {
            // Fetch users
            int userCount = getRowCount(conn, "SELECT COUNT(*) FROM registered_user");

            // Fetch categories
            int categoryCount = getRowCount(conn, "SELECT COUNT(*) FROM product_category");

            // Fetch products
            int productCount = getRowCount(conn, "SELECT COUNT(*) FROM products");

            // Fetch sales
            double totalSales = getTotalSales(conn);

            // Set attributes to be passed to JSP
            request.setAttribute("userCount", userCount);
            request.setAttribute("categoryCount", categoryCount);
            request.setAttribute("productCount", productCount);
            request.setAttribute("totalSales", totalSales);

            // Forward the request to the JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Dashboard/admin.jsp");
            dispatcher.forward(request, response);
        

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Helper method to get row count
    private int getRowCount(Connection conn, String query) throws SQLException {
        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return 0;
    }

    // Helper method to get total sales
    private double getTotalSales(Connection conn) throws SQLException {
        double totalSales = 0;
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT SUM(TotalPrice) FROM sales");
             ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                totalSales = rs.getDouble(1);
            }
        }
        return totalSales;
    }
}
