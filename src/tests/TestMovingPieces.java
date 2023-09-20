package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import levelPieces.LevelSetup;
import levelPieces.PoisonFrog;
import levelPieces.Assassin;
import levelPieces.GoldenSnitch;
import levelPieces.Guard;
import levelPieces.Treasure;	
import gameEngine.Drawable;
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
		
		//Create the test game board
		Moveable [] board = new Moveable[GameEngine.BOARD_SIZE];
		//Insert the GoldenSnitch object at position 2
		GoldenSnitch testSubject = new GoldenSnitch(2);
		board[2] = testSubject;
		//Filling every space except 2, 4, 8, 10 with game pieces pieces
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			if (i != 2 && i != 4 && i != 8 && i != 10) {
				board[i] = new GoldenSnitch(i);
			}
		}
		
		//Variables to store the location of the testSubject after moving. 
		int location2 = 0, location4 = 0, location8 = 0, location10 = 0;
		
		//Loop to move the testSubject 200 times and record where it landed. 
		for (int i = 0; i < 200; i++) {
			testSubject.move(board, 20);
			switch(testSubject.getLocation()) {
			
			case 2: 
				location2 ++;
				break;
			
			case 4:
				location4 ++;
				break;
			case 8:
				location8 ++;
				break;
			case 10:
				location10++;
				break;
			}
		}
		//On average each variable should be ~ 50, test case checks that its greater than 15
		
		assertTrue(location2 > 15);
		assertTrue(location4 > 15);
		assertTrue(location8 > 15);
		assertTrue(location10 > 15);
		
	}
	@Test
	public void testGuard() {
		//create the board with the Guard at position 2, and the treasure at position 5
		Drawable [] board = new Drawable[GameEngine.BOARD_SIZE];
		Guard testSubject = new Guard(2);
		board[2] = testSubject;
		board[5] = new Treasure(5);
		
		//Tests checking the Guard moves towards the treasure
		testSubject.move(board,5 );
		assertEquals(3, testSubject.getLocation());
		testSubject.move(board,  5);
		assertEquals(4, testSubject.getLocation());
		
		//Testing that the Guard hops over the treasure
		testSubject.move(board,  0);
		assertEquals(6, testSubject.getLocation());
		//Testing that he jumps back
		testSubject.move(board, 5);
		assertEquals(4, testSubject.getLocation());		
		
		
	}
	@Test
	public void testPoisonFrog() {
		//create the game board with the PoisonFrog at position 3
		Drawable[] board = new Drawable[GameEngine.BOARD_SIZE];
		PoisonFrog testSubject = new PoisonFrog(3);
		board[3] = testSubject;
		
		
		//Testing that the frog moves 2 spaces towards the player
		
		testSubject.move(board, 20);
		assertEquals(5, testSubject.getLocation());
		testSubject.move(board, 20);
		assertEquals(7, testSubject.getLocation());
		testSubject.move(board, 20);
		assertEquals(9, testSubject.getLocation());
		
		//checking movement the other way
		
		testSubject.move(board, 0);
		assertEquals(7, testSubject.getLocation());
		testSubject.move(board, 0);
		assertEquals(5, testSubject.getLocation());
		
		//checking that it will jump over the player
		
		testSubject.move(board, 4);
		assertEquals(3, testSubject.getLocation());
	}
}
