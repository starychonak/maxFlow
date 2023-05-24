package by.starychonak;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread{

    private static String ipAddr = "127.0.0.1";
    private static int port = 4004;

    private String responseData;

    @Override
    public void run() {
        try (Socket socket = new Socket(ipAddr, port);
             OutputStream out = socket.getOutputStream();
             InputStream in = socket.getInputStream()) {

            out.write("Привет сервер!".getBytes());

            // Получаем ответ от сервера
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            responseData = new String(buffer, 0, bytesRead);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResponseData() {
        return responseData;
    }
}
