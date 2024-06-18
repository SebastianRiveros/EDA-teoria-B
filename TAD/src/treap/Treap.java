package treap;

import exceptions.ItemDuplicated;

// Implementación de un Treap genérico
public class Treap<T extends Comparable<T>> {
    private NodoTreap<T> raiz; // Nodo raíz del Treap

    // Constructor que inicializa un Treap vacío
    public Treap() {
        this.raiz = null;
    }

    // Método para verificar si el Treap está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // Método para insertar un elemento en el Treap
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato); // Insertar de manera recursiva
    }

    // Método recursivo para insertar un elemento en el Treap
    private NodoTreap<T> insertarRecursivo(NodoTreap<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoTreap<>(dato); // Caso base: Insertar en una hoja
        }

        int comparacion = dato.compareTo(nodo.dato);
        if (comparacion < 0) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato); // Insertar en el subárbol izquierdo
            if (nodo.izquierdo.prioridad > nodo.prioridad) {
                nodo = rotarDerecha(nodo); // Realizar rotación a la derecha si es necesario
            }
        } else if (comparacion > 0) {
            nodo.derecho = insertarRecursivo(nodo.derecho, dato); // Insertar en el subárbol derecho
            if (nodo.derecho.prioridad > nodo.prioridad) {
                nodo = rotarIzquierda(nodo); // Realizar rotación a la izquierda si es necesario
            }
        } else {
            throw new ItemDuplicated("El elemento ya existe en el Treap.");
        }

        return nodo; // Retornar el nodo actualizado
    }

    // Método para realizar una rotación a la izquierda
    private NodoTreap<T> rotarIzquierda(NodoTreap<T> nodo) {
        NodoTreap<T> hijoDerecho = nodo.derecho;
        nodo.derecho = hijoDerecho.izquierdo;
        hijoDerecho.izquierdo = nodo;
        return hijoDerecho;
    }

    // Método para realizar una rotación a la derecha
    private NodoTreap<T> rotarDerecha(NodoTreap<T> nodo) {
        NodoTreap<T> hijoIzquierdo = nodo.izquierdo;
        nodo.izquierdo = hijoIzquierdo.derecho;
        hijoIzquierdo.derecho = nodo;
        return hijoIzquierdo;
    }

    // Método para buscar un elemento en el Treap
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato); // Buscar de manera recursiva
    }

    // Método recursivo para buscar un elemento en el Treap
    private boolean buscarRecursivo(NodoTreap<T> nodo, T dato) {
        if (nodo == null) {
            return false; // Caso base: Elemento no encontrado
        }

        int comparacion = dato.compareTo(nodo.dato);
        if (comparacion < 0) {
            return buscarRecursivo(nodo.izquierdo, dato); // Buscar en el subárbol izquierdo
        } else if (comparacion > 0) {
            return buscarRecursivo(nodo.derecho, dato); // Buscar en el subárbol derecho
        } else {
            return true; // Elemento encontrado
        }
    }
}
