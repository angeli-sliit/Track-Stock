package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class forgetpass1Handler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = new UserService(); 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        HttpSession session = request.getSession();

        String emailOrUsername = request.getParameter("email");

        try {
           
            User user = userService.getUserByEmailOrUsername(emailOrUsername);

            if (user != null) {
        
                String otp = userService.generateOTP();
                System.out.println(otp);
                session.setAttribute("OTP", otp);
                session.setAttribute("verifiedEmail", user.getEmail());
         
                response.sendRedirect("forgetpass/forgetpass.jsp");
            } else {
                pr.println("<script>alert('User not found. Please try again.');window.location.href='forgetpass/forgetpass.jsp';</script>");
            }
        } catch (SQLException | ClassNotFoundException e) {
            pr.println("Database connection problem: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
