package by.starychonak;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class MessageHandler extends Thread {

    private Socket clientSocket;

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

            String responseData = "Ответ на ваш запрос";
            outputStream.write(responseData.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения информации из запроса");
        }
    }

}
