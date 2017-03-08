package Database;

public class DBProducts {

    private int id;
    private long id_in_store;
    private String name;
    private int price;
    private String sku;
    private int quantity;

    public DBProducts() {
    }

    private DBProducts(int id, long id_in_store, String name, int price, String sku, int quantity) {
        this.id = id;
        this.id_in_store = id_in_store;
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        this.id = id;
        return id;
    }

    public long getId_in_store() {
        return id_in_store;
    }

    public void setId_in_store(long id_in_store) {
        this.id_in_store = id_in_store;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String setSku(String sku) {
        this.sku = sku;
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
