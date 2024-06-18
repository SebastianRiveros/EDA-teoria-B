package rbt;

// Implementación de un Árbol Rojo-Negro genérico
public class ArbolRojoNegro<T extends Comparable<T>> {
    private NodoRB<T> raiz; // Nodo raíz del árbol

    // Constructor que inicializa un árbol vacío
    public ArbolRojoNegro() {
        this.raiz = null;
    }

    // Método para verificar si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // Método para insertar un elemento en el árbol
    public void insertar(T dato) {
        NodoRB<T> nuevoNodo = new NodoRB<>(dato, true); // Nuevo nodo rojo
        raiz = insertarRecursivo(raiz, nuevoNodo); // Insertar recursivamente
        raiz.esRojo = false; // Asegurar que la raíz sea negra
    }

    // Método recursivo para insertar un nodo en el árbol
    private NodoRB<T> insertarRecursivo(NodoRB<T> raizActual, NodoRB<T> nuevoNodo) {
        if (raizActual == null) {
            return nuevoNodo; // Caso base: Insertar en una hoja
        }

        // Comparar el dato del nuevo nodo con el dato del nodo actual
        int comparacion = nuevoNodo.dato.compareTo(raizActual.dato);

        if (comparacion < 0) {
            // Insertar en el subárbol izquierdo
            raizActual.izquierdo = insertarRecursivo(raizActual.izquierdo, nuevoNodo);
            raizActual.izquierdo.padre = raizActual; // Establecer el padre
        } else if (comparacion > 0) {
            // Insertar en el subárbol derecho
            raizActual.derecho = insertarRecursivo(raizActual.derecho, nuevoNodo);
            raizActual.derecho.padre = raizActual; // Establecer el padre
        } else {
            // Si el dato ya existe, no se hace nada en este caso
            return raizActual;
        }

        // Casos de rotación y ajuste de colores
        if (esRojo(raizActual.derecho) && !esRojo(raizActual.izquierdo)) {
            raizActual = rotacionIzquierda(raizActual); // Rotación a la izquierda
        }
        if (esRojo(raizActual.izquierdo) && esRojo(raizActual.izquierdo.izquierdo)) {
            raizActual = rotacionDerecha(raizActual); // Rotación a la derecha
        }
        if (esRojo(raizActual.izquierdo) && esRojo(raizActual.derecho)) {
            cambiarColores(raizActual); // Cambiar colores
        }

        return raizActual;
    }

    // Método para realizar una rotación a la izquierda
    private NodoRB<T> rotacionIzquierda(NodoRB<T> nodo) {
        NodoRB<T> nuevoNodo = nodo.derecho;
        nodo.derecho = nuevoNodo.izquierdo;
        if (nuevoNodo.izquierdo != null) {
            nuevoNodo.izquierdo.padre = nodo;
        }
        nuevoNodo.padre = nodo.padre;
        if (nodo.padre == null) {
            raiz = nuevoNodo;
        } else if (nodo == nodo.padre.izquierdo) {
            nodo.padre.izquierdo = nuevoNodo;
        } else {
            nodo.padre.derecho = nuevoNodo;
        }
        nuevoNodo.izquierdo = nodo;
        nodo.padre = nuevoNodo;
        return nuevoNodo;
    }

    // Método para realizar una rotación a la derecha
    private NodoRB<T> rotacionDerecha(NodoRB<T> nodo) {
        NodoRB<T> nuevoNodo = nodo.izquierdo;
        nodo.izquierdo = nuevoNodo.derecho;
        if (nuevoNodo.derecho != null) {
            nuevoNodo.derecho.padre = nodo;
        }
        nuevoNodo.padre = nodo.padre;
        if (nodo.padre == null) {
            raiz = nuevoNodo;
        } else if (nodo == nodo.padre.derecho) {
            nodo.padre.derecho = nuevoNodo;
        } else {
            nodo.padre.izquierdo = nuevoNodo;
        }
        nuevoNodo.derecho = nodo;
        nodo.padre = nuevoNodo;
        return nuevoNodo;
    }

    // Método para cambiar los colores de los nodos
    private void cambiarColores(NodoRB<T> nodo) {
        nodo.esRojo = !nodo.esRojo;
        nodo.izquierdo.esRojo = !nodo.izquierdo.esRojo;
        nodo.derecho.esRojo = !nodo.derecho.esRojo;
    }

    // Método para verificar si un nodo es rojo
    private boolean esRojo(NodoRB<T> nodo) {
        if (nodo == null) {
            return false;
        }
        return nodo.esRojo;
    }

    // Método para buscar un elemento en el árbol
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    // Método recursivo para buscar un elemento en el árbol
    private boolean buscarRecursivo(NodoRB<T> raizActual, T dato) {
        while (raizActual != null) {
            int comparacion = dato.compareTo(raizActual.dato);
            if (comparacion < 0) {
                raizActual = raizActual.izquierdo;
            } else if (comparacion > 0) {
                raizActual = raizActual.derecho;
            } else {
                return true; // Encontrado
            }
        }
        return false; // No encontrado
    }
}
