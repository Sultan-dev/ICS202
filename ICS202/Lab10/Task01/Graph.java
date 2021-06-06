package com.company;

public class Graph {
    private boolean adjacencyMatrix[][];
    private int numberOfVertices;
    private String type;

    public Graph(int numberOfVertices, String type) {
        this.numberOfVertices = numberOfVertices;
        adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
        if (type.equals("directed")) {
            this.type = type;
        } else {
            this.type = type;
        }
    }

    public void addEdge(int i, int j) {
        if (type.equals("directed")) {
            adjacencyMatrix[i][j] = true;
        } else {
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (type.equals("directed")) {
            adjacencyMatrix[i][j] = false;
        } else {
            adjacencyMatrix[i][j] = false;
            adjacencyMatrix[j][i] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (type.equals("directed")) {
            if (adjacencyMatrix[i][j] == true) {
                return true;
            } else {
                return false;
            }
        } else {
            if (adjacencyMatrix[i][j] == true && adjacencyMatrix[j][i] == true) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void displayGraph() {
        System.out.printf("%10s", " ");
        for (int i = 0; i < numberOfVertices; i++)
            System.out.printf("%10s", i);
        System.out.println();
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.printf("%10s", i);
            for (int j = 0; j < numberOfVertices; j++) {
                System.out.printf("%10s", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }

    }
}

