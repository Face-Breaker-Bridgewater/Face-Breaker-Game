//Jarrett Is the BOMB!
/* My thought process, so this class allows us to make an object with 
 * of type score that will contain score and name so we can hold our
 * highscores 
 */

import java.io.Serializable;

public class score implements Serializable{
	private int score; //global variable that holds the score
	private String name; //global variable that holds the name values
	
	public int getScore(){  //simple constructor
		return score;		
	}
	
	public String getName(){
		return name;
	}
	
	public score(String name, int score){
		this.score = score;
		this.name = name;
	}
}

