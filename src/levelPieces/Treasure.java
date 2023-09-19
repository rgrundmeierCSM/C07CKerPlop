package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Implements the move and interaction methods for the Treasure piece. 
 */
public class Treasure extends GamePiece implements Drawable {

	/**
	 * Default Constructor
	 * @param location the starting location of the Treasure on the board
	 */
	public Treasure(int location) {
		super('T', "Treasure (gives points)", location);
		
	}
	
	/**
	 * If the player reaches the prize then they get a point
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		if (this.getLocation() == playerLocation)
			gameBoard[this.getLocation()] = null;
		return this.getLocation()==playerLocation ? InteractionResult.GET_POINT : InteractionResult.NONE;
	}
	
	public String toString()
	{
		return super.toString();
	}

}
