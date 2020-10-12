package ru.geekbrains.java.homework.j2.lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Network {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8189;

    private final String host;
    private final int port;

    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;

    public Network() {
        this(SERVER_ADDRESS,SERVER_PORT);
    }

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public static int getServerPort() {
        return SERVER_PORT;
    }

    public boolean connect(){
        try {
            System.out.println("wait until the server starts...");
            while(true)
            {
                try
                {
                    socket = new Socket(host, port);
                    break;
                }
                catch(ConnectException e)
                {
                    System.out.println("Connect failed, waiting and trying again...");
                    try
                    {
                        Thread.sleep(2000);
                    }
                    catch(InterruptedException ie){
                        ie.printStackTrace();
                    }
                }
            }
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void close(){
        try {
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }
    public void waitMessages(){
        Thread thread = new Thread(()->{
           while (true){
               try {
                       String message = dataInputStream.readUTF();
                       Client.sendMessage(message);
               } catch (IOException | NullPointerException e) {
                   System.out.println("Connection lost");
                   close();
                   e.printStackTrace();
                   break;
               }
           }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
