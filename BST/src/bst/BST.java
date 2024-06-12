package bst;
import exceptions.*;
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
            node.setRight(insert(node.getRight(), x));
        else 
            throw new ItemDuplicated("El elemento "+ x +" ya existe");
        return node;
    }

    public E search(E x) throws ItemNotFound {
        Node<E> wanted = search(root, x);
        return wanted.getData();
    }
    private Node<E> search(Node<E> node, E x) throws ItemNotFound {
        if(node == null)
            throw new ItemNotFound("El elemento "+ x +" no existe");
        int comparison = x.compareTo(node.getData());
        if(comparison < 0)
            return search(node.getLeft(), x);
        else if(comparison > 0)
            return search(node.getRight(), x);
        else
            return node;
    }

    public void remove(E x) throws ItemNotFound {
        this.root = remove(root, x);
    }
    private Node<E> remove(Node<E> node, E x) throws ItemNotFound {
        if(node == null)
            throw new ItemNotFound("Elemento "+ x +" no encontrado");
        int comparison = x.compareTo(node.getData());
        if(comparison < 0)
            node.setLeft(remove(node.getLeft(), x));
        else if(comparison > 0)
            node.setRight(remove(node.getRight(), x));
        else if(node.getLeft() != null && node.getRight() != null){
            node.setData(minSearch(node.getRight()).getData());
            node.setRight(minRemove(node.getRight()));
        }else{
            node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
        }
        return node;
    }

    public E minSearch(){
        if(root == null)
            return null;
        return minSearch(root).getData();
    }
    private Node<E> minSearch(Node<E> node){
        if(node.getLeft() == null)
            return node;
        return minSearch(node.getLeft());
    }

    public void minRemove(){
        this.root = minRemove(root);
    }
    private Node<E> minRemove(Node<E> node){
        if(node.getLeft() == null)
            return node.getRight();
        node.setLeft(minRemove(node.getLeft()));
        return node;
    }
    
    public void show() {
        if (root == null) {
            System.out.println("El árbol está vacío.");
        } else {
            System.out.println("Árbol:");
            show(root, 0);
        }
    }

    private void show(Node<E> node, int level) {
        if (node != null) {
            // Mostrar el subárbol derecho primero (recursivamente)
            show(node.getRight(), level + 1);

            // Imprimir el nodo actual
            for (int i = 0; i < level; i++) {
                System.out.print("    "); // Espacios para la indentación
            }
            System.out.println(node.getData());

            // Mostrar el subárbol izquierdo (recursivamente)
            show(node.getLeft(), level + 1);
        }
    }

    public boolean isEmpty(){
        return root == null;
    }
}