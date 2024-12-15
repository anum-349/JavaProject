package jobportal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Skills {
    private int skillID;
    private String skillName;
    private String proficiency; 
    private static AtomicInteger generateid = new AtomicInteger(0);
    
    private static List<Skills> skillsList = new ArrayList<>();

    public Skills(String skillName, String proficiency) {
        this.skillID = generateid.getAndIncrement();
        this.skillName = skillName;
        this.proficiency = proficiency;
    }
    
    public int getSkillID() {
        return skillID;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public Skills addSkill() {
        Scanner scanner = new Scanner(System.in);
        String name;
        int s_proficiency;
        ArrayList<String> levels = new ArrayList<>(Arrays.asList("BEGINNER", "INTERMEDIATE", "ADVANCED", "EXPERT"));
        System.out.println("Enter your Skill Name: ");
        name = scanner.nextLine();
        System.out.println("Choose your proficiency Level: ");
        System.out.println("1. Beginner\n" + 
                        "2. Intermediate\n" + 
                        "3. Advanced\n" + 
                        "4. Expert");
        s_proficiency = scanner.nextInt();
        scanner.close();
        Skills skill = new Skills(name, levels.get(s_proficiency));
        skillsList.add(skill);
        System.out.println("Skill added with id: " +getSkillID()+" skill: "+ name + " (" + levels.get(s_proficiency) + ")");
        return skill;
    }

    public void updateSkill(int skillID) {
        for (Skills skill : skillsList) {
            if (skill.getSkillID() == skillID) {
                Scanner scanner = new Scanner(System.in);
                String name;
                int s_proficiency;
                ArrayList<String> levels = new ArrayList<>(Arrays.asList("BEGINNER", "INTERMEDIATE", "ADVANCED", "EXPERT"));
                System.out.println("Enter your Skill Name: ");
                name = scanner.nextLine();
                System.out.println("Choose your proficiency Level: ");
                System.out.println("1. Beginner\n" + 
                                "2. Intermediate\n" + 
                                "3. Advanced\n" + 
                                "4. Expert");
                s_proficiency = scanner.nextInt();
                scanner.close();
                skill.setSkillName(name);
                skill.setProficiency(levels.get(s_proficiency));
                System.out.println("Skill updated: " + name + " (" + levels.get(s_proficiency) + ")");
                return;
            }
        }
        System.out.println("Skill record not found with ID: " + skillID);
    }

    public void viewSkillDetails() {
        if (skillsList.isEmpty()) {
            System.out.println("No skills records available.");
        } else {
            System.out.println("Skills Records:");
            for (Skills skill : skillsList) {
                System.out.println("Skill ID: " + skill.getSkillID() + "\nSkill: " + skill.getSkillName() +
                        "\nProficiency: " + skill.getProficiency());
            }
        }
    }

    public void deleteSkill(int skillsID) {
        for (Skills skills : skillsList) {
            if (skills.getSkillID() == skillsID) {
                skillsList.remove(skills);
                System.out.println("skills deleted: " + skills.getSkillName() + " with " + skills.getProficiency());
                return;
            }
        }
        System.out.println("skills record not found with ID: " + skillsID);
    }
}
    