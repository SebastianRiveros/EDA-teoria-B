package arbol_binario;

// Implementación de un árbol binario genérico
public class ArbolBinario<T> {
    private Nodo<T> raiz; // Nodo raíz del árbol

    // Constructor que inicializa un árbol vacío
    public ArbolBinario() {
        this.raiz = null;
    }

    // Método para verificar si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // Método para insertar un elemento en el árbol
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    // Método recursivo para insertar un elemento en el árbol
    private Nodo<T> insertarRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            // Si el nodo es null, se crea un nuevo nodo con el dato
            return new Nodo<>(dato);
        }

        // Insertar en el subárbol izquierdo si está vacío
        if (nodo.izquierdo == null) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        } else {
            // Insertar en el subárbol derecho si está vacío
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        }

        return nodo;
    }

    // Método para buscar un elemento en el árbol
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    // Método recursivo para buscar un elemento en el árbol
    private boolean buscarRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            // Si el nodo es null, el dato no está en el árbol
            return false;
        }

        // Comparar el dato con el dato del nodo actual
        if (nodo.dato.equals(dato)) {
            return true; // Si se encuentra el dato, retornar true
        }

        // Buscar en el subárbol izquierdo y derecho recursivamente
        return buscarRecursivo(nodo.izquierdo, dato) || buscarRecursivo(nodo.derecho, dato);
    }

    // Método para eliminar un elemento del árbol
    public void eliminar(T dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }

    // Método recursivo para eliminar un elemento del árbol
    private Nodo<T> eliminarRecursivo(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            // Si el nodo es null, el dato no está en el árbol
            return null;
        }

        // Comparar el dato con el dato del nodo actual
        if (nodo.dato.equals(dato)) {
            // Caso 1: El nodo es una hoja (no tiene hijos)
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }

            // Caso 2: El nodo tiene un solo hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 3: El nodo tiene dos hijos
            // Encontrar el sucesor en orden en el subárbol derecho
            T sucesor = encontrarSucesor(nodo.derecho);
            nodo.dato = sucesor;
            // Eliminar el sucesor en orden
            nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor);
        } else {
            // Buscar el dato en el subárbol izquierdo y derecho recursivamente
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        }

        return nodo;
    }

    // Método para encontrar el sucesor en orden en un subárbol
    private T encontrarSucesor(Nodo<T> nodo) {
        // El sucesor en orden es el nodo más a la izquierda en el subárbol derecho
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.dato;
    }

    // Método para recorrer el árbol en orden (izquierda, raíz, derecha)
    public void recorridoEnOrden() {
        recorridoEnOrdenRecursivo(raiz);
        System.out.println();
    }

    // Método recursivo para recorrer el árbol en orden
    private void recorridoEnOrdenRecursivo(Nodo<T> nodo) {
        if (nodo != null) {
            recorridoEnOrdenRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            recorridoEnOrdenRecursivo(nodo.derecho);
        }
    }

    // Método para obtener la altura del árbol
    public int obtenerAltura() {
        return obtenerAlturaRecursivo(raiz);
    }

    // Método recursivo para obtener la altura de un nodo
    private int obtenerAlturaRecursivo(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierdo = obtenerAlturaRecursivo(nodo.izquierdo);
        int alturaDerecho = obtenerAlturaRecursivo(nodo.derecho);
        return 1 + Math.max(alturaIzquierdo, alturaDerecho);
    }

    // Método para verificar si un elemento existe en el árbol
    public boolean existe(T dato) {
        return buscar(dato);
    }
}
