import java.util.Random;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ExamplePuzzles {
	Puzzle_Maker puzzleMaker;
	Random randomGenerator;
	Random randomGeneratorSeed;
	public ExamplePuzzles(int windowSize, int offSet, Pane canvas){
		puzzleMaker = new Puzzle_Maker (windowSize,offSet,canvas);
		randomGeneratorSeed = new Random(125);
		randomGenerator = new Random(randomGeneratorSeed.nextInt());
	}
	
	public void level(int i){
		switch (i){
			case 1: String level1= "x0x0x0x0x0x0x0x"
					             + "0x0x0x0x0x0x0x0"
								 + "x0x0x0x0x0x0x0x"
								 + "0x0x0x0x0x0x0x0"
								 + "x0x0x0x0x0x0x0x"
								 + "0x0x0x0x0x0x0x0"
								 + "x0x0x0x0x0x0x0x"
								 + "0x0x0x0x0x0x0x0";
					puzzleMaker.makePuzzle(Color.YELLOWGREEN, level1);
					break;
			case 2: String level2= "x0x0x0x0x0x0x0x"
								  +"x0x0x0x0x0x0x0x"
								  +"x0x0x0x0x0x0x0x"
								  +"x0x0x0x0x0x0x0x"
								  +"x0x0x0x0x0x0x0x"
								  +"x0x0x0x0x0x0x0x"
								  +"x0x0x0x0x0x0x0x"
								  +"x0x0x0x0x0x0x0x"; 
				puzzleMaker.makePuzzle(Color.ORANGE, level2);
					break;
			case 3: String level3= "000000xxx000000"
								  +"0000xxxxxxx0000"
								  +"00xxxxxxxxxxx00"
								  +"xxxxxxxxxxxxxxx"
								  +"00xxxxxxxxxxx00"
								  +"0000xxxxxxx0000"
								  +"000000xxx000000"
								  +"0000xxxxxxx0000"
								  +"00xxxxxxxxxxx00"
								  +"xxxxxxxxxxxxxxx"
								  +"00xxxxxxxxxxx00"
								  +"0000xxxxxxx0000"
								  +"000000xxx000000"
								  +"000000000000000"
								  +"000000000000000";
				puzzleMaker.makePuzzle(Color.CRIMSON, level3);
					break;
			case 4: String level4= "xxxxxxxxxxxxxxx"
					  			  +"00000xxxxx00000"
					              +"xxxxxxxxxxxxxxx"
					              +"00000xxxxx00000"
					              +"xxxxxxxxxxxxxxx"
					              +"00000xxxxx00000"
					              +"xxxxxxxxxxxxxxx"
					              +"00000xxxxx00000"
					              +"xxxxxxxxxxxxxxx"
					              +"00000xxxxx00000"
					              +"xxxxxxxxxxxxxxx"
					              +"00000xxxxx00000"
					              +"xxxxxxxxxxxxxxx"
					              +"000000000000000"
					              +"000000000000000"; 
				puzzleMaker.makePuzzle(Color.LIGHTBLUE,level4);
					break;
			case 5: String level5= "000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"xxxxxxxxxxxxxxx"
					  			  +"xxxxxxxxxxxxxxx"
					  			  +"xxxxxxxxxxxxxxx"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000"
					  			  +"000000xxx000000";
				puzzleMaker.makePuzzle(Color.DARKGRAY, level5);
				break;
			case 6: String level6= "xxxxxxxxxxxxxxx"
		  			  			  +"xx0000xxx0000xx"
		  			  			  +"x0x000xxx000x0x"
		  			  			  +"x00x00xxx00x00x"
		  			  			  +"x000x0xxx0x000x"
		  			     		  +"x0000xxxxx0000x"
		  			     		  +"xxxxxxxxxxxxxxx"
		  			     		  +"xxxxxxxxxxxxxxx"
		  			     		  +"xxxxxxxxxxxxxxx"
		  			     		  +"x0000xxxxx0000x"
		  			     		  +"x000x0xxx0x000x"
		  			     		  +"x00x00xxx00x00x"
		  			     		  +"x0x000xxx000x0x"
		  			     		  +"xx0000xxx0000xx"
		  			     		  +"xxxxxxxxxxxxxxx";
				puzzleMaker.makePuzzle(Color.BLUEVIOLET,level6);
				break;
			case 7: String level7= "xxxxxxxxxxxxxxx"
		  			  			  +"0x00000000000x0"
		  			  			  +"00x000000000x00"
		  			  			  +"000x0000000x000"
		  			  			  +"0000x00000x0000"
		  			  			  +"00000x000x00000"
		  			  			  +"000000x0x000000"
		  			  			  +"0000000x0000000"
		  			  			  +"000000x0x000000"
		  			  			  +"00000x000x00000"
		  			  			  +"0000x00000x0000"
		  			  			  +"000x0000000x000"
		  			  			  +"00x000000000x00"
		  			  			  +"0x00000000000x0"
		  			  			  +"xxxxxxxxxxxxxxx";
				puzzleMaker.makePuzzle(Color.BROWN, level7);
				break;
			case 8: String level8= "000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"00000xxx0000000"
		  			  			  +"0000xx0xx000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level8);
				break;
			case 9: String level9= "000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000"
		  			  			  +"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level9);
				break;
			case 10: String level10= "000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level10);
				break;
			case 11: String level11= "000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level11);
				break;
			case 12: String level12= "000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level12);
				break;
			case 13: String level13= "000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000"
		  			  			   +"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level13);
				break;
			case 14: String level14= "000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level14);
				break;
			case 15: String level15= "000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000"
		  			  				+"000000000000000";
				puzzleMaker.makePuzzle(Color.BROWN, level15);
				break;
			case 16: int[] randomPuzzle16 = new int[80];
				for (int x=0; x<randomPuzzle16.length; x++){
					randomPuzzle16[x] = randomGenerator.nextInt(150);
				}
				puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle16);
				break;
			case 17: int[] randomPuzzle17 = new int[80];
			for (int x=0; x<randomPuzzle17.length; x++){
				randomPuzzle17[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle17);
			break;
			case 18: int[] randomPuzzle18 = new int[80];
			for (int x=0; x<randomPuzzle18.length; x++){
				randomPuzzle18[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle18);
			break;
			case 19: int[] randomPuzzle19 = new int[80];
			for (int x=0; x<randomPuzzle19.length; x++){
				randomPuzzle19[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle19);
			break;
			case 20: int[] randomPuzzle20 = new int[80];
			for (int x=0; x<randomPuzzle20.length; x++){
				randomPuzzle20[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle20);
			break;
			case 21: int[] randomPuzzle21 = new int[80];
			for (int x=0; x<randomPuzzle21.length; x++){
				randomPuzzle21[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle21);
			break;
			case 22: int[] randomPuzzle22 = new int[80];
			for (int x=0; x<randomPuzzle22.length; x++){
				randomPuzzle22[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle22);
			break;
			case 23: int[] randomPuzzle23 = new int[80];
			for (int x=0; x<randomPuzzle23.length; x++){
				randomPuzzle23[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle23);
			break;
			case 24: int[] randomPuzzle24 = new int[80];
			for (int x=0; x<randomPuzzle24.length; x++){
				randomPuzzle24[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle24);
			break;
			case 25: int[] randomPuzzle25 = new int[80];
			for (int x=0; x<randomPuzzle25.length; x++){
				randomPuzzle25[x] = randomGenerator.nextInt(150);
			}
			puzzleMaker.makePuzzle(Color.AZURE,randomPuzzle25);
			break;
			
			default: System.out.println();
					break;
		}
	}
}
