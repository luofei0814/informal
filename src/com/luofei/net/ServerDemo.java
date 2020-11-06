package com.luofei.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(8888);
            System.out.println("创建服务器成功");
            Socket socket=serverSocket.accept();
            System.out.println("客户端接入成功");

            SendRunnable sendRunnable=new SendRunnable(socket,"小王");
            new  Thread(sendRunnable).start();

            AcceptRunnable acceptRunnable=new AcceptRunnable(socket);
            new  Thread(acceptRunnable).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
