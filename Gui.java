package wireworld;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Gui extends JFrame {
	
	private JButton button = new JButton ("Wybierz z pliku");
	private JTextField input = new JTextField ("50", 3);
	private JButton button2 = new JButton ("Zapisz w plik");
	private JLabel label = new JLabel ("liczba generacji:");
	private Object[][] array = new String[][] {{ "Сахар" , "кг", "1.5" },
        { "Мука"  , "кг", "4.0" },
        { "Молоко", "л" , "2.2" }};
    private Object[] columnsHeader = new String[] {"Наименование", "Ед.измерения", 
           "Количество"};
	
	public Gui () {
		super ("Simple Example");
		this.setBounds(100,100,1100,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JTable table1 = new JTable(array, columnsHeader);
		
		JTable table2 = new JTable(50, 50);
        table2.setRowSelectionAllowed(false);
        table2.setColumnSelectionAllowed(false);
        table2.setRowHeight(12);
        TableColumnModel columnModel = table2.getColumnModel();
        for (int i = 0; i < 50; i++) {
        	columnModel.getColumn(i).setMaxWidth(9);
        }
       
        columnModel.getColumn(1).setPreferredWidth(5);
        table2.setIntercellSpacing(new Dimension(0, 0));
        table2.setGridColor(Color.black);
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout (1,1,0,0));
		//container.add(button);
		//container.add(label);
		//container.add(input);
		//container.add(button2);
		container.add(table2);
		
		input.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        input.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        // nothing
		    }
		});

		//button.addActionListener(new ButtonEventListener());
	}
	
	public void SimpleTableTest() {
        
        table1 = new JTable(Cell, columnsHeader);
        
        JTable table2 = new JTable(3, 5);
       
        table2.setRowHeight(30);
        table2.setRowHeight(1, 20);
        table2.setIntercellSpacing(new Dimension(10, 10));
        table2.setGridColor(Color.blue);
        table2.setShowVerticalLines(false);

        }
	
	/*
	class ButtonEventListener implements ActionListener {
		
	}
	*/
}
