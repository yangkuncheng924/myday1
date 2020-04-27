package src.SortAlgorithms.B_select;


import org.junit.Test;

import java.util.Arrays;

/**
 * @parameter
 * @effect 选择排序算法
 * @return
 * @date 2020/4/25 13:16
 */
public class Selectsort{

    @Test
    public void test(){
        //算法 先简单-->复杂 优化
        int []arry={101,34,119,1};

        for (int j=0;j<arry.length-1; j++) {
            int minIndex = j;
            int min = arry[j];
            for (int i = j+ 1; i < arry.length; i++) {
                if (min > arry[i]) {    //说明假定的最小值，并不是最小
                    min = arry[i];    //重置min
                    minIndex = i;     //重置minIndex
                }
            }
            //将最小值 放在array[0]，交换
            if (minIndex != j) {
                arry[minIndex] = arry[j];
                arry[j] = min;
            }
            System.out.println("第"+(j+1)+"轮后");
            System.out.println(Arrays.toString(arry));
        }
    }
    @Test
    public void test2(){
        int []array={5,3,4,8,-1,2,3,9,6};
        for (int i = 0; i <array.length-1 ; i++) {
            int index=i;
            int min=array[i];
            for (int j =i+1; j <array.length; j++) {
                if(min>array[j]){
                    min=array[j];
                    index=j;
                }
            }
            if(index!=i){
                array[index]=array[i];
                array[i]=min;
            }
            System.out.println("第"+(i+1)+"轮后");
            System.out.println(Arrays.toString(array));

        }

    }
}
