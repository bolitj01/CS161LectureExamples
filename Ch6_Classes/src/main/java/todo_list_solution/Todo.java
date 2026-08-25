package todo_list_solution;

public class Todo {

	private String description;
	private boolean complete;
	
	/**
	 * @param description
	 */
	public Todo(String description) {
		this.description = description;
		complete = false;
	}

	public String getDescription() {
		return description;
	}
	
	public boolean isComplete() {
		return complete;
	}
	
	public void toggleComplete() {
		complete = !complete;
	}
}
