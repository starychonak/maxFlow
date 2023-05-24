package by.starychonak;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    private List<GraphDTO> graphList = new ArrayList<>();
    public static int[][] graph =
        {
            { 0, 3, 0, 0, 15, 0, 0, 0 },
            { 0, 0, 4, 7, 0, 2, 0, 9, },
            { 0, 0, 0, 5, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 15, 0, 0, },
            { 0, 0, 0, 0, 0, 10, 0, 4, },
            { 0, 0, 0, 0, 0, 0, 11, 11, },
            { 0, 0, 0, 0, 0, 0, 0, 3, },
            { 0, 0, 0, 0, 0, 0, 0, 0, }
        };

    public List<GraphDTO> getGraphList() {
        GraphDTO graph1 = new GraphDTO(graph, 1, 5);
        graphList.add(graph1);
        return graphList;
    }
}
