package tools;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Enumeration;

public class session {

    // Method to clear the session
    public static void clearSession(HttpSession session) {
        session.invalidate();
    }

    // Method to view the session attributes
    public static void viewSession(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (!attributeNames.hasMoreElements()) {
            out.println("<p>No session data available.</p>");
        } else {
            while (attributeNames.hasMoreElements()) {
                String attributeName = attributeNames.nextElement();
                Object attributeValue = session.getAttribute(attributeName);

                out.println("<p><strong>" + attributeName + ":</strong> " + attributeValue + "</p>");
            }
        }
    }
}
