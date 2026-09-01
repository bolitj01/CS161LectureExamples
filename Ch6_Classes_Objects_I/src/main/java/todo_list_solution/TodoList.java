package todo_list_solution;

import java.util.ArrayList;

public class TodoList {
	
	private ArrayList<Todo> todos;
	
	public TodoList() {
		todos = new ArrayList<>();
	}
	
	public void addTodo(String description) {
		todos.add(new Todo(description));
	}
	
	/**
	 * Complete a single todo in the todos 
	 * @param index which todo to complete (indexing from 1 for user-friendly)
	 */
	public void toggleComplete(int index) {
		index -= 1;
		if (index >= 0 && index < todos.size()) {			
			todos.get(index).toggleComplete();
		}
	}
	
	/**
	 * Display the % progress of completed items 
	 * in the TodoList
	 * @return "Progress: 0-100%"
	 */
	public String todoProgress() {
		double count = 0;
		for (Todo todo : todos) {
			if (todo.isComplete()) {
				count++;
			}
		}
		return String.format("%.0f%%\n", count / todos.size() * 100);
	}
	
	/**
	 * A text representation of the Todo
	 * list with checkboxes
	 */
	public String toString() {
		String result = "Todo List:\n";
		for (int i = 0; i < todos.size(); i++) {
			Todo todo = todos.get(i);
			if (todo.isComplete()) {
				result += "\u2714"; //Check mark symbol
			}
			else {
				result += "\u25EF"; //Circle symbol
			}
			result += " " + (i+1) + ":\t" + todo.getDescription() + "\n";
			result += "Progress: " + todoProgress();
		}
		return result;
	}
}