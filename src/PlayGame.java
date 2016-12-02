/*
 * Hunter Layman
 */
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class PlayGame {
	Stage mainStage;
	Player player;
	public PlayGame(Stage mainStage,Player player) {
		this.mainStage = mainStage;
		this.player = player;
	}

	public Player playGame(Login login) {
		Stage stage = new Stage();
		stage.setResizable(false);
		StackPane pane = new StackPane();
		int levelNumber = 10;
		Scene scene = new Scene(pane, 800, 800);
		stage.setOnHidden(e -> {
			try {
				System.out.println("Saving player: " + player.toString());
				login.writeObject();
			} catch (IOException a) {
				a.printStackTrace();
			}
		});
		Label title = new Label("FACE BREAKER GAME");
		title.setTranslateY(-300);
		Separator separator1 = new Separator();
		separator1.setTranslateY(-270);
		Label selectLevel = new Label("Please select a level:");
		selectLevel.setTranslateY(-250);

		Button back = new Button("Back");
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				mainStage.show();
				stage.close();
			}
		});
		back.setTranslateX(-330);
		back.setTranslateY(-330);
		for (int i = 1; i <= levelNumber; i++) {
			final int levelSelection = i;
			Button level = new Button("Level " + i);
			level.setTranslateX((-267 + (133 * ((i-1)%5))));
			level.setTranslateY(-200+((i-1)/5)*50);
			level.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int levels = player.getLevel();
					System.out.println("Level is "+levels);
					if (levels>=levelSelection||player.getUserName().equals("hunter")){
					try {
						System.out.println(levelSelection);
						PlayLevel level = new PlayLevel(player,levelSelection);
						player = level.playLevel(levelSelection, player,login,stage);
						stage.close();
						
					} catch (NullPointerException | MatrixOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}}
				}
			});
			pane.getChildren().add(level);
		}
		pane.getChildren().addAll(back,title,separator1,selectLevel);
		stage.setScene(scene);
		stage.show();
		return player;
	}
}

