package CommonlyUsedAlgorithm.B_bivideAndConquerAlgorithm;

/**
 * @parameter
 * @effect
 * @return
 * @date 2020/5/5 18:05
 */
public class BivideAndConquerAlgorithm {
    public static void main(String[] args) {
        hanoitower(3,'A','B','C');
    }

    //汉诺塔的移动的方法
    //使用分治算法
    public static void hanoitower(int num,char a,char b,char c){
        //如果只有一个盘
        if(num==1){
            System.out.println("第一个盘从"+a+"->"+c);
        }else {
            //如果我们有n>=2情况，可以看做是两个盘 1.最下边的一个盘 2.上面的所有盘
            //1.先把最上面所有盘A->B,移动过程会使用C
            hanoitower(num-1, a, c, b);
            //2.把最下边的盘A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3.把B塔所有盘从B->C,移动过程使用到a塔
            hanoitower(num-1, b, a, c);
        }
    }
}
