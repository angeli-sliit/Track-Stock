package auth;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(username, email, password);
        UserService userService = new UserService();

        try {
            // Check if the user already exists
            if (userService.getUserByEmailOrUsername(email) != null) {
                pr.println("User already exists. Please choose a different email or username.");
            } else {
                // Register the user
                boolean success = userService.registerUser(user);
                if (success) {
                    response.sendRedirect("Login/Login.jsp"); 
                } else {
                    pr.println("Signup failed. Please try again.");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            pr.println("Database connection problem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

