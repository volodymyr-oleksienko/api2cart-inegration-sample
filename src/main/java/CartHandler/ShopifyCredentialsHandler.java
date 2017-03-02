package CartHandler;

import Main.Constants;

import java.io.IOException;
import java.util.ArrayList;

public class ShopifyCredentialsHandler {

    String API2CART_KEY = Constants.getApiKey();
    final String A2CURL = "https://api.api2cart.com/v1.0/cart.create.json?";

    public String shopifyCredentialsHandler() throws IOException {

        ShopifyCredentialsCollector shopifyCredentialsCollector = new ShopifyCredentialsCollector();

        System.out.println("Started with shopify credentials collector to collect all necessary credentials");
        ArrayList<String> scarray = shopifyCredentialsCollector.shopifyOauthCredentialsCollector();
        System.out.println("grab data from shopify credentials collector to  shopify credentials handler to build cart.create method for Shopify");
        String ShopifuUrl = scarray.get(0);
        String ShopifyKey = scarray.get(1);
        String ShopifyPassword = scarray.get(2);

        System.out.println("Start with String builder");
        StringBuilder shopifyStringBuilder = new StringBuilder();

        shopifyStringBuilder.append(A2CURL).append("api_key=").append(API2CART_KEY).append("&cart_id=Shopify").append("&store_url=").append(ShopifuUrl)
                .append("&apiKey=").append(ShopifyKey).append("&apiPassword=").append(ShopifyPassword);

        String shopifyConnectionApiCall = shopifyStringBuilder.toString();
        System.out.println("String building finished " + shopifyConnectionApiCall);

        return shopifyConnectionApiCall;
    }
}
