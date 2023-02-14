package OFF;

public class LLQ<E> implements QueueADT<E> {
    private Link<E> front;
    private Link<E> rear;
    private int size;

    public LLQ(){front=rear=new Link<>(null);
        size=0;
    }

    public LLQ(int size){front=rear=new Link<>(null);
        size=0;
    }

    @Override
    public void clear() {
        front=rear=new Link<>(null);
        size=0;
    }

    @Override
    public void enqueue(E item) {
        rear.setNext(new Link<E>(item,null));
        rear=rear.next();
        size++;


    }

    @Override
    public E dequeue() {

        assert size != 0 : "Queue is empty";
        E it = front.next().element();     // Store dequeued value
        front.setNext(front.next().next());    // Advance front
        if (front.next() == null) rear = front; // Last Object
        size--;
        return it;

    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E frontValue() {
        return front.next().element();
    }

    @Override
    public E rearValue() {
        return rear.element();
    }

    @Override
    public E leaveQueue() {
        assert size != 0 : "Queue is empty";
        E it=rear.element();
        rear.setNext(null);
        Link<E> any=front;
        for (int i=0;i<size-1;i++)
        {
            any=any.getNext();
        }
        rear=any;
        size--;
        return it;


    }
}
