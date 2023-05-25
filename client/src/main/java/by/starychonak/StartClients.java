package by.starychonak;

import java.util.ArrayList;
import java.util.List;

public class StartClients {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (long i = 0; i < 1; i++) {
            Thread thread = new Client();
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Thread thread : threads) {
            if (thread instanceof Client result) {
                result.printResponse();
            }
        }

    }
}