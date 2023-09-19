package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/*
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Implements the move and interaction methods for the GoldenSnitch piece. 
 */
public class GoldenSnitch extends GamePiece implements Moveable
{
	/**
	 * Determines how likely it is for the snitch to be allowed to be within 2 spaces of 
	 * the player
	 */
	private final double LUCK_FACTOR = 0.1;
	
	/**
	 * Default Constructor
	 * @param location the starting location of the GoldenSnitch on the board
	 */
	public GoldenSnitch(int location) {
		super('s', "Golden Snich (special)", location);
	}

	/**
	 * If the player land on the golden snitch advance to the next level
	 */
	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation==this.getLocation())
			return InteractionResult.ADVANCE;
		return InteractionResult.NONE;
	}

	/**
	 * Decides on a random location to move to then makes sure that it is a valid location
	 * If it is close to the player so that the player can reach it, then run a random chance 
	 * based on the luck factor to see whether it is allowed to be next to the player or if it
	 * should find a random location that is not near the player.
	 */
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int randLocation = (int)(Math.random() * GameEngine.BOARD_SIZE);
		randLocation = this.getValidSpace(randLocation, false, gameBoard, playerLocation);
		if((int)(Math.random()* 1/LUCK_FACTOR)!=0)
		{
			while(Math.abs(randLocation- playerLocation) <= 2)
			{
				randLocation = (int)(Math.random() * GameEngine.BOARD_SIZE);
				randLocation = this.getValidSpace(randLocation, false, gameBoard, playerLocation);
			}
		}
		gameBoard[this.getLocation()] = null;
		this.setLocation(randLocation);
		gameBoard[this.getLocation()] = this;
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}