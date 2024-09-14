<%@ include file="headeradmin.jsp" %>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="auth.DbConn" %>
<%
    HttpServletRequest httpRequest = (HttpServletRequest) pageContext.getRequest();
    String contextPath = httpRequest.getContextPath();
%>

<title>Track-Stock - AdminDashboard</title>


<style>
.panel-box{
height:50%  !important;
}
</style>

 

<div class="page">
    <div class="container-fluid">

        <!-- Welcome Alert -->
        <div class="row">
            <div class="col-md-6">
                <div class="alert alert-success" style="opacity:0">
                    <a href="#" class="close" data-dismiss="alert">�</a>Welcome to Inventory Management System
                </div>   
            </div>
        </div>

        <!-- Dashboard Panels -->
        <div class="row">
            <!-- Users panel -->
            <a href="users.php" style="color:black;">
                <div class="col-md-3">
                    <div class="panel panel-box clearfix h-10px">
                        <div class="panel-icon pull-left bg-secondary1">
                            <i class="glyphicon glyphicon-user"></i>
                        </div>
                        <div class="panel-value pull-right">
                              <h2 class="margin-top"><%= request.getAttribute("userCount") %></h2>
                            <p class="text-muted">Users</p>
                        </div>
                    </div>
                </div>
            </a>

            <!-- Categories panel -->
            <a href="categorie.php" style="color:black;">
                <div class="col-md-3">
                    <div class="panel panel-box clearfix">
                        <div class="panel-icon pull-left bg-red">
                            <i class="glyphicon glyphicon-th-large"></i>
                        </div>
                        <div class="panel-value pull-right">
                         <% 
    							int rowCount_category = 0; 

  								  try (Connection conn = DbConn.getConnection();
        								PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM product_category");
         								ResultSet rs = pstmt.executeQuery()) {

        						 		while (rs.next()) {
            							rowCount_category++;  
        							 }

    							 } 
  								 catch (SQLException | ClassNotFoundException e) {
        								e.printStackTrace();
    							 }
				%>
                            <h2 class="margin-top"> <%= rowCount_category %> </h2>
                            <p class="text-muted">Categories</p>
                        </div>
                    </div>
                </div>
            </a>

            <!-- Products panel -->
            <a href="product.php" style="color:black;">
                <div class="col-md-3">
                    <div class="panel panel-box clearfix">
                        <div class="panel-icon pull-left bg-blue2">
                            <i class="glyphicon glyphicon-shopping-cart"></i>
                        </div>
                        <div class="panel-value pull-right">
                         <% 
    							int rowCount_products= 0; 

  								  try (Connection conn = DbConn.getConnection();
        								PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM products");
         								ResultSet rs = pstmt.executeQuery()) {

        						 		while (rs.next()) {
            							rowCount_products++;  
        							 }

    							 } 
  								 catch (SQLException | ClassNotFoundException e) {
        								e.printStackTrace();
    							 }
				%>
                            <h2 class="margin-top"> <%= rowCount_products %></h2>
                            <p class="text-muted">Products</p>
                        </div>
                    </div>
                </div>
            </a>

            <!-- Sales panel -->
            <a href="sales.php" style="color:black;">
                <div class="col-md-3">
                    <div class="panel panel-box clearfix">
                        <div class="panel-icon pull-left bg-green">
                            <i class="glyphicon glyphicon-usd"></i>
                        </div>
                        <div class="panel-value pull-right">
                         <% 
    							double Sum_sales= 0; 

  								  try (Connection conn = DbConn.getConnection();
        								PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM sales");
         								ResultSet rs = pstmt.executeQuery()) {

        						 		while (rs.next()) {
        						 			Sum_sales += rs.getDouble("TotalPrice");    
        							 }

    							 } 
  								 catch (SQLException | ClassNotFoundException e) {
        								e.printStackTrace();
    							 }
				%>
                            <h2 class="margin-top"> Rs.<%= Sum_sales %></h2>
                            <p class="text-muted">Sales</p>
                        </div>
                    </div>
                </div>
            </a>
        </div>

        <!-- Highest Selling Products Panel -->
        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong>
                            <span class="glyphicon glyphicon-th"></span>
                            <span>Highest Selling Products</span>
                        </strong>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-condensed">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Added Date</th>
                                    <th>Total Price</th>
                                    <th>No of Pcs</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                try (Connection conn = DbConn.getConnection();
                                     PreparedStatement pstmt = conn.prepareStatement(
                                         "SELECT s.AddedDate, p.ProdName, SUM(s.TotalPrice) AS TotalPrice, COUNT(s.Quantity) AS couQU " +
                                         "FROM sales AS s " +
                                         "INNER JOIN products AS p ON p.prodId = s.productId " +
                                         "GROUP BY p.ProdName " +
                                         "ORDER BY couQU DESC LIMIT 8");
                                     ResultSet rs = pstmt.executeQuery()) {

                                    while (rs.next()) {
                                        String addedDate = rs.getString("AddedDate");
                                        String prodName = rs.getString("ProdName");
                                        int count = rs.getInt("couQU");
                                        double totalPrice = rs.getDouble("TotalPrice");
                                %>
                                <tr>
                                    <td><%= prodName != null ? prodName : "N/A" %></td>
                                    <td width="120px"><%= addedDate != null ? addedDate : "N/A" %></td>
                                    <td><%= totalPrice %></td>
                                    <td><%= count %></td>
                                </tr>
                                <% 
                                    }
                                } catch (SQLException | ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Latest Sales Panel -->
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong>
                            <span class="glyphicon glyphicon-th"></span>
                            <span>LATEST SALES</span>
                        </strong>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered table-condensed">
                            <thead>
                                <tr>
                                    <th class="text-center" style="width: 50px;">#</th>
                                    <th>Product Name</th>
                                    <th>Date</th>
                                    <th>Total Sale</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% 
                                try (Connection conn = DbConn.getConnection();
                                     PreparedStatement pstmt = conn.prepareStatement(
                                         "SELECT s.AddedDate, p.ProdName, SUM(s.TotalPrice) AS TotalPrice " +
                                         "FROM sales AS s " +
                                         "INNER JOIN products AS p ON p.prodId = s.productId " +
                                         "GROUP BY p.ProdName, s.AddedDate " +
                                         "ORDER BY s.AddedDate DESC LIMIT 8");
                                     ResultSet rs = pstmt.executeQuery()) {

                                    int index = 1;
                                    while (rs.next()) {
                                        String addedDate = rs.getString("AddedDate");
                                        String prodName = rs.getString("ProdName");
                                        double totalPrice = rs.getDouble("TotalPrice");
                                %>
                                <tr>
                                    <td class="text-center"><%= index++ %></td>
                                    <td><%= prodName != null ? prodName : "N/A" %></td>
                                    <td><%= addedDate != null ? addedDate : "N/A" %></td>
                                    <td><%= totalPrice %></td>
                                </tr>
                                <% 
                                    }
                                } catch (SQLException | ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Recently Added Products Panel -->
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <strong>
                            <span class="glyphicon glyphicon-th"></span>
                            <span>Recently Added Products</span>
                        </strong>
                    </div>
                    <div class="panel-body">
                        <div class="list-group">
<%
    try (Connection conn = DbConn.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(
             "SELECT * FROM products AS p INNER JOIN product_category AS pc ON p.ProductCategory = pc.product_cat_id ORDER BY TotalDate DESC LIMIT 3");
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            String prodId = rs.getString("prodId");
            String prodName = rs.getString("prodName");
            double price = rs.getDouble("Price");
            String category = rs.getString("product_category");
            String image = rs.getString("ProductImage");
           
            String imagepath = (image == null || image.isEmpty()) 
                    ? contextPath + "/src/Sample.png" 
                    : image;
%>
<a class="list-group-item clearfix" href="edit_product.php?id=<%= prodId %>">
    <h4 class="list-group-item-heading">
        <img class="img-avatar img-circle" src="<%= imagepath %>" alt="">
        <%= prodName != null ? prodName : "N/A" %>
        <span class="label label-warning pull-right">$<%= price %></span>
    </h4>
    <span class="list-group-item-text pull-right"><%= category != null ? category : "N/A" %></span>
</a>
<% 
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
%>
                           
                        </div>                 
                    </div>           
                </div>   
            </div>
 
        </div>
</div>