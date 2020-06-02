package wireworld;

public class Gen {
	
	private int [][]table;
    private int row;
    private int col;
    private MakeGrid tablearray;


    public Gen (int[][] table, int row, int col, MakeGrid tablearray) {
        this.table = table;
        this.row = row;
        this.col = col;
        this.tablearray = tablearray;
    }
	
	public void generation () { //Function which generate next states
		int [][] temp = new int [row][col];
    	for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
            	temp[i][j] = table[i][j]; //Making an additional temporary array
               if (table[i][j] == 0) //If was empty will be empty
            	   temp[i][j] = 0;
               if (table[i][j] == 3) //If was head will be tail
                   temp[i][j] = 2;
               if (table[i][j] == 2) //If was tail will be conductor
                    temp[i][j] = 1;
               if (table[i][j] == 1) { //If was conductor count the neighbors
            	   
            	   int neighbours = 0; //Default 0
            	   
            	   int top = (i != 0) ? table[i-1][j] : -1;      
            	   int topright = ((i != 0) && (j+1 != col)) ? table[i-1][j+1] : -1;
            	   int right = (j+1 != col) ? table[i][j+1] : -1;
            	   int bottomright = ((i+1 != row) && (j+1 != col)) ? table[i+1][j+1] : -1;
            	   int bottom = (i+1 != row) ? table[i+1][j] : -1;
            	   int bottomleft = (( i + 1 != row) && (j != 0)) ? table[i+1][j-1] : -1;
            	   int left = (j != 0) ? table[i][j-1] : -1;
            	   int topleft = ((i != 0) && (j != 0)) ? table[i-1][j-1] : -1;
            	   
            	   if (top == 3) neighbours++;                     
            	   if (topright == 3) neighbours++;
            	   if (right == 3) neighbours++;
            	   if (bottomright == 3) neighbours++;
            	   if (bottom == 3) neighbours++;
            	   if (bottomleft == 3) neighbours++;
            	   if (left == 3) neighbours++;
            	   if (topleft == 3) neighbours++;
            	   
            	   if (neighbours == 1 || neighbours == 2) //If 1 or 2 were a head 
            		   temp[i][j] = 3; //Cell will be a head
               }
            }
    	}
    	for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) 
            	table[i][j] = temp[i][j]; //Copying to main table array
    	
    	tablearray.repaint(); //Update board
    }
}
