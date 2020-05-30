package I_facade;

/**
 * @City
 *
 * @City
 */
public class DVDplayer {
    //使用单例模式
    private static  DVDplayer instance=new DVDplayer();

    public static  DVDplayer getInstance(){
        return instance;
    }
    public  void on(){
        System.out.println("DVD on");
    }
    public  void off(){
        System.out.println("DVD off");
    }
    public  void play(){
        System.out.println("DVD is playing");
    }
    public  void pause(){
        System.out.println("DVD pause");
    }
}
