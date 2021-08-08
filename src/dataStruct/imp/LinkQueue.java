package dataStruct.imp;

import dataStruct.Queue;

public class LinkQueue<T> implements Queue<T> {

    // 链表节点
    class Node{
        T value;
        Node next;
    }

    // 头节点
    private Node first;

    // 尾节点
    private Node last;

    // 长度
    private int N = 0;

    @Override
    public void enqueue(T item) {
        Node newItem = new Node();
        newItem.value = item;
        newItem.next = null;
        if(N == 0) {
            first = newItem;
            last = newItem;
        }else{
            last.next = newItem;
            last = newItem;
        }
        N++;
    }

    @Override
    public T dequeue() {
        T item = first.value;
        first = first.next;
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
