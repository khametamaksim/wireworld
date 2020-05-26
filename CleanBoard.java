package com.wireworld;

public class CleanBoard {
//plansza
    private int[][] tab;
    private int row;
    private int col;


    public CleanBoard(int[][] tab, int row, int coll, Board boardPanel) {
        this.tab = tab;
        this.row = row;
        this.col = col;
        //this.plansza;
    }

    public void CLEAN() {
for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                tab[i][j] = 0;
            }
        }
    boardPanel.repaint();
    }

}

