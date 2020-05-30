package O_iterator;

import java.util.Iterator;

/**
 * @City
 * @City
 */
public class ComputerCollegeIterator implements Iterator {
    //这里我们需要Departments;
    Depatment[] departments;
    int position=0; //遍历的位置

    public ComputerCollegeIterator(Depatment[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position>=departments.length||departments[position]==null){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public Object next() {
     Depatment depatment=departments[position];
     position+=1;
        return depatment;
    }
    //删除的方法 默认空实现
    public  void remove(){

    }
}
