//
//      Name:       D.Kryzia
//      Project:    5
//      Due:        12/9/2022
//      Course:     cs-2400-02-f22
//  
//      Description:
//                  This project is the AirportApp that uses the Graph adt. Using a directed, weighted graph
//                  the user can operate on a graph where airports are vertices and routes between them are edges.
//                  The implementation uses other ADTs: Queue, PriorityQueue, Stack, List, and HashMap.
//

public interface PriorityQueueInterface<T extends Comparable<? super T>>
{
    public void add(T newEntry);
    public T remove();
    public T peek();
    public boolean isEmpty();
    public int getSize();
    public void clear();
}
