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
	
	public Gui () {
		super ("WireWorld by KK");
		this.setBounds(100,100,1100,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JTable table1 = new JTable(array, columnsHeader);
		
		DefaultTableModel model = new DefaultTableModel(50, 50);
		JTable table2 = new JTable(model);
        table2.setRowSelectionAllowed(false);
        table2.setColumnSelectionAllowed(false);
        table2.setRowHeight(13);
        TableColumnModel columnModel = table2.getColumnModel();
        for (int i = 0; i < 50; i++) {
        	columnModel.getColumn(i).setMaxWidth(6);
        }
       
        columnModel.getColumn(1).setPreferredWidth(5);
        table2.setIntercellSpacing(new Dimension(0, 0));
        table2.setGridColor(Color.black);
		
        JPanel panel = new JPanel (null);
        this.add(panel, BorderLayout.CENTER);
        table2.setBounds(10, 10, 690, 650);
        button.setBounds(750, 250, 120, 30);
        label.setBounds(750, 310, 120, 30);
        input.setBounds(750, 350, 120, 30);
        button2.setBounds(750, 420, 120, 30);
        panel.add(table2);
        panel.add(button);
        panel.add(label);
        panel.add(input);
        panel.add(button2);

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
