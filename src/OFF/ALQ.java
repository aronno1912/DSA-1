package OFF;

public class ALQ<E> implements QueueADT<E> {

    private static final int DEFAULTSIZE = 15;
    private int maxSize;
    private int listSize;
    private E[] listArray;
    private int sizeFactor = 1;
    private int front;
    private int rear;

    public ALQ(){this(DEFAULTSIZE);}
    public ALQ(int size){
        maxSize = size+1; // One extra space is allocated
        rear = 0; front = 1;
        listArray = (E[])new Object[maxSize];
        // Create listArray
        listSize=0;
    }

    public  ALQ(E[]listArray)

    {

        this.listArray=listArray;

        this.maxSize=listArray.length+1;
        this.listSize=0;

        rear = 0;
        front = 1;



    }



    private void increaseArraySize() {
        E[] tmp = listArray;
        sizeFactor *= 2;
        listArray = (E[]) new Object[maxSize*sizeFactor];
        for (int i = 0; i < listSize; i++) {
            listArray[i] = tmp[i];
        }
    }
    @Override
    public void clear() {
        rear = 0; front = 1;
        listSize=0;
    }

    @Override
    public void enqueue(E item) {
        // assert ((rear+2) % maxSize) != front : "Queue is full";
        if(((rear+2) % maxSize) == front) increaseArraySize();
        rear = (rear+1) % maxSize; // Circular increment
        listArray[rear] = item;
        listSize++;

    }

    @Override
    public E dequeue() {

        assert length() != 0 : "Queue is empty";
        E it = listArray[front];
        front = (front+1) % maxSize; // Circular increment
        listSize--;
        return it;
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public E frontValue() {
        assert length() != 0 : "Queue is empty";
        return listArray[front];
    }

    @Override
    public E rearValue() {

        assert length() != 0 : "Queue is empty";
        return listArray[rear];
    }

    @Override
    public E leaveQueue() {

        assert length() != 0 : "Queue is empty";
        E it = listArray[rear];
        rear = (rear-1) % maxSize; // Circular decrement
        listSize--;
        return it;
    }
}
