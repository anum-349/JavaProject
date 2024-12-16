package jobportal;

import java.util.ArrayList;
import java.util.Scanner;

public class job_3 extends Job {
    // Constructor for the job_3 class
    public job_3(String title, String description, String company, String location, double salary, 
                 ArrayList<String> reqSkills, String qualification, int experienceYears) {
        super(title, description, company, location, salary, reqSkills, qualification, experienceYears);
    }

    public Job addJob() {
        Scanner scanner = new Scanner(System.in);
        String j_title, j_company, j_description, j_location, j_qualification;
        int j_experience;
        double j_salary;
        ArrayList<String> j_Skills = new ArrayList<>();

        System.out.println("Enter Job Title: ");
        j_title = scanner.nextLine();

        System.out.println("Enter Job Company Name: ");
        j_company = scanner.nextLine();

        System.out.println("Enter your Job Description: ");
        j_description = scanner.nextLine();

        System.out.println("Enter your Job Location: ");
        j_location = scanner.nextLine();

        System.out.println("Enter Job Salary: ");
        j_salary = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Enter Job Qualification: ");
        j_qualification = scanner.nextLine();

        System.out.println("Enter your Year of Duration(0,1,2...): ");
        j_experience = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter skills required for the job (comma-separated): ");
        String skillsInput = scanner.nextLine();
        for (String skill : skillsInput.split(",")) {
            j_Skills.add(skill.trim());
        }
        scanner.close();

        Job job = new job_3(j_title, j_description, j_company, j_location, j_salary, j_Skills, j_qualification, j_experience);
        jobList.add(job);

        System.out.println("Experience added with ID: " + job.getJobID() + " job: " + j_title + " at " + j_company);
        return job;
    }

    public void updateJob(int jobId) {
        for (Job job : jobList) {
            if (job.getJobID() == jobId) { 
                Scanner scanner = new Scanner(System.in);
                String e_title, e_company, e_description;
                int e_duration;

                System.out.println("Enter your Job Title: ");
                e_title = scanner.nextLine();

                System.out.println("Enter your Company Name: ");
                e_company = scanner.nextLine();

                System.out.println("Enter your Year of Duration(0,1,2...): ");
                e_duration = scanner.nextInt();
                scanner.nextLine(); 
                System.out.println("Enter your Job Description: ");
                e_description = scanner.nextLine();
                scanner.close();
                job.setJobTitle(e_title);
                job.setCompanyName(e_company);
                job.setExperienceYears(e_duration); 
                job.setDescription(e_description);

                System.out.println("Job updated: " + e_title + " at " + e_company);
                return;
            }
        }
        System.out.println("Job record not found with ID: " + jobId);
    }

    public void deleteJob(int jobId) {
        for (Job job : jobList) {
            if (job.getJobID() == jobId) {
                jobList.remove(job);
                System.out.println("Job deleted: " + job.getTitle() + " at " + job.getCompany());
                return;
            }
        }
        System.out.println("Job record not found with ID: " + jobId);
    }
}
