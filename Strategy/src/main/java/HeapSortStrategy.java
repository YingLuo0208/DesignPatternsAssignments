/**
 * HeapSortStrategy - 堆排序策略实现
 * Heap Sort implementation
 * 参考/Reference: https://www.geeksforgeeks.org/heap-sort/
 *
 * 算法说明: 堆排序首先将数组转换为最大堆，然后重复提取最大元素
 * 并重新调整堆结构
 *
 * Algorithm: Heap Sort first converts the array into a max heap,
 * then repeatedly extracts the maximum element and re-heapifies.
 */
public class HeapSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        heapSort(arr);
    }

    /**
     * 堆排序主函数
     * Main heap sort function
     */
    private void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆 (build max heap)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // 一个个从堆中提取元素 (extract elements from heap one by one)
        for (int i = n - 1; i > 0; i--) {
            // 将当前根移到末尾 (move current root to end)
            swap(arr, 0, i);

            // 对减少的堆调用heapify (call heapify on reduced heap)
            heapify(arr, i, 0);
        }
    }

    /**
     * 堆化子树，以节点i为根
     * Heapify a subtree rooted at node i
     * @param arr 数组 (array)
     * @param n 堆的大小 (size of heap)
     * @param i 根节点索引 (root node index)
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大值为根 (initialize largest as root)
        int left = 2 * i + 1; // 左子节点 (left child)
        int right = 2 * i + 2; // 右子节点 (right child)

        // 如果左子节点大于根 (if left child is larger than root)
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // 如果右子节点大于当前最大值 (if right child is larger than largest)
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // 如果最大值不是根 (if largest is not root)
        if (largest != i) {
            swap(arr, i, largest);

            // 递归堆化受影响的子树 (recursively heapify the affected sub-tree)
            heapify(arr, n, largest);
        }
    }

    /**
     * 交换数组中的两个元素
     * Swap two elements in array
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

