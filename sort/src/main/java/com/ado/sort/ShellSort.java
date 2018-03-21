package com.ado.sort;

/**
 * @author Jackie
 **/
public class ShellSort extends Sort {

    @Override
    public void sort(int[] array) {
        shellSort(array);
    }

    /**
     * 希尔排序
     * @param group
     */
    public static void shellSort(int[] group){
        int length = group.length;
        int d = length;
        while (d>1){
            d /= 2;
            for (int i = d;i < group.length;i++) {
                int temp = group[i];
                // 如果待处理的无序区第一个元素array[i] < 有序区最大的元素array[i-d]
                // 需要将有序区比array[i]大的元素向后移动
                if (temp < group[i-d]){
                    int j = i - d;
                    while (j >= 0 && temp < group[j]){
                        // 如果array[i] >= 左侧有序区最大的array[i-d]，或者经过扫描移动后，找到一个比array[i]小的元素
                        // 将右侧无序区第一个元素tmp = array[i]放到正确的位置上
                        group[j + d] = group[j];
                        group[j] = temp;
                        j -= d;
                    }
                }
            }
        }
    }
}
