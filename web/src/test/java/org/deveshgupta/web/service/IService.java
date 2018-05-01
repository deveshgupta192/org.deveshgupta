package org.deveshgupta.web.service;

import java.util.List;

public interface IService<T> {

	public List<T> getAll();

	public T getById(Long id);

	public T create(T t);

	public T update(Long id, T t);

	public void delete(T t);

	public void deleteById(Long id);

}
