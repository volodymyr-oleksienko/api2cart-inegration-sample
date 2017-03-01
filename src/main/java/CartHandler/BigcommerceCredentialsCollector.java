package CartHandler;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BigcommerceCredentialsCollector {

    String BigCommerceStoreUrl = null;
    String BigCommerceApiPath = null;
    String BigCommerceAdminAccount = null;
    String BigcommerceApiKey = null;

    public ArrayList<String> bigCommerceBasicCredentailsCollector() throws IOException {

        BufferedReader bigCommerceBufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Specify your Bigcommerce Store URL");
        String StoreUrl = bigCommerceBufferedReader.readLine();
        BigCommerceStoreUrl = StoreUrl;
        System.out.println("Specify your Bigcommerce Admin Account");
        String StoreAdminAccount = bigCommerceBufferedReader.readLine();
        BigCommerceAdminAccount = StoreAdminAccount;
        System.out.println("Specify your API Path");
        String StoreApiPath = bigCommerceBufferedReader.readLine();
        BigCommerceApiPath = StoreApiPath;
        System.out.println("Specify your API Key");
        String StoreApikey = bigCommerceBufferedReader.readLine();
        BigcommerceApiKey = StoreApikey;

        ArrayList<String> bigCommerceBasicCredentials = new ArrayList<String>(4);
        bigCommerceBasicCredentials.add(BigCommerceStoreUrl);
        bigCommerceBasicCredentials.add(BigCommerceAdminAccount);
        bigCommerceBasicCredentials.add(BigCommerceApiPath);
        bigCommerceBasicCredentials.add(BigcommerceApiKey);

        return bigCommerceBasicCredentials;
    }

}
