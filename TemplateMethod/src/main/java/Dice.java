import java.util.Random;

/**
 * 骰子类
 * 负责生成随机的骰子点数
 */
public class Dice {

    // 骰子的最小点数
    private static final int MIN_VALUE = 1;

    // 骰子的最大点数
    private static final int MAX_VALUE = 6;

    // 随机数生成器
    private final Random random;

    /**
     * 构造函数
     * 初始化随机数生成器
     */
    public Dice() {
        this.random = new Random();
    }

    /**
     * 掷骰子
     * 生成1到6之间的随机数
     * @return 骰子的点数（1-6）
     */
    public int roll() {
        return random.nextInt(MAX_VALUE) + MIN_VALUE;
    }

    /**
     * 获取骰子的最小值
     * @return 最小点数
     */
    public int getMinValue() {
        return MIN_VALUE;
    }

    /**
     * 获取骰子的最大值
     * @return 最大点数
     */
    public int getMaxValue() {
        return MAX_VALUE;
    }
}

