package O_iterator;

import java.util.Iterator;
import java.util.List;

/**
 * @City
 * @City
 */
public class InfoColleageIterator implements Iterator {

    List<Depatment>depatmentList;//信息工程学院是以List方式存放系
    int index=-1;//索引

    public InfoColleageIterator(List<Depatment> depatmentList) {
        this.depatmentList = depatmentList;
    }

    //判断list中还有没有下一个元素
    @Override
    public boolean hasNext() {
        if(index>=depatmentList.size()-1){
            return  false;
        }else {
            index+=1;
            return true;
        }

    }

    @Override
    public Object next() {
       return  depatmentList.get(index);
    }
    //remove方法空实现
    public  void remove(){

    }
}
