package splay_tree;

public class Main {
    public static void main(String[] args) {
        ArbolSplay<Integer> arbol = new ArbolSplay<>();

        // Insertar elementos en el árbol
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(15);
        arbol.insertar(30);

        // Buscar elementos en el árbol
        System.out.println("Buscar 15: " + arbol.buscar(15)); // Debería imprimir: true
        System.out.println("Buscar 25: " + arbol.buscar(25)); // Debería imprimir: false
    }
}
