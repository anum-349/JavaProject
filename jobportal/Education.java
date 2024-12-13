package jobportal;

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

    public void addEducation() {
        System.out.println("Education added: " + degree + " from " + institution);
    }

    public void updateEducation(String degree, String institution, int yearOfGraduation, double grade) {
        this.degree = degree;
        this.institution = institution;
        this.yearOfGraduation = yearOfGraduation;
        this.grade = grade;
        System.out.println("Education updated: " + degree + " from " + institution);
    }

    public void deleteEducation() {
        System.out.println("Education deleted: " + degree + " from " + institution);
    }

    public void viewEducation() {
        System.out.println("Degree: " + degree + ", Institution: " + institution +
                ", Year: " + yearOfGraduation + ", Grade: " + grade);
    }
}
