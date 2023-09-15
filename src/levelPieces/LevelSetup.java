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
	
	public Drawable [] getBoard() {
		
		
		return null;
	}
	
	public ArrayList<Moveable> getMovingPieces() {
		
		return null;
	}
	
	public ArrayList<GamePiece> getInteractingPieces() {
		
		return null;
	}
	public int getPlayerStartLoc() {
		
		return 0;
	}
}
