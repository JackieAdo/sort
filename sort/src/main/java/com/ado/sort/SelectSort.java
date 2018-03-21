package com.ado.sort;

/**
 * @author Jackie
 **/
public class SelectSort extends Sort {

    @Override
    public void sort(int[] array) {
        quickSort(array);
    }

    private void quickSort(int[] array) {
        int tmp; // 用于交换数据的暂存单元
        for (int i = 0; i < array.length - 1; i++) { // 这里只要从0~array.length-2即可
            int k = i;
            for (int j = i + 1; j < array.length; j++) { // 该循环可以找到右侧无序区最小的元素array[k]
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            if (k != i) { // 如果array[i]不是无序区最小的，需要与无序区最小的进行交换
                tmp = array[i];
                array[i] = array[k];
                array[k] = tmp;
            }
            // 如果array[i]是无序区最小的元素，不需要执行交换
        }
    }
}
