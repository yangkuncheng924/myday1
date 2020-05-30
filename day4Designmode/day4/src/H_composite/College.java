package H_composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @City
 * @City
 */
public class College extends OrganizationComponent{
    List<OrganizationComponent> organizationComponentList=new ArrayList<OrganizationComponent>();

    public College(String name, String des) {
        super(name, des);
    }

    //重写add
    @Override
    protected void add(OrganizationComponent organizationComponent) {

        organizationComponentList.add(organizationComponent);
    }

    //重写remove

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
       // organizationComponent.remove(organizationComponent);
        organizationComponentList.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void print() {
        System.out.println("++++++"+getName()+"+++++++");

        //遍历
        for (OrganizationComponent organizationComponent:organizationComponentList) {
            organizationComponent.print();
        }
    }
}
