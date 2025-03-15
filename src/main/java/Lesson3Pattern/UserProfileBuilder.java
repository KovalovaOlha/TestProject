package Lesson3Pattern;

//Test Data Builder

public class UserProfileBuilder {
    private String name = "Default Name";
    private String email = "default@example.com";
    private String phone = "1234567890";

    public UserProfileBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserProfileBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserProfileBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(name, email, phone);
    }
}
