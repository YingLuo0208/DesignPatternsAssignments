/**
 * QuickSortStrategy - 快速排序策略实现
 * Quick Sort implementation
 * 参考/Reference: https://www.geeksforgeeks.org/quick-sort/
 *
 * 算法说明: 快速排序使用分治法，选择一个基准元素，将数组分为两部分：
 * 小于基准的元素和大于基准的元素，然后递归排序这两部分
 *
 * Algorithm: QuickSort uses divide-and-conquer by selecting a pivot element,
 * partitioning the array into elements less than and greater than the pivot,
 * then recursively sorting both parts.
 */
public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归快速排序
     * Recursive quick sort
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找到分区点 (find partition point)
            int pi = partition(arr, low, high);

            // 分别排序分区前后的元素 (sort elements before and after partition)
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * 分区函数，将数组分为两部分
     * Partition function to divide array into two parts
     */
    private int partition(int[] arr, int low, int high) {
        // 选择最右边的元素作为基准 (choose rightmost element as pivot)
        int pivot = arr[high];
        int i = low - 1; // 较小元素的索引 (index of smaller element)

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准 (if current element <= pivot)
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
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

