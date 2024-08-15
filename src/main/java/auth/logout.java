package auth;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the session to clear all session attributes
        HttpSession session = request.getSession(false); // Get existing session, if any
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        // Redirect to the login page or any other page after logout
        response.sendRedirect("login.jsp"); // Adjust the path to your login page
    }
}
