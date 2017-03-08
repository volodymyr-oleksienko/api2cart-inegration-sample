package Database;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StatementWorker {

    String query = "select * from productshopifymain";
    public void getConnectedCartsStWorker() throws IOException, SQLException {

        String query = "select * from connectedcarts";
        DBConnectionWorker dbConnectionWorker = new DBConnectionWorker();

        try {
            Statement statement = dbConnectionWorker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                ConnectedCart connectedCart = new ConnectedCart();
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

    public ArrayList<String> getProductsMainStWorker() throws IOException, SQLException {

        String query = "select * from productshopifymain";
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


    public ArrayList<String> getProductsSecondStWorker() throws IOException, SQLException {

        String query = "select * from productsshopifytwo";
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
}

