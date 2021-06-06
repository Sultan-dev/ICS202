package com.company;

public class GraphDriver{
    public static void main(String[] args){

        Graph graph= new Graph(4, "undirected");

        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);

        // Display the graph before deleting edge 2---3
        System.out.println("Before deleting edge 2---3 the graph is: \n");
        graph.displayGraph();

        graph.removeEdge(2, 3);

        System.out.println("\nAfter deleting edge 2---3 the graph is: \n");
        graph.displayGraph();

    }
}
