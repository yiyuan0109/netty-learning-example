package com.sanshengshui.rpc.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        // 初始化服务端socket并且绑定9999端口           
        ServerSocket serverSocket = new ServerSocket(9999);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        while (true) {
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

        }
    }

}
