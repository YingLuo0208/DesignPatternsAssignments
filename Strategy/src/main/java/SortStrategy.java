/**
 * SortStrategy 接口 - 定义排序算法的策略接口
 * Strategy interface for sorting algorithms
 */
public interface SortStrategy {
    /**
     * 对数组进行排序（就地排序）
     * Sort the array in-place
     * @param arr 要排序的整型数组 (the integer array to sort)
     */
    void sort(int[] arr);
}

