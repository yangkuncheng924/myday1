package C_Prototype.Protorype_Improve1.ShallowCopyImproveOne;

import java.io.Serializable;

/**
 * @City
 * @City
 */
public class DeepCloneableTarget implements Serializable,Cloneable {
    private  static  final  long serialVersionUID=1L;

    private  String cloneName;

    private  String cloneClass;

       public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    @Override
    protected  Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
