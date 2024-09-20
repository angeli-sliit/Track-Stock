package admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tools.session;

import java.io.IOException;
import java.sql.SQLException;

import auth.User;
import auth.UserService;

public class editaccess extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    private String error_handler="";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
    	
    	
    	
    	// Get parameters from the request
        String id = request.getParameter("id");
        String email = request.getParameter("email");
        String access = request.getParameter("access_level"); 
        String status = request.getParameter("status");

        // Create a User object with the retrieved values
        User user = new User(id, access, status,email);

        // Use the UserService to update user access and status
        UserService userService = new UserService();
        boolean isUpdated = false;
		try {
			isUpdated = userService.updateUserAccess(user);
		} catch (ClassNotFoundException e) {
			error_handler="Class Not Found Error";
			e.printStackTrace();
		} catch (SQLException e) {
			error_handler="SQL Error";
			e.printStackTrace();
		}

        if (isUpdated) {
        	session.setAttribute("state","success");
        	session.setAttribute("message","Access Update Successful ");
            response.sendRedirect("Admin/UserManagement/UserManagement.jsp");  
        } else {
        	session.setAttribute("state","error");
        	session.setAttribute("message","Access Update Failed " + error_handler);
            response.sendRedirect("Admin/UserManagement/UserManagement.jsp");  
        }
    }
}
