package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Implements the move and interaction methods for the Prize piece. 
 */
public class Prize extends GamePiece implements Drawable {

	/**
	 * Default Constructor
	 * @param location the starting location of the Prize on the board
	 */
	public Prize(int location) {
		super('X', "Prize (what we are after)", location);
		
	}

	/**
	 * If the player reaches the prize then they advance to the next level
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		if (this.getLocation() == playerLocation)
			gameBoard[this.getLocation()] = null;
		return this.getLocation()==playerLocation ? InteractionResult.ADVANCE : InteractionResult.NONE;
	}
	
	public String toString()
	{
		return super.toString();
	}

}
