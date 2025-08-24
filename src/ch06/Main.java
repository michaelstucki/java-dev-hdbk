package ch06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        System.out.print("Choose an option: ");
        int option;
        do {
            option = getOption(sc);
            switch (option) {
                case 1: // add task
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    manager.addTask(new Task(description));
                    break;
                case 2: // view tasks
                    manager.viewTasks();
                    break;
                case 3: // save tasks
                    manager.saveTasks();
                    break;
                case 4: // load tasks
                    manager.loadTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while(option != 5);
        sc.close();
     }

    private static int getOption(Scanner sc) {
        String MENU = "\n1. Add Task\n2. View Tasks\n3. Save Tasks\n4. Load Tasks\n5. Exit";
        boolean validOption = false;
        int option = 0;
        do {
            System.out.println(MENU);
            System.out.print("Enter option: ");
            try {
                option = Integer.parseInt(sc.nextLine());
                validOption = true;
            } catch (NumberFormatException e) {
                System.out.println("Non-integer entered");
            }
        } while (!validOption);
        return option;
    }
}
