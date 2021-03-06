import java.util.Scanner;

public class ConnectFour {

	Scanner input = new Scanner(System.in);
	private int[][] grid = new int[8][8];
	int turn = 0;
	boolean over = false;
	
	public void drawStartScreen() {
		System.out.println("***************************************");
		System.out.println("*                                     *");
		System.out.println("*            CONNECT FOUR!            *");
		System.out.println("*                                     *");
		System.out.println("*          Player 1 drops Xs          *");
		System.out.println("*          Player 2 drops Os          *");
		System.out.println("*                                     *");
		System.out.println("***************************************");
		System.out.println();
	}
	
	public void drawGrid() {
		for (int r=0; r<grid.length; r++) {
			for (int c=0; c<grid[r].length; c++) {
				int val = grid[r][c];
				
				if (val == 1) {
					System.out.print("X");
				}
				else if (val == 5) {
					System.out.print("O");
				}
				else {
					System.out.print("-");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		System.out.println("1 2 3 4 5 6 7 8");
		System.out.println();
	}
	
	public int getMove() {
		System.out.print("Player " + (turn + 1) + ", Enter column to drop: ");
		int col = input.nextInt();
		return col - 1;
	}
	
	public int[] dropChip(int col) {		
		int row = grid.length - 1;
				
		while (grid[row][col] > 0) {
			row--;
		}
	
		if (turn == 0) {
			grid[row][col] = 1;
		}
		else {
			grid[row][col] = 5;
		}
		
		int[] loc = {row, col};
		return loc;
	}
	
	public boolean checkWin(int[] loc) {		
		int upperLeftRow = Math.max(loc[0] - 3, 0);
		int upperLeftCol = Math.max(loc[1] - 3, 0);
		int lowerRightRow = Math.min(loc[0] + 3, 7);
		int lowerRightCol = Math.min(loc[1] + 3, 7);
		
		int hSum = 0;
		int vSum = 0;
		int dSum1 = 0;
		int dSum2 = 0;
		
		for (int row = upperLeftRow; row <= lowerRightRow; row++) {
			for (int col = upperLeftCol; col <= lowerRightCol; col++) {
				
				if (col <= 4) {
					hSum = grid[row][col] + grid[row][col+1] + grid[row][col+2] + grid[row][col+3];
				}
				
				if (row <= 4) {
					vSum = grid[row][col] + grid[row+1][col] + grid[row+2][col] + grid[row+3][col];
				}
				
				if (row <= 4 && col <= 4) {
					dSum1 = grid[row][col] + grid[row+1][col+1] + grid[row+2][col+2] + grid[row+3][col+3];
				}
				
				if (row >= 4 && col <= 4) {
					dSum2 = grid[row][col] + grid[row-1][col+1] + grid[row-2][col+2] + grid[row-3][col+3];
				}
				
				if (hSum == 4 || hSum == 20 || vSum == 4 || vSum == 20 || 
				    dSum1 == 4 || dSum1 == 20 || dSum2 == 4 || dSum2 == 20) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void advanceTurn() {
		turn = (turn + 1) % 2;
	}
	
	public void play() {
		drawStartScreen();
		
		while (!over) {
			drawGrid();
			int col = getMove();
			int[] loc = dropChip(col);
			
			over = checkWin(loc);
			
			if (over) {
				drawGrid();
				System.out.println("Player " + (turn + 1) + " wins!");
			}
			else {
				advanceTurn();
			}
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		ConnectFour game = new ConnectFour();
		game.play();	
	}
}
