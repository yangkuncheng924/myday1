package priv.yangkunchen.reflect;

import java.util.HashMap;
import java.util.List;

public class Reflection extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        Class aClass = Class.forName("priv.yangkunchen.reflect.Reflect");
        System.out.println("aClass = " + aClass);

    }

}

/*/
 反射
 */
class Reflect {
    private Reflect reflect1;
    private String name;
    private Integer id;
    private List<Reflect> reflectList;
    private HashMap<String,Integer> reflectHashMap;

    @Override
    public String toString() {
        return "Reflect{" +
                "reflect1=" + reflect1 +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", reflectList=" + reflectList +
                ", reflectHashMap=" + reflectHashMap +
                '}';
    }

    public Reflect getReflect1() {
        return reflect1;
    }

    public void setReflect1(Reflect reflect1) {
        this.reflect1 = reflect1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Reflect> getReflectList() {
        return reflectList;
    }

    public void setReflectList(List<Reflect> reflectList) {
        this.reflectList = reflectList;
    }

    public HashMap<String, Integer> getReflectHashMap() {
        return reflectHashMap;
    }

    public void setReflectHashMap(HashMap<String, Integer> reflectHashMap) {
        this.reflectHashMap = reflectHashMap;
    }

    public Reflect() {
    }

    public Reflect(Reflect reflect1, String name, Integer id, List<Reflect> reflectList, HashMap<String, Integer> reflectHashMap) {
        this.reflect1 = reflect1;
        this.name = name;
        this.id = id;
        this.reflectList = reflectList;
        this.reflectHashMap = reflectHashMap;
    }
}