package com.anqi.es;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 依赖
 *https://www.runoob.com/html/html5-websocket.html
 *https://www.runoob.com/java/net-serversocket-socket.html
 *
 */
 
public class Server {
   public static void main(String[] args) {
      try {
         ServerSocket ss = new ServerSocket(8888);

         while (true){
            System.out.println("启动服务器....");
            Socket s = ss.accept();
            System.out.println("客户端:"+s.getInetAddress().getLocalHost()+"已连接到服务器");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //读取客户端发送来的消息
            String mess = br.readLine();
            System.out.println("客户端："+mess);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(mess+"\n");
            bw.flush();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}