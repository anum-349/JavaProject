package jobportal;
import java.util.ArrayList;
import java.util.List;

public class Experience {
    private int experienceID;
    private String jobTitle;
    private String companyName;
    private String duration; 
    private String description;
     
    private static List<Experience> experienceList = new ArrayList<>();

     public Experience(int experienceID, String jobTitle, String companyName, String duration, String description) {
        this.experienceID = experienceID;
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

    public static void addExperience(int experienceID, String jobTitle, String companyName, String duration, String description) {
        Experience experience = new Experience(experienceID, jobTitle, companyName, duration, description);
        experienceList.add(experience);
        System.out.println("Experience added: " + jobTitle + " at " + companyName);
    }

    public static void updateExperience(int experienceID, String jobTitle, String companyName, String duration, String description) {
        for (Experience experience : experienceList) {
            if (experience.getExperienceID() == experienceID) {
                experience.setJobTitle(jobTitle);
                experience.setCompanyName(companyName);
                experience.setDuration(duration);
                experience.setDescription(description);
                System.out.println("Experience updated: " + jobTitle + " at " + companyName);
                return;
            }
        }
        System.out.println("Experience record not found with ID: " + experienceID);
    }

    public static void deleteExperience(int experienceID) {
        for (Experience experience : experienceList) {
            if (experience.getExperienceID() == experienceID) {
                experienceList.remove(experience);
                System.out.println("Experience deleted: " + experience.getJobTitle() + " at " + experience.getCompanyName());
                return;
            }
        }
        System.out.println("Experience record not found with ID: " + experienceID);
    }

    public static void viewAllExperience() {
        if (experienceList.isEmpty()) {
            System.out.println("No experience records available.");
        } else {
            System.out.println("Experience Records:");
            for (Experience experience : experienceList) {
                System.out.println("Experience ID: " + experience.getExperienceID() + ", Job Title: " + experience.getJobTitle() +
                        ", Company: " + experience.getCompanyName() + ", Duration: " + experience.getDuration() + ", Description: " + experience.getDescription());
            }
        }
    }

  }