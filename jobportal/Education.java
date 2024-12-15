package jobportal;
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
        return "EducationID: " + educationID +
                "\n Degree: " + degree +
                "\n Institution: " + institution +
                "\n Year: " + yearOfGraduation +
                "\n Grade: " + grade;
    }

    public Education addEducation() {
        Scanner scanner = new Scanner(System.in);
        String e_degree, e_institution;
        int e_year;
        double e_grade;
        System.out.println("Enter your Degree: ");
        e_degree = scanner.nextLine();
        System.out.println("Enter your Institution: ");
        e_institution = scanner.nextLine();
        System.out.println("Enter your Year of Graduation: ");
        e_year = scanner.nextInt();
        System.out.println("Enter your Grade: ");
        e_grade = scanner.nextDouble();
        scanner.close();
        Education education = new Education(e_degree, e_institution, e_year, e_grade);
        educationList.add(education);
        System.out.println("Education with id: " +getEducationID()+" degree: "+ e_degree + " from " + e_institution);
        return education;
    }

    public void updateEducation(int educationID) {
        for (Education education : educationList) {
            if (education.getEducationID() == educationID) {
                Scanner scanner = new Scanner(System.in);
                String e_degree, e_institution;
                int e_year;
                double e_grade;
                System.out.println("Enter your Degree: ");
                e_degree = scanner.nextLine();
                System.out.println("Enter your Institution: ");
                e_institution = scanner.nextLine();
                System.out.println("Enter your Year of Graduation: ");
                e_year = scanner.nextInt();
                System.out.println("Enter your Grade: ");
                e_grade = scanner.nextDouble();
                scanner.close();
                education.setDegree(e_degree);
                education.setInstitution(e_institution);
                education.setYearOfGraduation(e_year);
                education.setGrade(e_grade);
                System.out.println("Education updated: " + e_degree + " from " + e_institution);
                return;
            }
        }
        System.out.println("Education record not found with ID: " + educationID);
    }

    public void deleteEducation(int educationID) {
        for (Education education : educationList) {
            if (education.getEducationID() == educationID) {
                educationList.remove(education);
                System.out.println("Education deleted: " + education.getDegree() + " from " + education.getInstitution());
                return;
            }
        }
        System.out.println("Education record not found with ID: " + educationID);
    }
    public void viewAllEducation() {
        if (educationList.isEmpty()) {
            System.out.println("No education records available.");
        } else {
            System.out.println("Education Records:");
            for (Education education : educationList) {
                System.out.println(education.toString());
            }
        }
    }}
