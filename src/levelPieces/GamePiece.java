package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

/**
 *  This is an abstract class because it contains an abstract 
 *  method AND an instance variable
 * 
 * @author Mark Baldwin
 * @author Cyndi Rader
 *
 */
public abstract class GamePiece implements Drawable {
	// Interfaces cannot have instance variables
	protected char symbol;
	private String label ;
	// Stores the piece location, which will be needed to interact
	// with the player. 
	private int location;

	/**
	 * Constructor for the game piece
	 * 
	 * @param symbol  symbol for the game piece
	 * @param label TODO
	 * @param location initial location
	 */
	public GamePiece(char symbol, String label, int location) {
		super();
		this.symbol = symbol;
		this.label = label ;
		this.location = location;
	}

	/**
	 * Draws the pieces symbol on the board
	 * 
	 * Abstract classes can have concrete/defined methods
	 * 
	 */
	public void draw() {
		System.out.print(symbol);
	}

	/**
	 * 
	 * Abstract classes should have at least one abstract method
	 * 
	 * @param gameBoard
	 * @param playerLocation
	 * @return
	 */
	public abstract InteractionResult interact(Drawable [] gameBoard, int playerLocation);

	/**
	 * 
	 * @return piece's current location on board
	 */
	public int getLocation() {
		return location;
	}
	
	/**
	 * @param newLocation - location to place piece
	 */
	public void setLocation(int newLocation) {
		// Ensure the location remains on the board
		if (newLocation >= 0 && newLocation < GameEngine.BOARD_SIZE)
			location = newLocation;
	}
	
	@Override
	public String toString() {
		return symbol + " - " + label ; 
	}
	
	/**
	 * Based on the current location it gets the first valid location starting on the space of 
	 * the piece and going in the direction the piece was going and returns that value
	 * @param currentSpace starting space of the piece
	 * @param direction True for left to right and False for right to left
	 * @param board list of Drawables that consist of the other pieces on the board
	 * @param playerLocation location of the player
	 * @return the new valid location that piece can be on
	 */
	public int getValidSpace(int currentSpace, boolean direction, Drawable[] board, int playerLocation)
	{
		int i;
		if (direction)
			i = 1;
		else
			i = -1;
		while((board[currentSpace]!=null) || (currentSpace == playerLocation))
		{
			if((currentSpace == GameEngine.BOARD_SIZE) && direction)
				i = -1;
			else if((currentSpace == 0) && !direction)
				i = 1;
			currentSpace = currentSpace + i;
		}
		return currentSpace;
	}

}
