public class BST <E extends Comparable<E>> {
    // Atributos
    private Node<E> root;

    // Constructores de un BST vacio
    public BST(){
        this.root = null;
    }

    //operaciones
    public void insert(E x) throws ItemDuplicated {
        this.root = insert(root, x);
    }
    private Node<E> insert(Node<E> node, E x) throws ItemDuplicated {
        if(node == null) 
            return new Node<>(x);
        int comparison = x.compareTo(node.getData());
        if(comparison < 0) 
            node.setLeft(insert(node.getLeft(), x));
        else if(comparison > 0) 
            node.setRigth(insert(node.getRight(), x));
        else 
            throw new ItemDuplicated("El elemento "+ x +" ya existe");
        return node;
    }

    
}