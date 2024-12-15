package jobportal;
import java.util.ArrayList;
import java.util.List;

public class Skills {
    private int skillID;
    private String skillName;
    private String proficiency; 
    
    private static List<Skills> skillsList = new ArrayList<>();

    public Skills(int skillID, String skillName, String proficiency) {
        this.skillID = skillID;
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

    public static void addSkill(int skillID, String skillName, String proficiency) {
        Skills skill = new Skills(skillID, skillName, proficiency);
        skillsList.add(skill);
        System.out.println("Skill added: " + skillName + " (" + proficiency + ")");
    }

    public static void updateSkill(int skillID, String skillName, String proficiency) {
        for (Skills skill : skillsList) {
            if (skill.getSkillID() == skillID) {
                skill.setSkillName(skillName);
                skill.setProficiency(proficiency);
                System.out.println("Skill updated: " + skillName + " (" + proficiency + ")");
                return;
            }
        }
        System.out.println("Skill record not found with ID: " + skillID);
    }

    public static void getSkillDetails() {
        if (skillsList.isEmpty()) {
            System.out.println("No skills records available.");
        } else {
            System.out.println("Skills Records:");
            for (Skills skill : skillsList) {
                System.out.println("Skill ID: " + skill.getSkillID() + ", Skill: " + skill.getSkillName() +
                        ", Proficiency: " + skill.getProficiency());
            }
        }
    }
}
    