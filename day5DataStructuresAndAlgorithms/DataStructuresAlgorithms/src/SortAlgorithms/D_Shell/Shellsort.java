package DataStructuresAlgorithms.src.SortAlgorithms.D_Shell;

import org.junit.Test;

import java.util.Arrays;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/4/25 15:53
 */
public class Shellsort {
    @Test
    public void test(){
        int[] arr={8,9,1,7,2,3,5,4,6,0,};
        int tmp=0;
        for (int gap=arr.length/2; gap>0;gap/=2) {
            //因为第一轮排序是将10个数据分成了五组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共gap组，每组有个元素），步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素 ，说明交换
                    if (arr[j] > arr[j + gap]) {
                        tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tmp;
                    }
                }
            }

        }
    }

    //对交换式的希尔排序进行优化->移位法
    @Test
    public void test1(){
        int[] arr={8,9,1,7,2,3,5,4,6,0,};
        for (int gap=arr.length/2; gap>0;gap/=2) {
        //从第gap个元素，逐个对其所在的组进行直接插入顺序
            for (int i = gap; i <arr.length ; i++) {
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j]=temp;
                }
            }
            System.out.println("希尔排序的结果是："+ Arrays.toString(arr));
        }
    }
}
