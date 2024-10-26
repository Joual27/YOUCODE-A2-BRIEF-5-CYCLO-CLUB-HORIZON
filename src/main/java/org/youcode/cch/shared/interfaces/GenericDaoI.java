package org.youcode.cch.shared.interfaces;

import java.util.List;
import java.util.Optional;

public interface GenericDaoI<T,ID> {
    T save(T entity);
    void update(T entity);
    List<T> findAll();
    Optional<T> findById(ID id);
    void delete(T entity);
    void deleteById(ID id);
}
