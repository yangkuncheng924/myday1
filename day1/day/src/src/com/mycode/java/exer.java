package com.mycode.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @City
 * @City
 */
public class exer {
    //图片的加密
    @Test
    public void test(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("rpg.jpg");
            fos = new FileOutputStream("rpg2.jpg");

            byte[] buffer=new byte[20];

            int len;

            while((len=fis.read(buffer))!=-1){
                //字节数组修改
                for(int i=0;i<len;i++){
                    buffer[i]=(byte)(buffer[i]^5);
                }
                fos.write(buffer,0,len);

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
                if(fos!=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }
    //图片的解密
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("rpg.jpg");
            fos = new FileOutputStream("rpg2.jpg");

            byte[] buffer=new byte[20];

            int len;

            while((len=fis.read(buffer))!=-1){
                //字节数组修改
                for(int i=0;i<len;i++){
                    buffer[i]=(byte)(buffer[i]^5);
                }
                fos.write(buffer,0,len);

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
                if(fos!=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
    }
}
