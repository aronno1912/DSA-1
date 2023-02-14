package tree;

public class Node<T> {

    public T val;
    private Node<T> left;
    private  Node<T> right;

    public Node(T val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public Node(T val){
        this.val = val;
        left = null;
        right = null;
    }
    public Node(){
        left = null;
        right = null;
    }
    public void setLeft( Node<T> left){this.left = left;}
    public void setRight( Node<T> right){this.right = right;}
    public  Node<T> getLeft(){return left;}
    public  Node<T> getRight(){return right;}
}
