package gui;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TimerGUI extends VBox{
	private Label nameLabel;
	private DisplayPart displayPart;
	private ControlPart controlPart;
	// implement your code here
	

	public TimerGUI(String name) {
		this.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.setPadding(new Insets(10));
		nameLabel = new Label(name);
		nameLabel.setFont(new Font(22));
		this.displayPart = new DisplayPart();
		this.controlPart = new ControlPart();
		// implement your code here
		this.getChildren().addAll(nameLabel,displayPart,controlPart);
	}
	
	public String getName() {
		return this.nameLabel.getText().trim();
		// implement your code here
		
	}
	public DisplayPart getDisplayPart() {
		return this.displayPart;
	}
	public ControlPart getControlPart() {
		return this.controlPart;
	}
	
	// Generate getters 
	
	
}
