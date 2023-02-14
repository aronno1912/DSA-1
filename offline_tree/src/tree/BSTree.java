package tree;

import static java.lang.Math.max;

public class BSTree<T extends Comparable> implements BST_ADT<T> {

    private Node<T> root;
    private int size;
    private String s = "";

    public BSTree(){
        root = null;
        size = 0;
    }

    // return the minimum value of the tree
    // the left subtree of a node always have the minimum values
    private Node<T> getMin(Node<T> root){
        if (root.getLeft() == null) return root;
        return getMin(root.getLeft());
    }


    // return the maximum values of the tree
    // the right subtree of a node always have the maximum values
    private Node<T> getMax(Node<T> root){
        if(root.getRight() == null) return root;
        return getMax(root.getRight());
    }



     //if the tree is empty enter new node and return it
     // search for the correct position to set the value as a tree element

    //helper function for  insert

    private Node<T> insertHelper(Node<T> root, T t){

        if(root == null){
            root = new Node<>(t);
            return root;
        }

        if(root.val.compareTo(t) > 0){
            root.setLeft(insertHelper(root.getLeft(), t));
        }else{
            root.setRight(insertHelper(root.getRight(), t));
        }
        return root;
    }

    // return the node if found else return null
    private Node<T> findHelper(Node<T> root,T key){
        if (root == null){
            return null;
        }
        if (root.val.compareTo(key) == 0)
            return root;
        else if(root.val.compareTo(key) > 0){
            return findHelper(root.getLeft(),key);
        }else{
            return findHelper(root.getRight(),key);
        }
    }

    // x.compareTo(y) returns positive if x>y



    private Node<T> deleteHelper(Node<T> root, T t){

        if(root.val.compareTo(t)>0){
            root.setLeft(deleteHelper(root.getLeft(),t));
        }
        else if(root.val.compareTo(t)<0){
            root.setRight(deleteHelper(root.getRight(),t));
        }

        else{
            if(root.getRight() == null)
                return root.getLeft(); //shifting
            else if(root.getLeft() == null)
                return root.getRight();
            //when the node has both right and left child

            else if(root.getRight() != null && root.getLeft() != null){
                Node max = getMax(root.getLeft());
                //Node min=getMin(root.getRight());
                root.val=(T)max.val;
               // root.val = (T) min.val;
                root.setLeft(deleteHelper(root.getLeft(), (T) max.val));
                //root.setRight(deleteHelper(root.getRight(), (T) min.val));
                return root;
            }else{
                return null;
            }
        }
        return root;
    }

    @Override
    public Node<T> Insert(T t) {

        root =  insertHelper(root, t);
        size++;
        printTree();
        return root;
    }



    @Override
    public void Find(T t) {
        Node x = findHelper(root,t);
        if(x == null){
            System.out.println("False");
        }else if(x.val == t){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }


    @Override
    public void Delete(T t) {

        Node n = this.findHelper(root, t);

        if(n != null){
            root = deleteHelper(root,t);
            size--;
            printTree();
        }else{
            System.out.println("Invalid Operation");
        }

    }

     //  inorder=  left -> parent ->  right

    @Override
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node root){
        if(root == null)return;

        inOrder(root.getLeft());
        System.out.print(root.val+ " ");
        inOrder(root.getRight());

    }




    @Override
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    //postorder=left->right->parent
    private void postOrder(Node root){
        if(root == null) return;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.val+ " ");
    }

    @Override
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
//preorder=parent->left->right
    private void preOrder(Node root){
        if(root == null)return;

        System.out.print(root.val+ " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    // return the height of the tree
//
//    private int height(Node<T> root){
//        if (root == null)return 0;
//
//        int left_height = height(root.getLeft());
//        int right_height = height(root.getRight());
//
//        return max(left_height+1, right_height+1);
//    }

    public Node<T> getRoot(){
        return root;
    }


    private void print(Node<T> root){
        if(root == null)
            return;

        s += root.val;

        // if leaf return
        if(root.getLeft() == null && root.getRight() == null)
            return;
        else{
            s+="(";
            print(root.getLeft());
            s+=")";

            s+="(";
            print(root.getRight());
            s+=")";
        }
    }

    public void printTree(){
        s = "";
        print(root);
        System.out.println(s);

    }
}
