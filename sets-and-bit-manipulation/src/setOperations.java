import java.util.*;
import java.lang.*;

public class setOperations {

    public int[] parser(String sin)
    {
        String[] s = sin.split(",");
        int[] set = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
        {
            set = new int[]{};
        }
        else
        {
            for(int i = 0; i < s.length; i++)
            {
                set[i] = Integer.parseInt(s[i]);
            }
        }
        return set;
    }

    public int[] checkRepetition(int[] set)
    {
        int size = set.length;
        for (int i = 0; i < size; i++)
        {
            for (int j = i + 1; j < size; j++)
            {
                while ( (set[i] == set[j]) && (j < size) )
                {
                    for (int k = j; k < size - 1; k++)
                    {
                        set[k] = set[k + 1];
                    }
                    size--;
                }
            }
        }
        int[] updatedSet = new int[size];
        System.arraycopy(set, 0, updatedSet, 0, size);
        return updatedSet;
    }
    public boolean checkElements(int[] universe, int[] set)
    {
        boolean inUniverse = true;
        for (int i = 0; i < set.length; i++)
        {
            inUniverse = false;
            for (int j = 0; j < universe.length; j++)
            {
                if (set[i] == universe[j]) {
                    inUniverse = true;
                    break;
                }
            }
        }
        return inUniverse;
    }
    public int integerCreator(int[] universe, int[] set)
    {
        int setRepresentation = 0;
        int bitmask;
        for (int i = 0; i < set.length; i++)
        {
            for (int j = 0; j < universe.length; j++)
            {
                if (set[i] == universe[j])
                {
                    bitmask = (1 << (universe.length - j - 1));
                    setRepresentation = setRepresentation | bitmask;
                    break;
                }
            }
        }
        return setRepresentation;
    }

    public int union(int set1, int set2)
    {
        return (set1 | set2);
    }
    public int intersection(int set1, int set2)
    {
        return (set1 & set2);
    }
    public int complement(int preComplement, int universeNum)
    {
        return (preComplement ^ universeNum);
    }
    public int difference(int set1, int set2, int universeNum)
    {
        int notB = complement(set2, universeNum);
        return (set1 & notB);
    }
    public int cardinality(int setNum)
    {
        int onesCounter = 0;
        String binaryNum = Integer.toBinaryString(setNum);
        for (int i = 0; i < binaryNum.length(); i++)
        {
            if ( binaryNum.charAt(i) == '1' )
            {
                onesCounter++;
            }
        }
        return onesCounter;
    }
    public int[] converter (int setNum, int[] universe)
    {
        int setSize = cardinality(setNum);
        int[] set = new int[setSize];
        int filled = 0;
        int bitmask;
        for (int i = 0; i < universe.length; i++)
        {
            bitmask = (1 << i);
            if ( (setNum & bitmask) != 0 )
            {
                set[setSize - filled - 1] = universe[universe.length - i - 1];
                filled++;
            }
        }
        return set;
    }
    public void printSet(int[] set)
    {
        System.out.print("[");
        for (int i = 0; i < set.length; i++)
        {
            System.out.print(set[i]);
            if (i < set.length - 1)
            {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }
    public static void main(String[] args) {
        boolean errorFlag = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your universe");
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        setOperations x = new setOperations();
        int[] rawUniverse = x.parser(sin);
        int[] universe = x.checkRepetition(rawUniverse);
        int universeNum = x.integerCreator(universe, universe);
        System.out.println("Please enter the number of subsets you want");
        int numOfSets = sc.nextInt();
        while (numOfSets < 1) {
            System.out.println("Invalid Option. There must be at least 1 set.");
            numOfSets = sc.nextInt();
        }
        int[] sets = new int[numOfSets];
        for (int i = 0; i < numOfSets; i++)
        {
            System.out.println("Please enter set " + (i + 1) + " elements");
            String setString = sc.next().replaceAll("\\[|\\]", "");
            int[] rawSet = x.parser(setString);
            int[] set = x.checkRepetition(rawSet);
            if (x.checkElements(universe, set))
            {
                int setRepresentation = x.integerCreator(universe, set);
                sets[i] = setRepresentation;
            }
            else
            {
                System.out.println("Error");
                errorFlag = true;
                break;
            }
        }
        boolean tryAgain = true;
        if (!(errorFlag)) {
            while (tryAgain) {
                if (sets.length == 1)
                {
                    System.out.println("Select The Operation\n" +
                            "1. set complement\n" +
                            "2. set cardinality\n" +
                            "3. set print");
                    int operation = sc.nextInt();
                    while ((operation > 3) || (operation < 1)) {
                        System.out.println("Invalid Option. Please Try Again.");
                        operation = sc.nextInt();
                    }
                    switch (operation) {
                        case 1:
                            int postComplement = x.complement(sets[0], universeNum);
                            int[] complementedSet = x.converter(postComplement, universe);
                            System.out.print("The complement of your set is: ");
                            x.printSet(complementedSet);
                            break;
                        case 2:
                            int setCardinality = x.cardinality(sets[0]);
                            System.out.println("The cardinality of your set is: " + setCardinality);
                            break;
                        case 3:
                            int[] setToBePrinted = x.converter(sets[0], universe);
                            System.out.print("Your set is: ");
                            x.printSet(setToBePrinted);
                            break;
                    }
                    System.out.print("\n");
                    System.out.println("Do you want to try again?\n" +
                            "1. Yes\n" +
                            "2. No");
                    int choice = sc.nextInt();
                    while ((choice > 2) || (choice < 1)) {
                        System.out.println("Invalid Option. Please Try Again.");
                        choice = sc.nextInt();
                    }
                    if (choice == 2) {
                        System.out.println("Thank you for playing!");
                        tryAgain = false;
                    }
                }
                else {
                    System.out.println("Select The Operation\n" +
                            "1. union\n" +
                            "2. intersection\n" +
                            "3. set complement\n" +
                            "4. difference\n" +
                            "5. set cardinality\n" +
                            "6. set print");
                    int operation = sc.nextInt();
                    while ((operation > 6) || (operation < 1)) {
                        System.out.println("Invalid Option. Please Try Again.");
                        operation = sc.nextInt();
                    }
                    switch (operation) {
                        case 1:
                            System.out.println("Please select the first set");
                            int firstSet = sc.nextInt();
                            while ((firstSet > sets.length) || (firstSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                firstSet = sc.nextInt();
                            }
                            int set1 = sets[firstSet - 1];
                            System.out.println("Please select the second set");
                            int secondSet = sc.nextInt();
                            while ((secondSet > sets.length) || (secondSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                secondSet = sc.nextInt();
                            }
                            int set2 = sets[secondSet - 1];
                            int unionSetNum = x.union(set1, set2);
                            int[] unionSet = x.converter(unionSetNum, universe);
                            System.out.print("The union of your sets is: ");
                            x.printSet(unionSet);
                            break;
                        case 2:
                            System.out.println("Please select the first set");
                            firstSet = sc.nextInt();
                            while ((firstSet > sets.length) || (firstSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                firstSet = sc.nextInt();
                            }
                            set1 = sets[firstSet - 1];
                            System.out.println("Please select the second set");
                            secondSet = sc.nextInt();
                            while ((secondSet > sets.length) || (secondSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                secondSet = sc.nextInt();
                            }
                            set2 = sets[secondSet - 1];
                            int intersectionSetNum = x.intersection(set1, set2);
                            int[] intersectionSet = x.converter(intersectionSetNum, universe);
                            System.out.print("The intersection of your sets is: ");
                            x.printSet(intersectionSet);
                            break;
                        case 3:
                            System.out.println("Please select your set");
                            int selectedSet = sc.nextInt();
                            while ((selectedSet > sets.length) || (selectedSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                selectedSet = sc.nextInt();
                            }
                            int preComplement = sets[selectedSet - 1];
                            int postComplement = x.complement(preComplement, universeNum);
                            int[] complementedSet = x.converter(postComplement, universe);
                            System.out.print("The complement of your set is: ");
                            x.printSet(complementedSet);
                            break;
                        case 4:
                            System.out.println("Please select the first set");
                            firstSet = sc.nextInt();
                            while ((firstSet > sets.length) || (firstSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                firstSet = sc.nextInt();
                            }
                            set1 = sets[firstSet - 1];
                            System.out.println("Please select the second set");
                            secondSet = sc.nextInt();
                            while ((secondSet > sets.length) || (secondSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                secondSet = sc.nextInt();
                            }
                            set2 = sets[secondSet - 1];
                            int differenceSetNum = x.difference(set1, set2, universeNum);
                            int[] differenceSet = x.converter(differenceSetNum, universe);
                            System.out.print("The difference between your sets is: ");
                            x.printSet(differenceSet);
                            break;
                        case 5:
                            System.out.println("Please select your set");
                            selectedSet = sc.nextInt();
                            while ((selectedSet > sets.length) || (selectedSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                selectedSet = sc.nextInt();
                            }
                            int preOperation = sets[selectedSet - 1];
                            int setCardinality = x.cardinality(preOperation);
                            System.out.println("The cardinality of your set is: " + setCardinality);
                            break;
                        case 6:
                            System.out.println("Please select your set");
                            selectedSet = sc.nextInt();
                            while ((selectedSet > sets.length) || (selectedSet < 1)) {
                                System.out.println("Invalid Input. Please Try Again");
                                selectedSet = sc.nextInt();
                            }
                            int toBePrinted = sets[selectedSet - 1];
                            int[] setToBePrinted = x.converter(toBePrinted, universe);
                            System.out.print("Your set is: ");
                            x.printSet(setToBePrinted);
                            break;
                    }
                    System.out.print("\n");
                    System.out.println("Do you want to try again?\n" +
                            "1. Yes\n" +
                            "2. No");
                    int choice = sc.nextInt();
                    while ((choice > 2) || (choice < 1)) {
                        System.out.println("Invalid Option. Please Try Again.");
                        choice = sc.nextInt();
                    }
                    if (choice == 2) {
                        System.out.println("Thank you for playing!");
                        tryAgain = false;
                    }
                }
            }
        }
    }
}