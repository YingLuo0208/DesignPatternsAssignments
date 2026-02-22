// State.java
// 中文注释：
// 状态接口，定义游戏角色在不同状态下可以执行的操作。
// 每个具体状态类都需要实现这个接口，提供不同的行为实现。
public interface State {
    /**
     * 训练操作：增加经验值
     * @param character 游戏角色对象
     */
    void train(GameCharacter character);

    /**
     * 冥想操作：增加生命值
     * @param character 游戏角色对象
     */
    void meditate(GameCharacter character);

    /**
     * 战斗操作：减少生命值但增加经验值
     * @param character 游戏角色对象
     */
    void fight(GameCharacter character);

    /**
     * 获取当前状态的名称
     * @return 状态名称
     */
    String getStateName();

    /**
     * 显示当前状态下可用的操作
     */
    void displayAvailableActions();
}
