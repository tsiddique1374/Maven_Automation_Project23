package Action_Items;

public class Automation_AI02 {

    public static void main(String[] args) {

        //Using Linear Array String[] region and int[] regionalCode with while loop and linear array
        String[] region = new String[]{"Boston","Brooklyn","Chicago","Denver"};
        int[] regionalCode = new int[]{857,718,872,720};

        int i = 0;
        while (i< region.length){
            System.out.println("My region is " + region[i] + " and my area code is " + regionalCode[i]);

            i=i+1;

        }//end of while loop
    }//end of main
}//end of class
