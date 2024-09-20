package auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class UserService {
    public User getUserByEmailOrUsername(String emailOrUsername) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM registered_user WHERE username=? OR email=?";
        try (Connection con = DbConn.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, emailOrUsername);
            ps.setString(2, emailOrUsername);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                return new User(username, email, password);
            }
        }
        return null;
    }
    
 // Method to check if the credentials exist in the admin table
    public User getAdminByEmailOrUsername(String emailOrUsername) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM admin WHERE email=? OR name=?";
        try (Connection con = DbConn.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, emailOrUsername);
            ps.setString(2, emailOrUsername);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String username = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                return new User(username, email, password);
            }
        }
        return null;
    }
    
    public boolean isAdmin(String email) throws SQLException, ClassNotFoundException {
        String query = "SELECT * FROM admin WHERE email=?";
        try (Connection con = DbConn.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // Returns true if the email exists in the admin table
        }
    }
    
    
    
    public boolean registerUser(User user) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO registered_user (username, email, password) VALUES (?, ?, ?)";
        try (Connection con = DbConn.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }
    public String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
    
    public boolean updatePassword(String email, String newPassword) throws SQLException, ClassNotFoundException {
        String query = "UPDATE registered_user SET password=? WHERE email=?";
        try (Connection con = DbConn.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, newPassword);
            ps.setString(2, email);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }
}

