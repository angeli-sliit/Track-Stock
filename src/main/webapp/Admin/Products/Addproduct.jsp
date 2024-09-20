<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../Dashboard/headeradmin.jsp" %>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="auth.DbConn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Track-Stock - Add Product</title>
</head>
<body>
<div class="page">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12"></div>
        <% 
// Retrieve the session attributes


String msgs = (String) session.getAttribute("message");
String messageType = (String) session.getAttribute("state");
String displayMessage = "";

System.out.println(msgs);
System.out.println(messageType);


if (msgs != null && !msgs.isEmpty()) {
    if ("success".equalsIgnoreCase(messageType)) {
        displayMessage = "<div id='alert-message' class='alert alert-success'><a href='#' class='close' data-dismiss='alert'>×</a>" + msgs + "</div>";
    } else if ("error".equalsIgnoreCase(messageType)) {
        displayMessage = "<div id='alert-message' class='alert alert-danger'><a href='#' class='close' data-dismiss='alert'>×</a>" + msgs + "</div>";
    } else {
        displayMessage = "<div id='alert-message' class='alert alert-info'><a href='#' class='close' data-dismiss='alert'>×</a>" + msgs + "</div>";
    }

    // Clear the session attributes after displaying the message
    session.removeAttribute("message");
    session.removeAttribute("state");
}
%>

<%= displayMessage %>
    </div>
    <div class="row">
      <div class="col-md-8">
        <div class="panel panel-default">
          <div class="panel-heading">
            <strong>
              <span class="glyphicon glyphicon-th"></span>
              <span>Add New Product</span>
            </strong>
          </div>
          <div class="panel-body">
            <div class="col-md-12">
              <form method="post" action="${pageContext.request.contextPath}/ProductServlet?action=add" class="clearfix">
                <div class="form-group">
                  <div class="input-group">
                    <span class="input-group-addon">
                      <i class="glyphicon glyphicon-th-large"></i>
                    </span>
                    <input type="text" class="form-control" name="product-title" placeholder="Product Title">
                  </div>
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-md-6">
                      <select class="form-control" name="product-categorie">
                        <option value="">Select Product Category</option>
                        <%
                         
                          Connection conn = null;
                          PreparedStatement stmt = null;
                          ResultSet rs = null;

                          try {
                            conn = DbConn.getConnection();
                            String sql = "SELECT * FROM product_category"; 
                            stmt = conn.prepareStatement(sql);
                            rs = stmt.executeQuery();

                            while (rs.next()) {
                              int categoryId = rs.getInt("product_cat_Id");
                              String categoryName = rs.getString("product_category");
                        %>
                        <option value="<%= categoryId %>"><%= categoryName %></option>
                        <%
                            }
                          } catch (SQLException e) {
                            e.printStackTrace();
                        } finally {
                          try {
                            if (rs != null) rs.close();
                            if (stmt != null) stmt.close();
                            if (conn != null) conn.close();
                          } catch (SQLException e) {
                            e.printStackTrace();
                          }
                        }
                        %>
                      </select>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <div class="row">
                    <div class="col-md-4">
                      <div class="input-group">
                        <span class="input-group-addon">
                          <i class="glyphicon glyphicon-shopping-cart"></i>
                        </span>
                        <input type="number" class="form-control" name="product-quantity" placeholder="Product Quantity">
                      </div>
                    </div>
                    <div class="col-md-4">
                      <div class="input-group">
                        <span class="input-group-addon">
                          <i class="glyphicon glyphicon-usd"></i>
                        </span>
                        <input type="number" class="form-control" name="Price" placeholder="Price">
                        <span class="input-group-addon">.00</span>
                      </div>
                    </div>
                    <div class="col-md-4"></div>
                  </div>
                </div>
                <button type="submit" name="add_product" class="btn btn-danger">Add Product</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
