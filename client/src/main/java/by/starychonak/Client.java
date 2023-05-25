package by.starychonak;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread{

    private static String ipAddr = "127.0.0.1";
    private static int port = 4004;
    private final ObjectMapper MAPPER = new ObjectMapper();

    private String responseData;

    @Override
    public void run() {
        String message = convertGraphToString(TestData.getGraph());
        try (Socket socket = new Socket(ipAddr, port);
             OutputStream out = socket.getOutputStream();
             InputStream in = socket.getInputStream()) {

            out.write(message.getBytes());

            // Получаем ответ от сервера
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            responseData = new String(buffer, 0, bytesRead);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertGraphToString(GraphDTO graph) {
        try {
           return MAPPER.writeValueAsString(graph);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка преобразования графа в сроку", e);
        }
    }

    public void printResponse() {
        try {
            GraphSolutionDTO graphSolutionDTO = MAPPER.readValue(responseData, GraphSolutionDTO.class);
            System.out.println(graphSolutionDTO.toString());
        } catch (Exception e) {
            throw new RuntimeException("ОШибка конвертации json в обект", e);
        }
    }
}
