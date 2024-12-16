
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Skills {
    private int skillID;
    private String skillName;
    private String proficiency;
    private static final List<String> PROFICIENCY_LEVELS = Arrays.asList("BEGINNER", "INTERMEDIATE", "ADVANCED", "EXPERT");
    private static AtomicInteger generateid = new AtomicInteger(0);
    private static List<Skills> skillsList = new ArrayList<>();
    private static List<String> skillsName = new ArrayList<>();


    public Skills(String skillName, String proficiency) {
        this.skillID = generateid.getAndIncrement();
        this.skillName = skillName;
        this.proficiency = proficiency;
    }

    public int getSkillID() {
        return skillID;
    }

    public List<String> getSkillList() {
        return skillsName;
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
        System.out.println("Enter your Skill Name: ");
        String name = scanner.nextLine();

        System.out.println("Choose your proficiency Level: ");
        System.out.println("1. Beginner\n2. Intermediate\n3. Advanced\n4. Expert");
        int s_proficiency = scanner.nextInt();
        scanner.nextLine(); 
        scanner.close();
        
        if (s_proficiency < 1 || s_proficiency > PROFICIENCY_LEVELS.size()) {
            System.out.println("Invalid proficiency selection. Please enter a number between 1 and 4.");
            return null;
        }

        Skills skill = new Skills(name, PROFICIENCY_LEVELS.get(s_proficiency - 1));
        skillsList.add(skill);
        skillsName.add(name);
        System.out.println("Skill added with ID: " + skill.getSkillID() + ", Skill: " + name +
                " (" + skill.getProficiency() + ")");
        return skill;
    }

    public void updateSkill(int skillID) {
        for (Skills skill : skillsList) {
            if (skill.getSkillID() == skillID) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter your Skill Name: ");
                String name = scanner.nextLine();

                System.out.println("Choose your proficiency Level: ");
                System.out.println("1. Beginner\n2. Intermediate\n3. Advanced\n4. Expert");
                int s_proficiency = scanner.nextInt();
                scanner.nextLine(); 
                scanner.close();

                if (s_proficiency < 1 || s_proficiency > PROFICIENCY_LEVELS.size()) {
                    System.out.println("Invalid proficiency selection. Please enter a number between 1 and 4.");
                    return;
                }

                skill.setSkillName(name);
                skill.setProficiency(PROFICIENCY_LEVELS.get(s_proficiency - 1));
                System.out.println("Skill updated: " + skill.getSkillName() + 
                                   " (" + skill.getProficiency() + ")");
                return;
            }
        }
        System.out.println("Skill record not found with ID: " + skillID);
    }

    public void viewSkillDetails() {
        if (skillsList.isEmpty()) {
            System.out.println("No skill records available.");
        } else {
            System.out.println("Skills Records:");
            for (Skills skill : skillsList) {
                System.out.printf("Skill ID: %d\nSkill: %s\nProficiency: %s\n",
                        skill.getSkillID(), skill.getSkillName(), skill.getProficiency());
            }
        }
    }

    public void deleteSkill(int skillsID) {
        boolean removed = skillsList.removeIf(skill -> skill.getSkillID() == skillsID);
        if (removed) {
            System.out.println("Skill deleted with ID: " + skillsID);
        } else {
            System.out.println("Skill record not found with ID: " + skillsID);
        }
    }
}
