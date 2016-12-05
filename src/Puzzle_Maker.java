/*hunter layman
 * 
 */
import java.util.ArrayList;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Puzzle_Maker {

	private int adjustedWidth;
	Pane canvas;
	int offSet;
	Brick brick;

	public Puzzle_Maker(int windowSize, int offSet, Pane canvas) {
		adjustedWidth = windowSize / offSet;
		this.canvas = canvas;
		this.offSet = offSet;
	}

	public ArrayBrick makePuzzle(Color color, String input) throws NullPointerException, MatrixOutOfBoundsException {
		ArrayBrick bricks=new ArrayBrick ();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'x') {
			
				brick = new Brick(color, brickXPos(i), brickYPos(i), offSet, offSet / 2);
				bricks.add(brick);
				// brick = new
				// Brick(color,brickXPos(indexes[i]-1),brickYPos(indexes[i]-1),offSet,offSet/2);
				brick.addBlock(canvas);
			}
		}
		return bricks;
	}
	public void makePuzzle(Color color, int[] input) {

		for (int i = 0; i < input.length; i++) {
				
				brick = new Brick(color,brickXPos(input[i]-1),brickYPos(input[i]-1),offSet,offSet/2);
				System.out.println(input[i]);
				brick.addBlock(canvas);
		}
	}

	public double brickXPos(int i) {
		return (i % adjustedWidth) * offSet;
	}

	public double brickYPos(int i) {
		return (i / adjustedWidth) * (offSet / 2);
	}

}
