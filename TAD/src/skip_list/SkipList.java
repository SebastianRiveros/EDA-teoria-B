package skip_list;

import java.util.Random;

// Implementación de una Skip List genérica
public class SkipList<T extends Comparable<T>> {
    private static final int MAX_NIVEL = 32; // Máximo nivel de la Skip List
    private NodoSkip<T> cabeza; // Nodo cabeza de la Skip List
    private int nivelActual; // Nivel actual de la Skip List
    private Random random; // Generador aleatorio

    // Constructor que inicializa una Skip List vacía
    public SkipList() {
        this.cabeza = new NodoSkip<>(null, MAX_NIVEL);
        this.nivelActual = 1;
        this.random = new Random();
    }

    // Método para generar un nivel aleatorio para un nuevo nodo
    private int generarNivel() {
        int nivel = 1;
        while (random.nextInt(2) == 0 && nivel < MAX_NIVEL) {
            nivel++;
        }
        return nivel;
    }

    // Método para insertar un elemento en la Skip List
    public void insertar(T dato) {
        // Crear un nuevo nodo con un nivel aleatorio
        int nivelNuevo = generarNivel();
        NodoSkip<T> nuevoNodo = new NodoSkip<>(dato, nivelNuevo);

        // Actualizar el nivel actual de la Skip List si es necesario
        if (nivelNuevo > nivelActual) {
            nivelActual = nivelNuevo;
        }

        // Iniciar desde la cabeza
        NodoSkip<T> actual = cabeza;

        // Mantener un arreglo de referencias que serán actualizadas
        NodoSkip<T>[] actualizar = new NodoSkip[MAX_NIVEL];

        // Recorrer desde el nivel más alto al más bajo
        for (int i = nivelActual - 1; i >= 0; i--) {
            while (actual.siguiente.get(i) != null && actual.siguiente.get(i).dato.compareTo(dato) < 0) {
                actual = actual.siguiente.get(i); // Mover al siguiente nodo en el nivel i
            }
            actualizar[i] = actual; // Mantener el nodo anterior en el nivel i
        }

        // Insertar el nuevo nodo en cada nivel
        for (int i = 0; i < nivelNuevo; i++) {
            nuevoNodo.siguiente.set(i, actualizar[i].siguiente.get(i));
            actualizar[i].siguiente.set(i, nuevoNodo);
        }
    }

    // Método para buscar un elemento en la Skip List
    public boolean buscar(T dato) {
        NodoSkip<T> actual = cabeza;

        // Recorrer desde el nivel más alto al más bajo
        for (int i = nivelActual - 1; i >= 0; i--) {
            while (actual.siguiente.get(i) != null && actual.siguiente.get(i).dato.compareTo(dato) < 0) {
                actual = actual.siguiente.get(i); // Mover al siguiente nodo en el nivel i
            }
        }

        // Verificar si el dato está en el nivel 0 y no es null
        actual = actual.siguiente.get(0);
        return actual != null && actual.dato.compareTo(dato) == 0;
    }

    // Método para eliminar un elemento de la Skip List
    public void eliminar(T dato) {
        NodoSkip<T> actual = cabeza;

        // Mantener un arreglo de referencias que serán actualizadas
        NodoSkip<T>[] actualizar = new NodoSkip[MAX_NIVEL];

        // Recorrer desde el nivel más alto al más bajo
        for (int i = nivelActual - 1; i >= 0; i--) {
            while (actual.siguiente.get(i) != null && actual.siguiente.get(i).dato.compareTo(dato) < 0) {
                actual = actual.siguiente.get(i); // Mover al siguiente nodo en el nivel i
            }
            actualizar[i] = actual; // Mantener el nodo anterior en el nivel i
        }

        // Actualizar las referencias para eliminar el nodo con dato igual a dato
        actual = actual.siguiente.get(0);
        if (actual != null && actual.dato.compareTo(dato) == 0) {
            for (int i = 0; i < nivelActual; i++) {
                if (actual == actualizar[i].siguiente.get(i)) {
                    actualizar[i].siguiente.set(i, actual.siguiente.get(i));
                }
            }
        }

        // Reducir el nivel actual si es necesario
        while (nivelActual > 1 && cabeza.siguiente.get(nivelActual - 1) == null) {
            nivelActual--;
        }
    }
}
