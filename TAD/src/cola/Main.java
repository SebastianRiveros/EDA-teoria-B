package cola;
public class Main {
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();

        // Encolar elementos
        cola.encolar(1);
        cola.encolar(2);
        cola.encolar(3);
        
        // Imprimir la cola
        cola.imprimir(); // 1 -> 2 -> 3 -> null
        
        // Obtener y mostrar el tamaño de la cola
        System.out.println("Tamaño: " + cola.obtenerTamaño()); // Tamaño: 3

        // Ver el frente de la cola
        System.out.println("Frente: " + cola.frente()); // Frente: 1

        // Buscar elementos en la cola
        System.out.println("Buscar 2: " + cola.buscar(2)); // Buscar 2: true
        System.out.println("Buscar 4: " + cola.buscar(4)); // Buscar 4: false

        // Desencolar un elemento
        System.out.println("Desencolado: " + cola.desencolar()); // Desencolado: 1
        cola.imprimir(); // 2 -> 3 -> null

        // Intentar desencolar de una cola vacía (lanzará una excepción)
        cola.desencolar(); // Desencolado: 2
        cola.desencolar(); // Desencolado: 3
        cola.desencolar(); // ItemNotFound: La cola está vacía.
    }
}
