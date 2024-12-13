package jobportal;

public class Skills {
    private String skillName;
    private String proficiency; // e.g., "Beginner", "Intermediate", "Expert"

    public Skills(String skillName, String proficiency) {
        this.skillName = skillName;
        this.proficiency = proficiency;
    }

    public void addSkill() {
        System.out.println("Skill added: " + skillName + " (" + proficiency + ")");
    }

    public void updateSkill(String skillName, String proficiency) {
        this.skillName = skillName;
        this.proficiency = proficiency;
        System.out.println("Skill updated: " + skillName + " (" + proficiency + ")");
    }

    public void getSkillDetails() {
        System.out.println("Skill: " + skillName + ", Proficiency: " + proficiency);
    }
}
