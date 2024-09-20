package auth;

public class User {
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    public boolean validateEmail(String inputEmail) {
        return this.email.equals(inputEmail);
    }
    
}
