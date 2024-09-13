<%@ include file="headeradmin.jsp" %>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="auth.Sales.SalesData" %>
<%@ page import="auth.DbConn" %>

<title>Track-Stock - Admin Dashboard</title>

<div class="page">
    <div class="container-fluid">

        <div class="row">
            <div class="col-md-6">
                <div class="alert alert-success" style="opacity:0">
                    <a href="#" class="close" data-dismiss="alert">×</a>Welcome to Inventory Management System
                </div>   
            </div>
        </div>

        <div class="row">
            <!-- Users panel -->
            <a href="users.php" style="color:black;">
                <div class="col-md-3">
                    <div class="panel panel-box clearfix h-10px">
                        <div class="panel-icon pull-left bg-secondary1">
                            <i class="glyphicon glyphicon-user"></i>
                        </div>
                        <div class="panel-value pull-right">
                            <h2 class="margin-top"> 5 </h2>
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
                            <h2 class="margin-top"> 7 </h2>
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
                            <h2 class="margin-top"> 12 </h2>
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
                            <h2 class="margin-top"> 7</h2>
                            <p class="text-muted">Sales</p>
                        </div>
                    </div>
                </div>
            </a>
        </div>

        <!-- Highest Selling Products panel -->
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
                        Connection conn = null;
                        PreparedStatement pstmt = null;
                        ResultSet rs = null;

                        try {
                            conn = DbConn.getConnection();
                            String query = "SELECT s.AddedDate, p.ProdName, SUM(s.TotalPrice) AS TotalPrice, COUNT(s.Quantity) AS couQU " +
                                           "FROM sales AS s " +
                                           "INNER JOIN products AS p ON p.prodId = s.productId " +
                                           "GROUP BY p.ProdName " +
                                           "ORDER BY couQU DESC"; 

                            pstmt = conn.prepareStatement(query);
                            rs = pstmt.executeQuery();
                            
                            while (rs.next()) {
                                String addedDate = rs.getString("AddedDate");
                                String prodName = rs.getString("ProdName");
                                int count = rs.getInt("couQU");
                                double totalPrice = rs.getDouble("TotalPrice");
                        %>
                                <tr>
                                    <td><%= prodName %></td>
                                    <td><%= addedDate %></td>
                                    <td><%= totalPrice %></td>
                                    <td><%= count %></td>
                                </tr>
                        <% 
                            }
                        } catch (SQLException | ClassNotFoundException e) {
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

            <!-- Latest Sales panel -->
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
                                <!-- Sample sales rows -->
                                <tr>
                                    <td class="text-center">1</td>
                                    <td><a href="edit_sale.php?id=8">Disney Woody Action Figure</a></td>
                                    <td>2021-04-04</td>
                                    <td>$110.00</td>
                                </tr>
                                <!-- Add more rows as needed -->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <!-- Recently Added Products panel -->
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
                            <!-- Sample recently added product -->
                            <a class="list-group-item clearfix" href="edit_product.php?id=13">
                                <h4 class="list-group-item-heading">
                                    <img class="img-avatar img-circle" src="uploads/products/no_image.png" alt="">
                                    Small Bubble Cushioning Wrap
                                    <span class="label label-warning pull-right">$19</span>
                                </h4>
                                <span class="list-group-item-text pull-right">Packing Materials</span>
                            </a>
                            <!-- Add more product links as needed -->
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
