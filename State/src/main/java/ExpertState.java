// ExpertState.java
// 中文注释：
// 专家状态 - 角色可以执行所有操作：训练、冥想和战斗。
public class ExpertState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("\n" + character.getName() + " trains with mastery...");
        character.addExperience(30);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("\n" + character.getName() + " meditates deeply...");
        character.addHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("\n" + character.getName() + " engages in fierce combat!");
        character.reduceHealth(15);
        character.addExperience(40);

        if (character.getHealthPoints() <= 0) {
            System.out.println("\n   [!] WARNING: Health is critically low!");
        }
    }

    @Override
    public String getStateName() {
        return "Expert";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available Actions:");
        System.out.println("  [1] Train    - Gain experience points");
        System.out.println("  [2] Meditate - Restore health points");
        System.out.println("  [3] Fight    - Lose health but gain more experience");
        System.out.println("  [0] Quit");
    }
}
