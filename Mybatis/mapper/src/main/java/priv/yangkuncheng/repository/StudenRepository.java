package priv.yangkuncheng.repository;

import priv.yangkuncheng.entity.Student;

public interface StudenRepository {
    public Student findById(int id);
    public Student findByIdLazy(long id);
}
