// IntermediateState.java
// 中文注释：
// 中级状态 - 角色可以训练和冥想，但还不能战斗。
public class IntermediateState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("\n" + character.getName() + " is training with focus...");
        character.addExperience(25);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("\n" + character.getName() + " enters a meditative state...");
        character.addHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("\n" + character.getName() + " is not skilled enough to fight yet.");
        System.out.println("   [!] Action not available at Intermediate level!");
    }

    @Override
    public String getStateName() {
        return "Intermediate";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println("Available Actions:");
        System.out.println("  [1] Train    - Gain experience points");
        System.out.println("  [2] Meditate - Restore health points");
        System.out.println("  [3] Fight    - NOT AVAILABLE");
        System.out.println("  [0] Quit");
    }
}
