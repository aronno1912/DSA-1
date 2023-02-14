package OFF;

public interface QueueADT<E> {

    void clear();
    void enqueue(E item);
    E dequeue();
    int length();
    E frontValue();
    E rearValue();
    E leaveQueue();

}