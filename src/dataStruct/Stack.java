package dataStruct;

public interface Stack<T> {
    /**
     * 出栈
     *
     * @return T
     */
    T pop();

    /**
     * 入栈
     *
     * @param item
     */
    void push(T item);

    /**
     * 栈是否为空
     *
     * @return boolen
     */
    boolean isEmpty();

    /**
     * 栈的长度
     *
     * @return
     */
    int size();
}
