package treap;

public class Main {
    public static void main(String[] args) {
        Treap<Integer> treap = new Treap<>();

        // Insertar elementos en el Treap
        treap.insertar(10);
        treap.insertar(20);
        treap.insertar(15);
        treap.insertar(30);

        // Buscar elementos en el Treap
        System.out.println("Buscar 15: " + treap.buscar(15)); // Debería imprimir: true
        System.out.println("Buscar 25: " + treap.buscar(25)); // Debería imprimir: false
    }
}
