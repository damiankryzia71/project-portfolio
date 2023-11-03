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

import java.util.Iterator;

/**
 * Interface that represents a vertex in a graph.
 */
public interface VertexInterface<T>
{
    /**
     * Gets the label of the vertex.
     * @return The label of the vertex.
     */
    public T getLabel();

    /**
     * Marks the vertex as visited.
     */
    public void visit();

    /**
     * Marks the vertex as not visited.
     */
    public void unvisit();

    /**
     * Checks whether the vertex is marked as visited.
     * @return True if marked as visited, false otherwise.
     */
    public boolean isVisited();

    /**
     * Creates a directed edge of a specified weight between the vertex and
     * another specified vertex.
     * @param endVertex The vertex to connect to.
     * @param edgeWeight The weight of the created edge.
     * @return True if connection was successful, false otherwise.
     */
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight);

    /**
     * Creates a directed, unweighted edge between the vertex and
     * another specified vertex.
     * @param endVertex The vertex to connect to.
     * @return True if connection was successful, false otehrwise.
     */
    public boolean connect(VertexInterface<T> endVertex);

    /**
     * Creates an Iterator object that iterates over the vertex's neighbors.
     * @return A new iterator.
     */
    public Iterator<VertexInterface<T>> getNeighborIterator();

    /**
     * Creates an Iterator object that iterates over the weight of the edges
     * to the vertex's neighbors.
     * @return A new iterator.
     */
    public Iterator<Double> getWeightIterator();

    /**
     * Checks whether the vertex has neighbors.
     * @return True if the vertex has a neighbor, false otherwise.
     */
    public boolean hasNeighbor();

    /**
     * Gets the first unvisited neighbor of the vertex.
     * @return The first unvisited neighbor, or null if there are no unvisited neighbors.
     */
    public VertexInterface<T> getUnvisitedNeighbor();

    /**
     * Sets the vertexs predecessor.
     * @param predecessor The specified vertex to become a predecessor of this vertex.
     */
    public void setPredecessor(VertexInterface<T> predecessor);

    /**
     * Gets the vertex's predecessor.
     * @return The vertex's predecessor.
     */
    public VertexInterface<T> getPredecessor();

    /**
     * Checks whether the vertex has a predecessor.
     * @return True if the vertex has a predecessor, false otherwise.
     */
    public boolean hasPredecessor();

    /**
     * Sets the cost of this vertex's path from the origin vertex.
     * @param newCost The new cost.
     */
    public void setCost(double newCost);

    /**
     * Gets the cost of this vertex's path from the origin vertex.
     * @return The cost.
     */
    public double getCost();
}