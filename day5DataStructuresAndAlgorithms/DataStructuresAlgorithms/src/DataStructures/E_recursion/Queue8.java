package DataStructures.E_recursion;

/**
 * @parameter 八皇后问题
 * @effect
 * @return
 * @date 2020/4/24 16:48
 */
public class Queue8 {
    //定义一个MAX表示共有多少个皇后
    int max=8;
    //定义数组array，保存皇后放置位置的结果，比如arr={0,4,7,5,2,6,1,3}
    int[]array=new int[max];
    //定义计数器
    static int cont=0;
    static int judegeCouunt=0;

    public static void main(String[] args) {
        //测试 ，8皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.cheak(0);
        System.out.printf("共写出%d解法",cont);
        System.out.printf("共判断冲突%d次数",judegeCouunt);

    }

    //编写一个方法 ，放置第n个皇后
    private void cheak(int n){
        if(n==max){ //如果n=8 说明8个皇后就已经放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i <max; i++) {
            //先把当前这个皇后n，放到该行的第1例
            array[n]=i;
            //判断当前放置第n个皇后到i例时，是否冲突
            if(judge(n)){
                //接着放n+1个皇后  开始递归
                cheak(n+1);
            }
            //如果冲突 就继续执行array[n]=i;
        }
    }


    //写一个方法，可以将皇后摆放的位置输出
    private void print(){
        cont++;
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    //查看我们防止第n个皇后，就去检测皇后是否和前面已经摆放的皇后冲突
    /***
     *  n 表示第n个皇后
     */
    private boolean judge(int n){
        judegeCouunt++;
        for (int i = 0; i <n; i++) {
            //说明
            //1.array[i]==array[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //2.
            if(array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

}
