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

    public E search(E x) throws ItemNotFound {
        Node<E> wanted = search(head, x);
        return wanted.getData();
    }
    private Node<E> search(Node<E> node, E x) throws ItemNotFound {
        if(node == null)
            throw new ItemNotFound("El elemento "+ x +" no existe");
        int comparison = x.compareTo(node.getData());
        if(comparison < 0)
            return search(node.getLeft(), x);
        else if(comparicion > 0)
            return search(node.getRight(), x);
        else
            return node;
    }

    
}