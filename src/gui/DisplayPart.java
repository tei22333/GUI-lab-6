package gui;



import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DisplayPart extends Label{
	
	public DisplayPart() {
		this.setPadding(new Insets(10));
		this.setFont(Font.font(18));;
		// implement your code here
		
	}
	
	public void update(String text) {
		this.setText(text);
		// implement your code here
		
	}
}
