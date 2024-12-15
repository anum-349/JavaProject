package jobportal;

public class JobPortalClient {
    public static void main(String[] args) {
        
        //Notification        
        Notification notification = new Notification("Your job application was received.");
        notification.sendNotification();
        notification.viewNotification();
        notification.deleteNotification();
        notification.viewNotification();

        JobPortalClient portal = new JobPortalClient();
        portal.triggerEvent("application", "Software Engineer");
        portal.triggerEvent("recommendation", "Senior Developer");
        portal.triggerEvent("hired", "Frontend Developer");
        //Application        
        Application.submitApplication(1, 101, 1001, "Submitted");
        Application.submitApplication(2, 102, 1002, "Under Review");

        Application.viewAllApplications();
        Application.updateStatus(1, "Interview Scheduled");
        Application.viewApplicationDetails(2);
        Application.viewApplicationDetails(23);
        Application.viewAllApplications(); 
        
        
        MatchingEngine matchingEngine = new MatchingEngine();

        Job job1 = new Job1(101, "Software Developer", "Develop software", "New York", 85000);
        Job job2 = new Job2(102, "Data Analyst", "Analyze data", "San Francisco", 95000);

        matchingEngine.addJob(job1);
        matchingEngine.addJob(job2);

        JobSeeker seeker = new JobSeeker(1);
        matchingEngine.matchJobs(seeker);
        seeker.manageEducation();
        seeker.manageExperience();
        seeker.manageSkills();
        matchingEngine.generateRecommendation();
    }

    public void triggerEvent(String eventType, String jobTitle) {
        try {
            Notification notification = Notification.createNotification(eventType, jobTitle);
            notification.sendNotification();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Example implementation of concrete jobs
class Job1 extends Job {
    public Job1(int jobID, String title, String description, String location, double salary) {
        super(jobID, title, description, location, salary);
    }

    @Override
    public boolean isEligible(JobSeeker jobSeeker) {
        return "New York".equalsIgnoreCase(jobSeeker.getLocation()); // Simple eligibility check
    }
}

class Job2 extends Job {
    public Job2(int jobID, String title, String description, String location, double salary) {
        super(jobID, title, description, location, salary);
    }

    @Override
    public boolean isEligible(JobSeeker jobSeeker) {
        return "San Francisco".equalsIgnoreCase(jobSeeker.getLocation()); // Simple eligibility check
    }
}
