package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

/*
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Implements the move and interaction methods for the MysteriousClock piece. 
 */
public class MysteriousClock extends GamePiece implements Drawable{

	/**
	 * The previous board that is used to go back a turn 
	 */
	private Drawable[] secondPreviousBoard;
	/**
	 * Stores the previousBoard and constantly update the second previous board with this
	 */
	private Drawable[] firstPreviousBoard;
	/**
	 * Pointer to the actual board being used in the game
	 */
	private Drawable[] board;
	
	/**
	 * Default Constructor
	 * @param location the starting location of the MysteriousClock on the board
	 */
	public MysteriousClock(int location, Drawable[] board) {
		super('c', "Mysterious Clock (special)", location);
		this.board = board;
		this.firstPreviousBoard = new Drawable[GameEngine.BOARD_SIZE];
		this.secondPreviousBoard = new Drawable[GameEngine.BOARD_SIZE];
		copyBoard(firstPreviousBoard,board);
		copyBoard(secondPreviousBoard,board);
		
	}

	/**
	 * If the player interacts with the clock set the board back a turn and stop the other pieces
	 * besides the player from moving this turn
	 */
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
	
	/**
	 * Creates a hard copy of the board to be copied from to the board that is to be copied to
	 * @param boardToCopyTo board to be copied to
	 * @param boardToCopyFrom board to be copied from
	 */
	private void copyBoard(Drawable[] boardToCopyTo, Drawable[] boardToCopyFrom)
	{
		for(int i = 0; i < boardToCopyFrom.length; i++)
		{
			boardToCopyTo[i] = boardToCopyFrom[i];
		}
	}
	
	/**
	 * 
	 * @param board sets the active board's pieces to the previous board's location of 
	 * those pieces
	 */
	private void setBoardLocations(Drawable[] board)
	{
		for(int i = 0; i < board.length; i++)
		{
			if(board[i] instanceof GamePiece)
				((GamePiece) board[i]).setLocation(i);
		}
	}
}
