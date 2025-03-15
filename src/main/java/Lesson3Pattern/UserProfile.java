package Lesson3Pattern;
//Test Data Builder
public class UserProfile {
    private String name;
    private String email;
    private String phone;

    // Конструктор
    public UserProfile(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Геттери
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
