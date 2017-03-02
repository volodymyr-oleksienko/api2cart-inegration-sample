package CartHandler;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CartCreateDecoder {

    public String cartCreateDecoder() throws ParseException, IOException {

        CartApiHttpConnector cartApiConnector = new CartApiHttpConnector();

        // Allows to add a new shopping cart
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
        System.out.println(storekey);

        return storekey;
    }
}
