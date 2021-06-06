

import java.util.*;

// Determines if a vertex is reachable from another vertex in a directed graph
public class Graph {
    private List<List<Integer>> adjList = null;
    private int numVertices;

    public Graph(List<Edge> edges, int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the directed graph
        for (Edge edge : edges) {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
        }
    }

    public boolean isReachable(int src, int dest) {
        boolean[] visited = new boolean[numVertices];
        return isReachable(src, dest, visited);
    }

    // Function to perform BFS traversal from the source vertex in the graph to
    // determine if the destination vertex is reachable from the source or not
    private boolean isReachable(int src, int dest, boolean[] visited) {
        int el = 0;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src - 1] = true;

        while (!queue.isEmpty()) {
            el = queue.poll();
            if (dest == el) {
                return true;
            }

            for (int i = 0; i < adjList.get(el).size(); i++) {
                int adjVertex = adjList.get(el).get(i);
                if (visited[adjVertex] == false) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
        return false;
    }
}