package Action_Items;

public class Automation_AI03 {

    public static void main(String[] args) {

        int grade = 60;                              //declaring grade variable

        if(grade >=90 && grade <=100){              //beginning condition if grade is 90 to 100
            System.out.println("Grade is A");       //if grade is 90-100 print out Grade is A
        } else if (grade >=80 && grade <90){
            System.out.println("Grade is B");       //if grade is 80-89 print out grade is B
        } else if (grade >=70 && grade <80){
            System.out.println("Grade is C");       //if grade is 70-79 print out grade is C
        } else if (grade >=60 && grade <70){
            System.out.println("Grade is D");       //if grade is 60-69 print out grade is D
        } else if (grade <60){
            System.out.println("Grade is F");       //if grade is below 60 print out grade is F
        }//end of conditional
    }//end of main
}//end of class