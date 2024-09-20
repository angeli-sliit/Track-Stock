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
<title>Track-Stock - Daily Sales</title>
</head>
<body>
<div class="page">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-6"></div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <div class="panel panel-default">
          <div class="panel-heading clearfix">
            <strong>
              <span class="glyphicon glyphicon-th"></span>
              <span>Monthly Sales</span>
            </strong>
          </div>
          <div class="panel-body">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th class="text-center" style="width: 50px;">#</th>
                  <th>Product Name</th>
                  <th class="text-center" style="width: 15%;">Quantity Sold(Pcs)</th>
                  <th class="text-center" style="width: 15%;">Total(Rs)</th>
                  <th class="text-center" style="width: 15%;">Sale Date</th>
                </tr>
              </thead>
              <tbody>
                <%
                  Connection conn = null;
                  PreparedStatement pstmt = null;
                  ResultSet rs = null;

                  try {
                      conn = DbConn.getConnection();
                      String query = "SELECT s.SalesId, p.prodName, s.Quantity, s.TotalPrice, s.AddedDate " +
                              "FROM sales s JOIN products p ON s.productId = p.prodId " +
                              "WHERE DAY(s.AddedDate) = DAY(CURDATE()) " +
                              "ORDER BY s.AddedDate DESC";

                      pstmt = conn.prepareStatement(query);
                      rs = pstmt.executeQuery();

                      int count = 1;
                      while (rs.next()) {
                          String prodName = rs.getString("prodName");
                          int quantity = rs.getInt("Quantity");
                          double totalPrice = rs.getDouble("TotalPrice");
                          String addedDate = rs.getString("AddedDate");
                          double total = quantity * totalPrice;
                %>
                <tr>
                  <td class="text-center"><%= count++ %></td>
                  <td><%= prodName %></td>
                  <td class="text-center"><%= quantity %></td>
                  <td class="text-center"><%= total %></td>
                  <td class="text-center"><%= addedDate %></td>
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
