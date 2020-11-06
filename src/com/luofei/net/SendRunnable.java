package com.luofei.net;

import java.io.*;
import java.net.Socket;

public class SendRunnable implements Runnable{
    private BufferedWriter writer;
    private BufferedReader reader;
    private String name;

    public SendRunnable(Socket socket,String name) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        reader=new BufferedReader(isr);
        OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
        writer=new BufferedWriter(osw);
        this.name=name;

    }

    @Override
    public void run() {
        String line=null;

            try {
                while (((line=reader.readLine())!=null)) {
                    writer.write(name+":"+line);
                    writer.newLine();
                    writer.flush();
                }
                writer.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


}
