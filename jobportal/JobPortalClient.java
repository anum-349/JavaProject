package jobportal;

public class JobPortalClient {
    public static void main(String[] args) {
        // Notification Example
        Notification notification = new Notification("Your application has been approved!");
        notification.sendNotification();
        notification.viewNotification();
        notification.deleteNotification();
        notification.viewNotification();

        // MatchingEngine Example
        MatchingEngine matchingEngine = new MatchingEngine();

        Job job1 = new Job1(101, "Software Developer", "Develop software", "New York", 85000);
        Job job2 = new Job2(102, "Data Analyst", "Analyze data", "San Francisco", 95000);

        matchingEngine.addJob(job1);
        matchingEngine.addJob(job2);

        JobSeeker seeker = new JobSeeker(1, "John Doe", "john@example.com", "1234567890", "New York");
        matchingEngine.matchJobs(seeker);
        matchingEngine.generateRecommendation();
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
