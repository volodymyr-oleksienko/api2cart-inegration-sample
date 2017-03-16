package Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatementWorker {

    //Get the list of connected carts from DB
    public void getConnectedCartsStWorker() throws IOException, SQLException {
        String query = "select * from connectedcarts";
        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();

        try {
            Statement statement = dbConnectionWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                DBConnectedCarts connectedCart = new DBConnectedCarts();
                connectedCart.setId(resultSet.getInt("id"));
                connectedCart.setCart_type(resultSet.getString("cart_type"));
                connectedCart.setConnected_cart_name(resultSet.getString("connected_cart_name"));
                connectedCart.setStore_key(resultSet.getString("store_key"));

                System.out.println(connectedCart.getConnected_cart_name() + " : " + connectedCart.getStore_key());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //get the list of products in main shopping cart from DB
    public ArrayList<String> getProductsMainStWorker() throws IOException, SQLException {

        String query = "select * from productsmain";
        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();

        ArrayList<String> pmain = new ArrayList<String>();

        try {
            Statement statement = dbConnectionWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                DBProducts dbProducts = new DBProducts();

                int id = dbProducts.setId(resultSet.getInt("id"));
                String name = dbProducts.setName(resultSet.getString("name"));
                String sku = dbProducts.setSku(resultSet.getString("sku"));
                //System.out.println(id + " " + name + " " + sku);
                pmain.add(sku);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pmain;
    }

    //get the list of products in second shopping cart from DB
    public ArrayList<String> getProductsSecondStWorker() throws IOException, SQLException {

        String query = "select * from productssecond";
        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();

        ArrayList<String> psecond = new ArrayList<String>();

        try {
            Statement statement = dbConnectionWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                DBProducts dbProducts = new DBProducts();

                int id = dbProducts.setId(resultSet.getInt("id"));
                String name = dbProducts.setName(resultSet.getString("name"));
                String sku = dbProducts.setSku(resultSet.getString("sku"));
                //System.out.println(id + " " + name + " " + sku);
                psecond.add(sku);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return psecond;
    }

    //insert products in main shopping cart into DB
    public void postProductsMainStWorker(ArrayList<HashMap<String, Object>> productMainList) {

        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();
        try {
            Statement statement = dbConnectionWorker.getConnection().createStatement();

            String querymain = "INSERT INTO productsmain (id_in_store, name, price, sku, quantity) ";

            for (Map<String, Object> entry : productMainList) {

                Object id_in_store = entry.get("id_in_store");
                String name = entry.get("name").toString();
                Object price = entry.get("price");
                String sku = entry.get("u_model").toString();
                Object quantity = entry.get("quantity");

                StringBuilder sb = new StringBuilder();
                sb.append("VALUES(").append("'" + id_in_store + "',").append("'" + name + "',").append("'" + price + "',")
                        .append("'" + sku + "',").append("'" + quantity + "')");

                String query = sb.toString();
                System.out.println("Query test " + query);
                String query_all = querymain + query;
                System.out.println("Main " + query_all);
                statement.executeUpdate(query_all);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //insert products in second shopping cart into DB
    public void postProductsSecondStWorker(ArrayList<HashMap<String, Object>> productMainList) {

        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();
        try {
            Statement statement = dbConnectionWorker.getConnection().createStatement();

            String querymain = "INSERT INTO productssecond (id_in_store, name, price, sku, quantity) ";

            for (Map<String, Object> entry : productMainList) {

                Object id_in_store = entry.get("id_in_store");
                String name = entry.get("name").toString();
                Object price = entry.get("price");
                String sku = entry.get("u_model").toString();
                Object quantity = entry.get("quantity");

                StringBuilder sb = new StringBuilder();
                sb.append("VALUES(").append("'" + id_in_store + "',").append("'" + name + "',").append("'" + price + "',")
                        .append("'" + sku + "',").append("'" + quantity + "')");

                String query = sb.toString();
                System.out.println("Query test " + query);
                String query_all = querymain + query;
                System.out.println("Main " + query_all);
                statement.executeUpdate(query_all);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}