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

/**
 * Interface that contains algorithms to be used by a directed graph.
 */
public interface GraphAlgorithmsInterface<T>
{
    /**
     * Creates a breadth-first traversal of the graph.
     * @param origin The origin vertex.
     * @return A queue of vertices in the breadth-first order.
     */
    public QueueInterface<T> getBreadthFirstTraversal(T origin);

    /**
     * Creates a depth-first traversal of the graph.
     * @param origin The origin vertex.
     * @return A queue of vertices in the depth-first order.
     */
    public QueueInterface<T> getDepthFirstTraversal(T origin);

    /**
     * Creates a topological ordering of the graph.
     * @return A stack of vertices in the topological order.
     */
    public Stack<T> getTopologicalOrder();

    /**
     * Finds the shortest path between two vertices in an unweighted graph.
     * @param begin Origin vertex.
     * @param end End vertex.
     * @param path A stack to hold vertices that represent the shortest path.
     * @return The number of edges in the shortest path.
     */
    public int getShortestPath(T begin, T end, Stack<T> path);

    /**
    * Finds the cheapest path between two vertices in a weighted graph.
    * @param begin Origin vertex.
    * @param end End vertex.
    * @param path A stack to hold vertices that represent the cheapest path.
    * @return The total weight of the path.
    */
    public double getCheapestPath(T begin, T end, Stack<T> path);
}
