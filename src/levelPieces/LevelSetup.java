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
	static int currentLevel = 0 ;  // stores the input for the current level, used in the hardcoding for the level loadouts. 
	
	static Drawable[] boardList; // array to contain the information 
	
	static ArrayList<Moveable> movingPiecesList; // array list to contain the list of all of the pieces that can move in a level. 
	
	
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
		// clears out any information previously stored in the list
		boardList = new Drawable[21];
		// Uses a hard coded method to check which level is being loaded. Only have to assign the non empty elements, because currently array contains 21 null entries.
		// When adding elements, the 3rd value of the constructor must match the array index that it is being assigned to. 
		if (currentLevel == 1 ) {
			
			boardList[0] = new PoisonFrog ('F', "Frog", 0);
			boardList[20] = new PoisonFrog ('F', "Frog", 0);
			
		}
		
		else if (currentLevel == 2) {
			boardList[2] = new PoisonFrog ('F', "Frog", 2); 
			boardList[3] = new PoisonFrog ('F', "Frog", 3);
					
		}
		
		return boardList;
		
		
		
	}
	/**
	 * This function is called to build the array of pieces that have the capability of moving. 
	 * @return The array of moving pieces
	 */
	static public ArrayList<Moveable> getMovingPieces() {
		//clear out/initialize the array list. 
		movingPiecesList = new ArrayList<Moveable>();
		// hard coded way to store the level information for the levels. 
		// Create an object temp that stores the information for typecasting 
		Moveable temp;
		if (currentLevel == 1) {
			// Typecast the object from the Drawable array and add it to the ArrayList of moveables. 
			 
			movingPiecesList.add(temp = (Moveable) boardList[0]);
			
			movingPiecesList.add(temp = (Moveable) boardList[20]);
		}
		
		if (currentLevel == 2) {
			movingPiecesList.add(temp = (Moveable) boardList[2]);
			movingPiecesList.add(temp = (Moveable) boardList[3]);
		}
		
		
		
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
		getMovingPieces();
		
		System.out.println(movingPieciesList);
		
		
		
		
		
	}
	
	
	}



