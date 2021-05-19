package todolist.hello;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

	private Map<Integer, String> users = new Hashtable<>();

	public List<User> getAllUsers() {
		List<User> data = new ArrayList<>();

		for (Integer k : this.users.keySet() ) {
			data.add(new User(k, this.users.get(k)));
		}

		return data;
	}

	public void addUser(User user) {
		if (!this.users.containsKey(user.getId())) {
			this.users.put(user.getId(), user.getName());
		}
	}

	public User getUser(Integer id) {
		if (this.users.containsKey(id)) {
			return new User(id, this.users.get(id));
		}

		return new User();
	}
}