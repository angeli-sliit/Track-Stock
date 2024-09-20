package auth;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;




@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1,
    maxFileSize = 1024 * 1024 * 10,      
    maxRequestSize = 1024 * 1024 * 50    
)
public class addphoto extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "D:\\Xampp\\tomcat\\webapps\\StockProjectSliit\\src\\main\\webapp\\images";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userId = request.getParameter("uname");

       
        Part filePart = request.getPart("file_upload"); 
        String fileName = getFileName(filePart);
        String uploadPath =  UPLOAD_DIRECTORY;

        
     


       
        System.out.println("Upload Path: " + uploadPath);

       
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            System.out.println("Directory does not exist, creating it.");
            if (uploadDir.mkdir()) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory.");
                return; 
            }
        } else {
            System.out.println("Directory exists.");
        }

       
        String filePath = uploadPath + File.separator + fileName;
        try {
            filePart.write(filePath);
            System.out.println("File saved at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return; 
        }

        
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            try {
                conn = DbConn.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            String query = "UPDATE registered_user SET user_profile_img = ? WHERE username = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, fileName);
            pstmt.setString(2, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

       
        response.sendRedirect("account/account.jsp");
    }

    private String getFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String cd : contentDisposition.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
