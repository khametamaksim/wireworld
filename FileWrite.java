package wireworld;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileWrite {

	private int[][] table;
    private int row;
    private int col;
    private char [][] array;
    private JFileChooser filesave;
	

	public FileWrite (int[][] table, int row, int col, JFileChooser filesave) throws IOException {
		
		this.array = new char [row][col+1]; //Additional column
		this.row = row;
		this.col = col;
		this.table = table;
		this.filesave = filesave;
	}
	
	public void write() throws IOException {
		
		for (int i = 0; i < row; i++) { 
			for (int j = 0; j < col; j++) {
				if (table[i][j] == 3) //Same analogy as in FileRead
					array[i][j] = 'H';
				else if (table[i][j] == 2)
					array[i][j] = 'T';
				else if (table[i][j] == 1)
					array[i][j] = '.';
				else 
					array [i][j] = ' ';
			}
			array[i][col] = '\n'; //Adding column with new line symbols
		}
		
		FileWriter filew = new FileWriter(filesave.getSelectedFile()+".txt");
		
		StringBuilder sb = new StringBuilder(); //Making strings
		for (char[] ch: array) {
			sb.append(ch);
		}
		
        filew.write(sb.toString()); //Write to file
        filew.close();
	}
}
