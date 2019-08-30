package com.sanshengshui.rpc.demo1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket1 {

    public static void main(String[] args) throws InterruptedException {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            Scanner scanner =new Scanner(System.in);
            if(scanner.hasNext()){
                String str = scanner.next();

                int type =1;
                byte[] data = str.getBytes();
                int len = data.length +5;

                dataOutputStream.writeByte(type);
                dataOutputStream.writeInt(len);
                dataOutputStream.write(data);
                dataOutputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
