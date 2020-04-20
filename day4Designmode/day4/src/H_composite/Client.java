package H_composite;

/**
 * @City
 * @City
 */
public class Client {
    public static void main(String[] args) {
        //从大到小创建对象  学校
       OrganizationComponent organizationComponent=new University("清华大学", "好的大学");

       //创建学院
        OrganizationComponent organizationComponent1=new College("计算机学院", "计算机学院");
        OrganizationComponent organizationComponent2=new College("信息工程学院", "信息工程学院");

        //创建各个学院下面的系（专业）
        organizationComponent1.add(new Depatrment("软件工程", "软件工程不错"));
        organizationComponent1.add(new Depatrment("网络工程", "网络工程不错"));
        organizationComponent1.add(new Depatrment("计算机科学与技术", "计算机科学与技术不错"));

        organizationComponent2.add(new Depatrment("通信工程", "通信工程难学"));
        organizationComponent2.add(new Depatrment("信息工程", "信息工程简单"));
        organizationComponent2.add(new Depatrment("计算机原理", "计算机原理不错"));

        //加入进去
        organizationComponent.add(organizationComponent1);
        organizationComponent.add(organizationComponent2);
        //输出
        organizationComponent.print();

        System.out.println("=================================");
        //删除
        organizationComponent.remove(organizationComponent1);
        organizationComponent.remove(organizationComponent2);

        organizationComponent.print();

    }
}
