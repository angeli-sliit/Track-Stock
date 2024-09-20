package admin;

public class Category {
    private int id;
    private String name;

    // Constructors
    public Category() {}

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString for debugging
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}
