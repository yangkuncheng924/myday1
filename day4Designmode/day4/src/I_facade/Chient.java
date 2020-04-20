package I_facade;

/**
 * @City
 * @City
 */
public class Chient {
    public static void main(String[] args) {
        //这里直接调用类方法 会很麻烦
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.pay();
        homeTheaterFacade.end();
    }
}
