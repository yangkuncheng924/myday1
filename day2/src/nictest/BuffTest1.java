package nictest;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @City
 * 1.缓冲区（buffer）：在java nio中负责数据的存取。缓冲区就是数组。用于储存不同数据类型的数据
 *
 *  根据数据类型不同（boolean 除外），提供了相应类型的缓冲区：
 *  ByteBuffer
 *  CharBuffer
 *  ShorBuffer
 *  IntBuffer
 *  LongBuffer
 *  FloatBuffer
 *  DoubleBuffer
 *
 *  上述缓冲区的管理方式几乎一致，通过allocate（） 获取缓冲区
 *
 * 2.缓冲区存取数据的两个核心方法：
 *  put（）：存入数据到缓冲区中
 *  get（）：获取缓冲区中的数据
 *
 * 3.缓冲区中的四个核心属性：
 *  capacity:容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 *  limit：  界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 *  position：位置，表示缓冲区中正在操作数据的位置。
 *
 *  mark:标记，表示记录当前position的位置 可以通过reset（）恢复到mark位置
 *
 *  0<=mark<=position<=limit<=capacity
 *
 * 4.直接缓冲区与非直接缓冲区：
 *  非直接缓冲区：通过allocate（）方法分配缓冲区，将缓冲区建立在JVM的内存中
 *   直接缓冲区：通过allocateDirect（）方法分配直接缓冲区，将缓冲区建立在物理内存中，可以提高效率
 * @City
 */
public class BuffTest1 {

        @Test
        public void test1(){

        String str = "abcde";
        //1.分配一个指定大小的缓冲区
        ByteBuffer buf=ByteBuffer.allocate(1024);
        System.out.println("----------allocate()-----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2.0
        //  put（）存入数据到缓冲区中
        buf.put(str.getBytes());
        System.out.println("----------put()-----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2.1 flip（）切换读取数据模式
        buf.flip();
        System.out.println("----------flip()-----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2.2 get（）利用读取缓冲区中的数据
        byte[] dst=new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("----------get()-----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2.3 rewind() 利用可重复读
        buf.rewind();
        System.out.println("----------rewind()-----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        //2.4 clear（） 清空缓冲区数据 但是缓冲区的数据依然存在 但是处于被“遗忘”状态
        buf.clear();
        System.out.println("----------clear()-----------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println((char)buf.get());
    }
    @Test
    public void test2()
    {
        String str = "abcde";

        ByteBuffer buf=ByteBuffer.allocate(1024);

        buf.put(str.getBytes());

        buf.flip();

        byte[] dst=new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println(buf.position());

        //mark（）： 标记
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println(buf.position());

        //reset(): 恢复到mark的位置
        buf.reset();
        System.out.println(buf.position());

        //hasRemaining():判断缓冲区中是否还有剩余数据
        if(buf.hasRemaining()){
            //获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());
        }
    }

    @Test
    public void test3()
    {
        //分配直接缓冲区-----------分配-----直接
        ByteBuffer buf=ByteBuffer.allocateDirect(1024);
        //判断是否为直接缓冲区
        System.out.println(buf.isDirect());

    }
}
