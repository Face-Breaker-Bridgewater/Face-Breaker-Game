/*
 * Jarrett Horton
 * Laura Gretz
 */

import java.util.*;
import java.io.*;

public class HighScore {
	HashMap<String, Integer> scores = new HashMap<>();
	
	public HighScore() {
		this.scores = scores;
	}
	//This is the method you call to add highscores to!
	public void addScore(String name, int score) {
		scores.put(name, score);
	}
	
	public HashMap<String, Integer> returnScores() {
		scores.put("Jarrett", 1);
		scores.put("John", 2);
		scores.put("Laura", 3);
		scores.put("Hunter", 4);
		scores.put("Sean", 5);
		
		return scores;
	}

	/*public void getHighScoreString() {
		String highScoreString = "";
		/*int max = 50;
		
		int i = 0;
		int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highScoreString += (i + 1)  + scores.get(i).get() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        
		//List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
	    Collections.sort(mapValues);
	  //  Collections.sort(mapKeys);
      //  return highScoreString;
	}
*/


	/*
	//load the arraylist that is in the high-score file and put it in the scores arraylist
	public void LoadScoreFile(){
		try {
			inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
	}
	
	public void updateScoreFile() {
		try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
	}
	
	
	*/
}
        
        
        
        
