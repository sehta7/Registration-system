package registration.system.menu;

import java.io.IOException;
import java.util.Scanner;

import registration.system.service.UserService;

public class Menu {

	private static UserService user = new UserService();

	public static void showMenu() throws IOException {		

		showOptions();

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();

		user.selectedOption(choice);
	}

	private static void showOptions() {
		System.out.println("What you want to do?");
		System.out.println("1. Add user");
		System.out.println("2. Delete user");
		System.out.println("3. Exit");
	}
}
