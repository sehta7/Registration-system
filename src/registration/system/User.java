package registration.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("registration.txt"), true));
			pw.println(name + "\r\n" + age + "\r\n");
			pw.close();
			
		} catch (IOException e) {
			System.out.println("File error!");
		}
	}
	
	public void deleteUser() {
		try {
			System.out.println("Which user to delete?");
			Scanner sc = new Scanner(System.in);
			name = sc.nextLine();
			
			PrintWriter pw = new PrintWriter("reg.txt");
			BufferedReader br = new BufferedReader(new FileReader("registration.txt"));
			
			String text;
			while((text = br.readLine()) != null) {
				if(text.equals(name)) {
					br.readLine();
					br.readLine();
				}
				else{
					pw.println(text);
				}
			}
			
			pw.close();
			br.close();
			
			BufferedReader br1 = new BufferedReader(new FileReader("reg.txt"));
			PrintWriter pw1 = new PrintWriter("registration.txt");
			while((text = br1.readLine()) != null) {
				pw1.println(text);
			}
			
			br1.close();
			pw1.close();
			
			File file = new File("reg.txt");
			file.delete();
		} catch (IOException e) {
			System.out.println("File error!");
		}
	}
}
