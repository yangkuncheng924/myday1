package com.mycode.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试FileImputStream和FileOutpuStream的使用
 * @City
 * @City
 */
public class FileImputOutputStreamTest {

    @Test
    public void testFileImputStream(){
        FileInputStream fis= null;
        try {
            //造文件
          //  File file=new File("C:\\JAVAIDEA\\src\\src\\com\\mycode\\java\\helloworld.txt");
            File file=new File("hello.txt");
            //输出流
            fis = new FileInputStream(file);

            //读数据
            byte[] buffer=new byte[5];
            int len=0;
            while((len=fis.read(buffer))!=-1){
                String str=new String(buffer,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
