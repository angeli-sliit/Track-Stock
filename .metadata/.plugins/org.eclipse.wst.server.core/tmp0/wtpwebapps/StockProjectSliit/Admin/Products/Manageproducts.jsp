<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../Dashboard/headeradmin.jsp" %>
<%@ page import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<%@ page import="auth.DbConn" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Track-Stock - Manage Products</title>
    
</head>
<body>
<div class="page">
  <div class="container-fluid">
    <div class="row">
      <div class="col-md-12">
      <% 
        String msgs = (String) session.getAttribute("message");
        String messageType = (String) session.getAttribute("state");
        String displayMessage = "";

        if (msgs != null && !msgs.isEmpty()) {
            if ("success".equalsIgnoreCase(messageType)) {
                displayMessage = "<div id='alert-message' class='alert alert-success'><a href='#' class='close' data-dismiss='alert'>×</a>" + msgs + "</div>";
            } else if ("error".equalsIgnoreCase(messageType)) {
                displayMessage = "<div id='alert-message' class='alert alert-danger'><a href='#' class='close' data-dismiss='alert'>×</a>" + msgs + "</div>";
            } else {
                displayMessage = "<div id='alert-message' class='alert alert-info'><a href='#' class='close' data-dismiss='alert'>×</a>" + msgs + "</div>";
            }
            session.removeAttribute("message");
            session.removeAttribute("state");
        }
      %>

      <%= displayMessage %>
        <div class="panel panel-default">
          <div class="panel-heading clearfix">
            <div class="pull-right">
              <a href="add_product.jsp" class="btn btn-primary">Add New</a>
            </div>
          </div>
          <div class="panel-body">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th class="text-center" style="width: 50px;">Product ID</th>
                  <th>Photo</th>
                  <th>Product Title</th>
                  <th class="text-center" style="width: 10%;">Categories</th>
                  <th class="text-center" style="width: 15%;">In-Stock(Pcs)</th>
                  <th class="text-center" style="width: 10%;">Buying Price</th>
                  <th class="text-center" style="width: 20%;">Added Date</th>
                  <th class="text-center" style="width: 100px;">Actions</th>
                </tr>
              </thead>
              <tbody>
                <% 
                  try (Connection conn = DbConn.getConnection();
                       PreparedStatement pstmt = conn.prepareStatement(
                          "SELECT * FROM products AS p INNER JOIN product_category AS pc ON p.ProductCategory = pc.product_cat_id");
                       ResultSet rs = pstmt.executeQuery()) {

                    while (rs.next()) {
                      String prodId = rs.getString("prodId");
                      String prodName = rs.getString("ProdName");
                      String quantity = rs.getString("Quantity");
                      String totalDate = rs.getString("TotalDate");
                      String category = rs.getString("product_category");
                      String price = rs.getString("Price");
                %>
                <tr>
                  <td class="text-center"><%= prodId %></td>
                  <td>
                    <img class="img-avatar img-circle" src="uploads/products/no_image.png" alt="">
                  </td>
                  <td><%= prodName %></td>
                  <td class="text-center"><%= category %></td>
                  <td class="text-center"><%= quantity %></td>
                  <td class="text-center"><%= price %></td>
                  <td class="text-center"><%= totalDate %></td>
                  <td class="text-center">
                    <div class="btn-group">
                      <!-- Trigger the edit modal -->
                      <button type="button" class="btn btn-info btn-xs" data-toggle="modal" data-target="#editModal<%=prodId%>">
                        <span class="glyphicon glyphicon-edit"></span>
                      </button>
                      <!-- Trigger the delete confirmation modal -->
                      <button type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteModal<%=prodId%>">
                        <span class="glyphicon glyphicon-trash"></span>
                      </button>
                    </div>
                  </td>
                </tr>

                <!-- Modal for Editing Product -->
                <div class="modal fade" id="editModal<%=prodId%>" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="editModalLabel">Edit Product</h4>
                      </div>
                      <div class="modal-body">
                        <form method="post" action="${pageContext.request.contextPath}/ProductServlet?id=<%=prodId%>&action=update">
                          <div class="form-group">
                            <label for="product-title">Product Title</label>
                            <input type="text" class="form-control" name="product-title" value="<%=prodName%>">
                          </div>
                          <div class="form-group">
                            <label for="product-category">Product Category</label>
                            <select class="form-control" name="product-category">
                              <option value="">Select Product Category</option>
                              <%
                                try (Connection conn1 = DbConn.getConnection();
                                     PreparedStatement stmt1 = conn1.prepareStatement("SELECT * FROM product_category");
                                     ResultSet rs1 = stmt1.executeQuery()) {
                                  String currentCategoryId = rs.getString("ProductCategory");
                                  while (rs1.next()) {
                                    int categoryId = rs1.getInt("product_cat_Id");
                                    String categoryName = rs1.getString("product_category");
                                    String selected = categoryId == Integer.parseInt(currentCategoryId) ? "selected" : "";
                              %>
                              <option value="<%= categoryId %>" <%= selected %>><%= categoryName %></option>
                              <% 
                                  }
                                } catch (SQLException e) {
                                  e.printStackTrace();
                                }
                              %>
                            </select>
                          </div>
                          <div class="form-group">
                            <label for="product-quantity">Quantity</label>
                            <input type="number" class="form-control" name="product-quantity" value="<%=quantity%>">
                          </div>
                          <div class="form-group">
                            <label for="price">Price</label>
                            <input type="number" class="form-control" name="price" value="<%=price%>">
                          </div>
                          <button type="submit" class="btn btn-primary">Save changes</button>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- End Edit Modal -->

                <!-- Delete Confirmation Modal -->
                <div class="modal fade" id="deleteModal<%=prodId%>" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
                  <div class="modal-dialog" role="document">
                    <div class="modal-content" style="background-color:white; color: black;">
                      <div class="modal-header">
                        <h5 class="modal-title" id="deleteModalLabel">Confirm Deletion</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="color: white;">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body">
                        <p>Are you sure you want to delete the product "<%= prodName %>"?</p>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <a href="${pageContext.request.contextPath}/ProductServlet?id=<%=prodId%>&action=delete" class="btn btn-danger">Delete</a>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- End Delete Modal -->

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
    </div>
  </div>
</div>

<!-- Clear the message after the set time -->
<script>
   const time_duration = 20000;
   var alertMessage = document.getElementById('alert-message');
   if (alertMessage) {
       setTimeout(function() {
           alertMessage.style.display = 'none';
       }, time_duration);
   }
</script>

</body>
</html>
