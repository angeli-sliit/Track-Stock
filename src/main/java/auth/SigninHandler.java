package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup")
public class SigninHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();

        String emailOrUsername = request.getParameter("email");
        String inputPassword = request.getParameter("password");

        UserService userService = new UserService();

        try {
            User user = userService.getUserByEmailOrUsername(emailOrUsername);
            if (user != null && user.validatePassword(inputPassword)&& user.validateAccess()) {
            	userService.updateLastLogin(user.getEmail());
                session.setAttribute("login_state", true);
                session.setAttribute("email", user.getEmail());
                session.setAttribute("username", user.getUsername());
                session.setAttribute("Access_level", user.getAccess_level());
                session.setAttribute("state", "success");
                session.setAttribute("message", "Welcome to Inventory Management System");

                // Check if the user is an admin
                if (user.getEmail().endsWith("@trackstock.com") && userService.isAdmin(user.getEmail()) && user.validateAccess()) {
                	System.out.println("hello");
                	userService.updateLastLogin(user.getEmail());
                	session.setAttribute("login_state", true);
                    session.setAttribute("email", user.getEmail());
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("Access_level", user.getAccess_level());
                    session.setAttribute("state", "success");
                    session.setAttribute("message", "Welcome to Inventory Management System");
                    response.sendRedirect("DashboardDataFetch");
                    
                    } else {
                    response.sendRedirect("Home/Home.jsp");
                }
            } else {
                response.sendRedirect("Login/Login.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            pr.println("Database connection problem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
