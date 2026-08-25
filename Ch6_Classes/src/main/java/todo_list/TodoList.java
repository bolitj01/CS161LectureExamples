package todo_list;

public class TodoList {

	private Todo[] todos;
	private int index;

	public TodoList() {
		todos = new Todo[100];
		index = 0;
	}

//	public void addTodo(String description) {
//		//TODO
//	}
//
//	/**
//	 * Complete a single todo in the todos
//	 * @param index which todo to complete (indexing from 1 for user-friendly)
//	 */
//	public void toggleComplete(int index) {
//		//TODO
//	}
//
//	/**
//	 * Display the % progress of completed items
//	 * in the TodoList
//	 * @return "Progress: 0-100%"
//	 */
//	public String todoProgress() {
//		//TODO
//	}
//
//	/**
//	 * A text representation of the Todo
//	 * list with checkboxes
//	 */
//	public String toString() {
//		//		"\u2714"; //Check mark symbol
//		//		"\u25EF"; //Circle symbol
//	}
}