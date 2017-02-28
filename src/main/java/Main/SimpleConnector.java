package Main;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class SimpleConnector
{
    //URL to Api2Cart Service
    private final String A2C_URL = "https://api.api2cart.com/v1.0/";

    public static final String DATA_FORMAT_XML = "xml";
    public static final String DATA_FORMAT_JSON = "json";

    //Your Store Key. It's unique for every added Store
    private String StoreKey;

    //Your Api Key
    private String ApiKey;

    //Response Data Format (XML or JSON)
    private String DataFormat;

    //URL query string;
    private StringBuilder Query;

    private String fileLogs = "logs.csv";

    public SimpleConnector(String storeKey, String apiKey)
    {
        this.StoreKey = storeKey;
        this.ApiKey = apiKey;
        this.DataFormat = DATA_FORMAT_JSON;
    }

    public SimpleConnector(String storeKey, String apiKey, String dataFormat)
    {
        this.StoreKey = storeKey;
        this.ApiKey = apiKey;
        this.DataFormat = dataFormat.toLowerCase();
    }

    public String initRequest(String MethodName) throws Exception
    {
        HashMap<String,Object> arg = new HashMap<String, Object>();
        return this.initRequest(MethodName, arg);
    }

    /**
     * It's a simple method for a request to API2Cart.
     *
     * @param MethodName - String
     * @param arguments - HashMap
     *
     * @return String
     * @throws Exception
     */
    public String initRequest(String MethodName, HashMap<String, Object> arguments) throws Exception
    {
        System.out.println("Start Init Request...");

        this.BuildQueryString(MethodName.toLowerCase(), arguments);

        System.out.println("QUERY_STRING:");
        System.out.println(this.Query.toString());

        URL url = new URL(this.Query.toString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        System.out.println("Build Response Body...\n");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    /**
     * Build query string
     *
     * @param method - String
     * @param arguments - HashMap
     *
     * @throws Exception
     */
    private void BuildQueryString(String method, HashMap<String, Object> arguments) throws Exception
    {
        System.out.println("Start Build QUERY_STRING...");

        this.Query = new StringBuilder();
        this.Query.append(A2C_URL).append(method).append('.').append(this.DataFormat).append('?');

        arguments.put("api_key",this.ApiKey);
        arguments.put("store_key",this.StoreKey);

        Iterator<String> paramIterator = arguments.keySet().iterator();

        while (paramIterator.hasNext()) {
            String key = paramIterator.next();
            Object value = arguments.get(key);
            this.Query.append(URLEncoder.encode(key, "UTF-8"));
            this.Query.append("=").append(URLEncoder.encode(String.valueOf(value), "UTF-8"));
            this.Query.append("&");
        }
    }

    public void writeLog()
    {
        this.writeLog("0","OK");
    }
    /**
     * Write logs
     *
     * @param code - String
     * @param msg - String
     */
    public void writeLog(String code, String msg)
    {
        try {
            Date d = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

            StringBuilder rows = new StringBuilder();
            BufferedReader in = new BufferedReader(new FileReader(this.fileLogs));
            String s;
            while ((s = in.readLine()) != null) {
                rows.append(s).append("\n");
            }
            rows.append(code).append(",").append(msg).append(",").append(format.format(d)).append(",").append(this.Query).append("\n");

            FileWriter file = new FileWriter(this.fileLogs);
            file.write(rows.toString());
            file.close();

        } catch(Exception e) {
            System.out.println("Error write log: " + e.getMessage());
        }
    }

    //Clear log

    public void clearLog()
    {
        try {
            File file = new File(this.fileLogs);

            if(file.exists()) {
                file.delete();
            }
            file.createNewFile();

            FileWriter f = new FileWriter(this.fileLogs);
            f.write("code,message,date,request");
            f.close();

        } catch (Exception e) {
            System.out.println("Error clear log: " + e.getMessage());
        }
    }
}