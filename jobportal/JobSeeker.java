package jobportal;
import java.util.Scanner;

public class JobSeeker {
    private int userID;
    private String name;
    private String email;
    private String phone;
    private String location;

    public JobSeeker(int userID) {
        this.userID = userID;
    }
    
    public void createProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter your email: ");
        this.email = scanner.nextLine();
        System.out.println("Enter your phone number: ");
        this.phone = scanner.nextLine();
        System.out.println("Enter your location: ");
        this.location = scanner.nextLine();
        System.out.println("Profile created successfully for: " + name);
        scanner.close();
    }

    public void viewProfile() {
        System.out.println("User ID: " + userID);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Location: " + location);
    }
    
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
    
    public void manageEducation() {
        Education.addEducation(123, "BSc Software Engineering", "COMSATS University", 2022, 3.8);
        Education.addEducation(876, "BS Pschology", "FAST NUCES", 2023, 3.5);

        Education.viewAllEducation();

        Education.updateEducation(123, "BSc Computer Science", "IIUI University", 2022, 3.9);

        Education.deleteEducation(2);
        Education.deleteEducation(876);

        Education.viewAllEducation();
    }
    
     public void manageExperience() {
        Experience.addExperience(23, "Software Developer", "ABC Corp", "2 years", "Developed web applications.");
        Experience.addExperience(10, "Senior Developer", "XYZ Ltd", "3 years", "Led a team of developers.");

        Experience.viewAllExperience();

        Experience.updateExperience(10, "Software Engineer", "ABC Corp", "2.5 years", "Worked on large-scale web projects.");

        Experience.viewAllExperience();

        Experience.deleteExperience(10);
        Experience.deleteExperience(27);

        Experience.viewAllExperience();
    }
     
    public void manageSkills() {
        Skills.addSkill(1, "Java", "Intermediate");
        Skills.addSkill(2, "JavaScript", "Beginner");

        Skills.getSkillDetails();

        Skills.updateSkill(1, "Java", "Advanced");

        Skills.getSkillDetails();
    }
}
