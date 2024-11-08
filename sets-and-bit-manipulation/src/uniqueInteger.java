import java.util.*;
import java.lang.*;

public class uniqueInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your list");
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(",");;
        int[] array = new int[s.length];
        if (s.length % 2 == 1) {
            if (s.length == 1 && s[0].isEmpty()) {
                array = new int[]{};
            } else {
                for (int i = 0; i < s.length; i++) {
                    array[i] = Integer.parseInt(s[i]);
                }
            }
            int uniqueNum = array[0];
            for (int i = 1; i < array.length; i++) {
                uniqueNum = uniqueNum ^ array[i];
            }
            System.out.println("The unique element in your array is " + uniqueNum);
        }
        else
        {
            System.out.println("Array cannot have a unique element");
        }
    }
}