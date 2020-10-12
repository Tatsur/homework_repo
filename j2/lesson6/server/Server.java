package ru.geekbrains.java.homework.j2.lesson6.server;

import ru.geekbrains.java.homework.j2.lesson6.client.Network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private DataOutputStream out;
    private DataInputStream in;
    private Socket clientSocket;
    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    private void start() {
        try {
            serverSocket = new ServerSocket(Network.getServerPort());
            System.out.println("Waiting for connection...");
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());

            out.writeUTF("Connected to server!");

            writeMessages();
            getMessageFromClient();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getMessageFromClient() throws IOException {
        Thread thread  = new Thread(()->
        {
            while (true) {
                try {
                    String message = in.readUTF();
                    System.out.println("Client message: " + message);
                    out.writeUTF("Server echo: " + message);
                    if (message.equals("/end")) {
                        out.writeUTF("Server closed");
                        break;
                    }
                } catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
                close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Server closed");
        });
        thread.start();
    }

    private void writeMessages() {
        Thread thread;
        thread = new Thread(()->
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
                try {
                    String message = bufferedReader.readLine();
                    out.writeUTF("Server: " + message);
                    System.out.println("message \""+message+"\" sent");

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("incorrect message");
                }
        });
        thread.setDaemon(true);
        thread.start();
    }
    private void close(){
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
            System.out.println("Shutdown");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
