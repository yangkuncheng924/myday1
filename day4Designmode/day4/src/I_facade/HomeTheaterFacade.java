package I_facade;

/**
 * @City
 * @City
 */
public class HomeTheaterFacade {
    private  DVDplayer dvDplayer;
    private  Popcorn popcorn;
    private  Projector projector;
    private  Screen screen;
    private  Stereo stereo;
    private  TheaterLight   theaterLight;

    public HomeTheaterFacade() {
        this.dvDplayer = DVDplayer.getInstance();
        this.popcorn = Popcorn.getPopcorn();
        this.projector =Projector.getProjector();
        this.screen = Screen.getScreen();
        this.stereo = Stereo.getStereo();
        this.theaterLight = TheaterLight.getTheaterLight();
    }
    public void ready(){
        dvDplayer.on();
        popcorn.on();
        projector.on();
        screen.down();
        stereo.on();
        theaterLight.on();
    }
    public  void pause(){
        dvDplayer.pause();
    }
    public  void pay(){
        dvDplayer.play();
    }
    public  void end(){
        dvDplayer.off();
        popcorn.off();
        projector.off();
        screen.up();
        stereo.off();
        theaterLight.off();
    }
}
