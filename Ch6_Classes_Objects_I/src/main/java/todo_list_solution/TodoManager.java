package todo_list_solution;

import java.util.Scanner;

public class TodoManager {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		String response = "";
		
		System.out.println("""
				What do you need to do? 
				Enter one task per line.
				When you're done, type "done\"""");
		
		TodoList todoList = new TodoList();
		
		//Build Todo list one task at a time
		while (!response.equals("done")) {
			response = keyboard.nextLine();
			if (!response.equals("done")) {
				todoList.addTodo(response);
			}
		}
		
		System.out.println(todoList.toString());
		
		int completeIndex = 0;
		
		// Toggle a task by number
		while (completeIndex != -1) {
			System.out.println("Enter task # to toggle complete:");
			System.out.println("Enter -1 to exit");
			completeIndex = keyboard.nextInt();
			todoList.toggleComplete(completeIndex);
			System.out.println(todoList.toString());
		}
		
		keyboard.close();
	}
}
