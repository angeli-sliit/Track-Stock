package auth;

public class User {
    private String username;
    private String email;
    private String password;
    private String active_statue;
    private String access_level;
    
    private String userID;
    private String accessLevel;
    private String status;

    public User(String username, String email, String password,String active_statue,String access_level) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active_statue = active_statue;
        this.access_level = access_level;
    }
    
    public User(String userID, String accessLevel, String status,String email) {
        this.setUserID(userID);
        this.setAccessLevel(accessLevel);
        this.setStatus(status);
        this.email = email;
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
    
    public boolean validateAccess() {
    	return this.active_statue.equals("Active");
    }
    
    public boolean validateAccesslevel(String active_level) {
    	return this.access_level.equals(active_level);
    }

	public String getActive_statue() {
		return active_statue;
	}

	public void setActive_statue(String active_statue) {
		this.active_statue = active_statue;
	}

	public String getAccess_level() {
		return access_level;
	}

	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
