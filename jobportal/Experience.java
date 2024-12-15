package jobportal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Experience {
    private int experienceID;
    private String jobTitle;
    private String companyName;
    private String duration; 
    private String description;
    private static AtomicInteger generateid = new AtomicInteger(0);
    private static List<Experience> experienceList = new ArrayList<>();

     public Experience(String jobTitle, String companyName, String duration, String description) {
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

    public String getDuration() {
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

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Experience addExperience() {
        Scanner scanner = new Scanner(System.in);
        String title, company, descrip, durat;
        System.out.println("Enter your Job Title: ");
        title = scanner.nextLine();
        System.out.println("Enter your Company Name: ");
        company = scanner.nextLine();
        System.out.println("Enter your Year of Duration: ");
        durat = scanner.nextLine();
        System.out.println("Enter your Job Description: ");
        descrip = scanner.nextLine();
        scanner.close();
        Experience experience = new Experience(title, company, durat, descrip);
        experienceList.add(experience);
        System.out.println("Experience added with id: " +getExperienceID()+" job: "+ title + " at " + company);
        return experience;
    }

    public void updateExperience(int experienceID) {
        for (Experience experience : experienceList) {
            if (experience.getExperienceID() == experienceID) {
                Scanner scanner = new Scanner(System.in);
                String title, company, descrip, durat;
                System.out.println("Enter your Job Title: ");
                title = scanner.nextLine();
                System.out.println("Enter your Company Name: ");
                company = scanner.nextLine();
                System.out.println("Enter your Year of Duration: ");
                durat = scanner.nextLine();
                System.out.println("Enter your Job Description: ");
                descrip = scanner.nextLine();
                scanner.close();
                experience.setJobTitle(title);
                experience.setCompanyName(company);
                experience.setDuration(durat);
                experience.setDescription(descrip);
                System.out.println("Experience updated: " + title + " at " + company);
                return;
            }
        }
        System.out.println("Experience record not found with ID: " + experienceID);
    }

    public void deleteExperience(int experienceID) {
        for (Experience experience : experienceList) {
            if (experience.getExperienceID() == experienceID) {
                experienceList.remove(experience);
                System.out.println("Experience deleted: " + experience.getJobTitle() + " at " + experience.getCompanyName());
                return;
            }
        }
        System.out.println("Experience record not found with ID: " + experienceID);
    }

    public void viewAllExperience() {
        if (experienceList.isEmpty()) {
            System.out.println("No experience records available.");
        } else {
            System.out.println("Experience Records:");
            for (Experience experience : experienceList) {
                System.out.println("Experience ID: " + experience.getExperienceID() + 
                                    "\nJob Title: " + experience.getJobTitle() +
                                    "\n Company: " + experience.getCompanyName() + 
                                    "\n Duration: " + experience.getDuration() +
                                    "\n Description: " + experience.getDescription());
            }
        }
    }

  }