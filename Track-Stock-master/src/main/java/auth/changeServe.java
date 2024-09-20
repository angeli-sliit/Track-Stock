package auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class changeServe extends HttpServlet {
    private static final long serialVersionUID = 1L;
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
    	String prodId = request.getParameter("prodId");
        String quantityStr = request.getParameter("quantity");
        String priceStr = request.getParameter("price");
        String saleDate = request.getParameter("sale_date");
        String Email = (String) session.getAttribute("email");

        if (prodId == null || quantityStr == null || priceStr == null || saleDate == null) {
            response.getWriter().println("Error: Missing required parameters.");
            return;
        }

        int quantity = 0;
        double price = 0;
        try {
            quantity = Integer.parseInt(quantityStr);
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            response.getWriter().println("Error: Invalid number format for quantity or price.");
            return;
        }

        double totalPrice = quantity * price;

        String insertSaleQuery = "INSERT INTO `sales`(`productId`, `AddedDate`, `Quantity`, `TotalPrice`,`UserEmail`) VALUES (?,?,?,?,?)";
        String updateProductQuery = "UPDATE `products` SET `Quantity` = `Quantity` - ? WHERE `prodId` = ?";

        try (Connection con = DbConn.getConnection();
             PreparedStatement insertSalePs = con.prepareStatement(insertSaleQuery);
             PreparedStatement updateProductPs = con.prepareStatement(updateProductQuery)) {

            // Insert sale
            insertSalePs.setString(1, prodId);
            insertSalePs.setString(2, saleDate);
            insertSalePs.setInt(3, quantity);
            insertSalePs.setDouble(4, totalPrice);
            insertSalePs.setString(5, Email);
            int rowsAffected = insertSalePs.executeUpdate();

            if (rowsAffected > 0) {
                // Update product quantity
                updateProductPs.setInt(1, quantity);
                updateProductPs.setString(2, prodId);
                int productRowsAffected = updateProductPs.executeUpdate();

                if (productRowsAffected > 0) {
                    response.sendRedirect("newsale/newsale.jsp?message=addsalesuccess");
                } else {
                    response.getWriter().println("Error: Failed to update product quantity.");
                }
            } else {
                response.getWriter().println("Error: No rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("SQL Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            response.getWriter().println("Error: Database connection class not found.");
        }
    }
}
