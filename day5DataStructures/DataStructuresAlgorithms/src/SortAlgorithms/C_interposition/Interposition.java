package DataStructuresAlgorithms.src.SortAlgorithms.C_interposition;

import org.junit.Test;

import java.util.Arrays;

/**
 * @parameter
 * @effect 插入排序
 * @return
 * @date 2020/4/25 14:13
 */
public class Interposition {
    public static void main(String[] args) {
    }

    @Test
    public void test(){
        int []arr={101,34,119,1};
        for (int i = 1; i <arr.length ; i++) {
            //定义待插入的数
            int inserVal = arr[i];
            int insertIndex = i - 1; //即arr[1]的前面这个数的下标

            //给insertVal找到插入的位置
            //*
            // 1.insertIndex>=0保证再给insertVal找插入位置 不越界
            // 2.insertval<arr[insertIndex]待插入的数 还没有找到插入位置
            // 3.就需要将arr[insertIndex]后移
            // */
            while (insertIndex >= 0 && inserVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //当退出while循环时说明插入的位置找到 insertIndex+1
            arr[insertIndex + 1] = inserVal;            //这里是赋值，inserVal是34 而arr[insertInde+1] 因为insertIndex是--是-1加一以后是0
            System.out.println("第"+i+"轮插入后");
            System.out.println(Arrays.toString(arr));
        }


    }
             @Test
             public void test3(){
            int []arr={101,34,119,1,-1,5};
            int value=0;
            int index=0 ;
            for (int i = 0; i <arr.length ; i++) {
             value=arr[i];
             index=i-1;
             while(index>=0&&value<arr[index]){
                arr[index+1]=arr[index];
                index--;
            }
            arr[index+1]=value;
            System.out.println("第"+i+"轮插入后");
            System.out.println(Arrays.toString(arr));
        }
    }
}
