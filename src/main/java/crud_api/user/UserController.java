package crud_api.user;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	//private QueueHandler queueHandler;

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		//queueHandler.sendJob();
		return userService.getAll();
	}
	
	@Cacheable("CrudCache")
	@RequestMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id)  {
		
		System.out.println("cache failed");
		return userService.get(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public ResponseEntity<String> addUser(@Valid @RequestBody User user) {
		
		return userService.create(user);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public ResponseEntity<String> updateUser(@Valid @RequestBody User user, @PathVariable Integer id) {
		userService.get(id);
		return userService.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.delete(id);
	}
	
	
	
}
