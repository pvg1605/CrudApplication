package crud_api.user;

import java.util.List;

public interface CRUDService<T> {

	List<T> getAll();
	
	T get(Integer id);
	
	T create(T entity);
	
	T update(Integer id, T entity);
	
	void delete(Integer id);
}
