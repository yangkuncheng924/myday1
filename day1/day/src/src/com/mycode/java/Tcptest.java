package com.mycode.java;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @City
 * 实现tcp的网络编程
 * @City
 */
//客户端
public class Tcptest {
    @Test
    public void cilent(){
        Socket socket= null;
        OutputStream os= null;
        try {
            InetAddress inet=InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8899);
            os = socket.getOutputStream();
            os.write("你好 你xxx".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }



    }

    //服务端
    @Test
    public void server() {
        ServerSocket ss= null;
        Socket scoket = null;
        InputStream is = null;
        ByteArrayOutputStream boos= null;
        try {
            ss = new ServerSocket(8899);

            scoket = ss.accept();

            is = scoket.getInputStream();

//****************不建议此做法*********************
//        byte[] bytes = new byte[20];
//        int len=0;
//        while((len=is.read(bytes))!=-1){
//            String s = new String(bytes, 0, len);
//            System.out.print(s);
//        }

            boos = new ByteArrayOutputStream();
            byte[] bytes = new byte[5];
            int len=0;
            while((len=is.read(bytes))!=-1){
                boos.write(bytes, 0, len);
            }
            System.out.println(boos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(boos!=null) {
                try {
                    boos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        if(scoket!=null){
            try {
                scoket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(ss!=null){
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }
}
