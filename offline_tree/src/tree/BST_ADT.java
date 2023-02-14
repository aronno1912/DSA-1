package tree;

public interface BST_ADT<T> {
     void Delete(T t);
    Node Insert(T t);
    void Find(T t);
    void inOrder();
    void postOrder();
    void preOrder();



}