package dataStruct;

public interface Queue<T> {

    /**
     * 进列
     *
     * @param item
     */
    void enqueue(T item);

    /**
     * 出列
     *
     * @return
     */
    T dequeue();

    /**
     * 队列是否为空
     *
     * @return boolen
     */
    boolean isEmpty();

    /**
     * 队列的长度
     *
     * @return
     */
    int size();
}
