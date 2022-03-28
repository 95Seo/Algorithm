package Mogacko.Graph;

public class Graph {
    int node_count = 7;
    int[] visited = {0, 0, 0, 0, 0, 0, 0};;
    int[][] graph = {
            {0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
    };
}
