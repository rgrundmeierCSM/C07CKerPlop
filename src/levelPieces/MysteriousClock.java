package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class MysteriousClock extends GamePiece implements Drawable{

	private Drawable[] secondPreviousBoard;
	private Drawable[] firstPreviousBoard;
	private Drawable[] board;
	
	public MysteriousClock(int location, Drawable[] board) {
		super('c', "Mysterious Clock (special)", location);
		this.board = board;
		this.firstPreviousBoard = new Drawable[GameEngine.BOARD_SIZE];
		this.secondPreviousBoard = new Drawable[GameEngine.BOARD_SIZE];
		copyBoard(firstPreviousBoard,board);
		copyBoard(secondPreviousBoard,board);
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if(playerLocation == this.getLocation())
		{
			copyBoard(board, secondPreviousBoard);
			setBoardLocations(board);
			GameEngine.setSkipTurn(true);
			board[this.getLocation()] = null;
			this.setLocation(this.getLocation()<GameEngine.BOARD_SIZE/2 ? GameEngine.BOARD_SIZE-1 : 0);
			this.setLocation(this.getValidSpace(this.getLocation(), this.getLocation()<GameEngine.BOARD_SIZE/2, gameBoard, playerLocation));
			board[this.getLocation()] = this;
		}
		copyBoard(firstPreviousBoard,board);
		copyBoard(secondPreviousBoard,firstPreviousBoard);
		return InteractionResult.NONE;
	}
	@Override
	public String toString() {
		return super.toString();
	}
	
	private void copyBoard(Drawable[] boardToCopyTo, Drawable[] boardToCopyFrom)
	{
		for(int i = 0; i < boardToCopyFrom.length; i++)
		{
			boardToCopyTo[i] = boardToCopyFrom[i];
		}
	}
	private void setBoardLocations(Drawable[] board)
	{
		for(int i = 0; i < board.length; i++)
		{
			if(board[i] instanceof GamePiece)
				((GamePiece) board[i]).setLocation(i);
		}
	}
}
