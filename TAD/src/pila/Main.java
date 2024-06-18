package pila;
public class Main {
    public static void main(String[] args) {
        Pila<Integer> pila = new Pila<>();

        // Apilar elementos
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        
        // Imprimir la pila
        pila.imprimir(); // 3 -> 2 -> 1 -> null
        
        // Obtener y mostrar el tamaño de la pila
        System.out.println("Tamaño: " + pila.obtenerTamaño()); // Tamaño: 3

        // Ver la cima de la pila
        System.out.println("Cima: " + pila.cima()); // Cima: 3

        // Buscar elementos en la pila
        System.out.println("Buscar 2: " + pila.buscar(2)); // Buscar 2: true
        System.out.println("Buscar 4: " + pila.buscar(4)); // Buscar 4: false

        // Desapilar un elemento
        System.out.println("Desapilado: " + pila.desapilar()); // Desapilado: 3
        pila.imprimir(); // 2 -> 1 -> null

        // Intentar desapilar de una pila vacía (lanzará una excepción)
        pila.desapilar(); // Desapilado: 2
        pila.desapilar(); // Desapilado: 1
        pila.desapilar(); // ItemNotFound: La pila está vacía.
    }
}
