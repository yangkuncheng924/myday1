package I_facade;

/**
 * @City
 * @City
 */
public class Projector {
    private  static Projector projector=new Projector();
    public  static Projector getProjector(){
        return projector;
    }
    public  void on(){
        System.out.println("projector on");
    }
    public  void off(){
        System.out.println("projector off");
    }
    public void  play(){
        System.out.println("projector is playing");
    }
}
