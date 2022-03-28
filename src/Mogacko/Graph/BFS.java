package Mogacko.Graph;

public class BFS {
    public static void Bfs(Graph graph, int node) {
        Queue queue = new Queue();
        graph.visited[node] = 1;
        System.out.printf("%d ", node);
        queue.enqueue(node);

        while (!queue.is_empty()) {
            int v = queue.dequeue();

            for (int w = 0; w < graph.node_count; w++) {
                if (graph.graph[v][w] == 1 && graph.visited[w] == 0) {
                    graph.visited[w] = 1;
                    System.out.printf("%d ", w);
                    queue.enqueue(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Bfs(graph, 0);
    }
}
