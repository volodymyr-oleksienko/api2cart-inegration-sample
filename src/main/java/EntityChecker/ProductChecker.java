package EntityChecker;

import java.util.ArrayList;

public class ProductChecker {

    public static ArrayList<String> productChekedList(ArrayList<String> main, ArrayList<String> second){

        ArrayList<String> productCheckedList = new ArrayList<String>();

        for (int i = 0; i < main.size(); i++){
            String prmain = main.get(i);
            for (int j = 0; j < second.size(); j++){
                String prsecond = second.get(j);
                if (prmain.equals(prsecond)) {
                    System.out.println("There is a match");

                    productCheckedList.add(prmain);
                }
            }
        }
        return productCheckedList;
    }
}
