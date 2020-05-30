package F_bridging;

/**
 * @City
 * @City
 */
public class Clent {
    public static void main(String[] args) {

        UpRightPhone upRightPhone = new UpRightPhone(new XiaoMi());

        upRightPhone.open();
        upRightPhone.call();
        upRightPhone.close();

        Phone foldedPhone = new FoldedPhone(new XiaoMi());
        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();

        System.out.println("********************");

        Phone foldedPhone1 = new FoldedPhone(new Vivo());

        foldedPhone1.call();
        foldedPhone1.close();
        foldedPhone1.open();
    }
}
