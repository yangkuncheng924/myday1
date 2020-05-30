package S_responsibilitychain;

/**
 * @City
 * @City
 */
public class Client {
    public static void main(String[] args) {
        //创建一个请求
        purchaseRequest purchaseRequest = new purchaseRequest(1, 31000, 1);
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover  viceSchoolMasterApprover= new ViceSchoolMasterApprover("副校长");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("正校长");

        //需要将各个审批级别的下一个设置好（处理人构成环形：）
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);

        schoolMasterApprover.processRequest(purchaseRequest);
    }
}
