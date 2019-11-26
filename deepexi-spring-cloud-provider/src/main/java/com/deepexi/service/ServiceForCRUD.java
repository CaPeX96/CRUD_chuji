package com.deepexi.service;

import java.util.List;

public interface ServiceForCRUD<T> {
    public int insert(T t);
    public boolean delete(T t);
    public boolean update(T t);
    public T get(int id);
    public List<T> list();
}
