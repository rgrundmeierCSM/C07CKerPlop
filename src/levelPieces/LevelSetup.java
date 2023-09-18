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
	
	static ArrayList<GamePiece> interactingPiecesList; // contains all of the pieces with player interactions. 
	
	
	public LevelSetup() {
		
		
		
	}
	/**
	 * 
	 * @param levelNum Which level we need to create
	 * @apiNote
	 * 	This function is called to setup a level whenever the game starts or a new level is needed. 
	 */
	 public void createLevel(int levelNum) {
		currentLevel = levelNum;
		
		
	}
	/**
	 * This function provides the working gameBoard array that will be used to run the game. 
	 * @return The final array that will be used to store the gamestate
	 */
	 public Drawable [] getBoard() {
		// clears out any information previously stored in the list
		boardList = new Drawable[21];
		// Uses a hard coded method to check which level is being loaded. Only have to assign the non empty elements, because currently array contains 21 null entries.
		// When adding elements, the 3rd value of the constructor must match the array index that it is being assigned to. 
		if (currentLevel == 1 ) {
			
			boardList[0] = new PoisonFrog ('F', "Frog", 0);
			boardList[20] = new PoisonFrog ('F', "Frog", 20);
			
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
	 public ArrayList<Moveable> getMovingPieces() {
		//clear out/initialize the array list. 
		movingPiecesList = new ArrayList<Moveable>();
		// hard coded way to store the level information for the levels. 
		// Create an object temp that stores the information for typecasting 
		Moveable temp;
		
		for (int i  = 0; i < 21; i++) {
			movingPiecesList.add(temp = (Moveable) boardList[i]);
		}
		
		
		
		return movingPiecesList;
	}
	/**
	 * This function is called to build the array of pieces that can interact with the player. 
	 * @return The array of interacting pieces. 
	 */
	public ArrayList<GamePiece> getInteractingPieces() {
		interactingPiecesList = new ArrayList<GamePiece>();
		GamePiece temp;  // temp variable used for typecasting. 
		
		for (int i = 0; i < 21; i++) {
			interactingPiecesList.add(temp = (GamePiece) boardList[i]);
			
		}
		
		return interactingPiecesList;
	}
	/**
	 * This function is called to provide the players starting location. 
	 * @return
	 */
	public int getPlayerStartLoc() {
		
		
		return 10;
	}
	public static void main(String[] args) {
		
		
		
		
		
		
		
	}
	
	
	}



