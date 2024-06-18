package bst;
public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        
        // Insertar elementos en el árbol
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(10);
        
        // Mostrar el árbol
        System.out.println("Árbol después de insertar elementos:");
        tree.show();
        
        // Buscar elementos en el árbol
        System.out.println("Buscar elemento 4: " + tree.search(4));
        System.out.println("Buscar elemento 10: " + tree.search(10));
        
        // Eliminar elementos del árbol
        tree.remove(3);
        tree.remove(7);
        
        // Mostrar el árbol después de eliminar elementos
        System.out.println("Árbol después de eliminar elementos:");
        tree.show();
        
        // Mostrar el mínimo y eliminarlo del árbol
        System.out.println("Mínimo en el árbol: " + tree.minSearch());
        tree.minRemove();
        System.out.println("Árbol después de eliminar el mínimo:");
        tree.show();
    }
}
