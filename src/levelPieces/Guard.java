package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Guard extends GamePiece implements Moveable
{
	public Guard(int location) {
		super('G', "Guard (can kill you)", location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		int treasureLocation = 0;
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++)
		{
			if(gameBoard[i] instanceof Treasure)
			{
				treasureLocation = i;
			}
		}
		gameBoard[this.getLocation()] = null;
		if(this.getLocation()<treasureLocation)
			this.setLocation(this.getValidSpace(this.getLocation()+1, true, gameBoard, treasureLocation));
		else
			this.setLocation(this.getValidSpace(this.getLocation()-1, false, gameBoard, treasureLocation));
		gameBoard[this.getLocation()] = this;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(Math.abs(this.getLocation() - playerLocation)<=1)
		{
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
}