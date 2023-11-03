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
 * Interface that represents a basic graph.
 */
public interface BasicGraphInterface<T>
{
    /**
     * Adds a vertex to the graph.
     * @param vertexLabel The label of the new vertex.
     * @return True if addition was successful, false otherwise.
     */
    public boolean addVertex(T vertexLabel);

    /**
     * Adds a directed, weighted edge to the graph.
     * @param begin Beginning vertex.
     * @param end Ending vertex.
     * @param edgeWeight The weight of the edge.
     * @return True if addition was successful, false otherwise.
     */
    public boolean addEdge(T begin, T end, double edgeWeight);

    /**
     * Adds a directed, unweighted edge to the graph.
     * @param begin Beginning vertex.
     * @param end Ending vertex.
     * @return True if addition was successful, false otherwise.
     */
    public boolean addEdge(T begin, T end);

    /**
     * Checks whether an edge between two vertices exists in the graph.
     * @param begin Beginning vertex.
     * @param end Ending vertex.
     * @return True if the edge exists, false otherwise.
     */
    public boolean hasEdge(T begin, T end);

    /**
     * Checks whether the graph is empty.
     * @return True if the grapgh is empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Gets the number of vertices in the graph.
     * @return The number of vertices.
     */
    public int getNumberOfVertices();

    /**
     * Gets the number of edges in teh graph.
     * @return The number of edges.
     */
    public int getNumberOfEdges();

    /**
     * Clears the graph.
     */
    public void clear();
}
