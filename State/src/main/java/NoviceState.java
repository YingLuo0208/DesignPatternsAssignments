// NoviceState.java
// 中文注释：
// 新手状态 - 角色只能进行训练，无法冥想或战斗。
public class NoviceState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("\n" + character.getName() + " is training hard...");
        character.addExperience(20);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("\n" + character.getName() + " is too inexperienced to meditate.");
        System.out.println("   [!] Action not available at Novice level!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("\n" + character.getName() + " is too weak to fight.");
        System.out.println("   [!] Action not available at Novice level!");
    }

    @Override
    public String getStateName() {
        return "Novice";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available Actions:");
        System.out.println("  [1] Train    - Gain experience points");
        System.out.println("  [2] Meditate - NOT AVAILABLE");
        System.out.println("  [3] Fight    - NOT AVAILABLE");
        System.out.println("  [0] Quit");
    }
}
