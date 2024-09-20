<%@ page import="java.sql.*, auth.DbConn" %>
<%@ page import="jakarta.servlet.http.HttpSession"%>
<%@ include file="../Header/header.jsp" %>

<% 
    HttpSession session1 = request.getSession(); 
    if(session1.getAttribute("login_state") == null){
        response.sendRedirect("../Login/Login.jsp");
    }
%>
<%
//Get user ID from session or request
String userId = session1.getAttribute("username").toString();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Track-stock - Profile Settings</title>
</head>
<body>
<div class="page">
  <div class="container-fluid">
<div class="row">
  <div class="col-md-12">
      </div>
  <div class="col-md-6">
      <div class="panel panel-default">
        <div class="panel-heading">
          <div class="panel-heading clearfix">
            <span class="glyphicon glyphicon-camera"></span>
            <span>Change My photo</span>
          </div>
        </div>
        
        <div class="panel-body">
          <div class="row">
            <% 
                    Connection conn = null;
                    PreparedStatement pstmt = null;
                    ResultSet rs = null;

                    try {
                        conn = DbConn.getConnection();
                        String query = "SELECT user_profile_img FROM registered_user WHERE username = ?";
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1, userId);
                        rs = pstmt.executeQuery();

                        if (rs.next()) {
                            String imageUrl = rs.getString("user_profile_img");
                            if (imageUrl != null && !imageUrl.isEmpty()) {
                %>
                <img class="img-circle img-size-2 " style="object-fit:cover" src="../images/<%=imageUrl%>" alt="Profile Image">
                <% 
                            } else {
                %>
                <img class="img-circle img-size-2" src="../src/profile.png" alt="Default Profile Image">
                <% 
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        if (pstmt != null) try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                    }
                %>
            <div class="col-md-8">
              <form class="form" action="edit_account.php" method="POST" enctype="multipart/form-data">
              <div class="form-group">
                <input type="file" name="file_upload" multiple="multiple" placeholder="add" class="btn btn-default btn-file">
              </div>
              <div class="form-group">
                <input type="hidden" name="user_id" value="3">
                 <button type="submit" name="submit" class="btn btn-warning">Change</button>
              </div>
             </form>
            </div>
          </div>
        </div>
      </div>
  </div>
  <div class="col-md-6">
    <div class="panel panel-default">
      <div class="panel-heading clearfix">
        <span class="glyphicon glyphicon-edit"></span>
        <span>Edit My Account</span>
      </div>
      <div class="panel-body">
          <form method="post" action="edit_account.php?id=3" class="clearfix">
            <div class="form-group">
                  <label for="name" class="control-label">Name</label>
                  <input type="name" class="form-control" name="name" value="Christopher">
            </div>
            <div class="form-group">
                  <label for="username" class="control-label">Username</label>
                  <input type="text" class="form-control" name="username" value="User">
            </div>
            <div class="form-group clearfix">
                    <a href="change_password.php" title="change password" class="btn btn-danger pull-right">Change Password</a>
                    <button type="submit" name="update" class="btn btn-info">Update</button>
            </div>
        </form>
      </div>
    </div>
  </div>
</div>


     </div>
    </div>
</body>
</html>
