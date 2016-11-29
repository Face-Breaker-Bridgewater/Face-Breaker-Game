/*Laura Gretz
 * Jarrett Horton
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScoreMainClass {
	Stage mainStage;
	ArrayList<Player> players;
	public ScoreMainClass(Stage mainStage, ArrayList<Player> players) {
		this.mainStage = mainStage;
		this.players = players;
		runHighScores(this.players);
	}

	
	@SuppressWarnings("unchecked")
	public void runHighScores(ArrayList<Player> players) {
		System.out.println("Size of array inside smc"+players.size());
		Stage stage = new Stage();
		for (int i=0; i<players.size(); i++){
			System.out.println("In Score Main Class"+players.get(i));
		}
		stage.setTitle("High Scores");
		stage.setWidth(500);
		stage.setHeight(500);
		Label scoresTitle = new Label("HIGH SCORES");
		scoresTitle.getStyleClass().add("helpTitle");

		HighScore hs = new HighScore();
		
		Object[] sorted = hs.returnScores(players).entrySet().toArray();
		Arrays.sort(sorted, new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					// TODO Auto-generated method stub
					return((Map.Entry<String, Integer>) o2).getValue()
							.compareTo(((Map.Entry<String, Integer>) o1).getValue());
				}
				
		});

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        
        int i = 0; 
        final int  MAX_SIZE = 10;
        for (Object e : sorted) {
        	i++;
        	if(i <= MAX_SIZE){
        		String name = ((Map.Entry<String, Integer>) e).getKey().toString();
        		String val = ((Map.Entry<String, Integer>) e).getValue().toString();
 
        		Label this_score = new Label(i +". " + name + "  " + val);
        		vbox.getChildren().add(this_score);
        	}
  		}
        vbox.getStyleClass().add("vbox");
        
		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainStage.show();
				stage.close();
			}
		});
        
		StackPane root = new StackPane();
		StackPane.setAlignment(scoresTitle, Pos.TOP_CENTER);
		StackPane.setAlignment(back, Pos.TOP_LEFT);
		Scene scene = new Scene(root, 500, 500);
		root.getChildren().addAll(vbox, back, scoresTitle);
		
		scene.getStylesheets().add(this.getClass()
        		.getResource("stylesheet.css").toExternalForm());
		
		stage.setScene(scene);
	    stage.show();
	}
}