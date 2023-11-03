//
//    Name:        Kryzia, Damian
//    Project:     2
//    Due:         10/07/2022
//    Course:      cs-2400-02-f22
//
//    Description: 
//                 This file is part of the Set ADT project and contains the main method 
//                 that tests all the methods of the generic LinkedSet class which implements
//                 the generic SetInterface interface.

public class SetTest {
    public static void main(String[] args)
    {
        SetInterface<Integer> A = new LinkedSet<>();
        SetInterface<Integer> B = new LinkedSet<>();
        SetInterface<Integer> union;

        System.out.println("Set ADT by D.Kryzia ");
        System.out.println();
        System.out.println("Testing of class LinkedSet:");
        System.out.println();
        System.out.println("Testing method union():");
        System.out.println();

        A.add(3);
        A.add(2);
        A.add(1);

        B.add(3);
        B.add(1);
        B.add(2);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        union = A.union(B);
        System.out.println("The union of sets A and B is: " + union.toString());
        System.out.println();

        A.clear();
        A.add(1);

        B.clear();
        B.add(2);
        B.add(1);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        union = A.union(B);
        System.out.println("The union of sets A and B is: " + union.toString());
        System.out.println();

        A.clear();
        A.add(3);
        A.add(2);
        A.add(1);

        B.clear();
        B.add(5);
        B.add(4);
        B.add(3);
        B.add(2);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        union = A.union(B);
        System.out.println("The union of sets A and B is: " + union.toString());
        System.out.println();

        A.clear();
        A.add(1);

        B.clear();
        B.add(3);
        B.add(2);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        union = A.union(B);
        System.out.println("The union of sets A and B is: " + union.toString());
        System.out.println();

        A.clear();
        
        B.clear();
        B.add(5);
        B.add(4);
        B.add(3);
        B.add(2);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        union = A.union(B);
        System.out.println("The union of sets A and B is: " + union.toString());
        System.out.println();

        System.out.println("Testing of method union() concluded.");
        System.out.println();

        System.out.println("Testing method equals():");
        System.out.println();

        A.clear();
        A.add(2);
        A.add(1);

        B.clear();
        B.add(2);
        B.add(1);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        System.out.println("Result: " + A.equals(B) + " - Sets are equal.");
        System.out.println();

        A.clear();
        A.add(3);
        A.add(2);
        A.add(1);

        B.clear();
        B.add(2);
        B.add(1);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        System.out.println("Result: " + A.equals(B) + " - Sets are not equal.");
        System.out.println();
        
        System.out.println("Testing of method equals() concluded.");
        System.out.println();

        System.out.println("Testing of method subset(): ");
        System.out.println();

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        System.out.println("Result 1: " + A.subset(B) + " - B is a subset of A.");
        System.out.println("Result 2: " + B.subset(A) + " - A is not a subset of B.");
        System.out.println();

        System.out.println("Testing of method subset() concluded.");
        System.out.println();

        System.out.println("The following tests are perform on the following sets: ");
        System.out.println("The method toString() is tested right now:");
        System.out.println();

        A.clear();
        B.clear();

        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);

        B.add(7);
        B.add(3);
        B.add(1);

        System.out.println("Set A: " + A.toString());
        System.out.println("Set B: " + B.toString());
        System.out.println();

        System.out.println("Testing method getCurrentSize():");
        System.out.println();
        System.out.println("Result for set A: " + A.getCurrentSize());
        System.out.println("Result for set B: " + B.getCurrentSize());
        System.out.println();

        System.out.println("Testing method isEmpty() and clear() on set A:");
        System.out.println();
        System.out.println("Result 1: " + A.isEmpty() + " - set " + A.toString() + " is not empty.");
        System.out.println("Clearing set A.");
        A.clear();
        System.out.println("Result 2: " + A.isEmpty() + " - set " + A.toString() + " is empty.");
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
        System.out.println();

        System.out.println("Testing method add() on set B:");
        System.out.println();
        System.out.println("Case 1: adding a new entry (10).");
        System.out.println("Result: " + B.add(10) + " - addition successful.");
        System.out.println("Set B: " + B.toString());
        System.out.println();
        System.out.println("Case 2: adding an existing entry (10, after previous addition).");
        System.out.println("Result: " + B.add(10) + " - addition failed.");
        System.out.println("Set B: " + B.toString());
        System.out.println();

        System.out.println("Testing method remove() on set B:");
        System.out.println();
        System.out.println("Case 1: removing the most recent entry using remove() with no arguments.");
        System.out.println("Result: " + B.remove() + " - removal successful.");
        System.out.println("Set B: " + B.toString());
        System.out.println();
        System.out.println("Case 2: removing a specific entry using remove() with an argument.");
        System.out.println("Result: " + B.remove(7) + " - removal of entry \"7\" successful.");
        System.out.println("Set B: " + B.toString());
        System.out.println();

        B.clear();
        B.add(7);
        B.add(3);
        B.add(1);

        System.out.println("Testing method contains() on set A: " + A.toString());
        System.out.println();
        System.out.println("Case 1: testing for an existing entry.");
        System.out.println("Result: " + A.contains(5) + " - Set A contains entry \"5\".");
        System.out.println();
        System.out.println("Case 2: testing for a non-existing entry.");
        System.out.println("Result: " + A.contains(11) + " - Set A doesn't contain entry \"11\".");
        System.out.println();

        System.out.println("Testing method toArray() on set A:");
        System.out.println();
        Object[] arrayA = A.toArray();
        System.out.println("Outputting the contents of array A:");
        System.out.print("[");
        System.out.print(arrayA[0]);
        for (int i = 1; i < arrayA.length; i++)
        {
            System.out.print(", " + arrayA[i]);
        }
        System.out.println("]");
        System.out.println();
        
        System.out.println("Testing of class LinkedSet is conculded.");
    }
}
