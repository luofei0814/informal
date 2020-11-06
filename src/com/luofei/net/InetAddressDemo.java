package com.luofei.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress=InetAddress.getLocalHost();
            System.out.println("主机的IP："+inetAddress.getHostAddress());
            System.out.println("主机名："+inetAddress.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
