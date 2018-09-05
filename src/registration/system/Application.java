package registration.system;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		showMenu();

	}
	
	public static void showMenu() {
		User user = new User();
		
		System.out.println("What you want to do?");
		System.out.println("1. Add user");
		System.out.println("2. Delete user");
		System.out.println("3. Exit");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			user.addUser();
			showMenu();
			break;
		case 2:
			user.deleteUser();
			showMenu();
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Choose another option.");
			showMenu();
			break;
		}
	}

}
