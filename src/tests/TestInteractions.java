package tests;

import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.Platform;
import gameEngine.Drawable;

public class TestInteractions {
	public void testAssassin() {

	}
	public void testGoldenSnitch() {

	}
	public void testGuard() {

	}
	public void testMysteriousClock() {

	}
	public void testPlatform() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Platform platform = new Platform(10);
		gameBoard[10] = platform;
		assertEquals(InteractionResult.NONE,platform.interact(gameBoard, 10);
	}
	public void testPoisonFrog() {

	}
	public void testPrize() {

	}
	public void testTreasure() {

	}
}
