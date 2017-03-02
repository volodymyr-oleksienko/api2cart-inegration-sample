package Main;

import Main.SimpleConnector;
import Main.SimpleRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.HashMap;
import java.util.Iterator;

public class Product extends SimpleRequest {

    public Product(SimpleConnector con) {
        super(con);
    }

    public void productList()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("start","0");
            arg.put("count","4");
            arg.put("params","id,name,price");

            String response = this.connector.initRequest("product.list",arg);

            JSONObject jsonObj = this.validate(response);

            int products_count = Integer.parseInt(jsonObj.get("products_count").toString());

            JSONArray jsonArray = (JSONArray)jsonObj.get("product");

            System.out.println("Products count: " + products_count);

            for(int i = 0;i < products_count; i++) {
                jsonObj = (JSONObject)jsonArray.get(i);
                System.out.println("\tId: " + jsonObj.get("id").toString());
                System.out.println("\tName: " + jsonObj.get("name").toString());
                System.out.println("\tPrice: " + jsonObj.get("price").toString());
                System.out.println("-----------------");
            }

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.list: " + e.getMessage());
        }
    }

    public void productCount()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();

            arg.put("category_id","28");

            String response = this.connector.initRequest("product.count",arg);
            JSONObject jsonObj = this.validate(response);
            System.out.println("\tproducts_count: " + jsonObj.get("products_count").toString());
            System.out.println("------------------------");

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.count: " + e.getMessage());
        }
    }

        /**
     * Main.Product info
     * id: 32
     * params: force_all (all product fields)
     *
     * @param productId - int
     */
    public void productInfo(int productId)
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("id",""+productId);
            arg.put("params","force_all");

            String response = this.connector.initRequest("product.info",arg);

            JSONObject jsonObj = this.validate(response);
            System.out.println(jsonObj);

            Iterator<String> fieldIterator = jsonObj.keySet().iterator();

            while (fieldIterator.hasNext()) {
                String key = fieldIterator.next();

                String value;
                if(jsonObj.get(key) == null) {
                    value = "null";
                } else {
                    value = jsonObj.get(key).toString();
                }
                System.out.println("\t" + key + ": " + value);
            }
            System.out.println("-----------------");
            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.info: " + e.getMessage());
        }
    }


    public void ProductFind() {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("find_value", "Apple");
            arg.put("find_where", "name");
            arg.put("find_params", "regex");

            String response = this.connector.initRequest("product.find", arg);

            JSONObject jsonObj = this.validate(response);

            int products_count = Integer.parseInt(jsonObj.get("products_count").toString());

            JSONArray jsonArray = (JSONArray) jsonObj.get("product");

            System.out.println("Products count: " + products_count);

            for (int i = 0; i < products_count; i++) {
                jsonObj = (JSONObject) jsonArray.get(i);
                System.out.println("\tId: " + jsonObj.get("id").toString());
                System.out.println("\tName: " + jsonObj.get("name").toString());
                System.out.println("\tDescription: " + jsonObj.get("description").toString());
                System.out.println("\tPrice: " + jsonObj.get("price").toString());
                System.out.println("-----------------");
            }
            this.connector.writeLog();

        } catch (Exception e) {
            System.out.println("Error product.find: " + e.getMessage());
        }
    }

    public void ProductFields() {
        try {
            String response = this.connector.initRequest("product.fields");

            JSONObject jsonObj = this.validate(response);

            int products_fields = Integer.parseInt(jsonObj.get("product_fields").toString());

            JSONArray jsonArray = (JSONArray)jsonObj.get("product");

            System.out.println("product_fields: " + products_fields);

            for(int i = 0;i < products_fields; i++) {
                jsonObj = (JSONObject)jsonArray.get(i);
                System.out.println("\tId: " + jsonObj.get("id").toString());
                System.out.println("-----------------");
            }

            this.connector.writeLog();

        } catch (Exception e) {
            System.out.println("Error product.fields: " + e.getMessage());
        }
    }

    public void productAdd()
    {
        try {
            HashMap<String,Object> arg = new HashMap<String, Object>();
            arg.put("name","Pixel X");
            arg.put("model","221");
            arg.put("description","my google phone");
            arg.put("price","800");

            String request = this.connector.initRequest("product.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.add: " + e.getMessage());
        }
    }

    public void productUpdate()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("id","70");
            arg.put("model","221");
            arg.put("quantity","10");
            arg.put("description","updated description");

            String request = this.connector.initRequest("product.update",arg);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.update: " + e.getMessage());
        }
    }


    public void productDelete()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("id","71");

            String request = this.connector.initRequest("product.delete",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.delete: " + e.getMessage());
        }
    }

    public void productPriceAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","Nexus 6");
            arg.put("group_prices","array");

            String request = this.connector.initRequest("product.price.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.price.add: " + e.getMessage());
        }
    }

    public void productPriceUpdate()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","Nexus 6");
            arg.put("group_prices","array");

            String request = this.connector.initRequest("product.price.update",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {

            System.out.println("Error product.price.update: " + e.getMessage());

        }
    }

    public void productPriceDelete()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","Nexus 6");

            String request = this.connector.initRequest("product.price.delete",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();
        }
        catch(Exception e) {
            System.out.println("Error product.price.delete: " + e.getMessage());
        }
    }


    public void productImageAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","71");
            arg.put("image_name","nexus.jpg");
            arg.put("type","base");
            arg.put("url","https://content2.onliner.by/catalog/device/200x200/ab7df0276716d5a3395e8d16b1c07ca0.jpg");

            String request = this.connector.initRequest("product.image.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.image.add: " + e.getMessage());
        }
    }


    public void productImageUpdate()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","71");
            arg.put("image_name","nexus.jpg");
            arg.put("label","test label text");

            String request = this.connector.initRequest("product.image.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.image.update: " + e.getMessage());
        }
    }


    public void productAttributeList()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("start","0");
            arg.put("count","10");
            arg.put("params","force_all");

            String response = this.connector.initRequest("product.attribute.list",arg);

            JSONObject jsonObj = this.validate(response);

            int attributes_count = Integer.parseInt(jsonObj.get("attributes_count").toString());

            JSONArray jsonArray = (JSONArray)jsonObj.get("attribute");

            System.out.println("Attributes_count: " + attributes_count);

            for(int i = 0;i < attributes_count; i++) {
                jsonObj = (JSONObject)jsonArray.get(i);
                System.out.println("\tAttribute_id: " + jsonObj.get("attribute_id").toString());
                System.out.println("\tName: " + jsonObj.get("name").toString());
                System.out.println("-----------------");
            }
            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.attribute.list: " + e.getMessage());
        }
    }

    public void productOptionAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("name","Memory");
            arg.put("type","option_type_text");
            arg.put("product_id","70");

            String request = this.connector.initRequest("product.option.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.option.add: " + e.getMessage());
        }
    }

    public void productOptionList()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("start","0");
            arg.put("count","4");
            arg.put("product_id","70");
            arg.put("params","id,name");

            String response = this.connector.initRequest("product.option.list",arg);

            JSONObject jsonObj = this.validate(response);

            int options_count = Integer.parseInt(jsonObj.get("options_count").toString());

            JSONArray jsonArray = (JSONArray)jsonObj.get("option");

            System.out.println("Options count: " + options_count);

            for(int i = 0;i < options_count; i++) {
                jsonObj = (JSONObject)jsonArray.get(i);
                System.out.println("\tId: " + jsonObj.get("id").toString());
                System.out.println("\tName: " + jsonObj.get("name").toString());
                System.out.println("-----------------");
            }

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.option: " + e.getMessage());
        }
    }

    public void productOptionAssign()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","60");
            arg.put("option_id","4");

            String request = this.connector.initRequest("product.option.assign",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.option.assign: " + e.getMessage());
        }
    }


    public void productOptionValueAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("option_id","4");
            arg.put("option_value","test option value");

            String request = this.connector.initRequest("product.option.value.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.option.value.add: " + e.getMessage());
        }
    }

    public void productOptionValueAssign()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_option_id","10");
            arg.put("option_value_id","test option value integer");

            String request = this.connector.initRequest("product.option.value.assign",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.option.value.assign: " + e.getMessage());
        }
    }


    public void productOptionValueUpdate()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("option_value_id","test option value integer");
            arg.put("price","decimal value");
            arg.put("quantity","Integer value");

            String request = this.connector.initRequest("product.option.value.update",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.option.value.update: " + e.getMessage());
        }
    }


    public void productVariantAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","Nexus 6");
            arg.put("name","Nexus 6 Blue");
            arg.put("model","model code");
            arg.put("attributes"," ARRAY");
            arg.put("special_price","integer");
            arg.put("quantity","integer");
            arg.put("created_at","Date");

            String request = this.connector.initRequest("product.variant.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.variant.add: " + e.getMessage());
        }
    }

    public void productVariantList()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("start","0");
            arg.put("count","10");
            arg.put("params","id,name,price");

            String response = this.connector.initRequest("product.variant.list",arg);

            JSONObject jsonObj = this.validate(response);

            int variants_count = Integer.parseInt(jsonObj.get("variants_count").toString());

            JSONArray jsonArray = (JSONArray)jsonObj.get("variant");

            System.out.println("Variants count: " + variants_count);

            for(int i = 0;i < variants_count; i++) {
                jsonObj = (JSONObject)jsonArray.get(i);
                System.out.println("\tId: " + jsonObj.get("id").toString());
                System.out.println("\tName: " + jsonObj.get("name").toString());
                System.out.println("\tPrice: " + jsonObj.get("price").toString());
                System.out.println("-----------------");
            }

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.variant.list: " + e.getMessage());
        }
    }

    public void productVariantInfo(int productVariantId)
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("id","" + productVariantId);
            arg.put("params","force_all");

            String response = this.connector.initRequest("product.variant.info",arg);

            JSONObject jsonObj = this.validate(response);
            System.out.println(jsonObj);

            Iterator<String> fieldIterator = jsonObj.keySet().iterator();

            while (fieldIterator.hasNext()) {
                String key = fieldIterator.next();

                String value;
                if(jsonObj.get(key) == null) {
                    value = "null";
                } else {
                    value = jsonObj.get(key).toString();
                }
                System.out.println("\t" + key + ": " + value);
            }
            System.out.println("-----------------");
            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.variant.info: " + e.getMessage());
        }
    }


    public void productVariantCount()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();

            arg.put("category_id" , "6");
            arg.put("created_from","2010-07-29 13:45:52");
            arg.put("created_from","2010-08-29 13:45:52");

            String response = this.connector.initRequest("product.variant.count",arg);
            JSONObject jsonObj = this.validate(response);
            System.out.println("\tvariants_count: " + jsonObj.get("variants_count").toString());
            System.out.println("---------------------------");

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.variant.count: " + e.getMessage());
        }
    }

    public void productVariantUpdate()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("id","12");
            arg.put("price","221");
            arg.put("quantity","10");
            arg.put("manage_stock","true");

            String request = this.connector.initRequest("product.variant.update",arg);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.variant.update: " + e.getMessage());
        }
    }


    public void productVariantDelete()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("id","71");

            String request = this.connector.initRequest("product.variant.delete",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.variant.delete: " + e.getMessage());
        }
    }

    public void productTaxAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","42");
            arg.put("name","ECO-Tax");
            arg.put("tax_rates","array)");

            String request = this.connector.initRequest("product.tax.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.tax.add: " + e.getMessage());
        }
    }


    public void productManufacturerAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("product_id","35");
            arg.put("manufacturer","Google");

            String request = this.connector.initRequest("product.manufacturer.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.manufacturer.add: " + e.getMessage());
        }
    }


    public void productCurrencyAdd()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("iso3","USD");
            arg.put("rate","10");

            String request = this.connector.initRequest("product.currency.add",arg);
            JSONObject jsonObj = this.validate(request);

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.currency.add: " + e.getMessage());
        }
    }


    public void productCurrencyList()
    {
        try {
            HashMap<String, Object> arg = new HashMap<String, Object>();
            arg.put("start","0");
            arg.put("count","10");
            arg.put("params","force_all");

            String response = this.connector.initRequest("product.currency.list",arg);

            JSONObject jsonObj = this.validate(response);

            int currencies_count = Integer.parseInt(jsonObj.get("currencies_count").toString());

            JSONArray jsonArray = (JSONArray)jsonObj.get("currency");

            System.out.println("Currencies_count: " + currencies_count);

            for(int i = 0;i < currencies_count; i++) {
                jsonObj = (JSONObject)jsonArray.get(i);
                System.out.println("\tName: " + jsonObj.get("name").toString());
                System.out.println("\tIso3: " + jsonObj.get("iso3").toString());
                System.out.println("\tSymbol_left: " + jsonObj.get("symbol_left").toString());
                System.out.println("-----------------");
            }

            this.connector.writeLog();

        } catch(Exception e) {
            System.out.println("Error product.currency.list: " + e.getMessage());
        }
    }


    /**
     * Validate response
     *
     * @param response - String
     *
     * @return - JSONObject
     * @throws Exception
     */
    private JSONObject validate(String response) throws Exception
    {
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject)parser.parse(response);

        if(Integer.parseInt(jsonObj.get("return_code").toString()) != 0) {

            this.connector.writeLog(jsonObj.get("return_code").toString(),jsonObj.get("return_message").toString());
            throw new Exception("#" + jsonObj.get("return_code") + " " + jsonObj.get("return_message"));
        }

        return (JSONObject)jsonObj.get("result");
    }
}
