package O_iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @City
 * @City
 */
public class OutputImpl {

    //学院集合
    List<College> collegeList;

    public  OutputImpl(List<College> collegeList){
        this.collegeList=collegeList;
    }
    //遍历所有学院 然后调用printDepartment 输出各个学院的系
    public  void printCollege(){

        //从collegeList 取出所有学院，java中的List已经实现Iterator
        Iterator<College>iterator=collegeList.iterator();

        while (iterator.hasNext()){
            //取出一个学院
            College college=iterator.next();
            System.out.println("===="+college.getName()+"====");
            printDepartment(college.createIterator());          //得到对应的迭代器
        }
    }

    //输出学院输出 系
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Depatment d=(Depatment)iterator.next();
            System.out.println(d.getName());
        }

    }

}
