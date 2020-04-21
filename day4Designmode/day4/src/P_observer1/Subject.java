package P_observer1;

/**
 * @City
 * @City
 */
public interface Subject {
    public  void registerObserver(Observer o);
    public  void removeObserver(Observer o);
    public  void notifyObservers();
}
