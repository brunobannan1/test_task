package org.nick.org.nick.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> find(Integer id);
    void save(T model);
    void update(T model);
    void delete(Integer id);

    List<T> findAll();
}
