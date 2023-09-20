package tests;

import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Platform;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;
import levelPieces.*;

/**
 * @author Clark Howard
 * @author Ryan Grundmeier
 * 
 * Tests the various game piece interactions with the player
 */
public class TestInteractions {
	/**
	 * Tests the assassin to make sure that the assassin only kills when the player is one
	 * space away
	 */
	@Test
	public void testAssassin() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Assassin assassin = new Assassin(10);
		gameBoard[10] = assassin;
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++)
		{
			InteractionResult interaction = InteractionResult.NONE;
			switch(i)
			{
				case 9:
				case 11:
					interaction = InteractionResult.KILL;
				default:
					assertEquals(interaction,assassin.interact(gameBoard, i));
					break;
			}
		}

	}
	
	/**
	 * Tests the golden snitch to make sure that the player only advances if they are on
	 * the same location as the golden snitch
	 */
	@Test
	public void testGoldenSnitch() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		GoldenSnitch goldenSnitch = new GoldenSnitch(10);
		gameBoard[10] = goldenSnitch;
		assertEquals(InteractionResult.ADVANCE,goldenSnitch.interact(gameBoard, 10));
		assertEquals(InteractionResult.NONE,goldenSnitch.interact(gameBoard, 11));
		assertEquals(InteractionResult.NONE,goldenSnitch.interact(gameBoard, 9));
	}
	
	/**
	 * Tests the guard to make sure the guard kills the player if the player is at the same
	 * location or is one space away
	 */
	@Test
	public void testGuard() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Guard guard = new Guard(0);
		gameBoard[10] = guard;
		assertEquals(InteractionResult.NONE,guard.interact(gameBoard, 5));
		guard.setLocation(20);
		assertEquals(InteractionResult.KILL,guard.interact(gameBoard, 18));
		assertEquals(InteractionResult.KILL,guard.interact(gameBoard, 20));
		assertEquals(InteractionResult.KILL,guard.interact(gameBoard, 19));
	}
	
	/**
	 * Tests to make sure the mysterious clock makes the board go back a turn and that
	 * it does this only when the player is at the same location
	 */
	@Test
	public void testMysteriousClock() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		MysteriousClock mysteriousClock = new MysteriousClock(10,gameBoard);
		gameBoard[10] = mysteriousClock;
		Drawable[] previousPositions = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[11] = new Guard(11);
		gameBoard[12] = new Assassin(12);
		gameBoard[13] = new PoisonFrog(13);
		gameBoard[14] = new GoldenSnitch(14);
		for(int i = 0; i < gameBoard.length; i++)
		{
			previousPositions[i] = gameBoard[i];
		}
		mysteriousClock.interact(gameBoard, 0);
		gameBoard[1] = gameBoard[11];
		gameBoard[1] = gameBoard[12];
		gameBoard[1] = gameBoard[13];
		gameBoard[1] = gameBoard[14];
		mysteriousClock.interact(gameBoard, mysteriousClock.getLocation());
		for(int i = 0; i < gameBoard.length; i++)
		{
			if((gameBoard[i]!=mysteriousClock)&&(previousPositions[i]!=mysteriousClock))
			{
				assertEquals(gameBoard[i],previousPositions[i]);
			}
		}

		assertEquals(InteractionResult.NONE,mysteriousClock.interact(gameBoard, 10));
	}
	
	/**
	 * Tests to make sure the platform will only return NONE
	 */
	@Test
	public void testPlatform() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Platform platform = new Platform(10);
		gameBoard[10] = platform;
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++)
			assertEquals(InteractionResult.NONE,platform.interact(gameBoard, i));
	}
	
	/**
	 * Tests to make sure the poisonous frog only hits the player when the player is at the
	 * same location
	 */
	@Test
	public void testPoisonFrog() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		PoisonFrog poisonFrog = new PoisonFrog(10);
		gameBoard[10] = poisonFrog;
		for(int i = 0; i < GameEngine.BOARD_SIZE; i++)
		{
			InteractionResult interaction = InteractionResult.NONE;
			switch(i)
			{
				case 10:
					interaction = InteractionResult.HIT;
				default:
					assertEquals(interaction,poisonFrog.interact(gameBoard, i));
					break;
			}
		}

	}
	
	/**
	 * Tests to make sure the prize advances the player only when the player is at the same 
	 * location
	 */
	@Test
	public void testPrize() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Prize prize = new Prize(10);
		gameBoard[10] = prize;
		assertEquals(InteractionResult.ADVANCE,prize.interact(gameBoard, 10));
		assertEquals(InteractionResult.NONE,prize.interact(gameBoard, 11));
		assertEquals(InteractionResult.NONE,prize.interact(gameBoard, 9));
	}
	
	/**
	 * Tests to make sure the treasure gives the player a point only when the player is 
	 * at the same location
	 */
	@Test
	public void testTreasure() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Treasure treasure = new Treasure(10);
		gameBoard[10] = treasure;
		assertEquals(InteractionResult.NONE,treasure.interact(gameBoard, 11));
		assertEquals(InteractionResult.NONE,treasure.interact(gameBoard, 9));
		assertEquals(InteractionResult.GET_POINT,treasure.interact(gameBoard, 10));
	}
}
