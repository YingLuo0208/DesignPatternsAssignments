/**
 * 掷骰子游戏实现类
 * 继承Game抽象类，实现具体的游戏逻辑
 *
 * 游戏规则：
 * 1. 每个玩家轮流掷骰子（1-6点）
 * 2. 掷出的点数累加到玩家的总分
 * 3. 当某个玩家的总分达到或超过20分时游戏结束
 * 4. 该玩家获胜
 */
public class DiceGame extends Game {

    // 游戏胜利所需的分数
    private static final int WINNING_SCORE = 20;

    // 存储每个玩家的分数
    private int[] playerScores;

    // 玩家数量
    private int numberOfPlayers;

    // 获胜者编号（-1表示还没有获胜者）
    private int winner;

    // 骰子对象（用于掷骰子）
    private Dice dice;

    /**
     * 初始化游戏
     * 设置玩家数量，初始化所有玩家的分数为0
     * @param numberOfPlayers 玩家数量
     */
    @Override
    public void initializeGame(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.playerScores = new int[numberOfPlayers];
        this.winner = -1;
        this.dice = new Dice();

        System.out.println("=== Dice Game Started ===");
        System.out.println("Number of players: " + numberOfPlayers);
        System.out.println("Winning score: " + WINNING_SCORE);
        System.out.println("Each player will roll a dice (" + dice.getMinValue() +
                         "-" + dice.getMaxValue() + ") in turn.");
        System.out.println("First player to reach " + WINNING_SCORE + " points wins!\n");
    }

    /**
     * 判断游戏是否结束
     * 当有玩家的分数达到或超过胜利分数时，游戏结束
     * @return true表示游戏结束，false表示游戏继续
     */
    @Override
    public boolean endOfGame() {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (playerScores[i] >= WINNING_SCORE) {
                winner = i;
                return true;
            }
        }
        return false;
    }

    /**
     * 执行单个玩家的回合
     * 玩家掷骰子，将点数加到总分中，并显示结果
     * @param player 当前玩家的编号
     */
    @Override
    public void playSingleTurn(int player) {
        // 掷骰子
        int diceRoll = dice.roll();

        // 将掷出的点数加到玩家的总分
        playerScores[player] += diceRoll;

        // 显示当前回合的信息
        System.out.println("Player " + player + " rolled a " + diceRoll);
        System.out.println("Player " + player + "'s total score: " + playerScores[player]);
        System.out.println();
    }

    /**
     * 显示获胜者信息
     * 游戏结束后显示哪个玩家获胜及其最终分数
     */
    @Override
    public void displayWinner() {
        System.out.println("=== Game Over ===");
        System.out.println("Player " + winner + " wins with a score of " + playerScores[winner] + "!");
        System.out.println("\nFinal Scores:");
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Player " + i + ": " + playerScores[i] + " points");
        }
    }
}

