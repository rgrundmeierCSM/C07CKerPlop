package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/*
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Implements the move and interaction methods for the Platform piece. 
 */
public class Platform extends GamePiece implements Drawable {
	
	/**
	 * Default Constructor
	 * @param location the starting location of the Platform on the board
	 */
	public Platform(int location) {
		super('_', "Platform (Can stand on)", location);
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}

	/**
	 * Does nothing, just allows the player to stand on it
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;
	}
}
