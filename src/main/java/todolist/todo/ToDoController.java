package todolist.todo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

	@Autowired
	private ToDoService toDoService;

	@RequestMapping(method=RequestMethod.GET, value="/todos")
	public List<ToDo> getAllToDos() {
		return toDoService.getAllToDos();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/todos/{id}")
	public ToDo getToDo(@PathVariable Integer id) {
		return toDoService.getToDo(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/todos")
	public void createToDo(@RequestBody ToDo todo) {
		toDoService.createToDo(todo);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/todos/{id}")
	public void updateToDo(@PathVariable Integer id, @RequestBody ToDo todo) {
		toDoService.updateToDo(id, todo);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/todos/{id}")
	public void deleteToDo(@PathVariable Integer id) {
		toDoService.deleteToDo(id);
	}
}
