package SortAlgorithms.A_bubbling;



import org.junit.Test;

import java.util.Arrays;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/4/25 10:12
 */
public class Bubbling {
    public static void main(String[] args) {


    }
    @Test
    public void test(){
        int arr[] = {3, 9, -1, 10, -2};
        int temp = 0;
        boolean flag=false;
        //冒泡排序:时间复杂度 O(n2)
        for (int j = 0; j < arr.length - 1; j++) {
            //第一趟排序，就是将最大的数排在后面
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag=true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if(!flag){
                break;
            } else{
                flag=false;
            }

            System.out.println("第" + (j + 1) + "一次排序");
            System.out.println(Arrays.toString(arr));
            System.out.println();
        }
    }
    @Test
    public void test1(){
        int[] array = {10, -2, 3, -1, 9, 4, 5};
     //   int[] array = {1,2,3,4,5,6,7,8,9};
        int tmp = 0;
        boolean flag=false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag=true;
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            if(!flag){          //-2 -1 3 4 5 9 10
                break;
            } else{
                flag=false;
            }
            System.out.printf("第%d次\n", i);
            System.out.println(Arrays.toString(array));
        }
    }
}





