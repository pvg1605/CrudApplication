package crud_api.user;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CRUDService<T> {

	List<T> getAll();
	
	ResponseEntity<User> get(Integer id);
	
	ResponseEntity<String> create(T entity);
	
	ResponseEntity<String> update(Integer id, T entity);
	
	void delete(Integer id);
}
