package javaproject;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.List;

public abstract class Job {
    protected int jobID;
    protected String title;
    protected String description;
    protected String company;
    protected String location;
    protected double salary;
    protected String qualification;
    protected int experienceYears;
    protected static AtomicInteger generateid = new AtomicInteger(0);
    protected List<String> requiredSkillsList = new ArrayList<>(); 
    protected static List<Job> jobList = new ArrayList<>();
    private List<Application> applications = new ArrayList<>();

    public Job(){}
    
    public Job(String title, String description, String company, String location, double salary, 
            List<String> reqSkills, String qualification, int experienceYears) { 
        this.jobID = generateid.getAndIncrement();
        this.title = title;
        this.description = description;
        this.location = location;
        this.company = company;
        this.salary = salary;
        this.requiredSkillsList = reqSkills;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
    }

    public int getJobID() {
        return jobID;
    }

    public String getCompany() {
        return company;
    }

    public String getQualification() {
        return qualification;
    }
    
    public int getExperienceYears() {
        return experienceYears;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public List<String> getSkills() { 
        return requiredSkillsList;
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

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setJobTitle(String title) {
        this.title = title;
    }

    public void setCompanyName(String company) {
        this.company = company;
    }

    public void setExperienceYears(int experienceYears) { 
        this.experienceYears = experienceYears;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
    public void setSkills(List<String> skills) { 
        this.requiredSkillsList = skills;
    }

    public abstract Job addJob(); 
    
    public abstract void updateJob(int jobID); 

    public abstract void deleteJob(int jobID); 

    public void addApplication(Application application) {
        applications.add(application);
    }

    public void viewAllJob() {
        if (jobList.isEmpty()) {
            System.out.println("No Job records available.");
        } else {
            System.out.println("Job Records:");
            for (Job job : jobList) {
                System.out.println(job.toString()); 
            }
        }
    }
    
    public boolean isEligible(JobSeeker jobSeeker) {
        for(Education education: jobSeeker.getEducation())
        {
            if (!this.qualification.equalsIgnoreCase(education.getDegree())) {
                return false;
            }
        }
    
        for(Experience experience: jobSeeker.getExperience())
        {
            if (experience.getDuration() < this.experienceYears) {
                return false;
            }
        }
    
        for(Skills skill: jobSeeker.getSkills())
        {
            for (String requiredSkill : requiredSkillsList) {
                if (!skill.getSkillNameList().contains(requiredSkill)) {
                    return false;
                }
            }
        }
        
    
        return true; 
    }
    
    @Override
    public String toString() {
        return "Job Title: " + title +
                "\nDescription: " + description +
                "\nCompany: " + company +
                "\nLocation: " + location +
                "\nSalary: " + salary +
                "\nQualification: " + qualification +
                "\nExperience: " + experienceYears +
                " years\nSkills: " + requiredSkillsList;
    }
}
