/**
 * Class LevelSetup
 * @author Ryan Grundmeier
 * 
 */
package levelPieces;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
	/**
	 * Board for the game the stores the drawable pieces of the game
	 */
	protected Drawable[] board;
	
	/**
	 * Starting location of the player
	 */
	static private final int PLAYER_START_LOCATION = 20;

	/**
	 * 
	 * @param levelNum Which level we need to create
	 * @apiNote
	 * 	This function is called to setup a level whenever the game starts or a new level is needed. 
	 */
	 public void createLevel(int levelNum) {
		board = new Drawable[GameEngine.BOARD_SIZE];
		switch(levelNum)
		{
			case 1:
				for(int i = 0; i < GameEngine.BOARD_SIZE; i++)
				{
					switch(i)
					{
					case 1:
						board[i] = new Assassin(i);
						break;
					case 14:
						board[i] = new Platform(i);
						break;
					case 11:
						board[i] = new MysteriousClock(i,board);
						break;
					case 12:
						board[i] = new PoisonFrog(i);
						break;
					case 6:
						board[i] = new Treasure(i);
						break;
					case 0: 
						board[i] = new Prize(i);
						break;
					default:
						board[i] = null;
						break;
					}
				}
				break;
			case 2:
				for(int i = 0; i < GameEngine.BOARD_SIZE; i++)
				{
					switch(i)
					{
					case 1:
						board[i] = new Assassin(i);
						break;
					case 17:
						board[i] = new GoldenSnitch(i);
						break;
					case 14:
						board[i] = new Platform(i);
						break;
					case 11:
						board[i] = new MysteriousClock(i,board);
						break;
					case 12:
						board[i] = new PoisonFrog(i);
						break;
					case 6:
						board[i] = new Treasure(i);
						break;
					case 7:
						board[i] = new Guard(i);
						break;
					case 0: 
						board[i] = new Prize(i);
						break;
					default:
						board[i] = null;
						break;
					}
				}
				break;
			default:
				System.out.println("Unknown Level: " + levelNum);
				break;
		}
		
	}
	/**
	 * This function provides the working gameBoard array that will be used to run the game. 
	 * @return The final array that will be used to store the gamestate
	 */
	 public Drawable [] getBoard() {
		

		

		return board;

	}
	 
	/**
	 * This function is called to build the array of pieces that have the capability of moving. 
	 * @return The array of moving pieces
	 */
	public ArrayList<Moveable> getMovingPieces() {
		ArrayList<Moveable> movablePieces = new ArrayList<Moveable>();
		for(int i = 0; i < board.length; i++)
		{
			if(board[i] instanceof Moveable)
				movablePieces.add((Moveable)board[i]);		
		}
		return movablePieces;

	}
	/**
	 * This function is called to build the array of pieces that can interact with the player. 
	 * @return The array of interacting pieces. 
	 */
	public ArrayList<GamePiece> getInteractingPieces() {

		

		ArrayList<GamePiece> interactingPieces = new ArrayList<GamePiece>();
		for(int i = 0; i < board.length; i++)
		{
			if((board[i] instanceof GamePiece) && (board[i] instanceof Moveable))
				interactingPieces.add((GamePiece)board[i]);		
		}
		for(int i = 0; i < board.length; i++)
		{
			if((board[i] instanceof GamePiece) && !(board[i] instanceof Moveable))
				interactingPieces.add((GamePiece)board[i]);		
		}
		return interactingPieces;

	}
	
	/**
	 * This function is called to provide the players starting location. 
	 * @return
	 */
	public int getPlayerStartLoc() {
		return PLAYER_START_LOCATION;
	}
	
	
}



