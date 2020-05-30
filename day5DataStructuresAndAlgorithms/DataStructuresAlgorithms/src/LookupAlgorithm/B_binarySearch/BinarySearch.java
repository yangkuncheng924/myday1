package LookupAlgorithm.B_binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @parameter
 * @effect 二分查找的前提是 该数组是有序的
 * @return
 * @date 2020/4/26 13:37
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1234};
        int resindex = binarySearch(arr, 0, arr.length-1, 1234);
        System.out.println(resindex);

        //存在多个元素 进行查找
        int arr1[] = {1, 8, 10, 89, 1000,1000,1000,1000,1234};
       List<Integer>list = binarySearch1(arr1, 0, arr1.length-1, 1000);
        System.out.println(list);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if(left>right){
            return -1;
        }
        int mid = (left + right) / 2;
        int minVal = arr[mid];
        if (findVal > minVal) {     //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < minVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }



    //存在多个元素 进行查找
    public static ArrayList<Integer> binarySearch1(int[] arr, int left, int right, int findVal) {
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int minVal = arr[mid];
        if (findVal > minVal) {     //向右递归
            return binarySearch1(arr, mid + 1, right, findVal);
        } else if (findVal < minVal) {
            return binarySearch1(arr, left, mid - 1, findVal);
        }else {
            ArrayList<Integer> integers = new ArrayList<>();
            int tmp=mid-1;
            while (true){
                if(tmp<0||arr[tmp]!=findVal){
                    //退出
                    break;
                }
                //否则，就tmp放入到集合中
                integers.add(tmp);
                //tmp左移
                tmp-=1;
            }
            integers.add(mid);


            //向右扫描
            tmp=mid+1;
            while (true){
                if(tmp>arr.length-1||arr[tmp]!=findVal){
                    //退出
                    break;
                }
                //否则，就tmp放入到集合中
                integers.add(tmp);
                //tmp左移
                tmp+=1;
            }
            return  integers;
        }
    }
}
