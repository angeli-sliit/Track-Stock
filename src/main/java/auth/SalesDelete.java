package auth;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SalesDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SalesDelete() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                if (id == null || id.isEmpty()) {
                    response.sendRedirect("Saleslist/saleslist.jsp?message=No+sales+ID+provided");
                    return;
                }
                Sales itemHandler = new Sales();
                itemHandler.deleteSales(id, "Saleslist/saleslist.jsp", "Saleslist/saleslist.jsp", response);
                break;

            case "add":
                if (id == null || id.isEmpty()) {
                    response.sendRedirect("newsale/newsale.jsp?message=No+sales+ID+provided&type=error");
                    return;
                }
                Sales itemHandler1 = new Sales();
                itemHandler1.addsale(id, "newsale/newsale.jsp", "newsale/newsale.jsp", request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delegate POST requests to the doGet method
        doGet(request, response);
    }
}
