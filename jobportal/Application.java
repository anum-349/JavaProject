package jobportal;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private int applicationID;
    private int jobID;
    private int userID;
    private String status;

    private static List<Application> applicationList = new ArrayList<>();

    public Application(int applicationID, int jobID, int jobSeekerID, String status) {
        this.applicationID = applicationID;
        this.jobID = jobID;
        this.userID = jobSeekerID;
        this.status = status;
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
        this.status = status;
    }

    public static void submitApplication(int applicationID, int jobID, int jobSeekerID, String status) {
        Application application = new Application(applicationID, jobID, jobSeekerID, status);
        applicationList.add(application);
        System.out.println("Application submitted for job ID: " + jobID);
    }

    public static void updateStatus(int applicationID, String newStatus) {
        for (Application application : applicationList) {
            if (application.getApplicationID() == applicationID) {
                application.setStatus(newStatus);
                System.out.println("Application status updated to: " + newStatus);
                return;
            }
        }
        System.out.println("Application record not found with ID: " + applicationID);
    }

    public static void viewApplicationDetails(int applicationID) {
        for (Application application : applicationList) {
            if (application.getApplicationID() == applicationID) {
                System.out.println("Application ID: " + application.getApplicationID() +
                        ", Job ID: " + application.getJobID() +
                        ", Job Seeker ID: " + application.getJobSeekerID() +
                        ", Status: " + application.getStatus());
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
                        ", Job ID: " + application.getJobID() +
                        ", Job Seeker ID: " + application.getJobSeekerID() +
                        ", Status: " + application.getStatus());
            }
        }
    }}