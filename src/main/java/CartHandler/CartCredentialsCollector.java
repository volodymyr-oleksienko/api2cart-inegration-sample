package CartHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CartCredentialsCollector {

    public String credentailsCollector() throws IOException {

        String connectionrequest = null;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you want to connect a new shopping cart ('yes'/'no')");
        String newConnection = bufferedReader.readLine();
        if (newConnection.equals("no")) {
        }
        else {
            System.out.println("Specify your shopping cart. It works with Shopify and Bigcommerce only");
            String newShoppingCart = bufferedReader.readLine();

            if (newShoppingCart.equals("Shopify")) {
                ShopifyCredentialsHandler sch = new ShopifyCredentialsHandler();
                connectionrequest = sch.shopifyCredentialsHandler();
            }
            else if (newShoppingCart.equals("Bigcommerce")) {
                BigcommerceCredentailsHandler bigcomch = new BigcommerceCredentailsHandler();
                connectionrequest = bigcomch.bigCommerceCredentialsHandler();
            }
            else {
                System.out.println("This method works with Shopify. Try to connect a Shopify store.");
            }
        }
        return connectionrequest;
    }
}