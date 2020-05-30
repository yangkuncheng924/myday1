package I_facade;

/**
 * @City
 * @City
 */
public class Stereo {
    private  static  Stereo stereo=new Stereo();
    public  static  Stereo getStereo(){
        return  stereo;
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
