/**
 * MergeSortStrategy - 归并排序策略实现
 * Merge Sort implementation
 * 参考/Reference: https://www.geeksforgeeks.org/merge-sort/
 *
 * 算法说明: 归并排序使用分治法，将数组分为两半，递归排序每一半，
 * 然后合并两个已排序的半部分
 *
 * Algorithm: Merge Sort uses divide-and-conquer by dividing the array into two halves,
 * recursively sorting each half, then merging the two sorted halves.
 */
public class MergeSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归归并排序
     * Recursive merge sort
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // 找到中间点 (find middle point)
            int mid = left + (right - left) / 2;

            // 排序前半部分 (sort first half)
            mergeSort(arr, left, mid);
            // 排序后半部分 (sort second half)
            mergeSort(arr, mid + 1, right);

            // 合并两个已排序的半部分 (merge the sorted halves)
            merge(arr, left, mid, right);
        }
    }

    /**
     * 合并两个子数组
     * Merge two subarrays
     */
    private void merge(int[] arr, int left, int mid, int right) {
        // 计算两个子数组的大小 (find sizes of two subarrays)
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // 创建临时数组 (create temp arrays)
        int[] L = new int[n1];
        int[] R = new int[n2];

        // 复制数据到临时数组 (copy data to temp arrays)
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // 合并临时数组 (merge the temp arrays)
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // 复制剩余元素 (copy remaining elements)
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

