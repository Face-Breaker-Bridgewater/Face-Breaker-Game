// Jarrett is the BOMB!!

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4204374514516083783L;
	private String UserName;
	private int Level;
	private int Score;
	
	public Player(String UserName){
		this.UserName = UserName;
		Level = 1;
		Score = 0;
	}
	
	
	public Player(String UserName, int Level, int Score){
		this.UserName= UserName;
		this.Level = Level;
		this.Score = Score;
	}
	
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int Level) {
		this.Level = Level;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int Score){
		this.Score = Score;
	}
	public String toString(){
		return "Username: "+UserName+", Level: "+Level+", Score: "+Score;
	}
	
	
		
}
