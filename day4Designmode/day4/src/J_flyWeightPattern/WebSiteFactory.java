package J_flyWeightPattern;

import java.util.HashMap;

/**
 * @City
 * @City
 * 网站工厂类 根据需要返回压一个网站
 */
public class WebSiteFactory {

    //集合 充当池的作用
    private HashMap<String,ConcreteWebSite>pool=new HashMap<>();

    //根据网站的类型 返回一个网站 ，如果没有就创建一个网站 并放入池中 并且返回
    public  WebSite getWebSiteCategory(String tpye) {
        if (!pool.containsKey(tpye)) {
            //创建一个网站
            pool.put(tpye, new ConcreteWebSite(tpye));
    }
        return (WebSite) pool.get(tpye);
    }
    //获取网站分类的总数 池中有多少个网站类型
    public  int getWebSiteCout(){
        return pool.size();
    }
}
