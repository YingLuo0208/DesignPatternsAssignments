// GameCharacter.java
// 中文注释：
// 游戏角色类，包含角色的所有属性和状态管理。
// 使用状态模式，将不同等级的行为委托给具体的状态对象。
public class GameCharacter {
    // 角色属性
    private String name;
    private int level;
    private int experiencePoints;
    private int healthPoints;

    // 当前状态
    private State currentState;

    // 升级所需的经验值常量
    public static final int EXP_TO_INTERMEDIATE = 100;
    public static final int EXP_TO_EXPERT = 250;
    public static final int EXP_TO_MASTER = 500;

    /**
     * 构造函数，初始化角色为新手状态
     * @param name 角色名称
     */
    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.currentState = new NoviceState();
    }

    // === 状态相关方法 ===

    /**
     * 设置角色的状态
     * @param state 新状态
     */
    public void setState(State state) {
        this.currentState = state;
        System.out.println(">>> " + name + " has advanced to " + state.getStateName() + " level!");
    }

    /**
     * 获取当前状态
     * @return 当前状态对象
     */
    public State getState() {
        return currentState;
    }

    // === 操作方法（委托给当前状态） ===

    /**
     * 执行训练操作
     */
    public void train() {
        currentState.train(this);
        checkLevelUp();
    }

    /**
     * 执行冥想操作
     */
    public void meditate() {
        currentState.meditate(this);
    }

    /**
     * 执行战斗操作
     */
    public void fight() {
        currentState.fight(this);
        checkLevelUp();
    }

    // === 经验值和等级管理 ===

    /**
     * 检查是否可以升级
     */
    private void checkLevelUp() {
        if (currentState instanceof NoviceState && experiencePoints >= EXP_TO_INTERMEDIATE) {
            level = 2;
            setState(new IntermediateState());
        } else if (currentState instanceof IntermediateState && experiencePoints >= EXP_TO_EXPERT) {
            level = 3;
            setState(new ExpertState());
        } else if (currentState instanceof ExpertState && experiencePoints >= EXP_TO_MASTER) {
            level = 4;
            setState(new MasterState());
        }
    }

    /**
     * 增加经验值
     * @param amount 增加的数量
     */
    public void addExperience(int amount) {
        this.experiencePoints += amount;
        System.out.println("   [+] Gained " + amount + " experience points!");
    }

    /**
     * 增加生命值
     * @param amount 增加的数量
     */
    public void addHealth(int amount) {
        this.healthPoints += amount;
        if (this.healthPoints > 100) {
            this.healthPoints = 100; // 生命值上限100
        }
        System.out.println("   [+] Restored " + amount + " health points!");
    }

    /**
     * 减少生命值
     * @param amount 减少的数量
     */
    public void reduceHealth(int amount) {
        this.healthPoints -= amount;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
        System.out.println("   [-] Lost " + amount + " health points!");
    }

    // === 显示方法 ===

    /**
     * 显示角色当前状态
     */
    public void displayStatus() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("CHARACTER STATUS");
        System.out.println("=".repeat(50));
        System.out.println("Name:       " + name);
        System.out.println("Level:      " + level + " (" + currentState.getStateName() + ")");
        System.out.println("Experience: " + experiencePoints + " / " + getNextLevelExp());
        System.out.println("Health:     " + healthPoints + " / 100");
        System.out.println("=".repeat(50));
        currentState.displayAvailableActions();
        System.out.println();
    }

    /**
     * 获取下一等级所需经验值
     * @return 所需经验值，如果已是最高等级返回 -1
     */
    private int getNextLevelExp() {
        if (currentState instanceof NoviceState) {
            return EXP_TO_INTERMEDIATE;
        } else if (currentState instanceof IntermediateState) {
            return EXP_TO_EXPERT;
        } else if (currentState instanceof ExpertState) {
            return EXP_TO_MASTER;
        } else {
            return -1; // Master level (max level)
        }
    }

    // === Getter 方法 ===

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * 检查角色是否达到大师等级（游戏结束）
     * @return true 如果是大师等级
     */
    public boolean isMaster() {
        return currentState instanceof MasterState;
    }
}
