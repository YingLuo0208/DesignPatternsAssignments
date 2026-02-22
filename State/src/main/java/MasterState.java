// MasterState.java
// 中文注释：
// 大师状态 - 角色已达到最高等级，游戏结束。
public class MasterState implements State {

    @Override
    public void train(GameCharacter character) {
        System.out.println("\n" + character.getName() + " has mastered all training techniques.");
        System.out.println("   [!] No need to train anymore - you are a Master!");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("\n" + character.getName() + " meditates in perfect harmony.");
        System.out.println("   [!] You have achieved enlightenment!");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("\n" + character.getName() + " has transcended the need for combat.");
        System.out.println("   [!] You are beyond fighting now!");
    }

    @Override
    public String getStateName() {
        return "Master";
    }

    @Override
    public void displayAvailableActions() {
        System.out.println(">>> CONGRATULATIONS! You have reached Master level! <<<");
        System.out.println(">>> The game is complete! <<<");
        System.out.println("\nAvailable Actions:");
        System.out.println("  [0] Quit - End the game");
    }
}
