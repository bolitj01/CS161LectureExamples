import java.util.ArrayList;
import java.util.Scanner;

class Practice {
    public static void main(String[] args) {
        System.out.println("Final grocery list status:" + groceryList());
    }

    public static ArrayList<String> groceryList(){
        ArrayList<String> groceries = new ArrayList<String>();
        Scanner kb = new Scanner(System.in);

        while (true){
            System.out.println("Enter a command:");
            String response = kb.nextLine();

            if (response.equals("done")){
                kb.close();
                return groceries;
            }

            String[] parts = response.split(" ");

            if (parts[0].equals("add")){
                if (parts.length == 3){ //Assume add with index
                    groceries.add(Integer.parseInt(parts[2]), parts[1]);
                }
                else if (parts.length == 2){ //Assume add with index
                    groceries.add(parts[1]);
                }
            }
            else if (parts[0].equals("remove")){
                groceries.remove(parts[1]);
            }

            System.out.println(groceries);
        }

        
    }
}