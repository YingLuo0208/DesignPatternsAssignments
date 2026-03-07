import java.util.Arrays;
import java.util.Random;

/**
 * Main - 主程序，演示策略模式和性能比较
 * Main program demonstrating Strategy pattern and performance comparison
 *
 * 程序生成两个数据集（小和大），并使用三种不同的排序策略对它们进行排序，
 * 测量并比较每种策略的执行时间
 *
 * The program generates two datasets (small and large) and sorts them using
 * three different sorting strategies, measuring and comparing execution time.
 */
public class Main {
    public static void main(String[] args) {
        // 定义数据集大小 (define dataset sizes)
        int smallSize = 30;
        int largeSize = 100000;

        // 生成随机数组 (generate random arrays)
        int[] small = generateRandomArray(smallSize, 1000);
        int[] large = generateRandomArray(largeSize, 1000000);

        // 创建三种排序策略 (create three sorting strategies)
        SortStrategy[] strategies = new SortStrategy[] {
                new QuickSortStrategy(),
                new MergeSortStrategy(),
                new HeapSortStrategy()
        };
        String[] names = new String[] {"QuickSort", "MergeSort", "HeapSort"};

        System.out.println("=== Algorithm Performance Comparison ===\n");

        // 测试小数组 (test small array)
        System.out.println("--- Small Array (" + smallSize + " elements) ---");
        for (int i = 0; i < strategies.length; i++) {
            int[] copy = Arrays.copyOf(small, small.length);
            long startTime = System.nanoTime();
            strategies[i].sort(copy);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%s: %,d ns (%.3f ms)\n",
                names[i], duration, duration / 1_000_000.0);

            // 验证排序正确性 (verify sorting correctness)
            if (!isSorted(copy)) {
                System.out.println("ERROR: " + names[i] + " did not sort correctly!");
            }
        }

        System.out.println();

        // 测试大数组 (test large array)
        System.out.println("--- Large Array (" + largeSize + " elements) ---");
        for (int i = 0; i < strategies.length; i++) {
            int[] copy = Arrays.copyOf(large, large.length);
            long startTime = System.nanoTime();
            strategies[i].sort(copy);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%s: %,d ms\n", names[i], duration / 1_000_000);

            // 验证排序正确性 (verify sorting correctness)
            if (!isSorted(copy)) {
                System.out.println("ERROR: " + names[i] + " did not sort correctly!");
            }
        }

        // 演示使用SortContext动态切换策略 (demonstrate dynamic strategy switching with SortContext)
        System.out.println("\n--- Strategy Pattern Demonstration ---");
        int[] testArray = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array: " + Arrays.toString(testArray));

        SortContext context = new SortContext(new QuickSortStrategy());
        int[] arr1 = Arrays.copyOf(testArray, testArray.length);
        context.sort(arr1);
        System.out.println("Sorted with QuickSort: " + Arrays.toString(arr1));

        context.setStrategy(new MergeSortStrategy());
        int[] arr2 = Arrays.copyOf(testArray, testArray.length);
        context.sort(arr2);
        System.out.println("Sorted with MergeSort: " + Arrays.toString(arr2));

        context.setStrategy(new HeapSortStrategy());
        int[] arr3 = Arrays.copyOf(testArray, testArray.length);
        context.sort(arr3);
        System.out.println("Sorted with HeapSort: " + Arrays.toString(arr3));
    }

    /**
     * 生成指定大小的随机整数数组
     * Generate a random integer array of specified size
     * @param size 数组大小 (array size)
     * @param maxValue 最大值 (maximum value)
     * @return 随机整数数组 (random integer array)
     */
    private static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random(42); // 固定种子以便复现 (fixed seed for reproducibility)
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(maxValue);
        }
        return arr;
    }

    /**
     * 检查数组是否已排序
     * Check if array is sorted
     * @param arr 要检查的数组 (array to check)
     * @return 如果已排序返回true (true if sorted)
     */
    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}

