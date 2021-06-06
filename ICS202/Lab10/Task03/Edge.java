

public class Edge{
    public int source, dest;

    private Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    public static Edge getEdge(int a, int b) {
        return new Edge(a, b);        // calls private constructor
    }
}