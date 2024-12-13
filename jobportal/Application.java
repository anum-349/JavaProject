package jobportal;

public class Application {
    private int applicationID;
    private int jobID;
    private int jobSeekerID;
    private String status;

    public Application(int applicationID, int jobID, int jobSeekerID, String status) {
        this.applicationID = applicationID;
        this.jobID = jobID;
        this.jobSeekerID = jobSeekerID;
        this.status = status;
    }

    public void submitApplication() {
        System.out.println("Application submitted for job ID: " + jobID);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Application status updated to: " + newStatus);
    }
}
