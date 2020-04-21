package Q_memento;

import java.util.ArrayList;

/**
 * @City
 * @City
 */
public class Caretaker {
    private ArrayList<Memento>mementos=new ArrayList<Memento>();
    public  void add(Memento mement){
        mementos.add(mement);
    }

    //获取到第index个Originator的备忘录对象（即保存状态）
        public Memento get(int index){
        return mementos.get(index);
        }

}
