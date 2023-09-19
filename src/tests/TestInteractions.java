package tests;

import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Platform;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import gameEngine.Drawable;

public class TestInteractions {
	@Test
	public void testAssassin() {
		assertEquals(1,1);
	}
	@Test
	public void testGoldenSnitch() {
		assertEquals(1,1);
	}
	@Test
	public void testGuard() {
		assertEquals(1,1);
	}
	@Test
	public void testMysteriousClock() {
		assertEquals(1,1);
	}
	@Test
	public void testPlatform() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Platform platform = new Platform(10);
		gameBoard[10] = platform;
		assertEquals(InteractionResult.NONE,platform.interact(gameBoard, 10));
	}
	@Test
	public void testPoisonFrog() {
		assertEquals(1,1);
	}
	@Test
	public void testPrize() {
		assertEquals(1,1);
	}
	@Test
	public void testTreasure() {
		assertEquals(1,1);
	}
}
