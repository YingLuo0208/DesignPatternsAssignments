# Strategy Pattern - Algorithm Performance Comparison
# 策略模式 - 算法性能比较

## Project Overview / 项目概述

This project implements three sorting algorithms using the Strategy design pattern and compares their performance empirically.

本项目使用策略设计模式实现了三种排序算法，并对它们的性能进行了实证比较。

## Design Pattern / 设计模式

**Strategy Pattern / 策略模式**

The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

策略模式定义了一系列算法，将每个算法封装起来，并使它们可以互换。策略模式让算法独立于使用它的客户端而变化。

## File Structure / 文件结构

```
Strategy/
├── src/main/java/
│   ├── SortStrategy.java          # Strategy interface / 策略接口
│   ├── QuickSortStrategy.java     # Quick Sort implementation / 快速排序实现
│   ├── MergeSortStrategy.java     # Merge Sort implementation / 归并排序实现
│   ├── HeapSortStrategy.java      # Heap Sort implementation / 堆排序实现
│   ├── SortContext.java           # Context class / 上下文类
│   └── Main.java                  # Main program / 主程序
├── pom.xml
└── README.md
```

## File Descriptions / 文件说明

### 1. SortStrategy.java
**Strategy Interface / 策略接口**

Defines the contract for all sorting strategies. All concrete sorting strategies must implement the `sort(int[] arr)` method.

定义所有排序策略的契约。所有具体的排序策略都必须实现 `sort(int[] arr)` 方法。

**Location / 位置:** `src/main/java/SortStrategy.java`

---

### 2. QuickSortStrategy.java
**Quick Sort Strategy / 快速排序策略**

Implements the Quick Sort algorithm using divide-and-conquer approach. Selects a pivot element, partitions the array into elements less than and greater than the pivot, then recursively sorts both parts.

实现快速排序算法，使用分治法。选择一个基准元素，将数组分为小于和大于基准的部分，然后递归排序这两部分。

**Time Complexity / 时间复杂度:**
- Average / 平均: O(n log n)
- Worst / 最坏: O(n²)

**Space Complexity / 空间复杂度:** O(log n)

**Reference / 参考:** https://www.geeksforgeeks.org/quick-sort/

**Location / 位置:** `src/main/java/QuickSortStrategy.java`

---

### 3. MergeSortStrategy.java
**Merge Sort Strategy / 归并排序策略**

Implements the Merge Sort algorithm using divide-and-conquer. Divides the array into two halves, recursively sorts each half, then merges the two sorted halves.

实现归并排序算法，使用分治法。将数组分为两半，递归排序每一半，然后合并两个已排序的半部分。

**Time Complexity / 时间复杂度:**
- All cases / 所有情况: O(n log n)

**Space Complexity / 空间复杂度:** O(n)

**Reference / 参考:** https://www.geeksforgeeks.org/merge-sort/

**Location / 位置:** `src/main/java/MergeSortStrategy.java`

---

### 4. HeapSortStrategy.java
**Heap Sort Strategy / 堆排序策略**

Implements the Heap Sort algorithm. First converts the array into a max heap, then repeatedly extracts the maximum element and re-heapifies.

实现堆排序算法。首先将数组转换为最大堆，然后重复提取最大元素并重新调整堆结构。

**Time Complexity / 时间复杂度:**
- All cases / 所有情况: O(n log n)

**Space Complexity / 空间复杂度:** O(1)

**Reference / 参考:** https://www.geeksforgeeks.org/heap-sort/

**Location / 位置:** `src/main/java/HeapSortStrategy.java`

---

### 5. SortContext.java
**Context Class / 上下文类**

Maintains a reference to a SortStrategy object and allows dynamic switching between different sorting strategies at runtime.

维护对 SortStrategy 对象的引用，允许在运行时动态切换不同的排序策略。

**Location / 位置:** `src/main/java/SortContext.java`

---

### 6. Main.java
**Main Program / 主程序**

Demonstrates the Strategy pattern and compares the performance of three sorting algorithms. Generates two datasets (small: 30 elements, large: 100,000 elements) and measures execution time for each algorithm on both datasets.

演示策略模式并比较三种排序算法的性能。生成两个数据集（小：30个元素，大：100,000个元素），并测量每种算法在两个数据集上的执行时间。

**Location / 位置:** `src/main/java/Main.java`

---

## How to Run / 运行方法

### Option 1: Using Maven / 使用 Maven

```bash
# Compile the project / 编译项目
mvn -f "C:\Users\Eu'do'ra\IdeaProjects\DesignPatternsAssignments\Strategy\pom.xml" compile

# Run the main class / 运行主类
java -cp "C:\Users\Eu'do'ra\IdeaProjects\DesignPatternsAssignments\Strategy\target\classes" Main
```

### Option 2: Using IDE / 使用 IDE

1. Open the Strategy project in your IDE / 在IDE中打开Strategy项目
2. Navigate to `Main.java` / 导航到 `Main.java`
3. Run the `main()` method / 运行 `main()` 方法

---

## Expected Output / 预期输出

```
=== Algorithm Performance Comparison ===

--- Small Array (30 elements) ---
QuickSort: 23,300 ns (0.023 ms)
MergeSort: 28,000 ns (0.028 ms)
HeapSort: 31,700 ns (0.032 ms)

--- Large Array (100000 elements) ---
QuickSort: 16 ms
MergeSort: 18 ms
HeapSort: 25 ms

--- Strategy Pattern Demonstration ---
Original array: [64, 34, 25, 12, 22, 11, 90]
Sorted with QuickSort: [11, 12, 22, 25, 34, 64, 90]
Sorted with MergeSort: [11, 12, 22, 25, 34, 64, 90]
Sorted with HeapSort: [11, 12, 22, 25, 34, 64, 90]
```

---

## Implementation Details / 实现细节

### Strategy Pattern Structure / 策略模式结构

```
SortStrategy (Interface)
    ├── QuickSortStrategy
    ├── MergeSortStrategy
    └── HeapSortStrategy

SortContext (uses SortStrategy)

Main (client code)
```

### Key Features / 关键特性

1. **Encapsulation / 封装**: Each sorting algorithm is encapsulated in its own class / 每个排序算法都封装在自己的类中

2. **Interchangeability / 可互换性**: Algorithms can be switched at runtime / 算法可以在运行时切换

3. **Open/Closed Principle / 开闭原则**: New sorting strategies can be added without modifying existing code / 可以添加新的排序策略而无需修改现有代码

4. **Performance Testing / 性能测试**: Empirical comparison of algorithm performance / 算法性能的实证比较

---

## Quick Reference - Class Locations / 快速参考 - 类位置

| Class Name / 类名 | File / 文件 | Purpose / 用途 |
|-------------------|-------------|----------------|
| SortStrategy | `SortStrategy.java` | Strategy interface / 策略接口 |
| QuickSortStrategy | `QuickSortStrategy.java` | Quick Sort / 快速排序 |
| MergeSortStrategy | `MergeSortStrategy.java` | Merge Sort / 归并排序 |
| HeapSortStrategy | `HeapSortStrategy.java` | Heap Sort / 堆排序 |
| SortContext | `SortContext.java` | Context / 上下文 |
| Main | `Main.java` | Main program / 主程序 |

---

## Brief Explanation / 简要说明

**English:**
This project implements the Strategy design pattern with three sorting algorithms: QuickSort, MergeSort, and HeapSort. Each algorithm is encapsulated as a strategy class implementing the SortStrategy interface. The SortContext class allows dynamic algorithm switching. The Main class generates two datasets (30 and 100,000 elements), sorts them with each algorithm, and measures execution time for performance comparison.

**中文:**
本项目使用策略设计模式实现了三种排序算法：快速排序、归并排序和堆排序。每个算法都作为实现SortStrategy接口的策略类进行封装。SortContext类允许动态切换算法。Main类生成两个数据集（30和100,000个元素），使用每种算法对它们进行排序，并测量执行时间以进行性能比较。

---

## Assignment Requirements Met / 满足的作业要求

✅ Implemented three sorting algorithms (QuickSort, MergeSort, HeapSort) / 实现了三种排序算法

✅ Used Strategy design pattern / 使用了策略设计模式

✅ Each algorithm acts as a separate strategy / 每个算法作为独立策略

✅ Algorithms can be switched at runtime / 算法可在运行时切换

✅ Generated two datasets (small: 30, large: 100,000 elements) / 生成两个数据集

✅ Measured and displayed execution time for performance comparison / 测量并显示执行时间进行性能比较

✅ Referenced source code from GeeksforGeeks / 引用了GeeksforGeeks的源代码

✅ No built-in sorting methods used / 未使用内置排序方法

---

## Notes / 注意事项

- All algorithms sort arrays in-place or use auxiliary space as needed / 所有算法就地排序或根据需要使用辅助空间
- Random number generator uses fixed seed (42) for reproducibility / 随机数生成器使用固定种子(42)以确保可重现性
- Performance results may vary based on hardware and JVM / 性能结果可能因硬件和JVM而异
- All source code is in English, comments are bilingual / 所有源代码为英文，注释为双语

