import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class PlayLevel {
	public PlayLevel(int i) {
		playLevel(i);
	}

	public void playLevel(int i) {
		Stage stage = new Stage();
		Pane canvas = new Pane();
		int gameSizeX = 750;
		Scene scene = new Scene(canvas, gameSizeX, 700);
		stage.setScene(scene);
		stage.show();
		ExamplePuzzles levelSelector = new ExamplePuzzles(gameSizeX,50,canvas);
		Rectangle paddle = new Rectangle(80, 20);
		paddle.setFill(Color.BLUE);
		paddle.setLayoutX(400);
		paddle.setLayoutY(670);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.RIGHT)) {
					paddle.setLayoutX(paddle.getLayoutX() + 15);
				}
				if (event.getCode().equals(KeyCode.LEFT)) {
					paddle.setLayoutX(paddle.getLayoutX() - 15);
				}
			}
		});
		Circle circle = new Circle(15);
		circle.setLayoutX(185);
		circle.setLayoutY(185);
		Image smiley = new Image(getClass().getResource("Emotes-face-kiss-icon.png").toExternalForm());
		ImagePattern imagePattern = new ImagePattern(smiley);
		circle.setFill(imagePattern);
		canvas.getChildren().addAll(circle, paddle);
		levelSelector.level(i);
		
		final Timeline loop = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {

			double deltaX = 1;
			double deltaY = 1;

			final Bounds bounds = canvas.getBoundsInLocal();
			@Override
			public void handle(final ActionEvent t) {
				circle.setLayoutX(circle.getLayoutX() + deltaX);
				circle.setLayoutY(circle.getLayoutY() + deltaY);


				final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
				final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
				final boolean atBottomBorder =circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
				final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());

				if (circle.getLayoutY() == paddle.getLayoutY() - circle.getRadius()
						&& circle.getLayoutX() >= paddle.getLayoutX() - 20
						&& circle.getLayoutX() <= paddle.getLayoutX() + 100) {
					deltaY *= -1;
				}

				if (atRightBorder || atLeftBorder) {
					deltaX *= -1;
				}
				if (atTopBorder) {
					deltaY *= -1;
				}
				if (atBottomBorder) {
					stage.close();
				}

			}
		}));

		loop.setCycleCount(Timeline.INDEFINITE);
		loop.play();
		
		

		
	}
}
