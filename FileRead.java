package wireworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
	
	Scanner scanner;
	private int[][] table;
	private char array[][];
	private char arraytemp[][];
    private int row;
    private int col;
    private MakeGrid arraytable;
    private File fileo;

	public FileRead (int[][] table, MakeGrid arraytable, int row, int col, File fileo) throws FileNotFoundException {
		
		this.array = new char [row][col];
		this.arraytemp = new char [row][col];
		this.table = table;
		this.row = row;
		this.col = col;
		this.arraytable = arraytable;
		this.fileo = fileo;
	}

	public void read () throws FileNotFoundException {
		
	for (int i = 0; i < row; i++)
		for (int j = 0; j < col; j++)
			array[i][j] = ' '; //Default all cells = empty
				
	scanner = new Scanner(fileo); //Scan of file
	
	int n = 0; //Num of line
		while (scanner.hasNext()) {
				arraytemp [n] = scanner.nextLine().toCharArray(); //Each line to temp char array
				for (int k = 0; k < arraytemp[n].length; k++)
					array[n][k] = arraytemp[n][k]; //Temp array to double char array
				n++;
			}
	
	scanner.close();
	
	for (int i = 0; i < row; i++) {
		for (int j = 0; j < col; j++) {
			if (array[i][j] == '.') //"." = 1 = conductor
				table[i][j] = 1;
			else if (array[i][j] == 'T') //"T" = 2 = tail
				table[i][j] = 2;
			else if (array[i][j] == 'H') //"H" = 3 = head
				table[i][j] = 3;
			else
				table[i][j] = 0; //Empty cell
			}
		}
	
	arraytable.repaint(); //Update board
	
	}
}
