package jobportal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class JobSeeker {
    private int userID;
    private String name;
    private String email;
    private String phone;
    private String location;
    private Education education;
    private Experience experience;
    private Skills skills;
    private static AtomicInteger idGenerator = new AtomicInteger(0); 
    private static List<JobSeeker> jobSeekersList = new ArrayList<>();

    public JobSeeker(String name,String email, String phone,String  location, Education education, Skills skills, Experience experience) {
        this.userID = idGenerator.getAndIncrement();
        this.name = name;
        this.phone = phone;
        this.location = location;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
    }
    
    public int getJobSeekerID(){
        return userID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setLocation(String location){
        this.location = location;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void createProfile() {
        String u_name, u_email, u_phone, u_location;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        u_name = scanner.nextLine();
        System.out.println("Enter your email: ");
        u_email = scanner.nextLine();
        System.out.println("Enter your phone number: ");
        u_phone = scanner.nextLine();
        System.out.println("Enter your location: ");
        u_location = scanner.nextLine();
        System.out.println("Profile created successfully for: " + name);
        scanner.close();
        Education u_education = education.addEducation();
        Experience u_experience = experience.addExperience();
        Skills u_skills = skills.addSkill();
        JobSeeker job_Seeker = new JobSeeker(u_name, u_email, u_phone, u_location, u_education, u_skills, u_experience);
        jobSeekersList.add(job_Seeker);

    }
    
    public void updateProfile(int job_seeker_id) {
        for (JobSeeker job_seeker: jobSeekersList ) {
            if (job_seeker.getJobSeekerID() == job_seeker_id) {
                String u_name, u_email, u_phone, u_location;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your name: ");
                u_name = scanner.nextLine();
                System.out.println("Enter your email: ");
                u_email = scanner.nextLine();
                System.out.println("Enter your phone number: ");
                u_phone = scanner.nextLine();
                System.out.println("Enter your location: ");
                u_location = scanner.nextLine();
                System.out.println("Profile created successfully for: " + name);
                scanner.close();
                job_seeker.setName(u_name);
                job_seeker.setLocation(u_location);
                job_seeker.setPhone(u_phone);
                job_seeker.setEmail(u_email);
                System.out.println("Profile updated: " + u_name);
                return;
            }
        }
        System.out.println("User record not found with ID: " + job_seeker_id);
    }
    
    public void viewProfile(int job_seeker_id) {
        for (JobSeeker job_Seeker : jobSeekersList) {
            if (job_Seeker.getJobSeekerID() == job_seeker_id) {
                System.out.println("Jobseeker record not found with ID: " + job_seeker_id);
                System.out.println("User ID: " + job_Seeker.getJobSeekerID());
                System.out.println("Name: " + job_Seeker.getName());
                System.out.println("Email: " + job_Seeker.getEmail());
                System.out.println("Phone: " + job_Seeker.getPhone());
                System.out.println("Location: " + job_Seeker.getLocation());
                return;
            }
        }
        System.out.println("Jobseeker record not found with ID: " + job_seeker_id);
    }

    public void deleteJobSeeker(int job_seeker_id) {
        for (JobSeeker job_Seeker : jobSeekersList) {
            if (job_Seeker.getJobSeekerID() == job_seeker_id) {
                jobSeekersList.remove(job_Seeker);
                System.out.println("Jobseeker deleted: " + job_Seeker.getName());
                return;
            }
        }
        System.out.println("Jobseeker record not found with ID: " + job_seeker_id);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void manage_profile(){        
        Scanner scanner = new Scanner(System.in);
        int choice, job_seeker_id, select, education_id, experience_id, skill_id;
        String account_choice;
        System.out.println("Do You have Account? (y/n)");
        account_choice = scanner.nextLine();
        if (account_choice.substring(0, 1).equalsIgnoreCase("y")) {
            System.out.println("Enter your ID: ");
            job_seeker_id = scanner.nextInt();
            for (JobSeeker job_seeker: jobSeekersList ) {
                if (job_seeker.getJobSeekerID() == job_seeker_id) {
                    do {
                        System.out.println("Manage Profile: ");
                        System.out.println("1: Profile Section. ");
                        System.out.println("2: Education Section. ");        
                        System.out.println("3: Experience Section. ");
                        System.out.println("4: Skills Section. ");
                        System.out.println("5: Exit. ");
                        System.out.println("Choose Option to Manage Profile: ");
                        choice = scanner.nextInt();
                        if(choice == 1){
                            do {
                                System.out.println("Profile Section ");
                                System.out.println("1: Update Profile. ");
                                System.out.println("2: View Profile. ");      
                                System.out.println("3: Delete Profile. ");        
                                System.out.println("4: Exit. ");
                                System.out.println("Choose Option to Manage Profile: ");
                                select = scanner.nextInt();
                                if(select == 1){
                                    updateProfile(job_seeker_id);
                                }
                                else if(select == 2){
                                    viewProfile(job_seeker_id);
                                }
                                else if(select == 3){
                                    deleteJobSeeker(job_seeker_id);
                                }
                                else{
                                    System.out.println("Please Choose Valid option.");
                                }
                            }while(select!=4);
                        }
                        else if(choice == 2){
                            do {
                                System.out.println("Education Section ");
                                System.out.println("1: Add education. ");
                                System.out.println("1: Update education. ");
                                System.out.println("2: View education. ");      
                                System.out.println("3: Delete education. ");        
                                System.out.println("4: Exit. ");
                                System.out.println("Choose Option to Manage Eduation: ");
                                select = scanner.nextInt();
                                if(select == 1){
                                    education.addEducation();
                                }
                                else if(select == 2){
                                    education.viewAllEducation();
                                    System.out.println("Please Enter your EducationID: ");
                                    education_id = scanner.nextInt();
                                    education.updateEducation(education_id);
                                }
                                else if(select == 3){
                                    education.viewAllEducation();
                                }
                                else if(select == 4){
                                    education.viewAllEducation();
                                    System.out.println("Please Enter your EducationID: ");
                                    education_id = scanner.nextInt();
                                    education.deleteEducation(education_id);
                                }
                                else{
                                    System.out.println("Please Choose Valid option.");
                                }
                            }while(select!=5);
                        }
                        else if(choice == 3){
                            do {
                                System.out.println("Experience Section ");
                                System.out.println("1: Add experience. ");
                                System.out.println("1: Update experience. ");
                                System.out.println("2: View experience. ");      
                                System.out.println("3: Delete experience. ");        
                                System.out.println("4: Exit. ");
                                System.out.println("Choose Option to Manage Profile: ");
                                select = scanner.nextInt();
                                if(select == 1){
                                    experience.addExperience();
                                }
                                else if(select == 2){
                                    experience.viewAllExperience();
                                    System.out.println("Please Enter your ExperienceID: ");
                                    experience_id = scanner.nextInt();
                                    experience.updateExperience(experience_id);
                                }
                                else if(select == 3){
                                    experience.viewAllExperience();
                                }
                                else if(select == 4){
                                    experience.viewAllExperience();
                                    System.out.println("Please Enter your ExperienceID: ");
                                    experience_id = scanner.nextInt();
                                    experience.deleteExperience(experience_id);
                                }
                                else{
                                    System.out.println("Please Choose Valid option.");
                                }
                            }while(select!=5);
                        }
                        else if(choice == 4){
                            do {
                                System.out.println("skill Section ");
                                System.out.println("1: Add skill. ");
                                System.out.println("1: Update skill. ");
                                System.out.println("2: View skill. ");      
                                System.out.println("3: Delete skill. ");        
                                System.out.println("4: Exit. ");
                                System.out.println("Choose Option to Manage Profile: ");
                                select = scanner.nextInt();
                                if(select == 1){
                                    skills.addSkill();
                                }
                                else if(select == 2){
                                    skills.viewSkillDetails();
                                    System.out.println("Please Enter your skillID: ");
                                    skill_id = scanner.nextInt();
                                    skills.updateSkill(skill_id);
                                }
                                else if(select == 3){
                                    skills.viewSkillDetails();
                                }
                                else if(select == 4){
                                    skills.viewSkillDetails();
                                    System.out.println("Please Enter your skillID: ");
                                    skill_id = scanner.nextInt();
                                    skills.deleteSkill(skill_id);
                                }
                                else{
                                    System.out.println("Please Choose Valid option.");
                                }
                            }while(select!=5);
                        }
                        else{
                            System.out.println("Please Choose valid choice.");
                        }
                    }while(choice!=5);
                    return;
                }
            }
            System.out.println("Profile record not found with ID: " + job_seeker_id);  
        }
        else{
            System.out.println("Create User Profile.");
            createProfile();
        }
        scanner.close();
    }       
}
