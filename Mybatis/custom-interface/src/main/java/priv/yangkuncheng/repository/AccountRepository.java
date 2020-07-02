package priv.yangkuncheng.repository;

import org.apache.ibatis.annotations.Lang;
import priv.yangkuncheng.entity.Account;

import java.util.List;

public interface AccountRepository {
    public int save(Account account);
    public int update(Account account);
    public int deleteById(long id);
    public List<Account> findAll();
    public Account findById(long id);
    public Account findByName(String name);
    public Account findById2(Lang id);
    public Account findByNameAndAge(String name,int age);
    public int count();
    public Integer count2();
    public String findNameById(long id);
}
