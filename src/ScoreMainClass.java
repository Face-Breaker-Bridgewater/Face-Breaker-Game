import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScoreMainClass extends Application {

	public static void main(String[] args) {

		

		/*HighScore hs = new HighScore();hi
		hs.addScore("Jarrett", 9001);
		hs.addScore("John", 230);
		hs.addScore("Laura", 220);
		hs.addScore("Hunter", 210);
		hs.addScore("Sean", 200);
		*/
		//System.out.println(hs.getHighScoreString());
		//

		launch(args);
	}
	
	@Override 
	public void start(Stage mainStage) throws FileNotFoundException {
		mainStage.setTitle("High Scores");
		
		HighScore hs = new HighScore();
		hs.addScore("jarrett", 900);
		hs.addScore("John", 2);
		hs.addScore("Laura", 3);
		hs.addScore("Hunter", 4);
		hs.addScore("Sean", 5);		
		
		hs.addScore("Jarrett", 1);
		hs.addScore("John", 2);
		hs.addScore("Laura", 3);
		hs.addScore("Hunter", 4);
		hs.addScore("Sean", 5);
		
		ArrayList<String> scores = hs.getScores();
		
		Label highScores = new Label(scores.toString());
		
		//hs.getScores();
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 500, 300);
		root.getChildren().addAll(highScores);
		mainStage.setScene(scene);
	    mainStage.show();
	}
}