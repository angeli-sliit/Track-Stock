<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.Date, java.text.SimpleDateFormat"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ page import="auth.DbConn" %>

<%
    HttpSession session1 = request.getSession(); 
    if(session1.getAttribute("login_state") == null){
        response.sendRedirect("../Login/Login.jsp");
        return;
    }

    String startDateStr = request.getParameter("start-date");
    String endDateStr = request.getParameter("end-date");

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date startDate = null;
    Date endDate = null;

    if (startDateStr != null && !startDateStr.isEmpty() && endDateStr != null && !endDateStr.isEmpty()) {
        try {
            startDate = dateFormat.parse(startDateStr);
            endDate = dateFormat.parse(endDateStr);
        } catch (Exception e) {
            out.println("<p>Error parsing dates: " + e.getMessage() + "</p>");
        }
    }

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String query = "SELECT s.AddedDate, p.prodName, p.Price, s.Quantity, s.TotalPrice " +
                   "FROM sales AS s INNER JOIN products AS p ON p.prodId = s.productId " +
                   "WHERE s.AddedDate BETWEEN ? AND ?";
    
    try {
        conn = DbConn.getConnection();
        stmt = conn.prepareStatement(query);
        if (startDate != null && endDate != null) {
            stmt.setDate(1, new java.sql.Date(startDate.getTime()));
            stmt.setDate(2, new java.sql.Date(endDate.getTime()));
            rs = stmt.executeQuery();
        } else {
            out.println("<p>Please provide both start and end dates.</p>");
        }
    } catch (Exception e) {
        out.println("<p>Error retrieving records: " + e.getMessage() + "</p>");
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Track-Stock - Sales By Date</title>
<link rel="icon" type="image/x-icon" href="../src/icon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<style>
    body {
        background-color: #f4f4f9;
        font-family: 'Arial', sans-serif;
    }
    .container {
        margin-top: 30px;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
    }
    h1 {
        color: #007bff;
        font-weight: bold;
    }
    h4 {
        color: #6c757d;
    }
    .table-border {
        border-collapse: collapse;
        width: 100%;
        margin-top: 20px;
    }
    .table-border th, .table-border td {
        border: 1px solid #ddd;
        padding: 12px;
    }
    .table-border th {
        background-color: #007bff;
        color: #ffffff;
        text-align: center;
    }
    .table-border td {
        text-align: right;
    }
    .text-center {
        text-align: center;
    }
    .profit {
        color: #28a745;
        font-weight: bold;
    }
    .margin {
        color: #dc3545;
        font-weight: bold;
    }
    .overall {
        margin-top: 20px;
    }
</style>
</head>
<body>
<div class="container">
    <h1 class="text-center">Sales Report - Sales By Dates</h1>
    <h4 class="text-center">This is a computer-generated report, no signature required.</h4>
    <table class="table table-border">
        <thead>
            <tr>
                <th>Date</th>
                <th>Product Title</th>
                <th>Buying Price (Rs.)</th>
                <th>Selling Price (Rs.)</th>
                <th>Sold Qty</th>
                <th>Total (Rs.)</th>
                <th>Profit (Rs.)</th>
                <th>Profit Margin</th>
            </tr>
        </thead>
        <tbody>
    <% 
        double totalCost = 0.0;
        double totalRevenue = 0.0;
        double totalProfit = 0.0;
        double totalProfitMargin = 0.0;
          
        if (rs != null) {
            while (rs.next()) {
                double buyingPrice = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");
                double totalPrice = rs.getDouble("TotalPrice");
                double sellingPrice = totalPrice / quantity;
                double profit = (sellingPrice - buyingPrice) * quantity;
                double profitMargin = (profit / totalPrice) * 100;

                totalCost += buyingPrice * quantity;
                totalRevenue += totalPrice;
                totalProfit = totalRevenue - totalCost;
                totalProfitMargin = (totalProfit / totalRevenue) * 100;
        %>
        <tr>
            <td><%= rs.getDate("AddedDate") %></td>
            <td style="text-align: left;"><%= rs.getString("prodName") %></td>
            <td><%= String.format("%.2f", buyingPrice) %></td>
            <td><%= String.format("%.2f", sellingPrice) %></td>
            <td><%= quantity %></td>
            <td><%= String.format("%.2f", totalPrice) %></td>
            <td class="profit"><%= String.format("%.2f", profit) %></td>
            <td class="margin"><%= String.format("%.2f", profitMargin) + "%" %></td>
        </tr>
        <% 
            }
        }
    %>
    </tbody>
    </table>

    <% if (rs != null) { %>
        <div class="overall text-center">
            <h3>Overall Profit: Rs. <span class="profit"><%= String.format("%.2f", totalProfit) %></span></h3>
            <h3>Overall Profit Margin: <span class="margin"><%= String.format("%.2f", totalProfitMargin) + "%" %></span></h3>
        </div>
    <% } %>
</div>
</body>
</html>

<%
    // Clean up
    if (rs != null) rs.close();
    if (stmt != null) stmt.close();
    if (conn != null) conn.close();
%>
