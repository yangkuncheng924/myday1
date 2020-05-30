package CommonlyUsedAlgorithm.C_dynamicPlanning;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/5/5 18:24
 */
public class DynamicPlanning {
    public static void main(String[] args) {
        int[] w={1,4,3};    //物品的重量
        int[] val={1500,3000,2000}; //物品的价值 这里val[i]
        int m=4;    //背包的容量
        int n=val.length;  //物品的个数

        //创建二维数组
        //v[i][j] 表示在前i个物品中能够装入容量为ij背包中的最大价值
        int[][] v=new int[n+1][m+1];
        //为了记录放入商品的情况 我创建一个二维数组
        int[][]path=new int[n+1][m+1];

        //初始化第一行和第一列，这里在本程序中，可以不去处理 因此默认就是0
        for (int i = 0; i <v.length ; i++) {
            v[i][0]=0;//将第一列设置为0
        }
        for (int i = 0; i <v[0].length ; i++) {
            v[0][i]=0;//将第一行设置为0
        }

        //根据公式来动态规划处理
        for (int i = 1; i <v.length ; i++) {    //不处理第一行 i是从1开始
            for (int j = 1; j <v[0].length ; j++) {//不处理第一例，j是从1开始
                //公司
                if(w[i-1]>j){
                    //因为程序i是从1开始 因此公式要是w[i-1]
                    v[i][j]=v[i-1][j];
                }else {
                  //  v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]] );
                    //为了记录商品存放到背包的情况 不能直接使用上面的公式，需要使用if else
                    if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        //把当前情况记录到path
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

        //遍历
        for (int i = 0; i <v.length ; i++) {
            for (int j = 0; j < v[i].length; j++) {

                    System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        //输出最后是放入到了那些商品
        //遍历path，这样的输出会把所有的放入情况都得到，其实只需要最后的放入
//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j <path[i].length ; j++) {
//                if(path[i][j]==1){
//                    System.out.println("第"+i+"个商品放入背包中");
//                }
//            }
//        }
        int i=path.length-1;//行的最大下标
        int j=path[0].length-1;//列的最大下标
        while (i>0&&j>0){
            //从path的最后开始找
            if(path[i][j]==1){
                System.out.println("第"+i+"个商品放入背包中");
                j-=w[i-1];
            }
            i--;
        }
    }
}
