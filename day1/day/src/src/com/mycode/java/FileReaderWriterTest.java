package com.mycode.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @City
 * @City
 */
public class FileReaderWriterTest {


    @Test
    public void text1() throws IOException {
        //1.实例化file对象
        File file = new File("C:\\JAVAIDEA\\src\\src\\com\\mycode\\java\\hello.txt");
        //将hello 文件里的内容输入到程序并且输出到控制台

        //2.提供具体的流
        FileReader reaa= new FileReader(file);

        //3.数据的读入过程
        int data=reaa.read();

        //4.看看文件有没有东西
        while(data!=-1){
            System.out.print((char)data);
            data=reaa.read();
        }

        //流必须关闭手动关闭
        reaa.close();


    }

    //对read（）操作升级 使用read重载方法
    @Test
    public void test2()  {
        FileReader FR= null;
        try {
            ///1 file类的实例化
            File file=new File("C:\\JAVAIDEA\\src\\src\\com\\mycode\\java\\hello.txt");
            //2fileReader流的实例化
            FR = new FileReader(file);
            //3读入的操作
            char[] cbuf=new char[5];
            int len=0;
            System.out.println();
            while((len=FR.read(cbuf))!=-1){
                for(int i=0;i<len;i++){
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(FR!=null){
                //4资源的关闭
                try {
                    FR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    从内存中写入数据硬盘的文件
     */
    @Test
    public void text3() throws IOException {
        //提供写入文件的id路径
        File file=new File("C:\\JAVAIDEA\\src\\src\\com\\mycode\\java\\hello1.txt");
        //提供Filewriter的对象   用于数据的写入
        FileWriter FW=new FileWriter(file, true);
        //写出的操作
        FW.write("nmsl\n");
        FW.write("you is sima");
        //关闭的操作
        FW.close();
    }

    //进行一个集合 文件写入 文件输出
    @Test
    public void WriterReadTest(){
        FileWriter fr= null;
        FileReader fw= null;
        try {
            //1创建一个file文件 写出路径
            File file=new File("C:\\JAVAIDEA\\src\\src\\com\\mycode\\java\\hello1.txt");
            File Mirror =new File("C:\\JAVAIDEA\\src\\src\\com\\mycode\\java\\hello1.txt");

            //2创建输入流和输出流
            fr = new FileWriter(file);
            fw = new FileReader(Mirror);

            //3进行写入和读出
            char[] cbuff=new char[5];
            int len=0;//用于记录cbuff写入的个数
            while((len=fw.read(cbuff))!=-1){
                //每次写出len的个数
                fr.write(cbuff,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭文件
            try {
                if(fw!=null)
                fw.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            try{
                if(fr!=null)
                    fr.close();
              }catch (IOException e){
                e.printStackTrace();
            }
        }


    }
}

