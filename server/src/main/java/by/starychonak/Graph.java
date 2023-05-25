package by.starychonak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Graph {
    private int[][] graph;
    private int source;
    private int target;
}
