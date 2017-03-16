package Main;

import Api2cartApi.Product;
import Api2cartApi.ProductList;
import Api2cartApi.SimpleConnector;
import CartHandler.CartCreateDecoder;
import Database.StatementWorker;
import EntityChecker.ProductChecker;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        String API2CART_KEY = Constants.getApiKey();
        String WOOCOMMERCE_KEY = Constants.getWoocommerceStoreKey();
        String OPENCART_KEY = Constants.getOpencartStoreKey();

        //Create connection to main shopping cart
        SimpleConnector connector;
        connector = new SimpleConnector(WOOCOMMERCE_KEY, API2CART_KEY);

        //Create connection to second shopping cart
        SimpleConnector connector2 = new SimpleConnector(OPENCART_KEY, API2CART_KEY);

        //Get products from main shopping cart and store as an ArrayList of HashMaps
        ProductList productListMain = new ProductList(connector);
        ArrayList<HashMap<String, Object>> productHashMapListMain = productListMain.productList();

        //Get products from second shopping cart and store as an ArrayList of HashMaps
        ProductList productListSecond = new ProductList(connector2);
        ArrayList<HashMap<String, Object>> productHashMapListSecond = productListSecond.productList();

        //StatementWorker to INSERT products from main shopping cart into a DB
        StatementWorker postProductWorker = new StatementWorker();
        postProductWorker.postProductsMainStWorker(productHashMapListMain);

        //StatementWorker to INSERT products from second shopping cart into a DB
        postProductWorker.postProductsSecondStWorker(productHashMapListSecond);

        //StatementWorker to get products from DB
        StatementWorker getProductWorker = new StatementWorker();

        //Get product SKUs from main shopping cart
        ArrayList<String> productsMainList = getProductWorker.getProductsMainStWorker();
        System.out.println(productsMainList);

        //Get product SKUs from second shopping cart
        ArrayList<String> productSecondList = getProductWorker.getProductsSecondStWorker();
        System.out.println(productSecondList);

        //Create a product checker object to check SKUs from main and second shopping cart
        ProductChecker productChecker = new ProductChecker();
        ArrayList<String> prChecked = productChecker.productChekedList(productsMainList, productSecondList);
        System.out.println(prChecked);

//        CartCreate Decoder is used to connect a new shopping cart and retrieve its store key for sending further request to API2Cart
//        CartCreateDecoder ccd = new CartCreateDecoder();
//        ccd.cartCreateDecoder();
//
//        SimpleConnector connector;
//        connector = new SimpleConnector(WOOCOMMERCE_KEY, API2CART_KEY);
//        connector.clearLog();
//
//        Product product = new Product(connector);
//        product.productList();
    }
}