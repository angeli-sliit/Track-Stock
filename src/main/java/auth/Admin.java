package auth;

public class Admin extends User {
    private int adminId;
    private int addedAdminId;
    private String name;
    private String age;
    private String addedDate;
    private boolean isAdmin;

    public Admin(int adminId, int addedAdminId, String name, String age, String username, String email, String password, String addedDate,String access_state,String access_level) {
        super(username, email, password,access_state,access_level);
        this.adminId = adminId;
        this.addedAdminId = addedAdminId;
        this.name = name;
        this.age = age;
        this.addedDate = addedDate;
    }

    // Getter methods for admin-specific attributes
    public int getAdminId() {
        return adminId;
    }

    public int getAddedAdminId() {
        return addedAdminId;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddedDate() {
        return addedDate;
    }
    public boolean getisAdmin() {
    	return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
    	this.isAdmin = isAdmin;
    }
}
