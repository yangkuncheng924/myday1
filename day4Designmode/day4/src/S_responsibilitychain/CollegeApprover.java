package S_responsibilitychain;

/**
 * @City
 * @City
 */
public class CollegeApprover extends Approver {
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(purchaseRequest purchaseRequest1) {
        if(purchaseRequest1.getPrice()<=5000&&purchaseRequest1.getPrice()<=10000){
            System.out.println("请求编号id="+purchaseRequest1.getId()+"被"+this.name+"处理");
        }else {
            approver.processRequest(purchaseRequest1);
        }
    }
    }

