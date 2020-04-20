package O_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @City
 * @City
 */
public class InfoCollege implements College {

    List<Depatment>depatmentList;

    public  InfoCollege(){
        depatmentList=new ArrayList<Depatment>();
        addDepartment("信息安全专业", "信息安全专业");
        addDepartment("网络安全专业", "网络安全专业");
        addDepartment("服务器安全专业", "服务器安全专业");
            }
    @Override
    public String getName() {
        return "信息工程学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Depatment depatment=new Depatment(name, desc);
        depatmentList.add(depatment);
    }

    @Override
    public Iterator createIterator() {
        return new InfoColleageIterator(depatmentList);
    }
}
