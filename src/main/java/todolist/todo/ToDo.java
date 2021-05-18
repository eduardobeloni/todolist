package todolist.todo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ToDo {

	@Id
	private Integer id;
	private String name;
	private String description;
	private String summary;

	public ToDo() {
		
	}
	
	public ToDo(Integer id, String name, String description, String summary) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.summary = summary;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
