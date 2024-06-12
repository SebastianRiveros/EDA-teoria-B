package store;
import bst.*;
import exceptions.ItemNotFound;

public class Store {
    // Atributos de la tienda
    private BST<Product> products;

    // Constructor que inicializa el BST de productos
    public Store() {
        products = new BST<>();
    }

    public void buy(String code, String description, int stock) {
        if (stock < 0) {
            System.out.println("El stock no puede ser negativo");
            return;
        }

        Product product = products.search(new Product(code, description, 0));
        if (product != null) { //si el producto existía
            product.setStock(product.getStock() + stock); //se actualiza solo es stock
        } else { //si el producto no existía
            products.insert(new Product(code, description, stock));
        }
    }

    public void removeProduct(String code) {
        products.remove(new Product(code, "", 0));
    }

    public void sell(String code, int stock) {
        if (stock < 0) {
            System.out.println("El stock no puede ser negativo");
            return;
        }

        Product product = products.search(new Product(code, "", 0));
        if (product == null) {
            System.out.println("El producto no existe");
            return;
        }

        if (product.getStock() < stock) {
            System.out.println("stock insuficiente");
            return;
        }
        
        product.setStock(product.getStock() - stock);
    }
}
