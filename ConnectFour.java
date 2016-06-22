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
				else if (val == 5) {
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
		int lowerRightRow = Math.min(loc[0] + 4, 7);
		int lowerRightCol = Math.min(loc[1] + 4, 7);
		

		
		
		return false;
	}
	
	public void advanceTurn() {
		turn = (turn + 1) % 2;
	}
	
	public void play() {
		while (!over) {
			drawGrid();
			int col = getMove();
			int[] loc = dropChip(col);
			
			over = checkWin(loc);
			advanceTurn();
			
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		ConnectFour game = new ConnectFour();
		game.play();
		
	}
}
