package I_facade;

/**
 * @City
 * @City
 */
public class Screen {
    private  static  Screen screen=new Screen();
    public  static  Screen getScreen(){
        return screen;
    }
    public  void up(){
        System.out.println("screen up");
    }
    public  void down(){
        System.out.println("screen down");
    }
    public void  play(){
        System.out.println("screen is playing");
    }
}
