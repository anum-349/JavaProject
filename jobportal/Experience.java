package jobportal;

public class Experience {
    private String jobTitle;
    private String companyName;
    private String duration; // e.g., "Jan 2020 - Dec 2022"
    private String description;

    public Experience(String jobTitle, String companyName, String duration, String description) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.duration = duration;
        this.description = description;
    }

    public void addExperience() {
        System.out.println("Experience added: " + jobTitle + " at " + companyName);
    }

    public void updateExperience(String jobTitle, String companyName, String duration, String description) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.duration = duration;
        this.description = description;
        System.out.println("Experience updated: " + jobTitle + " at " + companyName);
    }

    public void deleteExperience() {
        System.out.println("Experience deleted: " + jobTitle + " at " + companyName);
    }

    public void viewExperience() {
        System.out.println("Job Title: " + jobTitle + ", Company: " + companyName +
                ", Duration: " + duration + ", Description: " + description);
    }
}
