package rbt;

public class Main {
    public static void main(String[] args) {
        ArbolRojoNegro<Integer> arbol = new ArbolRojoNegro<>();

        // Insertar elementos en el árbol
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(15);
        arbol.insertar(25);

        // Imprimir el resultado de la búsqueda
        System.out.println("Buscar 20: " + arbol.buscar(20)); // Debería imprimir: true
        System.out.println("Buscar 5: " + arbol.buscar(5)); // Debería imprimir: false
    }
}
