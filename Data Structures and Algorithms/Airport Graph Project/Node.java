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

public class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T dataPortion)
    {
        this(dataPortion, null);
    }

    public Node(T dataPortion, Node<T> nextNode)
    {
        data = dataPortion;
        next = nextNode;
    }

    public void setData(T dataPortion)
    {
        data = dataPortion;
    }

    public void setNext(Node<T> nextNode)
    {
        next = nextNode;
    }

    public T getData()
    {
        return data;
    }

    public Node<T> getNext()
    {
        return next;
    }
    
}