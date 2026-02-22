// Main.java
// 中文注释：
// 主程序入口，实现游戏循环和用户交互。
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 游戏开始提示
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    GAME CHARACTER DEVELOPMENT SYSTEM");
        System.out.println("=".repeat(60));
        System.out.print("\nEnter your character's name: ");
        String characterName = scanner.nextLine();

        // 创建游戏角色
        GameCharacter character = new GameCharacter(characterName);

        System.out.println("\nWelcome, " + characterName + "!");
        System.out.println("Your journey begins as a Novice...\n");

        // 游戏主循环
        boolean playing = true;
        while (playing) {
            // 显示角色状态和可用操作
            character.displayStatus();

            // 如果达到大师等级，游戏结束
            if (character.isMaster()) {
                System.out.println("\n" + "=".repeat(60));
                System.out.println("    GAME COMPLETED!");
                System.out.println("    " + character.getName() + " has become a Master!");
                System.out.println("=".repeat(60));
                break;
            }

            // 获取用户输入
            System.out.print("Choose an action (0-3): ");
            String input = scanner.nextLine().trim();

            // 处理用户选择
            switch (input) {
                case "1":
                    character.train();
                    break;
                case "2":
                    character.meditate();
                    break;
                case "3":
                    character.fight();
                    break;
                case "0":
                    playing = false;
                    System.out.println("\nThanks for playing! Goodbye, " + character.getName() + "!");
                    break;
                default:
                    System.out.println("\n[!] Invalid choice. Please select 0, 1, 2, or 3.");
            }

            // 检查生命值
            if (character.getHealthPoints() <= 0 && !character.isMaster()) {
                System.out.println("\n" + "=".repeat(60));
                System.out.println("    GAME OVER!");
                System.out.println("    " + character.getName() + " has fallen...");
                System.out.println("=".repeat(60));
                break;
            }

            // 暂停，等待用户查看结果
            if (playing && !input.equals("0")) {
                System.out.println("\n[Press Enter to continue...]");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
