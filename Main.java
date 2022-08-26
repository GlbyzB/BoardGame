
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		// Create a variable to represent the size of our game board
		System.out.println("Let's play the Board Game!");
		System.out.println("Please determine the board dimension: ");
		int sizeOfBoard = input.nextInt();
		
		
		
		//Create an object of the Board class and fill it with â€œ-1â€�. (This is your visible board)
		
		Board visibleBoard = new Board(sizeOfBoard);
		for (int[] row: visibleBoard.getGulbeyazBaymaz()) {
			Arrays.fill(row, -1);
			
		}
		
		// Create another object of the Board class and initialize it with random integer numbers between 1 and 10. (This is your hidden board)
		SecureRandom randomNumbers = new SecureRandom();
		Board hiddenBoard = new Board(sizeOfBoard);
		
		for (int counter2 = 0; counter2 < sizeOfBoard; counter2++) {
			for (int counter3 = 0; counter3 < sizeOfBoard; counter3++) {
				hiddenBoard.getGulbeyazBaymaz()[counter2][counter3] = 1 + randomNumbers.nextInt(10);
			}
		}

		//Create a Scanner and ask the players for their names
		
		System.out.print("Player 1, what is your name? ");
		String player1 = input.next();
		
		System.out.print("Player 2, what is your name? ");
		String player2 = input.next();
		
		
		System.out.println("Board: ");
		visibleBoard.drawBoard();
		
		int totalPlayer1 = 0;
		int totalPlayer2 = 0;
		
		//mistakes
		int mistakesOfPlayer1 = 3;
		int mistakesOfPlayer2 = 3;
		
		int iterations = sizeOfBoard*sizeOfBoard;
		
		for (int counter4 = 0; counter4 < iterations; counter4++) {
			//Ask the user for what element they want to choose
			System.out.printf("%s's Turn: ", counter4 % 2 == 0 ? player1 : player2);
			System.out.println();
			System.out.println("Enter a row number: ");
			int row = input.nextInt();
			
			//Check if the row and column are in the board
			while (row >= sizeOfBoard) {
				System.out.println("This position is out of the bounds of the board! Please try again.");
				System.out.println("Enter a row number: ");
				row = input.nextInt();
				
			}
			
			System.out.println("Enter a column number: ");
			int column = input.nextInt();
			
			//(if row is valid, column is out of rnage).
			while (column >= sizeOfBoard) {
				System.out.println("This position is out of the bounds of the board! Please try again.");
				System.out.println("Enter a column number: ");
				column = input.nextInt();
			}
			while (visibleBoard.getGulbeyazBaymaz()[row][column] == 0) {
				System.out.println("This position has already been chosen!!");
				if (counter4 % 2 == 0) {
					mistakesOfPlayer1 -= 1;
					System.out.printf("%s chose a restricted position.", player1);
					System.out.println();
					System.out.printf("Remaining number of permitted mistakes for %s is: %d\n",player1, mistakesOfPlayer1);	
					if (mistakesOfPlayer1 == 0) {
						break;
					}
				}
				else {
					mistakesOfPlayer2 -= 1;
					System.out.printf("%s chose a restricted position.", player2);
					System.out.println();
					System.out.printf("Remaining number of permitted mistakes for %s is: %d\n",player2, mistakesOfPlayer2);	
					if (mistakesOfPlayer2 == 0) {
						break;
					}
				}

				System.out.println("Enter a row number: ");
				row = input.nextInt();
				System.out.println("Enter a column number: ");
				column = input.nextInt();
				
			}
			
			visibleBoard.getGulbeyazBaymaz()[row][column] = 0;
			
			if (mistakesOfPlayer1 == 0 || mistakesOfPlayer2 == 0) {
				System.out.println("Board Game Finished");
				break;
			}
			else if (counter4 == iterations-1) {
				System.out.println("Board Game Finished");
			}
			else {
				visibleBoard.drawBoard();
			}
			
			if (counter4 % 2 == 0) {
				totalPlayer1 += hiddenBoard.getGulbeyazBaymaz()[row][column];
			
			}
			else {
				totalPlayer2 += hiddenBoard.getGulbeyazBaymaz()[row][column];
			}
		}
		
		
		
		
		System.out.println("\n\n----------------------- Result ---------------------------\n\n");
		
		
		// compare the scores and display who is the winner
		System.out.printf("The player %s has the score of %d and the player %s has the score of %d.", player1, totalPlayer1, player2, totalPlayer2);
		System.out.println();
		
		if (mistakesOfPlayer1 == 0) {
			System.out.printf("%s has made too many mistakes :( \n", player1);
			System.out.printf("%s is the winner!", player2);
		}
		else if (mistakesOfPlayer2 == 0) {
			System.out.printf("%s has made too many mistakes :( \n", player2);
			System.out.printf("%s is the winner!", player1);
		}
		else if (totalPlayer1 > totalPlayer2 && mistakesOfPlayer1 > 0) {
			System.out.printf("%s is the winner!", player1);
		}
		else if (totalPlayer1 < totalPlayer2 && mistakesOfPlayer2 > 0) {
			System.out.printf("%s is the winner!", player2);
		}
		else {
			System.out.printf("%s and %s have the same scores!!", player1, player2);
		}
		//Draw the board at the end of the game
		System.out.println("\n\n\n--- The final status of the visible board is: ---");
		System.out.println("Board: ");
		visibleBoard.drawBoard();
				
		
		System.out.println("--- The hidden board was: ---");
		System.out.println("Board: ");
		hiddenBoard.drawBoard();
				
		
		// Convert the hidden board to an ArrayList and display it in the requested order.
	        // Display the updated list
		
		hiddenBoard.makeArrayList();
		
		System.out.println("\n\n----------------------- New Board ---------------------------\n\n");
		
		System.out.println("Enter a row number: ");
		int row1 = input.nextInt();
		
		System.out.println("Enter a column number: ");
		int column1 = input.nextInt();

		Board newBoard = new Board(row1, column1);
		
		for (int counter5 = 0; counter5 < row1; counter5++) {
			for (int counter6 = 0; counter6 < column1; counter6++) {
				int[][] myArray = newBoard.getGulbeyazBaymaz();
 				int number1 = 10 + randomNumbers.nextInt(21);
 				myArray[counter5][counter6] = number1;
			}
		}
		System.out.println("Board: ");
		newBoard.drawBoard();
		
		newBoard.makeArrayList();
	}	
}	