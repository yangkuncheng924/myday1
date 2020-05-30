package O_iterator;

import java.util.ArrayList;

/**
 * @City
 * @City
 */
public class Client {
    public static void main(String[] args) {
        //创建学院
        ArrayList<College> collegeList=new ArrayList<College>();
        
        ComputerCollege computerCollege=new ComputerCollege();
        InfoCollege infoCollege=new InfoCollege();
        
        collegeList.add(computerCollege);
        collegeList.add(infoCollege);

        OutputImpl output = new OutputImpl(collegeList);
        output.printCollege();
    }
}
