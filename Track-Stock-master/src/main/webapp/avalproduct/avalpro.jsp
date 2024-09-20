<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,auth.DbConn" %>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ include file="../Header/header.jsp" %>

<% 
    HttpSession session1 = request.getSession(); 
    if(session1.getAttribute("login_state") == null){
        response.sendRedirect("../Login/Login.jsp");
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Track-stock - Available Products</title>
</head>
<body>
<div class="page">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
        <div class="panel panel-default">
          <div class="panel-heading clearfix">
            <strong>
              <span class="glyphicon glyphicon-th"></span>
              <span>All Products</span>
            </strong>
            <div class="pull-right">
              <a href="../newsale/newsale.jsp" class="btn btn-primary">Add Sales</a>
            </div>
          </div>
          <div class="panel-body">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th class="text-center" style="width: 50px;">#</th>
                  <th>Product Name</th>
                  <th class="text-center" style="width: 15%;">Quantity</th>
                  <th class="text-center" style="width: 15%;">Total Date</th>
                  <th class="text-center" style="width: 15%;">Category</th>
                  <th class="text-center" style="width: 15%;">Price</th>
                 
                </tr>
              </thead>
              <tbody>
                <% 
                  Connection conn = null;
                  PreparedStatement pstmt = null;
                  ResultSet rs = null;
                  
                  try {
                      conn = DbConn.getConnection();
                      String query = "SELECT * FROM products";
                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();
                      
                      int count = 1;
                      while (rs.next()) {
                          int prodId = rs.getInt("prodId");
                          String prodName = rs.getString("prodName");
                          int quantity = rs.getInt("Quantity");
                          String totalDate = rs.getString("TotalDate");
                          String category = rs.getString("ProductCategory");
                          double price = rs.getDouble("Price");
                %>
                <tr>
                  <td class="text-center"><%= count++ %></td>
                  <td><%= prodName %></td>
                  <td class="text-center"><%= quantity %></td>
                  <td class="text-center"><%= totalDate %></td>
                  <td class="text-center"><%= category %></td>
                  <td class="text-center"><%= price %></td>
                </tr>
                <% 
                      }
                  } catch (SQLException e) {
                      e.printStackTrace();
                  } finally {
                      if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                      if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                      if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                  }
                %>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
