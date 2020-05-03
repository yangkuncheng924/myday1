package src.Tree.D_Heapsort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @parameter
 *      堆排序
 * @effect
 * @return
 * @date 2020/4/27 22:27
 */
public class Heapsort {
    public static void main(String[] args) {
        //要求将数组进行升序排序
        int arr[]={4,6,8,5,9};
        heapSort(arr);
    }
    //编写一个堆排序的方法
    public static void  heapSort(int arr[]){
       System.out.println("堆排序！！");
       int temp=0;

        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length/2-1; i >=0 ; i--) {
            abjustHeap(arr, i, arr.length);
        }

        //将堆顶元素与末尾元素交换，将最大元素 沉到 数组末尾
        //重新调整结构使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个有序序列
        for (int i = arr.length-1; i >0 ; i--) {
            //交换
            temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            abjustHeap(arr, 0, i);
        }
        System.out.println( Arrays.toString(arr));
    }
    //将一个数组（二叉树），调整成一个大顶堆
    public static void abjustHeap(int arr[],int i,int lenght){
        int temp=arr[i];//先取出当前元素的值，保存在临时变量

        for(int k=i*2+1;k<lenght;k=k*2+1){
            if(k+1<lenght&&arr[k]<arr[k+1]){
                //说明左子节点的值小于右子节点的值
                k++;//k 指向右子节点
            }
            if(arr[k]>temp){
                //如果子节点大于父节点
                arr[i]=arr[k];//把大的值赋给当前节点
                i=k;    //i指向k，继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的数最大值，放在了最顶（局部）
        arr[i]=temp;//将temp的值放到调整后的位置
    }
}
