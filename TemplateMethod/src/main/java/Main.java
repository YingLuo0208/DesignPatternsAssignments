/**
 * 主类
 * 用于演示掷骰子游戏的运行
 */
public class Main {

    public static void main(String[] args) {
        // 创建一个掷骰子游戏实例
        Game game = new DiceGame();

        // 开始游戏，设置3个玩家
        game.play(3);
    }
}

