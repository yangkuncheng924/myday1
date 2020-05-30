package L_templateMethod1;

/**
 * @City
 * 对L_templateMethod进行改进 使用钩子方法
 * @City
 */
public class client {
    public static void main(String[] args) {
        //制作红豆豆浆
        System.out.println("-------制作红豆豆浆");
        SoyaMilk radBeanSoyaMilk = new RadBeanSoyaMilk();
        radBeanSoyaMilk.make();

        //制作花生豆浆
        System.out.println("--------制作花生豆浆");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();

        //制作纯豆浆
        System.out.println("--------制作纯豆浆");
        SoyaMilk  pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
}
