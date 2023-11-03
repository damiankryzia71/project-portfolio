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

import java.util.HashMap;
import java.util.Iterator;

/**
 * Class that implements a directed, wieghted graph.
 */
public class Digraph<T> implements GraphInterface<T>
{
    private HashMap<T, VertexInterface<T>> vertices;
    private int edgeCount;

    /**
     * Default constructor. Creates an empty graph.
     */
    public Digraph()
    {
        vertices = new HashMap<>();
        edgeCount = 0;
    }

    /**
    * Adds a vertex to the graph.
    * @param vertexLabel The label of the new vertex.
    * @return True if addition was successful, false otherwise.
    */
    public boolean addVertex(T vertexLabel)
    {
        if (vertices.containsKey(vertexLabel))
        {
            return false;
        }
        else
        {
            vertices.put(vertexLabel, new Vertex<>(vertexLabel));
            return true;
        }
    }

    /**
    * Adds a directed, weighted edge to the graph.
    * @param begin Beginning vertex.
    * @param end Ending vertex.
    * @param edgeWeight The weight of the edge.
    * @return True if addition was successful, false otherwise.
    */
    public boolean addEdge(T begin, T end, double edgeWeight)
    {
        boolean result = false;
        VertexInterface<T> startVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ((startVertex != null) && (endVertex != null))
        {
            result = startVertex.connect(endVertex, edgeWeight);
        }

        if (result)
            edgeCount++;
        
        return result;
    }

    /**
    * Adds a directed, unweighted edge to the graph.
    * @param begin Beginning vertex.
    * @param end Ending vertex.
    * @return True if addition was successful, false otherwise.
    */
    public boolean addEdge(T begin, T end)
    {
        return addEdge(begin, end, 0);
    }

    /**
    * Checks whether an edge between two vertices exists in the graph.
    * @param begin Beginning vertex.
    * @param end Ending vertex.
    * @return True if the edge exists, false otherwise.
    */
    public boolean hasEdge(T begin, T end)
    {
        boolean found = false;
        VertexInterface<T> startVertex = vertices.get(begin);
        VertexInterface<T> endVertex = vertices.get(end);

        if ((startVertex != null) && (endVertex != null))
        {
            Iterator<VertexInterface<T>> neighborIterator = startVertex.getNeighborIterator();
            while ((!found) && (neighborIterator.hasNext()))
            {
                if (neighborIterator.next().equals(endVertex))
                {
                    found = true;
                }
            }
        }

        return found;
    }

    /**
    * Checks whether the graph is empty.
    * @return True if the grapgh is empty, false otherwise.
    */
    public boolean isEmpty()
    {
        return vertices.isEmpty();
    }

    /**
    * Gets the number of vertices in the graph.
    * @return The number of vertices.
    */
    public int getNumberOfVertices()
    {
        return vertices.size();
    }

    /**
    * Gets the number of edges in teh graph.
    * @return The number of edges.
    */
    public int getNumberOfEdges()
    {
        return edgeCount;
    }

    /**
    * Clears the graph.
    */
    public void clear()
    {
        vertices.clear();
        edgeCount = 0;
    }

    /**
    * Creates a breadth-first traversal of the graph.
    * @param origin The origin vertex.
    * @return A queue of vertices in the breadth-first order.
    */
    public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        QueueInterface<T> traversal = new LinkedQueue<>();
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
        VertexInterface<T> originVertex = vertices.get(origin);

        resetVertices();
        originVertex.visit();
        traversal.enqueue(originVertex.getLabel());
        vertexQueue.enqueue(originVertex);

        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversal.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                }
            }
        }
        return traversal;
    }

    /**
    * Creates a depth-first traversal of the graph.
    * @param origin The origin vertex.
    * @return A queue of vertices in the depth-first order.
    */
    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        Stack<VertexInterface<T>> vertexStack = new LinkedStack<>();
        VertexInterface<T> originVertex = vertices.get(origin);

        resetVertices();
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexStack.push(originVertex);

        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            if (topVertex.getUnvisitedNeighbor() != null)
            {
                VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            else
            {
                vertexStack.pop();
            }
        }
        return traversalOrder;
    }

    /**
    * Creates a topological ordering of the graph.
    * @return A stack of vertices in the topological order.
    */
    public Stack<T> getTopologicalOrder()
    {
        Stack<T> vertexStack = new LinkedStack<>();
        int numberOfVertices = getNumberOfVertices();
        
        resetVertices();

        for (int i = 0; i < numberOfVertices; i++)
        {
            VertexInterface<T> nextVertex = pickNextVertex();
            nextVertex.visit();
            vertexStack.push(nextVertex.getLabel());
        }
        return vertexStack;
    }

    private VertexInterface<T> pickNextVertex()
    {
        boolean found = false;
        Iterator<T> vertexIterator = vertices.keySet().iterator();
        VertexInterface<T> nextVertex = null;

        while ((!found) && (vertexIterator.hasNext()))
        {
            nextVertex = vertices.get(vertexIterator.next());
            if ((!nextVertex.isVisited()) && (nextVertex.getUnvisitedNeighbor() == null))
            {
                found = true;
            }
        }
        
        return nextVertex;
    }

    /**
    * Finds the shortest path between two vertices in an unweighted graph.
    * @param begin Origin vertex.
    * @param end End vertex.
    * @param path A stack to hold vertices that represent the shortest path.
    * @return The number of edges in the shortest path.
    * @throws UnsupportedOperationException This operation is not supported for a weighted graph.
    */
    public int getShortestPath(T begin, T end, Stack<T> path)
    {
        throw new UnsupportedOperationException("Graph: getShortestPath(): Operation not supported.");
    }

    /**
    * Finds the cheapest path between two vertices in a weighted graph.
    * @param begin Origin vertex.
    * @param end End vertex.
    * @param path A stack to hold vertices that represent the cheapest path.
    * @return The total weight of the path.
    */
    public double getCheapestPath(T begin, T end, Stack<T> path)
    {
        boolean done = false;
        PriorityQueueInterface<EntryPQ> queue = new PriorityQueue<>();
        queue.add(new EntryPQ(begin, 0, null));
                    
        resetVertices();

        while ((!done) && (!queue.isEmpty()))
        {
            EntryPQ frontEntry = queue.remove();
            VertexInterface<T> frontVertex = vertices.get(frontEntry.label);

            if (!frontVertex.isVisited())
            {
                frontVertex.visit();
                frontVertex.setCost(frontEntry.cost);
                frontVertex.setPredecessor(frontEntry.predecessor);

                if (frontVertex.equals(vertices.get(end)))
                    done = true;
                else
                {
                    Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
                    Iterator<Double> edges = frontVertex.getWeightIterator();

                    while (neighbors.hasNext())
                    {
                        VertexInterface<T> nextNeighbor = neighbors.next();
                        double weightOfEdgeToNeighbor = edges.next();
                        
                        if (!nextNeighbor.isVisited())
                        {
                            double nextCost = weightOfEdgeToNeighbor + frontVertex.getCost();
                            queue.add(new EntryPQ(nextNeighbor.getLabel(), nextCost, frontVertex));
                        }
                    }
                }
            }
        }
        VertexInterface<T> endVertex = vertices.get(end);
        double pathCost = endVertex.getCost();
        path.push(endVertex.getLabel());
        VertexInterface<T> vertex = endVertex;
        while (vertex.hasPredecessor())
        {
            vertex = vertex.getPredecessor();
            path.push(vertex.getLabel());
        }
        return pathCost;
    }

    protected void resetVertices()
    {
        Iterator<T> vertexLabelIterator = vertices.keySet().iterator();

        while (vertexLabelIterator.hasNext())
        {
            VertexInterface<T> nextVertex = vertices.get(vertexLabelIterator.next());

            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        }
    }

    private class EntryPQ implements Comparable<EntryPQ>
    {
        private T label;
        private double cost;
        private VertexInterface<T> predecessor;

        private EntryPQ(T vertexLabel, double pathCost, VertexInterface<T> previousVertex)
        {
            label = vertexLabel;
            cost = pathCost;
            predecessor = previousVertex;
        }

        public int compareTo(EntryPQ entry)
        {
            if (cost == entry.cost)
            {
                return 0;
            }
            else if (cost < entry.cost)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }
}
