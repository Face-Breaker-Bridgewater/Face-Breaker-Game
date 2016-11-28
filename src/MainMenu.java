/*
 * Laura Gretz
 */
import java.io.File;

import javax.print.DocFlavor.URL;
import javax.sound.sampled.Clip;

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

public class MainMenu {
	
	Player returnedPlayer;
	Login login;
	public MainMenu() {
	//	runMainMenu();
	}

	public Player runMainMenu(Login login) {
		this.login = login;
		returnedPlayer = login.thePlayer;
		
		Stage mainStage = new Stage();
		mainStage.setOnHidden(e -> {
			try {
				System.out.println("Saving player: " + returnedPlayer.toString());
				login.writeObject();
			} catch (IOException a) {
				a.printStackTrace();
			}
		});

		Music playMusic = new Music();
		Clip playBGMusic = playMusic.playYaverclap();
		
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
				PlayGame newGame = new PlayGame(mainStage, returnedPlayer);
				returnedPlayer = newGame.playGame();
				mainStage.close();
			}
		});
	   
		highScore.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				ScoreMainClass highscores = new ScoreMainClass(mainStage);
				mainStage.close();
			}
		});
		help.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				Help help = new Help(mainStage);
				mainStage.close();
			}
		});
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
		    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
		         if (group.getSelectedToggle() != null) {
		        	 if(soundOn.isSelected()) {
		        		playBGMusic.start();
		        		playBGMusic.loop(Clip.LOOP_CONTINUOUSLY);
		        	 }
		        	 if(soundOff.isSelected()) {
		        		playBGMusic.stop();
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
		
        return returnedPlayer;
	}

}
