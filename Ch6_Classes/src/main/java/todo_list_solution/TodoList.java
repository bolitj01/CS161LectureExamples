package todo_list_solution;

public class TodoList {
	
	private Todo[] todos;
	private int index;
	
	public TodoList() {
		todos = new Todo[100];
		index = 0;
    }
	
	public void addTodo(String description) {
		if (index < todos.length) {
			todos[index] = new Todo(description);
			index++;
		}
	}
	
	/**
	 * Complete a single todo in the todos 
	 * @param index which todo to complete (indexing from 1 for user-friendly)
	 */
	public void toggleComplete(int index) {
		index -= 1;
		if (index >= 0 && index < this.index) {			
			todos[index].toggleComplete();
		}
	}
	
	/**
	 * Display the % progress of completed items 
	 * in the TodoList
	 * @return "Progress: 0-100%"
	 */
	public String todoProgress() {
		double count = 0;
		for (int i = 0; i < todos.length; i++) {
			if (todos[i] != null && todos[i].isComplete()) {
				count++;
			}
		}
		return String.format("%.0f%%\n", count / index * 100);
	}
	
	/**
	 * A text representation of the Todo
	 * list with checkboxes
	 */
	public String toString() {
		String result = "Todo List:\n";
		for (int i = 0; i < todos.length; i++) {
			if (todos[i] != null) {
				if (todos[i].isComplete()) {
					result += "\u2714"; //Check mark symbol
				}
				else {
					result += "\u25EF"; //Circle symbol
				}
				result += " " + (i+1) + ":\t" + todos[i].getDescription() + "\n";
				result += "Progress: " + todoProgress();
			}
		}
		return result;
	}
}