package wireworld;

//A GUI program is written as a subclass of Frame - the top-level container
//This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane
public class Main {
	
	public static void main (String[] args) {
		Gui app = new Gui();
		app.setVisible(true);
	}
}
