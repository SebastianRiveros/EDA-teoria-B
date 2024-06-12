public class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(E data, Node<E> left, Node<E> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(T data){
        super(data,null,null);
    }

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data = data;
    }
    public Node<T> getLeft(){
        return this.left;
    }
    public void setLeft(Node<T> left){
        this.left = left;   
    }
    public Node<T> getRight(){
        return this.rigth;
    }
    public void setRight(Node<T> right){
        this.right = right;   
    }
}