public class BST <E extends Comparable<E>> {
    // Atributos
    private Node<E> root;

    // Constructores de un BST vacio
    public BST(){
        this.root = null;
    }

    //operaciones
    public void insert(E x) throws ItemDuplicated {
        this.root = insertNode(x, this.root);
    }

    protected Node<E> insertNode(E x, Node<E> actual) throws ItemDuplicated {
        Node<E> res = actual;
        if (actual == null) { res = new Node<E>(x); }
        else {  //buscamos el lugar para inserción
            int resC = actual.data.compareTo(x);
            if (resC == 0 ) throw new ItemDuplicated(x + "esta duplcado");
            if (resC < 0) res.right = insertNode(x, actual.right);
            else
                res.left = insertNode(x, actual.left);
        }
        return res;
    }
}