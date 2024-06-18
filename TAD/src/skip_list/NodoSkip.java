package skip_list;

import java.util.ArrayList;
import java.util.List;

// Clase NodoSkip que representa un nodo en la Skip List
class NodoSkip<T extends Comparable<T>> {
    T dato; // Dato almacenado en el nodo
    List<NodoSkip<T>> siguiente; // Lista de referencias a nodos siguientes
    int nivel; // Nivel del nodo en la Skip List

    // Constructor que inicializa el nodo con un dato y nivel específicos
    NodoSkip(T dato, int nivel) {
        this.dato = dato;
        this.nivel = nivel;
        this.siguiente = new ArrayList<>(nivel);
        for (int i = 0; i < nivel; i++) {
            this.siguiente.add(null); // Inicializar todas las referencias a null
        }
    }
}
