package CartHandler;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShopifyCredentialsCollector {

    String ShopifyStoreURL = null;
    String ShopifyApiKey = null;
    String ShopifyApiPassword = null;

    public ArrayList<String> shopifyOauthCredentialsCollector() throws IOException {

        BufferedReader shopifyOauthBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Specify your storeURL");
        String newSroreUrl = shopifyOauthBufferedReader.readLine();
        ShopifyStoreURL = newSroreUrl;
        System.out.println("Specify your API key");
        String newApiKey = shopifyOauthBufferedReader.readLine();
        ShopifyApiKey = newApiKey;
        System.out.println("Specify your Api Password");
        String newApiPassword = shopifyOauthBufferedReader.readLine();
        ShopifyApiPassword = newApiPassword;

        ArrayList<String> shopifyOauthCredentials = new ArrayList<String>(3);
        shopifyOauthCredentials.add(ShopifyStoreURL);
        shopifyOauthCredentials.add(ShopifyApiKey);
        shopifyOauthCredentials.add(ShopifyApiPassword);

        return shopifyOauthCredentials;
    }

}
