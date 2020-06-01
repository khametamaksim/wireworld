package wireworld;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MakeGrid {

	char [][] array = new char [50][50];
	char [][] arraytemp = new char [50][50];
	File filename = null;
	Scanner scanner;
	
	public void set_filename (File fileo) { 
		this.filename = fileo;
	} 
	
	public void make_grid () throws IOException {
		for (int i = 0; i < 50; i++)
			for (int j = 0; j < 50; j++)
				array[i][j] = ' ';
		
	System.out.println(array[1].length);
				
	scanner = new Scanner(filename);
	int n = 0;
		while (scanner.hasNext()) {
				arraytemp [n] = scanner.nextLine().toCharArray();
				for (int k = 0; k < arraytemp[n].length; k++)
					array[n][k] = arraytemp[n][k];
				n++;
			}
		
	System.out.println(array[1].length);
	
	scanner.close();
	
	}
}
		
/*
	FileReader f = new FileReader(filename);
	    StringBuffer sb = new StringBuffer();
    	char[] arr = new char [2500];
    	int t;
	    while (f.ready()) {
	    	for (t = 0; t<2500; t++) {
	    		char c = (char) f.read();
	    		arr[t] = c;
	    	}
	        for (int k = 0, t2 = 0; k < 50; k++)
	        	for (int r = 0; r < 50; r++, t2++)
	        		array[k][r] = arr[t2];
	
}
*/
