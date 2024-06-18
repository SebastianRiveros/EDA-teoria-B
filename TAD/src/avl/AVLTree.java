import BST.*;
public class AVLTree <E extends Comparable<E>> extends BST<E>{
    class NodeAVL extends Node<E>{
        private int fb;
        public NodeAVL(E data){
            super(data);
            this.fb = 0;
        }
        public String toString(){
            return super.toString() + "("++this.fb")";
        }
    }
    private boolean height;
    public AVLTree(){
        super();
    }
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.setRoot(insert(x, (NodeAVL)this.getRoot()));
    }
    private Node<E> insert(NodeAVL node, E x) throws ItemDuplicated {
        if(node == null)
            return new Node<>(x);
        int comparison = x.compareTo(node.getData());
        if(comparison < 0) 
            node.setLeft(insert((NodeAVL)node.getLeft(), x));
        else if(comparison > 0) 
            node.setRight(insert((NodeAVL)node.getRight(), x));
        else 
            throw new ItemDuplicated("El elemento "+ x +" ya existe");
        return node;
    }
}