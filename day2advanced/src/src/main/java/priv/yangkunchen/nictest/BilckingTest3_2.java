import org.junit.Test;

import java.util.Date;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;



import java.util.Iterator;


/**
 * @City
 *  1.使用NIO完成网络通信的三个核心
 *
 *  1.1 通道（Channel）：负责连接
 *        java.nio.channels.Channel 接口：
 *            |--SelectableChannel
 *               |--SocketChannel
 *               |--ServerSocketChannel
 *                |--DatagramChannel
 *
 *              |--Pipe.SinkChannel
 *              |--Pipe.SourceChannel
 *
 *   1.2 缓冲区（Buffer）：负责数据的存取
 *    1.3 选择区（selector）：是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 * @City
 */
public class BilckingTest3_2 {

    //客户端
    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("192.168.1.2",5200));

        //2.切换非阻塞模式
        sChannel.configureBlocking(false);

        //3.分配指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);

        //4.发送数据给服务端

        byte tmp=10;
        buf.put(tmp);
       buf.put(new Date().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        buf.clear();

        //5.关闭通道
        sChannel.close();
    }

    //服务端
    @Test
    public  void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel=ServerSocketChannel.open();

        //2.切换非阻塞模式
        ssChannel.configureBlocking(false);

        //3.绑定连接
        ssChannel.bind(new InetSocketAddress(5200));

        //4.获取选择器
        Selector selector=Selector.open();

        //5.将通道注册到选择器上，并且指定“监听接受事件”
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.轮询式的获取选择器上已经“准备就绪”的事件
        while(selector.select()>0){

            //7.获取当前选择器中所有注册的“选择键（已就绪事件）”
           Iterator<SelectionKey> it=selector.selectedKeys().iterator();

           while( it.hasNext()){
               //8.获取准备“就绪”的是事件
               SelectionKey sk=it.next();

               //9.判断具体是什么事件准备就绪
               if(sk.isAcceptable()) {
                   //10.若“接受就绪”，获取客户端连接
                   SocketChannel sChannel = ssChannel.accept();

                   //11.切换非阻塞模式
                   sChannel.configureBlocking(false);

                   //12.将该通道注册到选择器上
                   sChannel.register(selector, SelectionKey.OP_READ);
               }else if(sk.isAcceptable()){
                   //13.获取当前选择器上“读就绪”状态的通道
                   SocketChannel sChannel= (SocketChannel) sk.channel();

                   //14.读取数据
                   ByteBuffer buf=ByteBuffer.allocate(1024);

                   int len=0;
                   while ((len=sChannel.read(buf))>0){
                       buf.flip();
                       System.out.println(new String(buf.array(),0,len));
                       buf.clear();
                   }
               }
               //15.取消选择键Selectionkey
               it.remove();
            }
        }
    }
}
