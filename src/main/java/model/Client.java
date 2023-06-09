package model;

/**
 * Reprezinta un tabel din DB
 */
public class Client {

    private int id;
    private String name;
    private String address;
    private String email;

    public Client() {
    }

    public Client( int id,String name, String address,String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.id = id;
    }

    public Client( String name, String address,String email) {
        super();
        this.name = name;
        this.address = address;
        this.email = email;
    }


    public int getId() {

        return id;
    }


    public String getName() {

        return name;
    }

    public String getAddress() {

        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public void setEmail(String email) {

        this.email = email;
    }

}


