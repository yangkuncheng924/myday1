package DataStructuresAlgorithms.src.SortAlgorithms.G_Cardinal;

import java.util.Arrays;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/4/25 19:36
 */
public class Cardinal {
    public static void main(String[] args) {
        int arr[]={51,970,3,22,541,1,554,65};
        radixSort(arr);
    }
    //基数排序方法
    public static void radixSort(int[] arr){
        //1.得到数组中最大的数的位数
        int max=arr[0];    //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //得到的最大数是几位数
        int maxLength=(max+"").length();

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        /*说明
            1.二维数组包含10个一维数组
            2.为了防止在放入数的时候，数据溢出，则每一个数组（桶），大小定位arr.length
            3.明确：基数排序是使用空间换时间的经典算法
         */
        int[][] bucket=new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0],记录的就是bucket[0]桶的放入数据个数
        int[] bucketElementCounts=new int[10];

        for(int f=0,n=1;f<maxLength;f++,n*=10) {
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[i] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
                //按照这个桶的顺序（一维数组的下标依次取出数据，并放入到原来数组）
                int index = 0;
                //遍历每一个桶，并将桶中是数据，放入到原数组
                for (int j = 0; j < bucketElementCounts.length; j++) {
                    if (bucketElementCounts[j] != 0) {
                        //循环该桶即第j个桶（即第k个一维数组），放入
                        for (int k = 0; k < bucketElementCounts[j]; k++) {
                            //取出元素放入到arr
                            arr[index++] = bucket[j][k];
                        }
                    }
                    //第一轮处理后，需要将每个bucketElementCounts[k]=0!!!
                    bucketElementCounts[j] = 0;
                }
            }
            System.out.println((f+1)+""+Arrays.toString(arr));
        }
    }
}
