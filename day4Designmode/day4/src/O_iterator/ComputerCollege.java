package O_iterator;

import java.util.Iterator;

/**
 * @City
 * @City
 */
public class ComputerCollege    implements College {
    Depatment[] depatments;
    int numOfDepartment=0;//保存当前数组的对象个数

    public  ComputerCollege(){
        depatments=new Depatment[5];
        addDepartment("java", "java");
        addDepartment("C++", "C++");
        addDepartment("python", "python");
    }
    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Depatment depatment=new Depatment(name, desc);
        depatments[numOfDepartment]=depatment;
        numOfDepartment+=1;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(depatments);
    }
}
