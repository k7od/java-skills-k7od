public class UserInfo {
    private String name;
    private int age;
    private String email;
    private boolean isActive;

    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Active: " + (isActive ? "Yes" : "No"));
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("Idris", 24, "idris@example.com", true);
        UserInfo user2 = new UserInfo("Albaraa", 25, "Albaraa@example.com", false);
        UserInfo user3 = new UserInfo("Ahmed", 24, "Ahmed@example.com", true);

        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        user1.setName("Osama");
        user1.setAge(26);
        user1.setEmail("Osama@example.com");
        user1.setActive(false);

        user1.displayInfo();
    }
}

