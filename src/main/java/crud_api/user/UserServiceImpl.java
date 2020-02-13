package crud_api.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		Iterable<User> iterable = userRepository.findAll();
		List<User> users = new ArrayList<>();
		iterable.forEach(e -> users.add(e));

		return users;
	}

	@Override
	public User get(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(Integer id, User user) {
		return userRepository.save(user);
	}

	@Override
	public void delete(Integer id) {
		userRepository.delete(id);
	}
}
