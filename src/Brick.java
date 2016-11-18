import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick {
	
	private Color color;
	private Bounds boundary;
	private Rectangle brick;
	private double width;
	private double height;
	private double xPosition;
	private double yPosition;
	
	public Brick(Color color, double xPos, double yPos, double width, double height){
		this.color = color;
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.width = width;
		this.height = height;
		this.brick = new Rectangle (width,height,color);
		brick.setLayoutX(xPosition);
		brick.setLayoutY(yPosition);
		brick.setStroke(Color.BLACK);
		this.boundary=brick.getBoundsInLocal();
		
	}
	public void addBlock(Pane canvas){
		canvas.getChildren().add(brick);
	}
	public void patternMaker(Color color,int...positions){
		
	}
}
