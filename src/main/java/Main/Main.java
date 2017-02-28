package Main;

import CartHandler.CartApiHttpConnector;
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

//        //SRetrieve from DB
//        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();
//
//        String query = "select * from connectedcarts";
//        try {
//            Statement statement = dbConnectionWorker.getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                ConnectedCart connectedCart = new ConnectedCart();
//
//                connectedCart.setId(resultSet.getInt("id"));
//                connectedCart.setCart_type(resultSet.getString("cart_type"));
//                connectedCart.setConnected_cart_name(resultSet.getString("connected_cart_name"));
//                connectedCart.setStore_key(resultSet.getString("store_key"));
//
//                System.out.println(connectedCart);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //API_KEY is a unique for your API2Cart account.
        final String API_KEY = "cd40010ae9e83dda0143fd304e47b657";

        //STORE_KEYS are unique for all connected stores under your account
        //Change your store keys to send a request to another shopping cart
        final String OPENCART_STORE_KEY = "ed58a22dfecb405a50ea3ea56979360d";
        final String WOOCOMMERCE_STORE_KEY = "cfce78a77cc4r46ab02ca75aee5d4398";


        CartApiHttpConnector cartApiConnector = new CartApiHttpConnector();

        // Don't delete
        CartCredentialsCollector ccc = new CartCredentialsCollector();

        //make a request to API2Cart in order to connect a Shopify store
        String connResponse = cartApiConnector.makeServiceCall(ccc.credentailsCollector());
        System.out.println("response " + connResponse);

        //decode JSON response
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject)parser.parse(connResponse);
        System.out.println(jsonObj);

        String result = jsonObj.get("result").toString();
        System.out.println(result);

        //Parse result object
        JSONObject jsonObj2 = (JSONObject)parser.parse(result);
        //Get generated store_key
        String storekey = jsonObj2.get("store_key").toString();
        System.out.print(storekey);

        SimpleConnector connector;

        connector = new SimpleConnector(storekey, API_KEY);
        connector.clearLog();

        Product product = new Product(connector);

        product.productList();
    }
}