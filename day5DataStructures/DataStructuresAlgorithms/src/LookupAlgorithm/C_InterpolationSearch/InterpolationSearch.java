package DataStructuresAlgorithms.src.LookupAlgorithm.C_InterpolationSearch;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @parameter
 * @effect 线性查找
 * @return
 * @date 2020/4/26 15:20
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i <100 ; i++) {
            arr[i]=i+1;
        }
        int index=insertValueSearch(arr, 0, arr.length-1,1);
        System.out.println(index);
      //  System.out.println(Arrays.toString(arr));
    }

    public static int insertValueSearch(int[] arr,int left,int right,int findVal){
        if(left>right||findVal<arr[0]||findVal>arr[arr.length-1]){
            return  -1;
        }

        //求出mid
        int mid=left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midval=arr[mid];
        if(findVal>midval){
            //说明应该向右边递归
            return insertValueSearch(arr, mid+1, right, findVal);
        }else if(findVal<midval){
            //说明应该向左边递归
            return insertValueSearch(arr, left, mid-1, findVal);
        }else {
            return mid;
        }
    }
}
