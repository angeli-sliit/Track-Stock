package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class updatepassword extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();

        String newPassword = request.getParameter("newPassword");
        String verifiedEmail = (String) session.getAttribute("verifiedEmail");

        UserService userService = new UserService();

        try {
            if (verifiedEmail != null) {
                boolean isUpdated = userService.updatePassword(verifiedEmail, newPassword);
                if (isUpdated) {
                    tools.session.clearSession(session);
                    response.sendRedirect("Login/Login.jsp");
                } else {
                    pr.println("Password update failed. Please try again.");
                }
            } else {
                pr.println("Invalid OTP or session expired.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            pr.println("Database connection problem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
