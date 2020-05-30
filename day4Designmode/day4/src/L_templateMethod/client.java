package L_templateMethod;

/**
 * @City
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
    }
}
