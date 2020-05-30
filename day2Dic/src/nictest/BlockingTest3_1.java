package nictest;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @City
 * @City
 */
//******************************************************************改程序存在错误
public class BlockingTest3_1 {
    //客户端
    @Test
    public void client(){
        SocketChannel sChannel= null;
        FileChannel inChannel= null;
        try {
            sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));

            inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

            ByteBuffer buf=ByteBuffer.allocate(10);

            while(inChannel.read(buf)!=-1){
              //  buf.flip();
             //   sChannel.write(buf);
                sChannel.write(buf.flip());
                buf.clear();
            }
           // sChannel.shutdownInput();
            //接受服务端反馈
            int len=0;
            while((len=sChannel.read(buf))!=-1){
                buf.flip();
                System.out.println(new String(buf.array(),0,len));
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(inChannel!=null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(sChannel!=null){
                try {
                    sChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server(){
        ServerSocketChannel ssChannel= null;
        FileChannel outChannel= null;
        SocketChannel sChannel= null;
        try {
            ssChannel = ServerSocketChannel.open();

            outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

            //ssChannel.bind(new InetSocketAddress(9898));
            ssChannel.bind(new InetSocketAddress(8888));

            sChannel = ssChannel.accept();

            ByteBuffer buf=ByteBuffer.allocate(1024);
            sChannel.shutdownInput();
            while(sChannel.read(buf)!=-1){
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
            //发送反馈到客户端
            buf.put("服务端接受数据成功".getBytes());
            buf.flip();
            sChannel.write(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sChannel!=null){
                try {
                    sChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outChannel!=null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
           if(ssChannel!=null){
               try {
                   ssChannel.close();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
        }
}
}
