package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Treasure extends GamePiece implements Drawable {

	public Treasure(int location) {
		super('T', "Treasure (what we are after)", location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return this.getLocation()==playerLocation ? InteractionResult.ADVANCE : InteractionResult.NONE;
	}
	
	public String toString()
	{
		return super.toString();
	}

}
