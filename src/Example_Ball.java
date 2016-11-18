import javafx.scene.paint.Color;
import javafx.animation.Timeline;

import java.awt.event.KeyListener;

import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;

public class Example_Ball extends Application {

	boolean atBottomBorder;
	int gameSizeX = 750;
	int gameSizeY = 700;
	int offSet = 50;

	public void setAtBottomBorder(boolean value) {
		atBottomBorder = value;
	}

	public void start(final Stage primaryStage) throws NullPointerException, MatrixOutOfBoundsException {

		Matrix_Brick<Object> gridMatrix = new Matrix_Brick<>(10, offSet);
		Pane canvas = new Pane();
		ExamplePuzzles levelSelector = new ExamplePuzzles(gameSizeX, offSet, canvas);
		Scene scene = new Scene(canvas, gameSizeX, gameSizeY);
		primaryStage.setTitle("Example Ball");
		primaryStage.setScene(scene);
		primaryStage.show();

		Circle circle = new Circle(15);
		circle.setLayoutX(185);
		circle.setLayoutY(185);
		DoubleProperty circleX = new SimpleDoubleProperty(circle.getLayoutX());
		DoubleProperty circleY = new SimpleDoubleProperty(circle.getLayoutY());
		Rectangle paddle = new Rectangle(80, 20);
		paddle.setFill(Color.BLUE);
		paddle.setLayoutX(400);
		paddle.setLayoutY(670);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.RIGHT)) {
					System.out.println("Right Clicked");
					paddle.setLayoutX(paddle.getLayoutX() + 15);
				}
				if (event.getCode().equals(KeyCode.LEFT)) {
					paddle.setLayoutX(paddle.getLayoutX() - 15);
				}
				// switch (event.getCode()) {
				// case RIGHT: paddle.setLayoutX(paddle.getLayoutX() + 10);
				// break;
				// case LEFT: circle.setLayoutX(paddle.getLayoutX() - 10);
				// break;
				// }
			}
		});

		// private EventHandler<KeyEvent> keyListener = new
		// EventHandler<KeyEvent>() {
		// @Override
		// public void handle(KeyEvent event) {
		// if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN
		// ||
		// event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT)
		// {
		// //your code for moving the ship
		// }
		// else if(event.getCode() == KeyCode.SPACE) {
		// //your code for shooting the missile
		// }
		// event.consume();
		// }
		// };
		Image smiley = new Image(getClass().getResource("Emotes-face-kiss-icon.png").toExternalForm());
		ImagePattern imagePattern = new ImagePattern(smiley);
		circle.setFill(imagePattern);
		// smiley.set(150);
		// smiley.setY(150);
		// circle.layoutXProperty().addListener(new ChangeListener(){
		// @Override public void changed(ObservableValue o,Object oldVal,
		// Object newVal){
		// smiley.setX(circle.getLayoutX()-circle.getRadius()-5);
		// System.out.println("done");
		// }
		// });
		// circle.layoutYProperty().addListener(new ChangeListener(){
		// @Override public void changed(ObservableValue o,Object oldVal,
		// Object newVal){
		// smiley.setY(circle.getLayoutX()-circle.getRadius()-5);
		// System.out.println("done");
		// }
		// });
		circle.setLayoutX(250);
		circle.setLayoutY(250);

		canvas.getChildren().addAll(circle, paddle);
		// for (int i=0; i<15; i++){
		// Brick brick = new Brick(Color.RED,
		// ((i*4)%(gameSizeX/gridMatrix.offSet))*gridMatrix.offSet,
		// ((i*4)/(gameSizeX/gridMatrix.offSet)*gridMatrix.offSet),
		// gridMatrix.offSet,gridMatrix.offSet);
		// brick.addBlock(canvas);
		// gridMatrix.add(brick, (i*3)+4);
		// }
		levelSelector.level4();
		final Timeline loop = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {

			double deltaX = 1;
			double deltaY = 1;

			final Bounds bounds = canvas.getBoundsInLocal();

			// final Bounds boundPaddle = paddle.getBoundsInLocal();
			@Override
			public void handle(final ActionEvent t) {
				circle.setLayoutX(circle.getLayoutX() + deltaX);
				circle.setLayoutY(circle.getLayoutY() + deltaY);

				// System.out.println("X Max: "+paddle.getLayoutX());
				// System.out.println("Y Max: "+paddle.getLayoutY());

				final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
				final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
				setAtBottomBorder(circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius()));
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
					System.out.println("You just lost the ball!");
					primaryStage.close();
				}

			}
		}));

		loop.setCycleCount(Timeline.INDEFINITE);
		loop.play();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
