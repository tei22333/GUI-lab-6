package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.Timer;

public class Main extends Application {
	// implement your code here
	public static Timer timer;
	@Override
	public void start(Stage primaryStage) {
		HBox root = new HBox();
		//root.setPadding(new Insets(10));
		//root.setSpacing(10);
		// implement your code here
		timer = new Timer("timer",-1);
		Timer stopWatch1 = new Timer("a", 1);
		Timer stopWatch2 = new Timer("x", 1);
		root.getChildren().addAll(timer.getTimerGUI(),stopWatch1.getTimerGUI(),stopWatch2.getTimerGUI());
		primaryStage.setTitle("Timer");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}
	
	public static void main (String [] args) {
		launch(args);
	}

	@Override
	public void stop() throws Exception{
		timer.getThread().interrupt();
		//stopWatch1.getThread().interrupt();
		//stopWatch2.getThread().interrupt();
		Platform.exit();
	}
	
}
