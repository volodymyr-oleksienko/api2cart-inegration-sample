package Main;

import CartHandler.CartApiHttpConnector;
import CartHandler.CartCreateDecoder;
import CartHandler.CartCredentialsCollector;
import CartHandler.ShopifyCredentialsHandler;
import Database.ConnectedCart;
import Database.DBConnectionWorker;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        String API2CART_KEY = Constants.getApiKey();

        //SRetrieve from DB
        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();

        String query = "select * from connectedcarts";
        try {
            Statement statement = dbConnectionWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ConnectedCart connectedCart = new ConnectedCart();

                connectedCart.setId(resultSet.getInt("id"));
                connectedCart.setCart_type(resultSet.getString("cart_type"));
                connectedCart.setConnected_cart_name(resultSet.getString("connected_cart_name"));
                connectedCart.setStore_key(resultSet.getString("store_key"));

                System.out.println(connectedCart);
                System.out.println(connectedCart.getStore_key());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //STORE_KEYS are unique for all connected stores under your account
        //Change your store keys to send a request to another shopping cart
        final String OPENCART_STORE_KEY = "ed58a22dfecb405a50ea3ea56979360d";
        final String WOOCOMMERCE_STORE_KEY = "cfce78a77cc4r46ab02ca75aee5d4398";

        //CartCreate Decoder is used to connect a new shopping cart and retrieve its store key for sending further request to API2Cart
        CartCreateDecoder ccd = new CartCreateDecoder();
        ccd.cartCreateDecoder();

        String storekey = null;

        SimpleConnector connector;
        connector = new SimpleConnector(storekey, API2CART_KEY);
        connector.clearLog();

        Product product = new Product(connector);
        product.productList();
    }
}