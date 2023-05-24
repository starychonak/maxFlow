package by.starychonak;

import java.util.LinkedList;

public class MaxFlow {

    private int verticesNumber = 6;
    private int source;
    private int target;
    private int path[];
    private int graph[][];

    public MaxFlow(int verticesNumber, int source, int target, int[] path, int[][] graph) {
        this.verticesNumber = verticesNumber;
        this.source = source;
        this.target = target;
        this.path = path;
        this.graph = graph;
    }

    public int resolve() {
        int maxFlow = 0;
        while (findPath()) {
            int pathFlow = Integer.MAX_VALUE;

            for (int i = target; i != source; i = path[i]) {
                int j = path[i];
                pathFlow = Integer.min(pathFlow, graph[j][i]);
            }

            for (int i = target; i != source; i = path[i]) {
                int j = path[i];
                graph[j][i] -= pathFlow;
                graph[i][j] += pathFlow;
            }
            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    private boolean findPath() {
        boolean[] visited = new boolean[verticesNumber];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        path[source] = -1;
        
        while (queue.size() != 0) {
            int graphNode = queue.poll(); // номер вершины графа

            for (int i = 0; i < verticesNumber; i++) {
                if (!visited[i] && graph[graphNode][i] > 0) {
                    queue.add(i);
                    path[i] = graphNode;
                    visited[i] = true;
                }
            }
        }
        return visited[target];
    }
}
