package Main;

import Api2cartApi.Product;
import Api2cartApi.SimpleConnector;
import CartHandler.CartCreateDecoder;
import Database.StatementWorker;
import EntityChecker.ProductChecker;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {

        String API2CART_KEY = Constants.getApiKey();
        String WOOCOMMERCE_KEY = Constants.getWoocommerceStoreKey();

        //StatementWorker
        StatementWorker productWorkerMain = new StatementWorker();
        ArrayList<String> productsMainList = productWorkerMain.getProductsMainStWorker();
        System.out.println(productsMainList);

        StatementWorker productWorkerSecond = new StatementWorker();
        ArrayList<String> productSecondList = productWorkerSecond.getProductsSecondStWorker();
        System.out.println(productSecondList);

        ProductChecker productChecker = new ProductChecker();
        ArrayList<String> prChecked = productChecker.productchkr(productsMainList, productSecondList);
        System.out.println(prChecked);

        //CartCreate Decoder is used to connect a new shopping cart and retrieve its store key for sending further request to API2Cart
        CartCreateDecoder ccd = new CartCreateDecoder();
        ccd.cartCreateDecoder();

        SimpleConnector connector;
        connector = new SimpleConnector(WOOCOMMERCE_KEY, API2CART_KEY);
        connector.clearLog();

        Product product = new Product(connector);
        product.productList();
    }
}