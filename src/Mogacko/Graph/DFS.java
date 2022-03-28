package Mogacko.Graph;

public class DFS {
    public static void Dfs(Graph graph, int node) {
        System.out.printf("%d ", node);
        graph.visited[node] = 1;

        for (int i = 0; i < graph.node_count; i++) {
            if (graph.graph[node][i] == 1 && graph.visited[i] == 0)
                Dfs(graph, i);
        }
    }
    public static void main(String[] args)  {
        Graph graph = new Graph();
        Dfs(graph, 0);
    }
}
