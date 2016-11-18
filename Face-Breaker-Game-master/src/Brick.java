import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
		this.brick = new Rectangle (xPosition,yPosition,width,height);
		brick.setStroke(Color.BLACK);
		brick.setFill(color);
		this.boundary=brick.getBoundsInLocal();
	}
	
	public double getXPos(){
		return xPosition;
	}
	public double getYPos(){
		return yPosition;
	}
	public void addBlock(Pane canvas){
		canvas.getChildren().add(brick);
	}
	public void removeBlock(Pane canvas){
		canvas.getChildren().remove(brick);
	}
	public void patternMaker(Color color,int...positions){
		
	}
	public double getBlockX(Circle circle){
		return brick.getX()-circle.getRadius();
	}
	public double getBlockXPrime(Circle circle){
		return getBlockX(circle)+(brick.getWidth()+circle.getRadius()*2);
	}
	public double getBlockY(Circle circle){
		return brick.getY()-circle.getRadius();
	}
	public double getBlockYPrime(Circle circle){
		return getBlockY(circle)+(brick.getHeight()+circle.getRadius()*2);
	}
	
	
}
