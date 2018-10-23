package Lesson7;

public class MainGraph {
    public static void main(String[] args) {
        Graph g = new Graph(32);
        g.addVertex('A');
        g.addVertex('B');
        g.addVertex('C');
        g.addVertex('D');
        g.addVertex('E');
        g.addVertex('F');
        g.addVertex('G');
        g.addVertex('H');
        g.addVertex('I');
        g.addVertex('J');
        g.addEdge('A', 'B');
        g.addEdge('A', 'C');
        g.addEdge('A', 'D');
        g.addEdge('B', 'E');
        g.addEdge('B', 'H');
        g.addEdge('C', 'H');
        g.addEdge('D', 'F');
        g.addEdge('E', 'J');
        g.addEdge('H', 'I');
        g.addEdge('F', 'H');
        g.addEdge('F', 'G');
        g.addEdge('G', 'J');

        g.depthTravers();
        System.out.println();
        g.widthTravers();
        System.out.println();
        g.getDiffRoutes('A', 'H');
    }
}
