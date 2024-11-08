import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.*;

public class basicBitOperations {

    public int getBit(int number, int position)
    {
        int bit;
        String binaryNum = Integer.toBinaryString(number);
        bit = Integer.parseInt(String.valueOf(binaryNum.charAt(binaryNum.length() - position - 1)));
        return bit;
    }
    public int setBit(int number, int position)
    {
        int bitMask = (1 << position);
        int result = number | bitMask;
        return result;
    }
    public int clearBit(int number, int position)
    {
        int bitMask = ~(1 << position);
        int result = number & bitMask;
        return result;
    }
    public int updateBit(int number, int position, boolean value)
    {
        int result;
        if ( value )
        {
            result = setBit(number, position);
        }
        else
        {
            result = clearBit(number, position);
        }
        return result;
    }
    public static void main(String[] args) {
        basicBitOperations x = new basicBitOperations();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number on which you want to operate");
        int number = sc.nextInt();
        System.out.println("Please enter the bit position on which you want to operate");
        int position = sc.nextInt();
        System.out.println("Select The Operation\n" +
                "1. getBit (returns bit value at the bit position specified)\n" +
                "2. setBit (sets the bit value at the bit position specified to 1)\n" +
                "3. clearBit (sets the bit value at the bit position specified to 0)\n" +
                "4. updateBit (sets the bit value at the bit position specified to desired value)");
        int operation = sc.nextInt();
        int operationResult;
        while ( (operation < 1) || (operation > 4) )
        {
            System.out.println("Invalid Input. Please Try Again");
            operation = sc.nextInt();
        }
        switch (operation)
        {
            case 1:
                operationResult = x.getBit(number, position);
                System.out.println("The bit at position " + position + " is: " + operationResult);
                break;
            case 2:
                operationResult = x.setBit(number, position);
                System.out.println("Your new number is: " + operationResult);
                break;
            case 3:
                operationResult = x.clearBit(number, position);
                System.out.println("Your new number is: " + operationResult);
                break;
            case 4:
                System.out.println("Please enter the bit value you want");
                int bitValue = sc.nextInt();
                while ( (bitValue > 1) || (bitValue < 0) )
                {
                    System.out.println("Invalid Input. Please Try Again");
                    bitValue = sc.nextInt();
                }
                boolean bitBoolean;
                if (bitValue == 1)
                {
                    bitBoolean = true;
                }
                else
                {
                    bitBoolean = false;
                }
                operationResult = x.updateBit(number, position, bitBoolean);
                System.out.println("Your new number is: " + operationResult);
                break;
        }
    }
}