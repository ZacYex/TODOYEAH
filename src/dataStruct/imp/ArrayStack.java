package dataStruct.imp;

import dataStruct.Stack;

public class ArrayStack<T> implements Stack<T> {

    // 数据存放的数组
    private T[] array;

    // 栈的长度
    private int N;

    public ArrayStack(){
        this.array = (T[]) new Object[1];
        this.N = 0;
    }

    /**
     * 数组增长
     */
    private void resize(){
        T[] newArray = (T[])new Object[this.array.length * 2];
        for (int i = 0;i < array.length; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    /**
     * 出栈
     *
     * @return 出栈元素
     */
    @Override
    public T pop() {
        T item = array[--N];
        array[N] = null;
        return item;
    }

    /**
     * 入栈
     *
     * @param item
     */
    @Override
    public void push(T item) {
        if(N == array.length) this.resize();
        array[N++] = item;
    }

    /**
     *栈是否为空
     *
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 栈的长度
     *
     * @return
     */
    @Override
    public int size() {
        return N;
    }
}
