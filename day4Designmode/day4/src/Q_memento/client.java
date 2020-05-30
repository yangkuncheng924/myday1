package Q_memento;

/**
 * @City
 * @City
 */
public class client {
    public static void main(String[] args) {
        Originator originator=new Originator();
        Caretaker caretaker=new Caretaker();

        originator.setState("状态#1 攻击力100");

        //保存了当前的状态
        caretaker.add(originator.staveStateMemento());

        originator.setState("状态#2 攻击力80");

        caretaker.add(originator.staveStateMemento());

        originator.setState("状态#3 攻击力50");

        //希望恢复到状态1
        System.out.println("当前的状态是="+originator.getState());

        originator.getStateFromMemento(caretaker.get(0));
        System.out.println("当前的状态是="+originator.getState());


    }
}
