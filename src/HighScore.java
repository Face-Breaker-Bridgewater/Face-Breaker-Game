//Jarrett Is the BOMB
/*Making an arraylist of the type score
 * making a file where the files will be saved
 * then I initialize the arraylist 
 */
import java.util.*;
import java.io.*;

public class HighScore {
	private ArrayList<score> scores;

	private static final String HIGHSCORE_FILE = "scores.txt";

	//Initialising an in and outputStream for working with the file
	ObjectOutputStream outputStream = null;
	ObjectInputStream inputStream = null;

	public HighScore() {
		scores = new ArrayList<score>();
	}
	
	//this function will return an arraylist with the scores in it.
	public ArrayList<score> getScores(){ 
		LoadScoreFile();
		sort();
		return scores;
	}
	
	//will create a object and allows you to sort the arraylist with scores
	private void sort(){
		ScoreComparator comparator = new ScoreComparator();
		Collections.sort(scores, comparator);
	}
	
	//This is the method you call to add highscores to!
	public void addScore(String name, int score) {
		LoadScoreFile();
		scores.add(new score(name, score));
        updateScoreFile();
	}
	
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
	
	public String getHighScoreString() {
		String highScoreString = "";
		int max = 50;
		
		ArrayList<score> scores;
		scores = getScores();
		
		int i = 0;
		int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highScoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highScoreString;
	}
}
        
        
        
        
