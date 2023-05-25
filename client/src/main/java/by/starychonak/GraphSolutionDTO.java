package by.starychonak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphSolutionDTO {
    private int maxFlow;

    @Override
    public String toString() {
        return "максимальный поток = " + maxFlow;
    }
}
