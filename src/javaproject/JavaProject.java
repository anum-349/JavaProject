package javaproject;

import java.util.Scanner;

public class JavaProject {

    public static void main(String[] args) {
        Application application = new Application();
        Notification notification = new Notification();
        JobSeeker jobseeker = new JobSeeker();
        int choice;
        Scanner scanner = new Scanner(System.in); 
        System.out.println("---------------------------------------Welcome To Our Job Portal---------------------------------------");
        do{
            System.out.println("1: Job Seeker");
            System.out.println("2: Employer (Job Provider)");
            System.out.println("3: Exit");
            System.out.println("Choose Your Role: ");
            choice = scanner.nextInt();
            if( choice == 1 ){
                System.out.println("\n\n---------------------------------------Job Seeker Section---------------------------------------");
                jobseeker.profile_Application();
            }
            else if( choice == 2){
                System.out.println("\n\n---------------------------------------Employeer Section---------------------------------------");
                employeer(scanner,application, notification);  
            }
            else{
                System.out.println("Please enter valid choice.");
            }
        }while( choice != 3 );
    }
    private static void employeer(Scanner scanner, Application application, Notification notification){
        int choice;
        do{
            System.out.println("1: FrontEndDeveloperJobs");
            System.out.println("2: BackendDeveloperJobs");
            System.out.println("3: SoftwareDeveloperJobs");      
            System.out.println("4: Exit");        
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("\n\n---------------------------------------Frontend Developers Jobs---------------------------------------");
                Job frontendJob = new FrontEndDeveloperJobs();
                jobMenu(frontendJob, application, notification);
            }
            else if(choice == 2){                
                System.out.println("\n\n---------------------------------------Backend Developers Jobs---------------------------------------");
                Job backendJob = new BackendDeveloperJobs();
                jobMenu(backendJob,application, notification);
            }
            else if(choice == 3){
                System.out.println("\n\n---------------------------------------Software Developers Jobs---------------------------------------");
                Job softwareEngineerJob = new SoftwareDeveloperJobs();
                jobMenu(softwareEngineerJob,application, notification);
            }
        }while(choice != 4);
    }

    private static void jobMenu(Job type, Application application, Notification notification){
        Scanner scanner = new Scanner(System.in); 
        int choice, jobid;
        do{
            System.out.println("1: Create Job");
            System.out.println("2: Update Job");
            System.out.println("3: Delete Job");
            System.out.println("4: View Jobs");   
            System.out.println("5: View Applications");
            System.out.println("6: Update Applications Status");     
            System.out.println("7: Exit");        
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1){
                type.addJob();
            }
            else if(choice == 2){
                type.viewAllJob();
                System.out.println("Enter your job id: ");
                jobid = scanner.nextInt();
                scanner.nextLine();
                type.updateJob(jobid);
            }
            else if(choice == 3){
                type.viewAllJob();
                System.out.println("Enter your job id: ");
                jobid = scanner.nextInt();
                scanner.nextLine();
                type.deleteJob(jobid);
            }
            else if(choice == 4){
                type.viewAllJob();
            }
            
            else if(choice == 5){
                application.viewAllApplications();
            }
            
            else if(choice == 6){
                application.viewAllApplications();
                application.setStatus("hired");
                notification.createNotification("hired", "");
            }
            
            else{
                System.out.println("Please Choose Valid Option.");
            }
        }while(choice != 5);
    }
}
