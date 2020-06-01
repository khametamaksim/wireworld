package wireworld;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class Gui extends JFrame {
	
	File fileo;
	
	private JButton button = new JButton ("Wybierz z pliku");
	private JTextField input = new JTextField ("50", 3);
	private JButton button2 = new JButton ("Zapisz w plik");
	private JLabel label = new JLabel ("liczba generacji:");
	private JButton button3 = new JButton ("Start");
	String [][] array = new String [50][50];
	String [] head = new String [50];
	JTable table1;

	public Gui () {
		super ("WireWorld by KK");
		this.setBounds(100,100,1100,850);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < 50; i++)
			head[i] = "0";
		table1 = new JTable (array, head);
		table1.setTableHeader(null);
        table1.setRowSelectionAllowed(false);
        table1.setColumnSelectionAllowed(false);
        table1.setIntercellSpacing(new Dimension(0, 0));
		
        JPanel panel = new JPanel (null);
        this.add(panel, BorderLayout.CENTER);
        table1.setBounds(0, 0, 735, 736);
        button.setBounds(800, 230, 120, 30);
        label.setBounds(800, 280, 120, 30);
        input.setBounds(800, 320, 120, 30);
        button2.setBounds(800, 380, 120, 30);
        button3.setBounds(800, 450, 120, 30);
        panel.add(table1);
        panel.add(button);
        panel.add(label);
        panel.add(input);
        panel.add(button2);
        panel.add(button3);

        this.setVisible(true);
        /*
		Container container = this.getContentPane();
		container.setLayout(new GridLayout (1,1,0,0));
		container.add(button);
		container.add(label);
		container.add(input);
		container.add(button2);
		container.add(table2);
		*/
		
		input.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        input.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		        // nothing
		    }
		});

		button.addActionListener(new onClick());
		button2.addActionListener(new onClick2());

	}
	
	class onClick implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Wybierz plik");                
            if (ret == JFileChooser.APPROVE_OPTION) {
                fileo = fileopen.getSelectedFile();
              
            }
		}
	}
	
	class onClick2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFileChooser filesave = new JFileChooser();
	
			String sb = "Test content";
            int ret = filesave.showDialog(null, "Zapisz plik");                
            if (ret == JFileChooser.APPROVE_OPTION) {
            	try {
                    FileWriter filew = new FileWriter(filesave.getSelectedFile()+".txt");
                    filew.write(sb.toString());
                    filew.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            	
            }
		}
	}
}
