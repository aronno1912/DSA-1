package pac;

class Link<E>{
    private E element;
    private Link<E> next;
    Link(E item, Link<E> nextval){
        element = item;
        next = nextval;
    }
    Link(Link<E> nextval){
        next = nextval;
    }
    Link<E> next(){
        return next;
    }

    void setNext(Link<E> nextVal){
        next = nextVal;
    }
    Link<E> getNext(){
        return next;
    }
    E element(){
        return element;
    }
    void setElement(E item){
        element = item;
    }
}

public class LL<E> implements StackADT<E> {

    private Link<E> top;
    private int size;

    public LL(){ top = null; size = 0;}
    public LL(int size){ top = null; size = 0; }


    @Override
    public int clear() {
        top = null; size = 0;
        return -1;
    }

    @Override
    public void push(E item) {
        top = new Link<E>(item, top);
        size++;


    }

    @Override
    public E pop() {
        if(size==0) {System.out.println("Stack is empty");

            return null;
        }
        else
        { E item = top.element();
            top = top.next(); //head is top
            size--;
            return item;}

    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public E topValue() {
        if(size==0) {System.out.println("Stack is empty");

            return null;
        }
        else
            return top.element();
    }

    @Override
    public void setDirection(int direction) {
        System.out.println("is not applicable here in LL");
    }

    @Override
    public void insert(E item, int offset) {

        E temp=top.element();
        top= new Link<>(item,top.next());

        LL<E>splitted=new LL<>();
        top= (Link<E>) temp;




    }

    @Override
    public E remove(int offset) {
        return null;
    }
}
