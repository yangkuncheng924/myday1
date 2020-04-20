package J_flyWeightPattern;

/**
 * @City
 * @City
 */
public class Client {
    public static void main(String[] args) {
        //创建工厂类
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        //以新闻
        WebSite webSite1 = webSiteFactory.getWebSiteCategory("新闻");
        webSite1.use(new User("tom"));
        //博客
        WebSite webSite2 = webSiteFactory.getWebSiteCategory("博客");
        webSite2.use(new User("jack"));

        WebSite webSite3 = webSiteFactory.getWebSiteCategory("博客");
        webSite3.use(new User("lim"));

        WebSite webSite4 = webSiteFactory.getWebSiteCategory("博客");
        webSite4.use(new User("hani"));

        System.out.println("网站的分类共："+webSiteFactory.getWebSiteCout());

    }
}
