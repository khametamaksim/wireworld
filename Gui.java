package wireworld;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Gui extends JFrame { //Is similar to JFrame 
	
	private JButton button = new JButton ("Wybierz z pliku"); //Read button
	private JTextField input = new JTextField ("50", 3); //Input field (num of generations
	private JButton button2 = new JButton ("Zapisz w plik"); //Write button
	private JLabel label = new JLabel ("liczba generacji:"); //Label
	private JButton button3 = new JButton ("Start"); //Start button
	int size = 75; //Default size
	int[][] table = new int[size][size]; //board = 75*75 cells
	MakeGrid tablearray;
	Gen generation;
	JTable table1;
	JPanel panel;
	File fileo = null;

	public Gui () {
		super ("WireWorld by KK");
		this.setBounds(100,100,1100,850); //Size of Application window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		tablearray = new MakeGrid (table, size, size); //Making a board
        
        panel = new JPanel (null); //Making a panel
        button.setBounds(800, 230, 120, 30); //Set coordinates and size of elements
        label.setBounds(800, 280, 120, 30);
        input.setBounds(800, 320, 120, 30);
        button2.setBounds(800, 380, 120, 30);
        button3.setBounds(800, 450, 120, 30);
		tablearray.setBounds(0, 0, 750, 750);
		panel.add(tablearray); //Adding elements to the panel
        panel.add(button); 
        panel.add(label);
        panel.add(input);
        panel.add(button2);
        panel.add(button3);

		input.addFocusListener(new FocusListener() { //Behavior of input value
		    public void focusGained(FocusEvent e) {
		        input.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        
		    }
		});

		button.addActionListener(new Read()); //Adding Listeners to the buttons
		button2.addActionListener(new Write());
		button3.addActionListener(new Start());
				
		this.add(panel, BorderLayout.CENTER); //Set panel to the application frame
		this.setVisible(true);
		
	}
	
	class Read implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFileChooser fileopen = new JFileChooser(); //Additional window with file chooser
            int ret = fileopen.showDialog(null, "Wybierz plik");                
            if (ret == JFileChooser.APPROVE_OPTION) {
                fileo = fileopen.getSelectedFile(); //Setting File variable
                try {
					FileRead f = new FileRead(table, tablearray, size, size, fileo); //FileRead class
					f.read();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
            }
		}
	}
	
	class Write implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFileChooser filesave = new JFileChooser(); //Open a window to save file
            int ret = filesave.showDialog(null, "Zapisz plik");                
            if (ret == JFileChooser.APPROVE_OPTION) {
            	try {
            		FileWrite w = new FileWrite (table, size, size, filesave); //FileWrite class
            		w.write();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
            }
		}
	}		
	
	class Start implements ActionListener {
		int n; //Number of entered generations
		public void actionPerformed (ActionEvent e) {
			n = Integer.parseInt(input.getText()); //Check the input el data
			for (; n > 0; n--) {
				Gen generate = new Gen (table, size, size, tablearray); //Class of generations
				generate.generation();
				
			}
		}
	}
}



