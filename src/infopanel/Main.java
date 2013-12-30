package infopanel;

import org.mt4j.MTApplication;

public class Main extends MTApplication {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		initialize();
	}

	@Override
	public void startUp() {
<<<<<<< HEAD
		addScene(new Hoofdmenu(this, "Hoofdmenu"));
=======
		addScene(new Screensaver(this, "screensaver"));
>>>>>>> 0b912f49881205208ff51acf5e63f346db640922
		
	}

}
