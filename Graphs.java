import java.util.*;
public class Graphs {
    //Inner class to track edges:
    private class Edge{
        char src, dst;
        int weight;
    }

    //No. of vertices (nodes):
    private int vertices, edges;
    private int edgeCount;

    //Array to store all the edges:
    private Edge[] edge;


    //Constructor:
    public Graphs(int vertices, int edges){
        this.vertices = vertices;
        this.edges = edges;
        this.edgeCount = 0;
        //initialize the edge array:
        edge = new Edge[edges];
        for (int i = 0; i<edges; i++){
            //each element of the edge array is an object of edge type:
            edge[i] = new Edge();
        }
    }

    //method to add an edge to the graph:
    public void addEdge (char src, char dst, int weight){
        if(edgeCount < edges){
            edge[edgeCount].src = src;
            edge[edgeCount].dst = dst;
            edge[edgeCount].weight = weight;
            edgeCount++;

        }else{
            System.out.println("You cannot add any more edges, the static graph is full!");
        }
        if (edgeCount >= edges) {
            resizeEdgeArray();
        }
    }

    //Resizing the array once it's full to allow addition of vertices:
    private void resizeEdgeArray() {
        this.edges *= 2; //Doubling the size of the edge array.
        Edge[] newEdgeArray = new Edge[edges]; //Creating a new edge array with the new size.
        for (int i = 0; i < edgeCount; i++) {
            newEdgeArray[i] = edge[i]; //Copying the existing edges to the new array.
        }
        for (int i = edgeCount; i < edges; i++) {
            newEdgeArray[i] = new Edge();// Initializing the remaining elements in the new array.
        }
        this.edge = newEdgeArray; // Replacing the old edge array ith the new one.
        System.out.println("Edge array resized to " + this.edges);
    }

//Method to add a new vertex to the graph:
    public void addVertex() {
        this.vertices++;
        System.out.println("Vertex " + this.vertices + " added.");
    }
    public void printGraph(){
        for(int i = 0; i<edgeCount; i++){
            System.out.println(edge[i].src + " - " +edge[i].dst);
        }
    }

    //Checking for connection:
    public boolean edgeExists(char src, char dst){
        for (int i =0; i< edgeCount; i++ ){
            if(edge[i].src == src && edge[i].dst ==dst){
                return true;
            }
        }
        return false;
    }

    //A helper Method for the DFS:
    private void DFSHelper(char vertex, boolean[] visited){
        int index = vertex - 'A';
        visited[index] = true; //Marking the vertex as visited.
        System.out.println(vertex+ " "); //To print the visited vertex.

        //visit all the other adjacent vertices:
        for(int i = 0; i < edgeCount; i++){
            //Checking if the adjacent vertex is not visited:
            if(edge[i].src == vertex && !visited[edge[i].dst - 'A']){
                DFSHelper(edge[i].dst, visited);
            }
        }
    }

    //Method to do the actual DFS:
    public void DFS(char startVertex){
        boolean[] visited = new boolean[26]; //Keeping track of the visited vertices.
        System.out.println("Performing DFS starting from: " +startVertex);
        DFSHelper(startVertex, visited);
        System.out.println(" ");
    }

    //Helper method for DLS:
    private boolean DLSHelper(char vertex, char target, boolean[] visited, int depth){
        int index = vertex - 'A';
        if(depth == 0){
            return vertex == target; //Checking if the targeted vertex is reached.
        }
        visited[index] = true;
        //Visiting all the other adjacent vertices:
        for(int i = 0; i < edgeCount; i++){
            if (edge[i].src == vertex && !visited[edge[i].dst-'A']){
                if(DLSHelper(edge[i].dst, target, visited, depth - 1)){// Recursively visiting adjacent vertices with the reduced depth.
                    return true; //When the target vertex is found.
                }
            }
        }
        visited[index] = false; //Backtracking. Unmark the vertex as visited.
        return false; //When the target vertex is not found.
    }

    //Method for performing the actual DLS
    public boolean DLS(char startVertex, char targetVertex, int maxDepth){
        boolean[] visited = new boolean[26];
        return DLSHelper (startVertex, targetVertex, visited, maxDepth);
    }
    public static void main(String[] args) {
        int noVertices = 6;
        int noEdges = 9;
        Graphs g = new Graphs(noVertices, noEdges);

        g.addVertex();

        //Add edges:
        g.addEdge('A', 'B', 4);
        g.addEdge('A', 'C', 5);
        g.addEdge('A', 'D', 7);
        g.addEdge('B', 'D', 6);
        g.addEdge('B', 'E', 2);
        g.addEdge('C', 'D', 1);
        g.addEdge('C', 'E', 9);
        g.addEdge('D', 'E', 3);
        g.addEdge('C', 'F', 8);
        g.addEdge('F', 'G', 10);

        g.printGraph();
        System.out.println("Edge A - B exists: " +g.edgeExists('A', 'B'));
        g.DFS('A');
        System.out.println("Performing DLS with depth 2 from A to E: " +g.DLS('A', 'E', 2));
    }
}
