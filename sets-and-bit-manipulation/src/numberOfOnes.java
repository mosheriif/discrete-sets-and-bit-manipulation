import java.util.*;
import java.lang.*;

public class numberOfOnes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int onesCounter = 0;
        System.out.println("Please enter your number");
        int number = sc.nextInt();
        String binaryNum = Integer.toBinaryString(number);
        for (int i = 0; i < binaryNum.length(); i++)
        {
            if ( binaryNum.charAt(i) == '1' )
            {
                onesCounter++;
            }
        }
        System.out.println("There are " + onesCounter + " ones in your number");
    }
}
