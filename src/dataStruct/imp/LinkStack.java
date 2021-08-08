package dataStruct.imp;

import dataStruct.Stack;

public class LinkStack<T> implements Stack<T> {

    /**
     * 链表节点
     */
    private class Node {
        T value;
        Node next;
    }

    /**
     * 栈长度
     */
    private int N;

    /**
     * 链表头节点
     */
    private Node first;

    public LinkStack(){
        this.N = 0;
    }

    @Override
    public T pop() {
        T value = first.value;
        first = first.next;
        N--;
        return value;
    }

    @Override
    public void push(T item) {
        Node first = new Node();
        first.value = item;
        if(isEmpty()) {this.first = first;}
        else {
            first.next = this.first;
            this.first = first;
        }
        N++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }
}
