package jobportal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Application {
    private int applicationID;
    private int jobID;
    private int userID;
    private String status;
    private static final List<String> status_list = Arrays.asList("PENDING", "APPROVED", "REJECTED");
    private static AtomicInteger generateId = new AtomicInteger(0);
    private static List<Application> applicationList = new ArrayList<>();

    public Application(int jobID, int userID) {
        this.applicationID = generateId.getAndIncrement();
        this.jobID = jobID;
        this.userID = userID;
        this.status = "PENDING"; 
    }

    public int getApplicationID() {
        return applicationID;
    }

    public int getJobID() {
        return jobID;
    }

    public int getJobSeekerID() {
        return userID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (isValidStatus(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    private boolean isValidStatus(String status) {
        return status_list.contains(status.toUpperCase());
    }

    public static Application createApplication(Job job, JobSeeker jobSeeker) {
        Application application = new Application(job.getJobID(), jobSeeker.getJobSeekerID());
    
        job.addApplication(application);
        jobSeeker.addApplication(application);
    
        applicationList.add(application); 
    
        System.out.println("Application submitted successfully for job: " + job.getTitle());
        return application;
    }
    
    public static void updateStatus(int applicationID, String newStatus) {
        for (Application application : applicationList) {
            if (application.getApplicationID() == applicationID) {
                application.setStatus(newStatus);
                System.out.println("Application status updated to: " + newStatus);
                Notification notification = new Notification(
                    "Your application status for Job ID " + application.getJobID() + " is now: " + newStatus
                );
                notification.sendNotification();
                return;
            }
        }
        System.out.println("Application record not found with ID: " + applicationID);
    }

    public static void viewApplicationDetails(int applicationID) {
        for (Application application : applicationList) {
            if (application.getApplicationID() == applicationID) {
                System.out.println("Application ID: " + application.getApplicationID() +
                        "\nJob ID: " + application.getJobID() +
                        "\nJob Seeker ID: " + application.getJobSeekerID() +
                        "\nStatus: " + application.getStatus());
                return;
            }
        }
        System.out.println("Application record not found with ID: " + applicationID);
    }

    public static void viewAllApplications() {
        if (applicationList.isEmpty()) {
            System.out.println("No application records available.");
        } else {
            System.out.println("All Application Records:");
            for (Application application : applicationList) {
                System.out.println("Application ID: " + application.getApplicationID() +
                        "\nJob ID: " + application.getJobID() +
                        "\nJob Seeker ID: " + application.getJobSeekerID() +
                        "\nStatus: " + application.getStatus());
            }
        }
    }
}
