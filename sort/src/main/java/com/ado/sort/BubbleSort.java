package com.ado.sort;

/**
 * @author Jackie
 **/
public class BubbleSort extends Sort {

    @Override
    public void sort(int[] array) {
        bubbleSort(array);
    }

    /**
     * 冒泡排序
     * @param group
     */
    public static void bubbleSort(int[] group){
        for (int i = 0; i < group.length - 1; i++) {
            for (int j = i; j < group.length; j++) {
                if(group[i] > group[j]) {
                    int temp = group[i];
                    group[i] = group[j];
                    group[j] = temp;
                }
            }
        }
    }
}
