package com.sanshengshui.rpc.demo1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest1 {

    public static void main(String[] args) throws IOException {
        // 初始化服务端socket并且绑定9999端口           
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream =new DataInputStream(inputStream);

        while (true) {
            byte b = dataInputStream.readByte();

            int len = dataInputStream.readInt();

            byte[] data =new byte[len-5];

            dataInputStream.readFully(data);
            String str =new String(data);

            System.out.println("获取的数据类型为："+b);
            System.out.println("获取的数据长度为："+len);
            System.out.println("获取的数据内容为："+str);


        }


/*        while (true) {
            //等待客户端的连接 （阻塞）
            Socket socket = serverSocket.accept();

            executorService.execute(() ->{

                //获取输入流,并且指定统一的编码格式
                BufferedReader bufferedReader =null;
                try {
                    bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
                    String str = "";
                    while ((str = bufferedReader.readLine())!=null){
                        //输出打印
                        System.out.println(Thread.currentThread().getName() + "接受:  " + str);
                    }

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }*/
    }

}
