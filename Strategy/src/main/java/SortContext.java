/**
 * SortContext - 排序上下文类
 * Context class for sorting using different strategies
 *
 * 这个类使用策略模式，允许在运行时切换不同的排序算法
 * This class uses the Strategy pattern to allow switching between different sorting algorithms at runtime
 */
public class SortContext {
    private SortStrategy strategy;

    /**
     * 构造函数
     * Constructor
     * @param strategy 排序策略 (sorting strategy)
     */
    public SortContext(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 设置新的排序策略
     * Set a new sorting strategy
     * @param strategy 新的排序策略 (new sorting strategy)
     */
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 使用当前策略对数组进行排序
     * Sort the array using the current strategy
     * @param arr 要排序的数组 (array to sort)
     */
    public void sort(int[] arr) {
        strategy.sort(arr);
    }
}

