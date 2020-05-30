package com.yang;
import org.junit.Test;

public class HelloWorld {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
       int arr[]={10,5,6,78,91,35,67,8};
        for (int i:arr
             ) {
            System.out.print("数组"+i+" ");
        }
        System.out.println();
    }
}