package I_facade;

/**
 * @City
 * @City
 */
public class TheaterLight {
    private static TheaterLight theaterLight=new TheaterLight();
    public  static TheaterLight getTheaterLight(){
        return theaterLight;
    }

    public  void on(){
        System.out.println("theaterLight on");
    }
    public  void off(){
        System.out.println("theaterLight off");
    }
    public  void dim(){
        System.out.println("theaterLight dim");
    }
    public  void bright(){
        System.out.println("theaterLight bright");
    }
}
