package by.starychonak;

import java.util.Arrays;

public class Test {

    static int[][] graph = {
        {0, 7, 4, 9, 0, 2, 6, 0, 0, 0},
        {0, 0, 0, 5, 4, 0, 7, 0, 0, 0},
        {0, 0, 0, 0, 0, 8, 0, 9, 0, 0},
        {0, 0, 0, 0, 0, 0, 2, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 9, 0, 3, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
        {0, 0, 0, 0, 0, 3, 0, 0, 4, 6},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 8},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    int source = 1;
    int target = 0;

    public static void main(String[] args) {
        int path[] = new int[graph.length];
        MaxFlow maxFlow = new MaxFlow(graph.length, 0, 9, path, graph);
        int result = maxFlow.resolve();
        System.out.println(result);
        System.out.println(Arrays.toString(path));
    }
}
