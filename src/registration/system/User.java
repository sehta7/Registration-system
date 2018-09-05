package registration.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class User {

	private String name;
	private int age;
	
	public User() {
		
	}
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
	public void addUser() {
		try {
			System.out.println("Give your name: ");
			Scanner sc = new Scanner(System.in);
			name = sc.nextLine();
			System.out.println("Give our age: ");
			age = sc.nextInt();
			PrintWriter pw = new PrintWriter("registration.txt");
			pw.print("name: " + name + ", age: " + age);
			pw.close();
			
		} catch (IOException e) {
			System.out.println("File error!");
		}
	}
}
