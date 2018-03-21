package com.ado.sort;

/**
 * @author Jackie
 **/
public class QuickSort extends Sort {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快速排序
     * @param group
     * @param low
     * @param high
     */
    public static void quickSort(int[] group, int low, int high) {
        int pivotPos;
        if(low < high) {
            pivotPos = partition(group, low, high);
            quickSort(group, low, pivotPos - 1);
            quickSort(group, pivotPos + 1, high);
        }
    }

    private static int partition(int[] group, int i, int j) {

        int pivot = group[i];
        while (i < j) {
            // 右侧指针向左移动
            while (i < j && group[j] >= pivot) {
                j--;
            }
            if (i < j) {
                group[i] = group[j];
                i++;
            }
            // 左侧指针向右移动
            while (i < j && group[i] <= pivot) {
                i++;
            }
            //当指针i和j没有相交时存在元素比基准大,就把元素
            if (i < j) { // 如果在没有使指针i和j相交的情况下找到了group[i] <= 基准元素pivot
                group[j] = group[i]; // 基准元素放到了i指针处
                j--; // 右侧j指针需要向左移动一个位置
            }
        }
        group[i] = pivot;
        return i;
    }
}
