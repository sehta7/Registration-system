package registration.system.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import registration.system.menu.Menu;
import registration.system.model.User;

public class UserService {

	private User user;
	private static final String FILE_NAME = "registration.txt";
	private static final String TEMPORARY_FILE_NAME = "temporary_registration.txt";

	public void addUser() throws FileNotFoundException {
		addUserData();
		saveUserInFile();
	}

	private void addUserData() {

		user = new User();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Give your name: ");
		user.setName(scanner.nextLine());
		System.out.println("Give your age: ");
		user.setAge(scanner.nextInt());
	}

	private void saveUserInFile() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
		pw.println(user.getName() + "\r\n" + user.getAge() + "\r\n");
		pw.close();
	}

	public void deleteUser() throws FileNotFoundException, IOException {
			userSelection();
			createTemporaryFile();
			createFileWithoutUser();
	}

	private void userSelection() {
		System.out.println("Give user name to delete");
		Scanner scanner = new Scanner(System.in);
		user.setName(scanner.nextLine());
	}
	
	private void createTemporaryFile() throws FileNotFoundException, IOException {
		PrintWriter temporaryFile = new PrintWriter(TEMPORARY_FILE_NAME);
		BufferedReader currentFile = new BufferedReader(new FileReader(FILE_NAME));
		
		writeDataToTemporaryFile(temporaryFile, currentFile);

		closeFiles(temporaryFile, currentFile);
	}

	private void writeDataToTemporaryFile(PrintWriter temporaryFile, BufferedReader currentFile) throws IOException {
		String currentFileLine;
		while ((currentFileLine = currentFile.readLine()) != null) {
			if (currentFileLine.equals(user.getName())) {
				omitUserToDelete(currentFile);
			} else {
				writeUserToFile(temporaryFile, currentFileLine);
			}
		}
	}

	private void omitUserToDelete(BufferedReader currentFile) throws IOException {
		currentFile.readLine();
		currentFile.readLine();
	}

	private void writeUserToFile(PrintWriter file, String lineToWrite) {
		file.println(lineToWrite);
	}
	
	private void closeFiles(PrintWriter temporaryFile, BufferedReader currentFile) throws IOException {
		temporaryFile.close();
		currentFile.close();
	}

	private void createFileWithoutUser() throws FileNotFoundException, IOException {
		BufferedReader tempoaryFile = new BufferedReader(new FileReader(TEMPORARY_FILE_NAME));
		PrintWriter fileWithoutUser = new PrintWriter(FILE_NAME);
		
		rewriteDataToNewFile(tempoaryFile, fileWithoutUser);

		closeFiles(fileWithoutUser, tempoaryFile);

		deleteTemporaryFile(TEMPORARY_FILE_NAME);
	}

	private void rewriteDataToNewFile(BufferedReader tempoaryFile, PrintWriter fileWithoutUser) throws IOException {
		String currentFileLine;
		while ((currentFileLine = tempoaryFile.readLine()) != null) {
			writeUserToFile(fileWithoutUser, currentFileLine);
		}
	}
	
	private void deleteTemporaryFile(String fileName) {
		File file = new File(fileName);
		file.delete();
	}
	
	public void selectedOption(int optionNumber) throws IOException {
		switch (optionNumber) {
		case 1:
			addUser();
			Menu.showMenu();
			break;
		case 2:
			deleteUser();
			Menu.showMenu();
			break;
		case 3:
			System.exit(0);
		default:
			System.out.println("Choose another option.");
			Menu.showMenu();
			break;
		}
	}

}
