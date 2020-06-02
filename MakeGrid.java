package wireworld;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MakeGrid extends JPanel {

    private int[][] table;
    private int row;
    private int col;

    public MakeGrid (int [][] table, int row, int col) {
        this.row = row;
        this.col = col;
        this.table = table;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (table[i][j] == 0) { //0 - empty cell
                    g.setColor(Color.white); //Make it white
                    g.fillRect(j * 10, i * 10, 10, 10); //Using rectangle 10*10
                }
                else if (table[i][j] == 1) { // 1 - conductor
                    g.setColor(Color.black);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
                else if (table[i][j] == 2) { // 2 - electron tail
                    g.setColor(Color.red);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
                else if (table[i][j] == 3) { // 3 - electron head
                    g.setColor(Color.yellow);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
            }
        }
    }
}