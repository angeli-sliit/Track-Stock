package auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
