package dataStruct.imp;

import dataStruct.Queue;

public class ArrayQueue<T> implements Queue<T> {

    // 队列所在数组
    private T[] array;

    // 队列头序号
    private int first;

    // 队列尾序号
    private int last;

    // 队列元素个数
    private int N;

    public ArrayQueue(int vol){
        this.array = (T[])new Object[vol];
        this.first = 0;
        this.last = 0;
        this.N = 0;
    }

    @Override
    public void enqueue(T item) {
        array[last] = item;
        last = (++last)%array.length;
        N++;
    }

    @Override
    public T dequeue() {
        T item = array[first];
        array[first] = null;
        first = (++first)%array.length;
        N--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

}
