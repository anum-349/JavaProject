package jobportal;

public abstract class Job {
    private int jobID;
    private String title;
    private String description;
    private String location;
    private double salary;

    public Job(int jobID, String title, String description, String location, double salary) {
        this.jobID = jobID;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
    }

    public int getJobID() {
        return jobID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    public abstract boolean isEligible(JobSeeker jobSeeker);

    public void displayJobDetails() {
        System.out.println("Job ID: " + jobID + ", Title: " + title + ", Location: " + location + ", Salary: " + salary);
    }
}
