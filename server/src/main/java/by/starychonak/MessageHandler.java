package by.starychonak;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MessageHandler extends Thread {

    private final Socket clientSocket;
    private final ObjectMapper MAPPER = new ObjectMapper();

    public MessageHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String requestData = new String(buffer, 0, bytesRead);

            System.out.println("Получен запрос от клиента: " + requestData);

            Graph graph = MAPPER.readValue(requestData, Graph.class);
            String response = MAPPER.writeValueAsString(resolve(graph));

            outputStream.write(response.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения информации из запроса");
        }
    }

    private GraphSolution resolve(Graph graph) {
        int verticesNumber = graph.getGraph().length;

        MaxFlow maxFlow = new MaxFlow(verticesNumber, graph.getSource(), graph.getTarget(), new int[verticesNumber], graph.getGraph());
        int flow = maxFlow.resolve();
        return new GraphSolution(flow);
    }

}
