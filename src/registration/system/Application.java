package registration.system;

import java.io.IOException;

import registration.system.menu.Menu;

public class Application {

	public static void main(String[] args) {

		try {
			Menu.showMenu();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
