package jobportal;
import java.util.ArrayList;
import java.util.List;

public class Education {
    private int educationID;
    private String degree;
    private String institution;
    private int yearOfGraduation;
    private double grade;

    public Education(int educationID, String degree, String institution, int yearOfGraduation, double grade) {
        this.educationID = educationID;
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
                ", Degree: " + degree +
                ", Institution: " + institution +
                ", Year: " + yearOfGraduation +
                ", Grade: " + grade;
    }

    private static List<Education> educationList = new ArrayList<>();

    public static void addEducation(int educationID, String degree, String institution, int yearOfGraduation, double grade) {
        Education education = new Education(educationID, degree, institution, yearOfGraduation, grade);
        educationList.add(education);
        System.out.println("Education added: " + degree + " from " + institution);
    }

    public static void updateEducation(int educationID, String degree, String institution, int yearOfGraduation, double grade) {
        for (Education education : educationList) {
            if (education.getEducationID() == educationID) {
                education.setDegree(degree);
                education.setInstitution(institution);
                education.setYearOfGraduation(yearOfGraduation);
                education.setGrade(grade);
                System.out.println("Education updated: " + degree + " from " + institution);
                return;
            }
        }
        System.out.println("Education record not found with ID: " + educationID);
    }

    public static void deleteEducation(int educationID) {
        for (Education education : educationList) {
            if (education.getEducationID() == educationID) {
                educationList.remove(education);
                System.out.println("Education deleted: " + education.getDegree() + " from " + education.getInstitution());
                return;
            }
        }
        System.out.println("Education record not found with ID: " + educationID);
    }
    public static void viewAllEducation() {
        if (educationList.isEmpty()) {
            System.out.println("No education records available.");
        } else {
            System.out.println("Education Records:");
            for (Education education : educationList) {
                System.out.println(education);
            }
        }
    }}
