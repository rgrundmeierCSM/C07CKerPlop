package levelPieces;

import gameEngine.Drawable;

/*
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Implements the move and interaction methods for the Assasin piece. 
 */
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Assassin extends GamePiece implements Moveable
{
	private Drawable gamePieceOnTopOf = null;
	public Assassin(int location) {
		super('A', "Assassin (can kill you)", location);
		
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int previousLocation = this.getLocation();
		// Checking to see whether the player is to the left or right of the Assasin. 
		if(this.getLocation() < playerLocation)
			this.setLocation(this.getValidSpace(this.getLocation() + 1,true,gameBoard, playerLocation));
		else
			this.setLocation(this.getValidSpace(this.getLocation() - 1,false,gameBoard, playerLocation));
		
		Drawable tempSpace = gamePieceOnTopOf;
		gamePieceOnTopOf = gameBoard[this.getLocation()];
		gameBoard[this.getLocation()] = this;
		gameBoard[previousLocation] = tempSpace;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(this.getLocation() - playerLocation) ==1)
		{
			return InteractionResult.KILL;
		}
		else if (this.getLocation() == playerLocation) {
			gameBoard[this.getLocation()] = null;
		}
		return InteractionResult.NONE;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}