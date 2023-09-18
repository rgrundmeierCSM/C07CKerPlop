/**
 * Class LevelSetup
 * @author Ryan Grundmeier
 * 
 */
package levelPieces;
import gameEngine.Drawable;
import gameEngine.Moveable;
import java.util.ArrayList;
public class LevelSetup {
	static int currentLevel = 0 ;  //
	static Drawable[] boardList = new Drawable[21];
	
	
	
	public LevelSetup() {
		
		
		
	}
	/**
	 * 
	 * @param levelNum Which level we need to create
	 * @apiNote
	 * 	This function is called to setup a level whenever the game starts or a new level is needed. 
	 */
	static public void createLevel(int levelNum) {
		currentLevel = levelNum;
		
		
	}
	/**
	 * This function provides the working gameBoard array that will be used to run the game. 
	 * @return The final array that will be used to store the gamestate
	 */
	static public Drawable [] getBoard() {
		if (currentLevel == 1 || currentLevel == 2) {
			boardList[0] = new PoisonFrog ('F', "Frog", 0);
			boardList[20] = new PoisonFrog ('F', "Frog", 0);
			
		}
		
		return boardList;
		
		
		
	}
	/**
	 * This function is called to build the array of pieces that have the capability of moving. 
	 * @return The array of moving pieces
	 */
	public ArrayList<Moveable> getMovingPieces() {
		
		return null;
	}
	/**
	 * This function is called to build the array of pieces that can interact with the player. 
	 * @return The array of interacting pieces. 
	 */
	public ArrayList<GamePiece> getInteractingPieces() {
		
		return null;
	}
	/**
	 * This function is called to provide the players starting location. 
	 * @return
	 */
	public int getPlayerStartLoc() {
		
		return 0;
	}
	public static void main(String[] args) {
		
		createLevel(1);
		getBoard();
		System.out.println(boardList[0]);
		System.out.println(boardList[1]);
		System.out.println(boardList[20]);
		
		
		
	}
	
	
	}



