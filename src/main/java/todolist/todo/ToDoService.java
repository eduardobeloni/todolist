package todolist.todo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepository toDoRepository;

	public List<ToDo> getAllToDos() {
		List<ToDo> todos = new ArrayList<>();
		this.toDoRepository.findAll().forEach(todos::add);

		return todos;
	}
	
	public ToDo getToDo(Integer id) {
		Optional<ToDo> opt = this.toDoRepository.findById(id);
		if (!opt.isEmpty())
			return opt.get();

		return new ToDo();
	}

	public void createToDo(ToDo todo) {
		this.toDoRepository.save(todo);
	}

	public void updateToDo(Integer id, ToDo todo) {
		ToDo old = this.getToDo(id);
		if (old.getId() != null)
			this.toDoRepository.save(todo);
	}

	public void deleteToDo(Integer id) {
		ToDo old = this.getToDo(id);
		if (old.getId() != null)
			this.toDoRepository.deleteById(id);
	}
}
