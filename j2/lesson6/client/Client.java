package ru.geekbrains.java.homework.j2.lesson6.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {


    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Network network = client.networkConnect();
        client.writeMessages(network);
    }

    private Network networkConnect() {
        Network network = new Network();
        if(!network.connect()){
            showErrorMessage("Server connection failed");
        }
        network.waitMessages();
        return network;
    }

    private void writeMessages(Network network) {
        Thread thread = new Thread(()->
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
                try {
                    String message = bufferedReader.readLine();
                    network.getDataOutputStream().writeUTF(message);
                    if(message.equals("/end")) break;
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
    private static void showErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    };
    public static void sendMessage(String message){
        System.out.println(message);
    }
}
