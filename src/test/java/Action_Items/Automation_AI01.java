package Action_Items;

import java.util.ArrayList;

public class Automation_AI01 {

    public static void main(String[] args) {

        //Using ArrayList for String country and Integer countryCode with for loop and ArrayList
        ArrayList<String> country = new ArrayList<>();
        country.add("USA");
        country.add("Japan");
        country.add("Brazil");
        country.add("Turkey");

        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1);
        countryCode.add(81);
        countryCode.add(55);
        countryCode.add(90);

            for (int i = 0; i < country.size(); i++) {
                System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));

            }//end of for loop
        }//end of main
}//end of class
