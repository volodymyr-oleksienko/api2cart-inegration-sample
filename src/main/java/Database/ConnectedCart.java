package Database;

public class ConnectedCart {

    private int id;
    private String cart_type;
    private String connected_cart_name;
    private String store_key;

    public ConnectedCart() {
    }

    public ConnectedCart(int id, String cart_type, String connected_cart_name, String store_key) {
        this.id = id;
        this.cart_type = cart_type;
        this.connected_cart_name = connected_cart_name;
        this.store_key = store_key;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCart_type() {
        return cart_type;
    }

    public void setCart_type(String cart_type) {
        this.cart_type = cart_type;
    }

    public String getConnected_cart_name() {
        return connected_cart_name;
    }

    public void setConnected_cart_name(String connected_cart_name) {
        this.connected_cart_name = connected_cart_name;
    }

    public String getStore_key() {
        return store_key;
    }

    public void setStore_key(String store_key) {
        this.store_key = store_key;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + id +
                ", cart type: " + cart_type +
                ", connected cart name: " + connected_cart_name +
                ", store key: " + store_key + "}";
    }
}
