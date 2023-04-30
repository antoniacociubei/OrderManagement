package model;

/**
 * represents the Product table from the DB
 */

public class Product {

    private int id;
    private String product_name;
    private int price;
    private int quantity;

    public Product() {

    }

    public Product( String product_name,int price,int quantity) {
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;

    }

    public Product(int id,String product_name,int price,int quantity) {
        super();
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;

    }


    public int getId() {

        return id;
    }
    public String getProduct_name() {

        return product_name;
    }
    public int getQuantity() {

        return quantity;
    }
    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public void setId(int id) {

        this.id = id;
    }


    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public void setProduct_name(String product_name) {

        this.product_name = product_name;
    }
}
