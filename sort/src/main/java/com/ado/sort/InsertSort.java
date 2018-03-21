package com.ado.sort;

/**
 * @author Jackie
 **/
public class InsertSort extends Sort {

    @Override
    public void sort(int[] array) {
        insertSort(array);
    }

    /**
     * 插入排序
     * @param group
     */
    public static void insertSort(int[] group){

        for (int i = 0; i <  group.length; i++){
            for (int j = i; j < group.length; j++){
                int temp = group[i];
                if (group[i] > group[j]){
                    group[i] = group[j];
                    group[j] = temp;
                }
            }
        }
    }
}
