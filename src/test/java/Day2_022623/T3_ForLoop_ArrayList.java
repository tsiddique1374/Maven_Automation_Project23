package Day2_022623;

import java.sql.Array;
import java.util.ArrayList;

public class T3_ForLoop_ArrayList {

    public static void main(String[] args) {

        //create an ArrayList of countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");
        countries.add("Russia");
        countries.add("Canada");
        countries.add("Argentina");

        ArrayList<Integer> areaCode = new ArrayList<>();
        areaCode.add(111);
        areaCode.add(211);
        areaCode.add(311);
        areaCode.add(411);
        areaCode.add(511);
        areaCode.add(611);
        areaCode.add(711);
        areaCode.add(811);


        //iterate/loop through the entire list of countries using for loop, then they all should have the same amount of count
        //if not then it needs to be in separate loop statement
        for (int i = 0; i < countries.size(); i++) {
            System.out.println("Country is " + countries.get(i) + " area code is " + areaCode.get(i));

        } //end of loop
    } //end of main
} //end of java class
