package todolist.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello, mate!";
	}

	@RequestMapping(method=RequestMethod.GET, value="/hello/{id}",
		produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public User getUser(@PathVariable Integer id) {
		return helloService.getUser(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/hello/add")
	public void addUser(@RequestParam Integer id, @RequestParam String name) {
		helloService.addUser(new User(id, name));
	}

	@RequestMapping(method=RequestMethod.GET, value="/hello/list",
		produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<User> displayUsers() {
		return helloService.getAllUsers();
	}
}
