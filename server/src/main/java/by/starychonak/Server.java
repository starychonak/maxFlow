package by.starychonak;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 4004;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT, 15, InetAddress.getByName(null))) {
            System.out.println("Сервер запущен. Ожидание подключений...");
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Подключение принято: " + clientSocket.getInetAddress());

                Thread thread = new MessageHandler(clientSocket);
                thread.start();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}
