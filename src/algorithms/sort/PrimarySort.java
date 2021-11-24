package algorithms.sort;

import java.util.Comparator;

/**
 * 初级排序
 */
public class PrimarySort {

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void bubbleSort(Comparable array[]){
        for (int i=array.length; i>0; i--){
            for (int j=0; j < i-1; j++){
                if(array[j].compareTo(array[j+1]) > 0){
                    exchange(array, j, j+1);
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public void selectionSort(Comparable array[]){
        for(int i = 0; i < array.length; i++){
            int min  = i;
            for(int j = i; j < array.length; j++){
                // 后面元素比min小
                if(array[j].compareTo(array[i])  < 0) {
                    min = j;
                }
            }
            exchange(array, i, min);
        }
    }

    /**
     *
     * 快速排序
     *
     * @param array
     */
    public void quickSort(Comparable array[], int low, int high){
        if(low >= high) return;
        int i = low;
        int j = high;
        int temp= i;

        while (i<j){
            while (i<j && array[j].compareTo(array[temp]) > 0){
                j--;
            }
            while (i<j && array[i].compareTo(array[temp]) < 0){
                i++;
            }
            exchange(array, i, j);
        }
        exchange(array, i, temp);

        quickSort(array, low,i-1);
        quickSort(array, i+1, high);
    }

    /**
     * 插入排序
     *
     * @param array
     */
    public void insertSort(Comparable array[]){
        for(int i = 1; i< array.length; i++){
            for(int j = i; j > 0 && (array[j].compareTo(array[j-1]) < 0); j--){
                exchange(array, j, j-1);
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     */
    public void shellSort(Comparable array[]){
        int h =1;
        while(h < array.length/3) h = 3*h + 1;
        while(h > 0) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && (array[j].compareTo(array[j - h]) < 0); j -= h) {
                    exchange(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /**
     * 堆排序
     *
     * @param array
     */
    public void heapSort(Comparable array[]){
        this.heapSort(array, array.length);
    }

    private void heapSort(Comparable  array[], int length){
        for(int i = length; i>0; i--){
            this.buildHeap(array, i);
            this.exchange(array, 0, i-1);
        }
    }

    /**
     * 构建大顶堆
     *
     * @param array
     * @param length
     */
    private void buildHeap(Comparable array[], int length){
        for(int i = length/2-1; i>=0; i--){
            if((2*i+1)<length && array[i].compareTo(array[2*i+1])<0){
                this.exchange(array, i, 2*i+1);
                if((2*(2*i+1)+1)<length && array[2*i+1].compareTo(array[2*(2*i+1)+1])<0){
                    this.buildHeap(array, length);
                }
            }
            if((2*i+2)<length && array[i].compareTo(array[2*i+2])<0){
                this.exchange(array, i, 2*i+2);
                if((2*(2*i+2)+2)<length && array[2*i+2].compareTo(array[2*(2*i+2)+2])<0){
                    this.buildHeap(array, length);
                }
            }
        }
    }

    /**
     * 归并排序
     *
     * @param array
     */
    public void mergeSort(Comparable array[]){
        Comparable mergeArr[] = new Comparable[array.length];
        this.mergeSort(array, mergeArr, 0, array.length-1);
    }
    private void mergeSort(Comparable array[], Comparable mergeArr[], int left, int right){
        int center;
        if(left < right){
            center = (left+right)/2;
            this.mergeSort(array, mergeArr, left, center);
            this.mergeSort(array, mergeArr, center+1, right);
            this.merge(array, mergeArr, left, center, right);
        }
    }
    private void merge(Comparable array[], Comparable mergeArr[], int left, int center, int right){
        int i = left, j =center+1;
        for(int k=left; k<=right; k++){
            if(i > center){
                mergeArr[k] = array[j++];
                continue;
            }
            if(j > right){
                mergeArr[k] = array[i++];
                continue;
            }
            if(array[i].compareTo(array[j]) < 0){
                mergeArr[k] = array[i++];
            }else {
                mergeArr[k] = array[j++];
            }
        }
        for(int k=left; k<=right; k++){
            array[k] = mergeArr[k];
        }
    }


    /**
     * 交换数组的两个元素
     *
     * @param array
     * @param i 交换元素
     * @param j 交换元素
     */
    private void exchange(Comparable array[], int i, int j){
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
