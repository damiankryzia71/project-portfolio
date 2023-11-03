//
// Name:        Kryzia, Damian
// Homework:    #1
// Due:         09/26/2022
// Course:      cs-2400-02-f22
//
// Description:
//              Contains the main method. Uses an external .txt file in order to
//              test all functions of the ArrayBag class which implements the BagInterface interface.
//
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JavaKeywords {
    
    public static void main (String[] args) throws IOException
    {

        // Checks the contents of the bag using javakeywords.txt

        File keywords = new File("javakeywords.txt");
        Scanner fileReader = new Scanner(keywords);
        BagInterface<String> bag = new ArrayBag<>(100);
        Object[] bagArray;
        boolean successfullyRemoved;

        System.out.println("Java Keywords by D. Kryzia\n");

        while (fileReader.hasNext())
        {
            bag.add(fileReader.nextLine());
        }

        System.out.println(bag.getCurrentSize() + " Java keywords loaded.\n");

        for (String element : args)
        {
            if (bag.contains(element))
                System.out.println(element + " is a keyword");
            else
                System.out.println(element + " is not a keyword");
        }

        fileReader.close();

        // All ArrayBag methods not used above are tested here:

        System.out.println("\nTesting method isEmpty():");

        if (bag.isEmpty())
            System.out.println("Bag is empty.");
        else
            System.out.println("Bag is not empty.");

        if (!bag.isEmpty())
        {
            System.out.println("\nTesting method remove(): ");
            System.out.println("\"" + bag.remove() + "\"" + " has been removed from the bag.");
        }

        System.out.println("\nTesting method remove(T anEntry) with argument \"for\": ");

        successfullyRemoved = bag.remove("for");

        if (successfullyRemoved)
            System.out.println("Successfully removed the keyword \"for\".");
        else
            System.out.println("Keyword not found.");

        System.out.println("\nTesting method remove(T anEntry) with argument \"total\": ");

        successfullyRemoved = bag.remove("total");

        if (successfullyRemoved)
            System.out.println("Successfully removed the keyword \"for\"");
        else
            System.out.println("Keyword not found.");
        
        System.out.println("\nTesting method getFrequencyOf(T anEntry) with an argument \"while\":");

        System.out.println(bag.getFrequencyOf("while") + " instance(s) of the keyword \"while\" are in the bag.");

        System.out.println("\nTesting method toArray():");

        bagArray = bag.toArray();
        
        System.out.print("{");
        
        for (int index = 0; index < bagArray.length - 1; index++)
        {
            System.out.print(bagArray[index].toString() + ", ");
        }

        System.out.println(bagArray[bagArray.length - 1] + "}");

        System.out.println("\nTesting method clear():");

        bag.clear();

        System.out.println("Bag has been cleared.");
    }

}
