package cola_de_prioridad;

public class Main {
    public static void main(String[] args) {
        ColaPrioridad<Integer> colaPrioridad = new ColaPrioridad<>();

        // Encolar elementos con diferentes prioridades
        colaPrioridad.encolar(1, 1);
        colaPrioridad.encolar(2, 3);
        colaPrioridad.encolar(3, 2);
        
        // Imprimir la cola de prioridad
        colaPrioridad.imprimir(); // (2, 3) -> (3, 2) -> (1, 1) -> null
        
        // Obtener y mostrar el tamaño de la cola de prioridad
        System.out.println("Tamaño: " + colaPrioridad.obtenerTamaño()); // Tamaño: 3

        // Ver el elemento con la mayor prioridad
        System.out.println("Cima: " + colaPrioridad.cima()); // Cima: 2

        // Buscar elementos en la cola de prioridad
        System.out.println("Buscar 2: " + colaPrioridad.buscar(2)); // Buscar 2: true
        System.out.println("Buscar 4: " + colaPrioridad.buscar(4)); // Buscar 4: false

        // Desencolar el elemento con la mayor prioridad
        System.out.println("Desencolado: " + colaPrioridad.desencolar()); // Desencolado: 2
        colaPrioridad.imprimir(); // (3, 2) -> (1, 1) -> null

        // Intentar desencolar de una cola de prioridad vacía (lanzará una excepción)
        colaPrioridad.desencolar(); // Desencolado: 3
        colaPrioridad.desencolar(); // Desencolado: 1
        colaPrioridad.desencolar(); // ItemNotFound: La cola de prioridad está vacía.
    }
}
