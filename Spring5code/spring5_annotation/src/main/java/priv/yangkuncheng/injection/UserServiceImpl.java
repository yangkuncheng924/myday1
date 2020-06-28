package priv.yangkuncheng.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private Userdao userdao;

    public Userdao getUserdao() {
        return userdao;
    }

    @Autowired
    public void setUserdao(Userdao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void register() {
        userdao.save();
    }
}
