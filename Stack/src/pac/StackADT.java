package pac;

public interface StackADT<E> {
    int clear();
    void push(E item);
    E pop();
    int length();
    E topValue();
    void setDirection(int direction);
    void insert(E item, int offset);
    E remove(int offset);

}
