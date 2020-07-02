package priv.yangkuncheng.repository;

import priv.yangkuncheng.entity.Classes;

public interface ClassesRepository {
    public Classes findById(long id);
    public Classes findByIdLazy(long id);
}
