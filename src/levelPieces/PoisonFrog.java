/**
 * @author Ryan Grundmeier
 * 
 * Class extends game piece
 */
package levelPieces;
import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Implements the move and interaction methods for the PoisonFrog piece. 
 */
public class PoisonFrog extends GamePiece implements Moveable {
	
	/**
	 * Default Constructor
	 * @param location the starting location of the PoisonFrog on the board
	 */
	public PoisonFrog(int location) {
		super('F', "PoisonFrog (can damage you)", location);
		
	}
	/**
	 * @param playerLocation the location the player is currently at
	 * @param gameBoard the array of drawable pieces
	 * 
	 * If the PoisonFrog is on the same space as the player after moving, it kills the player. 
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (getLocation() == playerLocation) {
			return InteractionResult.HIT ;
		}
		return InteractionResult.NONE;
	}
	/**
	 * @param gameBoard the array of all the drawable pieces
	 * @param playerLocation the current playerLocation
	 * 
	 * The PoisonFrog jumps 2 spaces towards the player, if its at the edge /1 from the edge, it will opt not to move. 
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {



		int previousLocation = this.getLocation();
		// Checking to see whether the player is to the left of right of the PoisonFrog
		if(this.getLocation() < playerLocation)
			this.setLocation(this.getValidSpace(this.getLocation() + 2,true,gameBoard,playerLocation));
		else
			this.setLocation(this.getValidSpace(this.getLocation() - 2,false,gameBoard,playerLocation));

		// This gets called when the player is to the right. 
		//Update the game board with our new position. 
		gameBoard[this.getLocation()] = this;
		gameBoard[previousLocation] = null;
	}
	@Override
	public String toString() {
		return super.toString();
	}

}
