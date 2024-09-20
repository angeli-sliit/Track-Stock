<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../Dashboard/headeradmin.jsp" %>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="auth.DbConn" %>

<%
    String id = request.getParameter("id");
    String email = "";
    String access = "";
    String state = "";

    try (Connection conn = DbConn.getConnection();
         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM registered_user WHERE User_ID = ?")) {
        
        pstmt.setString(1, id);  
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                email = rs.getString("email");
                access = rs.getString("Access_level");
                state = rs.getString("Access_state");
            }
        }
    } catch (SQLException | ClassNotFoundException e) {
        e.printStackTrace();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Track-Stock - Edit Access</title>
</head>
<body>
<div class="page">
  <div class="container-fluid">
    <div class="login-page">
      <div class="text-center">
         <h3>Edit Group</h3>
      </div>
      <form method="post" action="../../editaccess?id=<%=id %>" class="clearfix">
        <div class="form-group">
          <label for="name" class="control-label">Group Name</label>
          <input type="text" class="form-control" style="pointer-events:none" name="email" value="<%= email != null ? email : "N/A" %>">
        </div>
        <div class="form-group">
          <label for="access">Access Level</label>
          <select class="form-control" name="access_level">
            <option value="1" <%= "1".equals(access) ? "selected" : "" %>>Admin</option>
            <option value="2" <%= "2".equals(access) ? "selected" : "" %>>Special</option>
            <option value="3" <%= "3".equals(access) ? "selected" : "" %>>User</option>
          </select>
        </div>
        <div class="form-group">
          <label for="status">Status</label>
          <select class="form-control" name="status">
            <option value="Active" <%= "Active".equals(state) ? "selected" : "" %>>Active</option>
            <option value="Deactive" <%= "Deactive".equals(state) ? "selected" : "" %>>Deactive</option>
          </select>
        </div>
        <div class="form-group clearfix">
          <button type="submit" name="update" class="btn btn-info">Update</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
