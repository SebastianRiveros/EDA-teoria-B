package arbol_binario;

public class Main {
    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = new ArbolBinario<>();

        // Insertar elementos en el árbol
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(4);
        arbol.insertar(5);

        // Imprimir el recorrido en orden del árbol
        System.out.print("Recorrido en orden: ");
        arbol.recorridoEnOrden(); // Debería imprimir: 1 2 3 4 5

        // Buscar elementos en el árbol
        System.out.println("Buscar 3: " + arbol.buscar(3)); // Debería imprimir: true
        System.out.println("Buscar 6: " + arbol.buscar(6)); // Debería imprimir: false

        // Eliminar un elemento del árbol
        arbol.eliminar(3);
        System.out.print("Recorrido en orden después de eliminar 3: ");
        arbol.recorridoEnOrden(); // Debería imprimir: 1 2 4 5
    }
}
