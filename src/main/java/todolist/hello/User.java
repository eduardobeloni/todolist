package todolist.hello;

public class User {

	private Integer id;
	private String name;

	User(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	User() {
		this.id = -1;
		this.name = "_Unknown_";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
