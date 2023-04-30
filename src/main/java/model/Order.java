package model;

/**
 * Reprezinta un tabel din DB
 */
public class Order {

    private int id;
    private int id_client;
    private int id_product;
    private int quantity;

    public Order() {
    }

    public Order(int id, int id_client, int id_product, int quantity) {
        super();
        this.id = id;
        this.id_client = id_client;
        this.id_product = id_product;
        this.quantity = quantity;
    }

    public Order( int id_client, int id_product, int quantity) {
        this.id_client = id_client;
        this.id_product = id_product;
        this.quantity = quantity;
    }

    public int getId() {

        return id;
    }
    public int getId_client() {

        return id_client;
    }

    public int getId_product() {

        return id_product;
    }
    public int getQuantity() {

        return quantity;
    }

    public void setId_product(int id_product) {

        this.id_product = id_product;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setId_client(int id_client) {

        this.id_client = id_client;
    }







    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
