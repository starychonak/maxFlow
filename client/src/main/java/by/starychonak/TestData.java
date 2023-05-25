package by.starychonak;
public class TestData {

    private static GraphDTO graphDTO;
    private static int[][] graph = {
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
    private static int source = 0;
    private static int target = 9;

    public static GraphDTO getGraph() {
        graphDTO = new GraphDTO(graph, source, target);
        return graphDTO;
    }
}
