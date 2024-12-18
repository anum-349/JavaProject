/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.util.Scanner;

/**
 *
 * @author Rajput
 */
public class JavaProject {

    public static void main(String[] args) {
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
                jobseeker.profile_Application();
            }
            else if( choice == 2){
                employeer(scanner);  
            }
            else{
                System.out.println("Please enter valid choice.");
            }
        }while( choice != 3 );
    }
    private static void employeer(Scanner scanner){
        int choice;
        do{
            System.out.println("1: FrontEndDeveloperJobs");
            System.out.println("2: BackendDeveloperJobs");
            System.out.println("3: SoftwareDeveloperJobs");      
            System.out.println("4: Exit");        
            System.out.println("Choose an option: ");
            choice = scanner.nextInt();
            if(choice == 1){
                Job frontendJob = new FrontEndDeveloperJobs();
                jobMenu(frontendJob);
            }
            else if(choice == 2){
                Job backendJob = new BackendDeveloperJobs();
                jobMenu(backendJob);
            }
            else if(choice == 3){
                Job softwareEngineerJob = new SoftwareDeveloperJobs();
                jobMenu(softwareEngineerJob);
            }
        }while(choice != 4);
    }

    private static void jobMenu(Job type){
        Scanner scanner = new Scanner(System.in); 
        int choice, jobid;
        do{
            System.out.println("1: Create Job");
            System.out.println("2: Update Job");
            System.out.println("3: Delete Job");
            System.out.println("4: View Jobs");        
            System.out.println("5: Exit");        
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
            else{
                System.out.println("Please Choose Valid Option.");
            }
        }while(choice != 5);
    }
}
