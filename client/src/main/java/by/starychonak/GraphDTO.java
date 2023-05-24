package by.starychonak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphDTO {
    public int[][] graph;
    public int source;
    public int sink;
}
