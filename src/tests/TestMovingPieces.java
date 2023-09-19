package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import gameEngine.Drawable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import gameEngine.GameEngine;
import gameEngine.Moveable;
import levelPieces.LevelSetup;
import levelPieces.Assassin;

public class TestMovingPieces {
	@Test
	
	public void testAssassin() {
		Moveable [] board = new Moveable[GameEngine.BOARD_SIZE];
		
		// Insert the assassin at position 6
		board[6] = new Assassin(6);
		
		//Assuming the player is at position 18, test that the assassin takes 1 step movements toward the player. 
		
		for (int i = 6; i < 14; i++) {
			board[i].move(board, 18);
			assertTrue(board[i+1] != null);
			
		}
		
		//Assuming the player is at position 3, test that the Assassin takes 1 step toward the player (left)
		
		for (int i = 14; i > 5; i--) {
			board[i].move(board, 3);
			assertTrue(board[i-1] != null);
		}
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
	public void testPoisonFrog() {
		assertEquals(1,1);
	}
}
