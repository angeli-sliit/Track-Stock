<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpSession"%>

<%@ include file="../Header/header.jsp" %>

<% HttpSession Se1 = request.getSession(); %>


<% if(se1.getAttribute("login_state")== null){
	response.sendRedirect("../Login/Login.jsp");
} %>

<!-- Main content of your JSP page goes here -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Track-Stock - Home</title>
 <link rel="icon" type="image/x-icon" href="../src/icon.png">
</head>
<body>
<div class="page">
  <div class="container-fluid">
<div class="row">
  <div class="col-md-12">
      </div>
 <div class="col-md-12">
    <div class="panel">
      <div class="jumbotron text-center">
         <h1>Welcome User <hr> Inventory Management System</h1>
         <p>Browes around to find out the pages that you can access!</p>
      </div>
    </div>
    </div>
    </div>
 </div>
</div>
</body>
</html>