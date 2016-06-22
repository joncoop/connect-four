import java.util.Scanner;

public class ConnectFour {

	Scanner input = new Scanner(System.in);
	private int[][] grid = new int[8][8];
	int turn = 0;
	boolean over = false;
	
	public void drawGrid() {
		for (int r=0; r<grid.length; r++) {
			for (int c=0; c<grid[r].length; c++) {
				int val = grid[r][c];
				
				if (val == 1) {
					System.out.print("X");
				}
				else if (val == 2) {
					System.out.print("O");
				}
				else {
					System.out.print("-");
				}
			}
			System.out.println();
		}
		
	}
	
	public int getMove() {
		int displayPlayerNum = turn + 1;
		System.out.println("Player " + displayPlayerNum + ", Enter column to drop: ");
		int col = input.nextInt();
		return col;
	}
	
	public void dropChip(int col) {		
		int row = grid.length - 1;
				
		while (grid[row][col] > 0) {
			row--;
		}
	
		grid[row][col] = turn + 1;
	}
	
	public void checkWin() {
		for (int r=0; r<grid.length - 3; r++) {
			for (int c=0; c<grid[r].length - 3; c++) {
				int val = grid[r][c];
				
				// this isn't going to work
				int hSum = grid[r][c] +grid[r][c+1] +grid[r][c+2] +grid[r][c+3];
				int vSum = grid[r][c] +grid[r+1][c] +grid[r+2][c] +grid[r+3][c];
				
			}
		}
	}
	
	public void advanceTurn() {
		turn = (turn + 1) % 2;
	}
	
	public void play() {
		while (!over) {
			drawGrid();
			int col = getMove();
			dropChip(col);
			advanceTurn();
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		ConnectFour game = new ConnectFour();
		game.play();
		
	}
}
