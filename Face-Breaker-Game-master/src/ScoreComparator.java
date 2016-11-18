//Jarrett is the BOMB
/*using this to compare two objects*/

import java.util.Comparator;

public class ScoreComparator implements Comparator<score> {
	public int compare(score scor1, score scor2){
		int sc1 = scor1.getScore();
		int sc2 = scor2.getScore();
		
		if (sc1 > sc2){
			return -1;
		}
		else if (sc1 < sc2){
			return +1;
		}
		else{
			return 0;
		}
	}
}