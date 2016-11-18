
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
	public PlayGame(Stage mainStage) {
		playGame();
		this.mainStage = mainStage;
	}

	public void playGame() {
		Stage stage = new Stage();
		StackPane pane = new StackPane();
		int levelNumber = 10;
		Scene scene = new Scene(pane, 800, 800);
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
		for (int i = 1; i <= 40; i++) {
			final int levelSelection = i;
			Button level = new Button("Level " + i);
			level.setTranslateX((-267 + (133 * ((i-1)%5))));
			level.setTranslateY(-200+((i-1)/5)*50);
			level.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					try {
						PlayLevel level = new PlayLevel(levelSelection);
					} catch (NullPointerException | MatrixOutOfBoundsException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			pane.getChildren().add(level);
		}
		pane.getChildren().addAll(back,title,separator1,selectLevel);
		stage.setScene(scene);
		stage.show();
	}
}

