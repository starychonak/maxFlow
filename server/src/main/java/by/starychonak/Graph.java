package by.starychonak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Graph {
    public int[][] graph;
    public int source;
    public int sink;
}
