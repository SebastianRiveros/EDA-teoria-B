package treap;

import java.util.Random;

// Clase NodoTreap que representa un nodo en un Treap
class NodoTreap<T extends Comparable<T>> {
    T dato; // Dato almacenado en el nodo
    int prioridad; // Prioridad del nodo
    NodoTreap<T> izquierdo; // Referencia al nodo hijo izquierdo
    NodoTreap<T> derecho; // Referencia al nodo hijo derecho

    // Constructor que inicializa el nodo con un dato y una prioridad específicos
    NodoTreap(T dato) {
        this.dato = dato;
        this.prioridad = new Random().nextInt(); // Asignar una prioridad aleatoria
        this.izquierdo = null;
        this.derecho = null;
    }
}
