package S_responsibilitychain;

/**
 * @City
 * @City
 */
public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(purchaseRequest purchaseRequest1) {
        if(purchaseRequest1.getPrice()>30000){
            System.out.println("请求编号id="+purchaseRequest1.getId()+"被"+this.name+"处理");
        }else {
            approver.processRequest(purchaseRequest1);
        }
    }
}
