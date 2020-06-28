package priv.yangkuncheng.injection;


import org.springframework.stereotype.Repository;

@Repository
public class UserdaoImpl implements Userdao {
    @Override
    public void save() {
        System.out.println("UserdaoImpl.save");
    }
}
