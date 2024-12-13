package jobportal;

public class JobSeeker {
    private int userID;
    private String name;
    private String email;
    private String phone;
    private String location;

    private Education education;
    private Skills skills;
    private Experience experience;

    public JobSeeker(int userID, String name, String email, String phone, String location) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public void createProfile() {
        System.out.println("Profile created for: " + name);
    }

    public String getName() {
        return name;
    }

    public void viewProfile() {
        System.out.println("Name: " + name + ", Email: " + email);
    }

    public String getLocation() {
        return location;
    }
}
