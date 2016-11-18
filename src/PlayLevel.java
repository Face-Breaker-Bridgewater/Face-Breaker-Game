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
import java.util.ArrayList;

public class PlayLevel {
	int counterRight = 0;
	int counterLeft = 0;
	public PlayLevel(int i) throws NullPointerException, MatrixOutOfBoundsException {
		playLevel(i);
	}

	public void playLevel(int i) throws NullPointerException, MatrixOutOfBoundsException {
		Stage stage = new Stage();
		Pane canvas = new Pane();
		int gameSizeX = 750;
		Scene scene = new Scene(canvas, gameSizeX, 700);
		stage.setScene(scene);
		stage.show();
		ArrayBrick  bricks;
		ExamplePuzzles levelSelector = new ExamplePuzzles(gameSizeX, 50, canvas);
		Rectangle paddle = new Rectangle(80, 20);
		paddle.setFill(Color.BLUE);
		paddle.setLayoutX(400);
		paddle.setLayoutY(670);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
				if (paddle.getLayoutX() >= 0 && paddle.getLayoutX() <= gameSizeX - 85) {
					if (event.getCode().equals(KeyCode.RIGHT)) {
						paddle.setLayoutX(paddle.getLayoutX() + 15);
					}
					if (event.getCode().equals(KeyCode.LEFT)) {
						paddle.setLayoutX(paddle.getLayoutX() - 15);
					}
				} else {
					
					if (paddle.getLayoutX() >= 670&&counterRight<10) {
						paddle.setLayoutX(paddle.getLayoutX() - 15);
						counterRight++;
						System.out.println(counterRight);
					}
					if (paddle.getLayoutX() >= 670&&counterRight>=10){
						System.out.println("true");
						paddle.setLayoutX(10);
						counterRight = 0;
					}
					if (paddle.getLayoutX() <= 0&&counterLeft<10) {
						paddle.setLayoutX(paddle.getLayoutX() + 15);
						counterLeft++;
					}if (paddle.getLayoutX() <= 0&&counterLeft>=10) {
						paddle.setLayoutX(670);
						counterLeft=0;
					}
				}
			}
		});
		Circle circle = new Circle(15);
		circle.setLayoutX(400);
		circle.setLayoutY(600);
		Image smiley = new Image(getClass().getResource("Emotes-face-kiss-icon.png").toExternalForm());
		ImagePattern imagePattern = new ImagePattern(smiley);
		circle.setFill(imagePattern);
		canvas.getChildren().addAll(circle, paddle);
		bricks = levelSelector.level(i);
		//bricks.remove(0).removeBlock(canvas);
		System.out.println("Size"+bricks.size());
		final Timeline loop = new Timeline(new KeyFrame(Duration.millis(5), new EventHandler<ActionEvent>() {

			double deltaX = 1;
			double deltaY = 1;

			final Bounds bounds = canvas.getBoundsInLocal();

			@Override
			public void handle(final ActionEvent t) {
				circle.setLayoutX(circle.getLayoutX() - deltaX);
				circle.setLayoutY(circle.getLayoutY() - deltaY);

				final boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
				final boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
				final boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
				final boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());

				if (circle.getLayoutY() == paddle.getLayoutY() - circle.getRadius()
						&& circle.getLayoutX() >= paddle.getLayoutX() - 20
						&& circle.getLayoutX() <= paddle.getLayoutX() + 100) {
					if (circle.getLayoutX() >= paddle.getLayoutX()-20&&circle.getLayoutX() <= paddle.getLayoutX()&&deltaX>0){
						deltaY *= -1;
						deltaX *= -1;
					}else  
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
				
				for (int i=0; i<bricks.size(); i++){
					try{
					if (circle.getLayoutX()>bricks.get(i).getBlockX(circle)&&circle.getLayoutX()<bricks.get(i).getBlockXPrime(circle)&&(circle.getLayoutY()==bricks.get(i).getBlockY(circle)||circle.getLayoutY()==bricks.get(i).getBlockYPrime(circle))){
						deltaY *= -1;
						bricks.remove(i).removeBlock(canvas);
					}
					if (circle.getLayoutY()>bricks.get(i).getBlockY(circle)&&circle.getLayoutY()<bricks.get(i).getBlockYPrime(circle)&&(circle.getLayoutX()==bricks.get(i).getBlockX(circle)||circle.getLayoutX()==bricks.get(i).getBlockXPrime(circle))){
						deltaX *= -1;
						bricks.remove(i).removeBlock(canvas);
					}
					}catch(Exception e){
						
					}
				}
				if (bricks.isEmpty())
					stage.close();
			}
		}));

		loop.setCycleCount(Timeline.INDEFINITE);
		loop.play();

	}
}
