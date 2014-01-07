package infopanel;

import org.mt4j.MTApplication;

public class Main extends MTApplication {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		initialize();
	}

	@Override
	public void startUp() {

		addScene(new design(this, "bussiness"));

		
	}

}
