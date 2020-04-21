package S_responsibilitychain;

/**
 * @City
 * @City
 */
public class DepartmentApprover extends Approver {
    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(purchaseRequest purchaseRequest1) {
        if(purchaseRequest1.getPrice()<=5000){
            System.out.println("请求编号id="+purchaseRequest1.getId()+"被"+this.name+"处理");
        }else {
            approver.processRequest(purchaseRequest1);
        }
    }
}
