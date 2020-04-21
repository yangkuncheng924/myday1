package Q_memento1;

/**
 * @City
 * @City
 * 守护者对象，保存游戏角色的状态
 */
public class Caretaker {
    //如果只保存一次状态
    private Memento memento;
//    //保存多个
//    private ArrayList<Memento>mementlist;
//    //对于保存游戏角色多个状态
//    private HashMap<String,ArrayList<Memento>>mementMap;


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
