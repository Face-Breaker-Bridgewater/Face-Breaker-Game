/*
 * Laura Gretz
 * Jarrett Horton
 */

import java.util.*;
import java.io.*;

public class HighScore {
	HashMap<String, Integer> scores = new HashMap<>();
	
	public HighScore() {	
		this.scores = scores;
	}
	public HashMap<String, Integer> returnScores(ArrayList<Player> players) {
			for (int i=0; i< players.size(); i++){
				System.out.println(players.get(i));
				scores.put(players.get(i).getUserName(), players.get(i).getScore());
			}
		return scores;
	}


}
        
        
        
        
