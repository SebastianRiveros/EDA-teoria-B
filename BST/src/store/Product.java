package store;

public class Product implements Comparable<Product> {
    private String code;
    private String description;
    private int stock;

    public Product(String code, String description, int stock) {
        this.code = code;
        this.description = description;
        this.stock = stock;
    }
    public Product(){
        this("","",0);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return this.code.compareTo(otherProduct.getCode());
    }
}
