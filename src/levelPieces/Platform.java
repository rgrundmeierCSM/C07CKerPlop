package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Platform extends GamePiece implements Drawable {
	private int location;
	public Platform(int location) {
		super('_', "Platform (Can stand on)", location);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		//gameBoard[this.getLocation()] = this;
		return InteractionResult.NONE;
	}
}
