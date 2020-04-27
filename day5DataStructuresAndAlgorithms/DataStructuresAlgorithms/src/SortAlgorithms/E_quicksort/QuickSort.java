package DataStructuresAlgorithms.src.SortAlgorithms.E_quicksort;

import java.util.Arrays;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/4/25 17:06
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={50,40,30,20,10,-10};
        fun(arr,0,arr.length-1);
    }

      public static void fun(int []arr,int left1,int right1){
        int left=left1;     //左下标
        int right=right1;    //右下标
        int tmp=0;
        //pivot 中轴值
        int pivot=arr[(left+right)/2];
        //while循环的目的是让比pivot值小放到左边
        //比pivot值大放到右边
        while (left<right){
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[left]<pivot){
                left+=1;
            }
            //在pivot的右边一直找，找到小于等于pivot的值，才退出
            while (arr[right]>pivot){
                right-=1;
            }
            //如果left>=right说明pivot的左右两的值，已经按照左边全部是
            //小于等于privot值，右边全部是大于等于pivot值
            if(left>=right){
                break;
            }
            //交换
            tmp=arr[left];
            arr[left]=arr[right];
            arr[right]=tmp;

            //如果交换完后，发现这个arr[left]==pivot值 相等r--,前移
            if(arr[left]==pivot){
                right-=1;
            }
            //如果交换完后，发现这个arr[r]==pivot值 相等left++，后移
            if(arr[right]==pivot){
                left+=1;
            }
        }
        //如果left==right,必须left++，right，否则出现栈溢出
        if(left==right){
            left+=1;
            right-=1;
        }
        //向左递归
        if(left<right){
            fun(arr,left,right);
        }
        //向右递归
        if(right>left){
            fun(arr,left1,right);
        }
        System.out.println(Arrays.toString(arr));
    }
}
