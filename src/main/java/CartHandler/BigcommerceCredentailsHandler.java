package CartHandler;

import java.io.IOException;
import java.util.ArrayList;

public class BigcommerceCredentailsHandler {

    final String API_KEY = "cd40010ae9e83dda0143fd304e47b657";
    final String A2CURL = "https://api.api2cart.com/v1.0/cart.create.json?";

    public String bigCommerceCredentialsHandler() throws IOException {

        BigcommerceCredentialsCollector bigcommerceCredentialsCollector = new BigcommerceCredentialsCollector();

        System.out.println("Started with Bigcommerce credentials collector to collect all necessary credentials");
        ArrayList<String> bigcomcarray = bigcommerceCredentialsCollector.bigCommerceBasicCredentailsCollector();

        System.out.println("grab data from Bigcommerce credentials collector to Bigcommerce credentials handler to build cart.create method for adding new Bigcommerce store");

        String BigcommerceUrl = bigcomcarray.get(0);
        String BigcommerceAdminAccount = bigcomcarray.get(1);
        String BigcommerceApiPath = bigcomcarray.get(2);
        String BigcommerceApiKey = bigcomcarray.get(3);

        System.out.println("Start with String builder");
        StringBuilder bigCommerceStringBuilder = new StringBuilder();

        bigCommerceStringBuilder.append(A2CURL).append("api_key=").append(API_KEY).append("&cart_id=BigcommerceApi").append("&store_url=").append(BigcommerceUrl)
                .append("&AdminAccount=").append(BigcommerceAdminAccount).append("&ApiPath=").append(BigcommerceApiPath).append("&ApiKey=").append(BigcommerceApiKey);

        String bigcommerceConnectionApiCall = bigCommerceStringBuilder.toString();
        System.out.println("String building finished " + bigcommerceConnectionApiCall);

        return bigcommerceConnectionApiCall;
    }
}
