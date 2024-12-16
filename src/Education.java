import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Education {
    private int educationID;
    private String degree;
    private String institution;
    private int yearOfGraduation;
    private double grade;
    private static AtomicInteger idGenerator = new AtomicInteger(0);
    private static List<Education> educationList = new ArrayList<>();

    public Education(String degree, String institution, int yearOfGraduation, double grade) {
        this.educationID = idGenerator.getAndIncrement();
        this.degree = degree;
        this.institution = institution;
        this.yearOfGraduation = yearOfGraduation;
        this.grade = grade;
    }

    public int getEducationID() {
        return educationID;
    }

    public String getDegree() {
        return degree;
    }

    public String getInstitution() {
        return institution;
    }

    public int getYearOfGraduation() {
        return yearOfGraduation;
    }

    public double getGrade() {
        return grade;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public void setYearOfGraduation(int yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("EducationID: %d\nDegree: %s\nInstitution: %s\nYear: %d\nGrade: %.2f",
                educationID, degree, institution, yearOfGraduation, grade);
    }

    public Education addEducation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Degree: ");
        String e_degree = scanner.nextLine();
        System.out.println("Enter your Institution: ");
        String e_institution = scanner.nextLine();
        System.out.println("Enter your Year of Graduation: ");
        int e_year = scanner.nextInt();
        System.out.println("Enter your Grade: ");
        double e_grade = scanner.nextDouble();
        scanner.nextLine(); 
        scanner.close();
        Education education = new Education(e_degree, e_institution, e_year, e_grade);
        educationList.add(education);
        System.out.println("Education added: " + education);
        return education;
    }

    public void updateEducation(int educationID) {
        for (Education education : educationList) {
            if (education.getEducationID() == educationID) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Updating education details for ID: " + educationID);
                System.out.println("Enter your Degree: ");
                String e_degree = scanner.nextLine();
                System.out.println("Enter your Institution: ");
                String e_institution = scanner.nextLine();
                System.out.println("Enter your Year of Graduation: ");
                int e_year = scanner.nextInt();
                System.out.println("Enter your Grade: ");
                double e_grade = scanner.nextDouble();
                scanner.nextLine(); 
                scanner.close();
                education.setDegree(e_degree);
                education.setInstitution(e_institution);
                education.setYearOfGraduation(e_year);
                education.setGrade(e_grade);
                System.out.println("Education updated: " + education);
                return;
            }
        }
        System.out.println("Education record not found with ID: " + educationID);
    }

    public void deleteEducation(int educationID) {
        boolean removed = educationList.removeIf(education -> education.getEducationID() == educationID);
        if (removed) {
            System.out.println("Education record deleted for ID: " + educationID);
        } else {
            System.out.println("Education record not found with ID: " + educationID);
        }
    }

    public void viewAllEducation() {
        if (educationList.isEmpty()) {
            System.out.println("No education records available.");
        } else {
            System.out.println("Education Records:");
            for (Education education : educationList) {
                System.out.println(education);
            }
        }
    }
}
