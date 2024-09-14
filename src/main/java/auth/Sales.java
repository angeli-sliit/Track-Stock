package auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ItemsHandler")
public class Sales extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // SalesData class to hold sales information
    public static class SalesData {
        private String salesId;
        private String productId;
        private String addedDate;
        private int quantity;
        private double totalPrice;
        private String userEmail;

        // Constructor
        public SalesData(String salesId, String productId, String addedDate, int quantity, double totalPrice, String userEmail) {
            this.salesId = salesId;
            this.productId = productId;
            this.addedDate = addedDate;
            this.quantity = quantity;
            this.totalPrice = totalPrice;
            this.userEmail = userEmail;
        }

        // Getters and Setters
        public String getSalesId() { return salesId; }
        public void setSalesId(String salesId) { this.salesId = salesId; }

        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }

        public String getAddedDate() { return addedDate; }
        public void setAddedDate(String addedDate) { this.addedDate = addedDate; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public double getTotalPrice() { return totalPrice; }
        public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

        public String getUserEmail() { return userEmail; }
        public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    }

    
    //this used in prev method
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<SalesData> salesList = getAllSales();
        request.setAttribute("salesList", salesList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/Dashboard/admin.jsp");
        dispatcher.forward(request, response);
        System.out.println("Sales List: " + salesList); // Check if this prints the expected list
    }
    
    
    
    //Implementation of Delete Sales Method
    public void deleteSales(String recId, String successRedirect, String falseRedirect, HttpServletResponse response) {
        String sql = "DELETE FROM `sales` WHERE SalesId=?";

        try (Connection conn = DbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, recId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                response.sendRedirect(successRedirect + "?message=Sales+deleted+successfully");
            } else {
                response.sendRedirect(falseRedirect + "?message=Sales+not+found");
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                response.sendRedirect(falseRedirect + "?message=Error+deleting+sales");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    
    
    //Implementation of Add Sale Method
    public void addsale(String recId, String successRedirect, String falseRedirect, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String prodId = request.getParameter("prodId");
        String quantityStr = request.getParameter("quantity");
        String priceStr = request.getParameter("price");
        String saleDate = request.getParameter("sale_date");
        String email = (String) session.getAttribute("email");

        if (prodId == null || quantityStr == null || priceStr == null || saleDate == null) {
            System.out.println("Error: Missing required parameters.");
            return;
        }

        int quantity;
        double price;
        try {
            quantity = Integer.parseInt(quantityStr);
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format for quantity or price.");
            return;
        }

        double totalPrice = quantity * price;

        String insertSaleQuery = "INSERT INTO `sales`(`productId`, `AddedDate`, `Quantity`, `TotalPrice`, `UserEmail`) VALUES (?,?,?,?,?)";
        String updateProductQuery = "UPDATE `products` SET `Quantity` = `Quantity` - ? WHERE `prodId` = ?";

        try (Connection con = DbConn.getConnection();
             PreparedStatement insertSalePs = con.prepareStatement(insertSaleQuery);
             PreparedStatement updateProductPs = con.prepareStatement(updateProductQuery)) {

            // Insert sale
            insertSalePs.setString(1, prodId);
            insertSalePs.setString(2, saleDate);
            insertSalePs.setInt(3, quantity);
            insertSalePs.setDouble(4, totalPrice);
            insertSalePs.setString(5, email);
            int rowsAffected = insertSalePs.executeUpdate();

            if (rowsAffected > 0) {
                // Update product quantity
                updateProductPs.setInt(1, quantity);
                updateProductPs.setString(2, prodId);
                int productRowsAffected = updateProductPs.executeUpdate();

                if (productRowsAffected > 0) {
                    response.sendRedirect(successRedirect + "?message=Sale Added Successfully&type=success");
                } else {
                    response.sendRedirect(falseRedirect + "?message=Sale Adding Failed&type=error");
                }
            } else {
                response.getWriter().println("Error: No rows affected.");
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
            try {
                response.getWriter().println("Error: " + e.getMessage());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    //This is Return list of items in a array list
    // this method is not used any longer
    public ArrayList<SalesData> getAllSales() {
        ArrayList<SalesData> salesList = new ArrayList<>();
        String query = "SELECT * FROM sales";

        try (Connection conn = DbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String salesId = rs.getString("SalesId");
                String productId = rs.getString("productId");
                String addedDate = rs.getString("AddedDate");
                int quantity = rs.getInt("Quantity");
                double totalPrice = rs.getDouble("TotalPrice");
                String userEmail = rs.getString("UserEmail");

                SalesData sale = new SalesData(salesId, productId, addedDate, quantity, totalPrice, userEmail);
                salesList.add(sale);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return salesList;
    }
}
