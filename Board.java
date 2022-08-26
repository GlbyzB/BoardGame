import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	
	//Declare the variable 
	private int[][] gulbeyazBaymaz;
	private int row;
	private int column;
	
	public Board(int a) {
		//ToDo
		gulbeyazBaymaz = new int[a][a];
		
	}
	
	public Board(int a, int b) {
		row = a;
		column = b;
		gulbeyazBaymaz = new int[a][b];
	}
	
	// getter setter
	
	public int[][] getGulbeyazBaymaz() {
		return gulbeyazBaymaz;
	}


	public void setGulbeyazBaymaz(int[][] gulbeyazBaymaz) {
		this.gulbeyazBaymaz = gulbeyazBaymaz;
	}


	//This method draws the game board
	public void drawBoard() {
		
		//ToDo
		for (int[] row: gulbeyazBaymaz) {
			for (int elem: row) {
				System.out.printf("%d\t", elem);
			}
			System.out.println();
		}
		
	}
	
	//This method checks if all of the positions on the board have been filled with 0
	public boolean boardIsFull() {
		
		//ToDo
		int totalZeros = 0;
		for (int[] row: gulbeyazBaymaz) {
			for (int elem: row) {
				if (elem == 0) {
					totalZeros += 1;
				}
			}
		}
		int length = gulbeyazBaymaz.length;
		if (totalZeros == length * length) {
			return true;
		}
		else {
			return false;
		}
		
		
		
	}
	
	
	// This method Converts the hidden board to an ArrayList and displays it in the requested order		
	public void makeArrayList () {
				
		//ToDo	
		ArrayList<Integer> generatedArray = new ArrayList<Integer>();
		for (int counter = 0; counter < gulbeyazBaymaz.length; counter++) {
			for (int counter1 = 0; counter1 < gulbeyazBaymaz.length; counter1++) {
				generatedArray.add(gulbeyazBaymaz[counter1][counter]);
			}
		}
		System.out.print("The generated ArrayList is: ");
		System.out.print(generatedArray);
		int arraySize = generatedArray.size();
		for (int counter = 0; counter < arraySize; counter++) {
			try {
				int elem = generatedArray.get(counter);
				if (elem < 5) {
					generatedArray.remove(counter);
					counter -= 1;
				}
			} catch (Exception e){
				break;
			}
		}
		System.out.println();
		System.out.print("The updated ArrayList is: ");
		System.out.print(generatedArray);
				
	}
	
	

}
