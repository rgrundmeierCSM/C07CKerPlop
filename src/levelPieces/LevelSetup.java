/**
 * @author Ryan Grundmeier
 */
package levelPieces;
import gameEngine.Drawable;
import gameEngine.Moveable;
import java.util.ArrayList;
public class LevelSetup {

	public LevelSetup() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param levelNum Which level we need to create
	 * @apiNote
	 * 	This function is called to setup a level whenever the game starts or a new level is needed. 
	 */
	public void createLevel(int levelNum) {
		
	}
	/**
	 * This function provides the working gameBoard array that will be used to run the game. 
	 * @return The final array that will be used to store the gamestate
	 */
	public Drawable [] getBoard() {
		
		
		return null;
	}
	/**
	 * This function is called to build the array of pieces that have the capability of moving. 
	 * @return The array of moving pieces
	 */
	public ArrayList<Moveable> getMovingPieces() {
		
		return null;
	}
	/**
	 * This funciton is called to build the array of pieces that can interact with the player. 
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
}
