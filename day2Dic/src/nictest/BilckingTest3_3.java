package nictest;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.net.InetSocketAddress;
import java.util.Date;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;
/*
 * @City
 * @City*************************************代码错误************************
 */
public class BilckingTest3_3 {

    @Test
    public  void  send() throws IOException {
        DatagramChannel dc=DatagramChannel.open();

        dc.configureBlocking(false);

        ByteBuffer buf=ByteBuffer.allocate(1024);

        Scanner scan=new Scanner(System.in);

        while(scan.hasNext()){
            String str=scan.next();
           // buf.put((new Data().toString()+":\n"+str).getBytes());
           // buf.put((new Data().toString()+":\n"+str).getBytes());
            buf.flip();
            dc.send(buf, new InetSocketAddress("127.0.0.1",9999));


        }



    }

    @Test
    public  void  receive (){

    }
}
