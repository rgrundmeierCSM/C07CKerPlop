package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Treasure extends GamePiece implements Drawable {

	public Treasure(int location) {
		super('T', "Treasure (what we are after)", location);
		
	}

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
