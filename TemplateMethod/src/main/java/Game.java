/**
 * 游戏框架抽象类
 * 使用模板方法模式定义游戏的通用流程
 */
public abstract class Game {

    /**
     * 模板方法：定义游戏的整体流程
     * 这个方法不能被子类重写（final）
     * @param numberOfPlayers 玩家数量
     */
    public final void play(int numberOfPlayers) {
        // a template method specifying a generic game
        initializeGame(numberOfPlayers);
        int playerInTurn = 0;
        while (!endOfGame()) {
            playSingleTurn(playerInTurn);
            playerInTurn = ++playerInTurn % numberOfPlayers;
        }
        displayWinner();
    }

    /**
     * 初始化游戏
     * @param numberOfPlayers 玩家数量
     */
    public abstract void initializeGame(int numberOfPlayers);

    /**
     * 判断游戏是否结束
     * @return true表示游戏结束，false表示游戏继续
     */
    public abstract boolean endOfGame();

    /**
     * 执行单个玩家的回合
     * @param player 当前玩家的编号
     */
    public abstract void playSingleTurn(int player);

    /**
     * 显示获胜者信息
     */
    public abstract void displayWinner();
}

