package todolist.todo;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

	private List<ToDo> todos = new ArrayList<>(
			Arrays.asList(
					new ToDo(1, "task1", "desc1", "summary1"),
					new ToDo(2, "task2", "desc2", "summary2"),
					new ToDo(3, "task3", "desc3", "summary3")
					)
			);
	
	public List<ToDo> getAllToDos() {
		return todos;
	}
	
	public ToDo getToDo(Integer id) {
		// Dangerous code: what if the id is not found?
		//return todos.stream().filter(t -> t.getId().equals(id)).findFirst().get();

		for (ToDo todo : todos) {
			if (todo.getId().equals(id))
				return todo;
		}

		return new ToDo();
	}

	public void createToDo(ToDo todo) {
		todos.add(todo);
	}

	public void updateToDo(Integer id, ToDo todo) {
		ToDo old = this.getToDo(id);
		if (old.getId() != null) {
			old.setName(todo.getName());
			old.setDescription(todo.getDescription());
			old.setSummary(todo.getSummary());
		}
	}

	public void deleteToDo(Integer id) {
		// Dangerous code: what if id is not found?
		//todos.removeIf(t -> t.getId().equals(id));
		ToDo dead = this.getToDo(id);
		if (dead.getId() != null) {
			this.todos.remove(dead);
		}
	}
}
