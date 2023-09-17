/**
 * @author Ryan Grundmeier
 * 
 * Class extends game piece
 */
package levelPieces;
import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class PoisonFrog extends GamePiece implements Moveable, Drawable {

	public PoisonFrog(int location) {
		super('F', "PoisonFrog (can kill you)", location);
		
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
			return InteractionResult.KILL ;
		}
		return null;
	}
	/**
	 * @param gameBoard the array of all the drawable pieces
	 * @param playerLocation the current playerLocation
	 * 
	 * The PoisonFrog jumps 2 spaces towards the player, if its at the edge /1 from the edge, it will opt not to move. 
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Checking to see whether the player is to the left of right of the PoisonFrog
		if (playerLocation < this.getLocation()) {
			// If the PoisonFrog is at the edge/1 from the edge
			if (this.getLocation() > 1 ) {
				this.setLocation(this.getLocation() - 2);
			}
		}
		// This gets called when the player is to the right. 
		else {
			//Checking PoisonFrog location relative to the right edge
			if (this.getLocation() < 19) {
				this.setLocation(this.getLocation() + 2);
			}
		}
		//Update the game board with our new position. 
		gameBoard[this.getLocation()] = this;
		
		
	}
	@Override
	public String toString() {
		return super.toString();
	}

}
