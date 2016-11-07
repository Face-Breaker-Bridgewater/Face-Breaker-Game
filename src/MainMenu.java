import java.io.File;

import javax.print.DocFlavor.URL;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class MainMenu extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override 
	public void start(Stage mainStage) {
		//java.net.URL bitQuest = getClass().getResource("BitQuest.wav");
		//final AudioClip clip = new AudioClip(bitQuest.toString());
		Music playMusic = new Music();
		AudioClip playBGMusic = playMusic.playBitQuest();
		
		mainStage.setTitle("FaceBreaker Game!");
		Label title = new Label("FACE BREAKER GAME");
		title.getStyleClass().add("title");
		
		
		Button playGame = new Button("Click to Play!");
		Button highScore = new Button("High Scores");
		Button help = new Button("Help");
		
		ToggleButton soundOn = new ToggleButton("Sound On");
		ToggleButton soundOff = new ToggleButton("Sound Off");
		ToggleGroup group = new ToggleGroup();
		soundOn.setToggleGroup(group);
		soundOff.setToggleGroup(group);

		HBox hbox = new HBox();
	    hbox.getChildren().addAll(soundOn, soundOff);
	    hbox.setPadding(new Insets(0, 0, 50, 0));
	    hbox.getStyleClass().add("hbox");
	    
		VBox buttons = new VBox();
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10, 20, 10, 20)); 
		buttons.getChildren().addAll(playGame, highScore, help, hbox);
		buttons.getStyleClass().add("buttons");
		
		playGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				PlayGame newGame = new PlayGame(mainStage);
				mainStage.close();
			}
		});
	   
		highScore.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				ScoreMainClass highscores = new ScoreMainClass();
				mainStage.close();
			}
		});
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		         if (group.getSelectedToggle() != null) {
		        	 if(soundOn.isSelected()) {
		        		playBGMusic.play(1.0);
		        		boolean soundSetting = true;
		        	 }
		        	 if(soundOff.isSelected()) {
		        		 playBGMusic.stop();
		        		 boolean soundSetting = false;
		        	 }
		         }
		     }
		});
		

		StackPane root = new StackPane();
		StackPane.setAlignment(title, Pos.TOP_CENTER);
		
        root.getChildren().addAll(title, buttons);
        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(this.getClass()
        		.getResource("stylesheet.css").toExternalForm());
        
        mainStage.setScene(scene);
        mainStage.show();
		
	}

}
