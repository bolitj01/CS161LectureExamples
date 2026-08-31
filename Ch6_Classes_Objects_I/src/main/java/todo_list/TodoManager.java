package todo_list;

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
			//TODO
		}
		
		System.out.println(todoList.toString());
		
		int completeIndex = 0;
		
		// Toggle a task by number
		while (completeIndex != -1) {
			//TODO
		}
		
		keyboard.close();
	}
}
