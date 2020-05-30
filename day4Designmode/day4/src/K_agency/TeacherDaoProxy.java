package K_agency;

/**
 * @City
 * @City
 * 代理对象 静态代理
 */
public class TeacherDaoProxy implements IteacherDao {
    private  IteacherDao target; //目标对象 通过接口来聚合

    public TeacherDaoProxy(IteacherDao target) {
        this.target = target;
    }

    @Override
    public void teacj() {
        System.out.println("开始代理");
        target.teacj();
        System.out.println("结束代理");
    }
}
