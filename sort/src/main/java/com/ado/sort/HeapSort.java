package com.ado.sort;

/**
 * @author Jackie
 **/
public class HeapSort extends Sort {

    @Override
    public void sort(int[] array) {
        heapSort(array);
    }

    /**
     * <p>堆排序方法
     * 基于大根堆的堆排序方法
     */
    private void heapSort(int[] array) {
        Integer tmp; // 用于交换的暂存单元
        buildHeap(array); // 执行初始建堆，并调整
        for (int i = 0; i < array.length; i++) {
            // 交换堆顶元素array[0]和堆中最后一个元素array[array.length-1-i]
            tmp = array[0];
            array[0] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
            // 每次交换堆顶元素和堆中最后一个元素之后，都要对堆进行调整
            adjustHeap(array, 0, array.length - 1 - i);
        }
    }

    /**
     *
     * 建堆方法
     *
     * 调整堆中0~array.length/2个结点，保持堆的性质
     *
     */
    private void buildHeap(int[] array) {
        // 求出当前堆中最后一个存在孩子结点的索引
        int pos = (array.length - 1) / 2;
        // 从该结点结点开始，执行建堆操作
        for (int i = pos; i >= 0; i--) {
            adjustHeap(array, i, array.length); // 在建堆过程中，及时调整堆中索引为i的结点
        }
    }

    /**
     *
     * 调整堆的方法
     *
     * @param s 待调整结点的索引
     * @param m 待调整堆的结点的数量(亦即：排除叶子结点)
     */
    private void adjustHeap(int[] array, int s, int m) {
        Integer tmp = array[s]; // 当前待调整的结点
        int i = 2 * s + 1; // 当前待调整结点的左孩子结点的索引(i+1为当前调整结点的右孩子结点的索引)
        while (i < m) {
            if (i + 1 < m && array[i] < array[i + 1]) { // 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)
                i = i + 1;
            }
            if (array[s] < array[i]) {
                array[s] = array[i]; // 孩子结点大于当前待调整结点，将孩子结点放到当前待调整结点的位置上
                s = i; // 重新设置待调整的下一个结点的索引
                i = 2 * s + 1;
            } else { // 如果当前待调整结点大于它的左右孩子，则不需要调整，直接退出
                break;
            }
            array[s] = tmp; // 当前待调整的结点放到比其大的孩子结点位置上
        }
    }
}
