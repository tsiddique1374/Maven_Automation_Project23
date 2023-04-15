package Day2_022623;

import java.util.ArrayList;

public class T2_ArrayList {

    public static void main(String[] args) {

        //create an ArrayList of countries
        ArrayList <String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");

        //get the count of the ArrayList
        System.out.println("Countries list: " + countries.size());
        //print only USA Bangladesh and India
        System.out.println("Countries are " + countries.get(0) + ", " + countries.get(1) + ", " +countries.get(2));

        //add Russia to the countries ArrayList
        countries.add("Russia");
        //get the count of the list
        System.out.println("Countries list: " + countries.size());
        System.out.println(countries.get(4));

        //create an Integer arrayList of area codes
        ArrayList <Integer> areaCode = new ArrayList<>();
        areaCode.add(777);
        areaCode.add(222);
        areaCode.add(333);
        //get the count of the list
        System.out.println("Area code list: " + areaCode.size());
        //Print the first and third area code
        System.out.println("Area codes are " + areaCode.get(0) + ", " + areaCode.get(2));

    } //end of main
} //end of java class
