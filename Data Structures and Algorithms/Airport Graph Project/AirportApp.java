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

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class AirportApp
{
    public static void main(String[] args) throws IOException
    {
        File airportsFile = new File("airports.csv");
        File distancesFile = new File("distances.csv");
        Scanner airportsScanner = new Scanner(airportsFile);
        Scanner distancesScanner = new Scanner(distancesFile);
        HashMap<String, String> airportsMap = new HashMap<>();
        ArrayList<String[]> distancesList = new ArrayList<>();
        Digraph<String> airportsGraph = new Digraph<>();

        while (airportsScanner.hasNext())
        {
            String[] nextLine = airportsScanner.nextLine().split(",");
            String code = nextLine[0];
            String city = nextLine[1];
            String name = nextLine[2];
            String state = nextLine[3];

            airportsMap.put(code, city + ", " + name + ", " + state);
            airportsGraph.addVertex(code);
        }
        airportsScanner.close();

        while (distancesScanner.hasNext())
        {
            String[] nextLine = distancesScanner.nextLine().split(",");
            String code1 = nextLine[0];
            String code2 = nextLine[1];
            double distance = Double.parseDouble(nextLine[2]);

            airportsGraph.addEdge(code1, code2, distance);
            distancesList.add(nextLine);
        }
        distancesScanner.close();

        String command;
        boolean quit = false;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Airports v0.1 by D. Kryzia\n");

        do
        {
            System.out.print("Command? ");
            command = keyboard.nextLine();
            System.out.println();

            switch (command.split(" ")[0])
            {
                case "H":
                    System.out.println("Q Query the airport information by entering the airport code.");
                    System.out.println("D Find the minimum distance between two airports.");
                    System.out.println("I Add a connection between two airports.");
                    System.out.println("R Remove a connection between two airports.");
                    System.out.println("E Exit.\n");
                    break;

                case "Q":
                    String[] data = command.split(" ");
                    if (data.length == 1)
                    {
                        System.out.println("Invalid command format.");
                        System.out.println("Please enter command in the format: Q CODE CODE CODE...");
                    }
                    else
                    {
                        for (int i = 1; i < data.length; i++)
                        {
                            String code = data[i];
                            System.out.print(code + " - ");
                            
                            if (airportsMap.get(code) != null)
                            {
                                System.out.println(airportsMap.get(code));
                            }
                            else
                            {
                                System.out.println("Airport code unknown.");
                            }
                        }
                    }
                    System.out.println();
                    break;
                
                case "D":
                    data = command.split(" ");
                    if (data.length != 3)
                    {
                        System.out.println("Invalid command format.");
                        System.out.println("Please enter 2 airport codes to calculate the minimum distance.");
                    }
                    else
                    {
                        try
                        {
                            Stack<String> route = new LinkedStack<>();
                            double routeLength = airportsGraph.getCheapestPath(data[1], data[2], route);

                            if (routeLength == 0)
                            {
                                System.out.println("Airports not connected.");
                            }
                            else
                            {
                                System.out.println(airportsMap.get(data[1]) + " to " + airportsMap.get(data[2]) + " is " + routeLength + " through the route:");
                                while (!route.isEmpty())
                                {
                                    String code = route.pop();
                                    System.out.println(code + " - " + airportsMap.get(code));
                                }
                            }
                        }
                        catch (NullPointerException invalidAirportCodeException)
                        {
                            System.out.println("One or more of the airport codes entered are unknown.");
                        }
                    }
                    System.out.println();
                    break;

                case "I":
                    data = command.split(" ");
                    if (data.length != 4)
                    {
                        System.out.println("Invalid command format.");
                        System.out.println("Please enter command in the format: I CODE CODE DISTANCE");
                    }
                    else
                    {
                        if (airportsGraph.hasEdge(data[1], data[2]))
                        {
                            System.out.println("Airports already connected.");
                        }
                        else
                        {
                            try
                            {
                                airportsGraph.addEdge(data[1], data[2], Double.parseDouble(data[3]));
                                System.out.println(airportsMap.get(data[1]) + " to " + airportsMap.get(data[2]) + " with a distance of " + Double.parseDouble(data[3]) + " added.");
                            }
                            catch (NumberFormatException invalidDistanceFormat)
                            {
                                System.out.println("Invalid format of entered distance. Please enter the distance as a number.");
                            }
                        }
                    }
                    System.out.println();
                    break;
                
                case "R":
                    data = command.split(" ");
                    if (data.length != 3)
                    {
                        System.out.println("Invalid command format.");
                        System.out.println("Please enter command in the format: R CODE CODE");
                    }
                    else
                    {
                        if (!airportsGraph.hasEdge(data[1], data[2]))
                        {
                            System.out.println("Airports not connected.");
                        }
                        else
                        {
                            airportsGraph.clear();
                            Iterator<String> codeIterator = airportsMap.keySet().iterator();
                            while (codeIterator.hasNext())
                            {
                                airportsGraph.addVertex(codeIterator.next());
                            }
                            for (int i = 0; i < distancesList.size(); i++)
                            {
                                if ((!distancesList.get(i)[0].equals(data[1])) && (!distancesList.get(i)[1].equals(data[2])))
                                {
                                    airportsGraph.addEdge(distancesList.get(i)[0], distancesList.get(i)[1], Double.parseDouble(distancesList.get(i)[2]));
                                }
                            }
                            System.out.println("Connection between " + airportsMap.get(data[1]) + " and " + airportsMap.get(data[2]) + " removed.");
                        }
                    }
                    System.out.println();
                    break;

                case "E":
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid Command.\n");  
            }
        } while (!quit);

        keyboard.close();
    }
}
