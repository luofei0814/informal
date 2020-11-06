package com.luofei.net;

import java.io.IOException;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("172.20.10.3",8888);
            AcceptRunnable acceptRunnable=new AcceptRunnable(socket);
            new Thread(acceptRunnable);

            SendRunnable sendRunnable=new SendRunnable(socket,"小刘");
            new Thread(sendRunnable).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
