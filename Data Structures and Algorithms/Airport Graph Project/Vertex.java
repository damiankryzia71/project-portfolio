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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class that represents a vertex in a graph.
 */
public class Vertex<T> implements VertexInterface<T>
{
   private T label;
   private ArrayList<Edge> edgeList;
   private boolean visited;
   private VertexInterface<T> previousVertex;
   private double cost;

   /**
    * The constructor creates a new vertex with a specified label.
    * @param vertexLabel The vertex label.
    */
   public Vertex(T vertexLabel)
   {
      label = vertexLabel;
      edgeList = new ArrayList<>();
      visited = false;
      previousVertex = null;
      cost = 0;
   }

   /**
   * Gets the label of the vertex.
   * @return The label of the vertex.
   */
   public T getLabel()
   {
      return label;
   }

   /**
   * Marks the vertex as visited.
   */
   public void visit()
   {
      visited = true;
   }

   /**
   * Marks the vertex as not visited.
   */
   public void unvisit()
   {
      visited = false;
   }

   /**
   * Checks whether the vertex is marked as visited.
   * @return True if marked as visited, false otherwise.
   */
   public boolean isVisited()
   {
      return visited;
   }

   /**
   * Creates a directed edge of a specified weight between the vertex and
   * another specified vertex.
   * @param endVertex The vertex to connect to.
   * @param edgeWeight The weight of the created edge.
   * @return True if connection was successful, false otherwise.
   */
   public boolean connect(VertexInterface<T> endVertex, double edgeWeight)
   {
      boolean unique = true;
      for (int i = 0; i < edgeList.size(); i++)
      {
         if (edgeList.get(i).getEndVertex().equals(endVertex))
         {
            unique = false;
         }
      }
      if (unique)
      {
         edgeList.add(new Edge(endVertex, edgeWeight));
      }

      return unique;
   }

   /**
   * Creates a directed, unweighted edge between the vertex and
   * another specified vertex.
   * @param endVertex The vertex to connect to.
   * @return True if connection was successful, false otehrwise.
   */
   public boolean connect(VertexInterface<T> endVertex)
   {
      return connect(endVertex, 0);
   }

   /**
   * Creates an Iterator object that iterates over the vertex's neighbors.
   * @return A new iterator.
   */
   public Iterator<VertexInterface<T>> getNeighborIterator()
   {
      return new NeighborIterator();
   }

   /**
   * Creates an Iterator object that iterates over the weight of the edges
   * to the vertex's neighbors.
   * @return A new iterator.
   */
   public Iterator<Double> getWeightIterator()
   {
      return new WeightIterator();
   }

   /**
   * Checks whether the vertex has neighbors.
   * @return True if the vertex has a neighbor, false otherwise.
   */
   public boolean hasNeighbor()
   {
      return (!edgeList.isEmpty());
   }

   /**
   * Gets the first unvisited neighbor of the vertex.
   * @return The first unvisited neighbor, or null if there are no unvisited neighbors.
   */
   public VertexInterface<T> getUnvisitedNeighbor()
   {
      boolean found = false;
      Iterator<VertexInterface<T>> iterator = getNeighborIterator();
      VertexInterface<T> unvisitedNeighbor = null;
      VertexInterface<T> nextNeighbor;

      while ((!found) && (iterator.hasNext()))
      {
         nextNeighbor = iterator.next();

         if (!nextNeighbor.isVisited())
         {
            found = true;
            unvisitedNeighbor = nextNeighbor;
         }
      }

      return unvisitedNeighbor;
   }

   /**
   * Sets the vertexs predecessor.
   * @param predecessor The specified vertex to become a predecessor of this vertex.
   */
   public void setPredecessor(VertexInterface<T> predecessor)
   {
      previousVertex = predecessor;
   }

   /**
   * Gets the vertex's predecessor.
   * @return The vertex's predecessor.
   */
   public VertexInterface<T> getPredecessor()
   {
      return previousVertex;
   }

   /**
   * Checks whether the vertex has a predecessor.
   * @return True if the vertex has a predecessor, false otherwise.
   */
   public boolean hasPredecessor()
   {
      return (previousVertex != null);
   }

   /**
   * Sets the cost of this vertex's path from the origin vertex.
   * @param newCost The new cost.
   */
   public void setCost(double newCost)
   {
      cost = newCost;
   }

   /**
   * Gets the cost of this vertex's path from the origin vertex.
   * @return The cost.
   */
   public double getCost()
   {
      return cost;
   }

   protected class Edge
   {
      private VertexInterface<T> vertex;
      private double weight;

      protected Edge(VertexInterface<T> endVertex, double edgeWeight)
      {
         vertex = endVertex;
         weight = edgeWeight;
      }

      protected Edge(VertexInterface<T> endVertex)
      {
         this(endVertex, 0);
      }

      protected VertexInterface<T> getEndVertex()
      {
         return vertex;
      }

      protected double getWeight()
      {
         return weight;
      }
   }
   
   private class NeighborIterator implements Iterator<VertexInterface<T>>
   {
      private VertexInterface<T> current;
      private int index;

      private NeighborIterator()
      {
         index = 0;
         try
         {
            current = edgeList.get(0).getEndVertex();
         }
         catch (IndexOutOfBoundsException e)
         {
            current = null;
         }
      }

      public boolean hasNext()
      {
         return (current != null);
      }

      public VertexInterface<T> next()
      {
         VertexInterface<T> next = current;
         index++;

         try
         {
            current = edgeList.get(index).getEndVertex();
         }
         catch (IndexOutOfBoundsException e)
         {
            current = null;
         }

         return next;
      }
   }

   private class WeightIterator implements Iterator<Double>
   {
      private Double current;
      private int index;

      private WeightIterator()
      {
         index = 0;
         try
         {
            current = edgeList.get(0).getWeight();
         }
         catch (IndexOutOfBoundsException e)
         {
            current = null;
         }
      }

      public boolean hasNext()
      {
         return (current != null);
      }

      public Double next()
      {
         Double next = current;
         index++;

         try
         {
            current = edgeList.get(index).getWeight();
         }
         catch (IndexOutOfBoundsException e)
         {
            current = null;
         }

         return next;
      }
   }
}  
