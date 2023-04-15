package Day3_030423;

public class T2_Multiple_Conditions {

    public static void main(String[] args) {

        //using multiple conditional statements to verify when a+b > c, a+b < c, a+b == c

        // < less than
        // <= less than or equal to
        // > greater than
        // >= greater than or equal to
        // == equal to

        int a = 2;
        int b = 3;
        int c = 5;

        if (a+b > c){
            System.out.println("a and b is greater than c");
        } else if(a+b < c){
            System.out.println("a and b is less than c");
        } else {
            System.out.println("a and b is equal to c");
        }//end of multiple conditions
    }//end of main
}//end of class
