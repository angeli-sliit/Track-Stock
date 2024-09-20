<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../Header/header.jsp" %>
<%@ page import="java.sql.*,auth.DbConn" %>
<%@page import="jakarta.servlet.http.HttpSession"%>



<% HttpSession Se1 = request.getSession(); %>


<% if(se1.getAttribute("login_state")== null){
	response.sendRedirect("../Login/Login.jsp");
} %>
<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
        // Use the DbConn class to get a connection
        conn = DbConn.getConnection();
        stmt = conn.createStatement();
        String query = "SELECT * FROM Products";
        rs = stmt.executeQuery(query);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Track-Stock - All Sales</title>
    
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
                            <span>All Sales</span>
                        </strong>
                        <div class="pull-right">
                            <a href="../newsale/newsale.jsp" class="btn btn-primary">Add sale</a>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-bordered table-striped">
                            <thead>
                                <tr>
                                    <th class="text-center" style="width: 50px;">#</th>
                                    <th>Product name</th>
                                    <th class="text-center" style="width: 15%;">Quantity</th>
                                    <th class="text-center" style="width: 15%;">Total Date</th>
                                    <th class="text-center" style="width: 15%;">Category</th>
                                    <th class="text-center" style="width: 100px;">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    while (rs.next()) {
                                %>
                                <tr>
                                    <td class="text-center"><%= rs.getString("prodId") %></td>
                                    <td><%= rs.getString("prodName") %></td>
                                    <td class="text-center"><%= rs.getInt("Quantity") %></td>
                                    <td class="text-center"><%= rs.getString("TotalDate") %></td>
                                    <td class="text-center"><%= rs.getString("ProductCategory") %></td>
                                    <td class="text-center">
                                        <div class="btn-group">
                                            <a href="../updatesales/updatesales.jsp?id=<%= rs.getString("prodId") %>" class="btn btn-warning btn-xs" title="Edit">
                                                <span class="glyphicon glyphicon-edit"></span>
                                            </a>
                                            <a href="../Remove?table=products&idColumn=prodId&id=<%= rs.getString("prodId") %>&para=Addsales/Addsales.jsp" class="btn btn-danger btn-xs" title="Delete">
                                                <span class="glyphicon glyphicon-trash"></span>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                                <%
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

<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }
%>

</body>
</html>
