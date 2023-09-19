package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class GoldenSnitch extends GamePiece implements Moveable
{
	private final double LUCK_FACTOR = 0.1;
	public GoldenSnitch(int location) {
		super('s', "Golden Snich (special)", location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		if(playerLocation==this.getLocation())
			return InteractionResult.ADVANCE;
		return InteractionResult.NONE;
	}

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