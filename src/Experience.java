import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Experience {
    private int experienceID;
    private String jobTitle;
    private String companyName;
    private int duration;
    private String description;
    private static AtomicInteger generateid = new AtomicInteger(0);
    private static List<Experience> experienceList = new ArrayList<>();

    public Experience(String jobTitle, String companyName, int duration, String description) {
        this.experienceID = generateid.getAndIncrement();
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.duration = duration;
        this.description = description;
    }

    public int getExperienceID() {
        return experienceID;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Experience ID: %d\nJob Title: %s\nCompany: %s\nDuration: %d years\nDescription: %s",
                experienceID, jobTitle, companyName, duration, description);
    }

    public Experience addExperience() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Job Title: ");
        String e_title = scanner.nextLine();
        System.out.println("Enter your Company Name: ");
        String e_company = scanner.nextLine();
        System.out.println("Enter your Duration (in years): ");
        int e_duration = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter your Job Description: ");
        String e_description = scanner.nextLine();
        scanner.close();
        Experience experience = new Experience(e_title, e_company, e_duration, e_description);
        experienceList.add(experience);
        System.out.println("Experience added: " + experience);
        return experience;
    }

    public void updateExperience(int experienceID) {
        for (Experience experience : experienceList) {
            if (experience.getExperienceID() == experienceID) {
                System.out.println("Updating experience for ID: " + experienceID);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your Job Title: ");
                String e_title = scanner.nextLine();
                System.out.println("Enter your Company Name: ");
                String e_company = scanner.nextLine();
                System.out.println("Enter your Duration (in years): ");
                int e_duration = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Enter your Job Description: ");
                String e_description = scanner.nextLine();
                scanner.close();
                experience.setJobTitle(e_title);
                experience.setCompanyName(e_company);
                experience.setDuration(e_duration);
                experience.setDescription(e_description);
                System.out.println("Experience updated: " + experience);
                return;
            }
        }
        System.out.println("Experience record not found with ID: " + experienceID);
    }

    public void deleteExperience(int experienceID) {
        boolean removed = experienceList.removeIf(exp -> exp.getExperienceID() == experienceID);
        if (removed) {
            System.out.println("Experience record deleted for ID: " + experienceID);
        } else {
            System.out.println("Experience record not found with ID: " + experienceID);
        }
    }

    public void viewAllExperience() {
        if (experienceList.isEmpty()) {
            System.out.println("No experience records available.");
        } else {
            System.out.println("Experience Records:");
            for (Experience experience : experienceList) {
                System.out.println(experience);
            }
        }
    }
}
