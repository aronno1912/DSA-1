package OFF;

public  class Link<E>{
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