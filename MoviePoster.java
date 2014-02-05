import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.awt.Component;


public class MoviePoster extends JFrame
{
	private JPanel BigPanel;
	private JPanel imagePanel;	
	private JPanel textPanel;
	private JLabel imageLabel;	
	private JTextArea text;
	private JButton button;
	private JTable tableView;
	
	public MoviePoster()
	{
		super("Movie Poster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(800, 500);
		
		BigPanel = new JPanel();
		imagePanel = new JPanel();
		textPanel = new JPanel();
		
		tableView = new JTable(4,4);
		tableView.setRowHeight(100);
		tableView.getColumnModel().getColumn(0).setMinWidth(100);
		tableView.getColumnModel().getColumn(1).setMinWidth(100);
		tableView.getColumnModel().getColumn(2).setMinWidth(30);
		tableView.getColumnModel().getColumn(3).setMinWidth(400);
		
		//ImageIcon poster = new ImageIcon("pepper.jpg");
		tableView.setValueAt(new ImageIcon("pear.jpg"), 0, 0);
		tableView.setValueAt(new ImageIcon("pepper.jpg"), 1, 0);
		tableView.setValueAt(new ImageIcon("4.gif"), 2, 0);
		tableView.setValueAt(new ImageIcon("5.gif"), 3, 0);
		
		tableView.setValueAt("Hamlet", 0, 1);
		tableView.setValueAt("Kung Fu Kid", 1, 1);
		tableView.setValueAt("TRON: Legacy", 2, 1);
		tableView.setValueAt("Titanic", 3, 1);
		
		tableView.setValueAt("1948", 0, 2);
		tableView.setValueAt("2010", 1, 2);
		tableView.setValueAt("2010", 2, 2);
		tableView.setValueAt("1997", 3, 2);
		
		tableView.setValueAt("William Shakespeare's tale of tragedy of murder", 0, 3);
		tableView.setValueAt("12-year-old Dre Parker could've been the most popular kid in Detro", 1, 3);
		tableView.setValueAt("Sam Flynn, the tech-savvy 27-year-old son of Kevin Flynn", 2, 3);
		tableView.setValueAt("84 years later a 100-year-old woman named Rose DeWitt Bukater", 3, 3);
		
		tableView.getColumnModel().getColumn(0).setCellRenderer(new IconTableCellRenderer());
		
		imageLabel = new JLabel("Image Here");
		
		
		//imageLabel.setIcon(poster);
		imageLabel.setText(null);
		
		//imageLabel = new JLabel("Image Here");
		imagePanel.add(imageLabel);
		
		text = new JTextArea();
		text.setLineWrap(true);
		textPanel.add(text);
		
		button = new JButton("Display");
		//button.addActionListener(new ButtonListener());
	//	BigPanel.add(imagePanel);
	//	BigPanel.add(textPanel);
		BigPanel.add(tableView);
		this.add(BigPanel, BorderLayout.CENTER);
		//this.add(button, BorderLayout.SOUTH);
		
		
		
	
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}	

	class IconTableCellRenderer extends DefaultTableCellRenderer   
	{   
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,   
	                                                   boolean hasFocus, int row, int column)   
	    {   
	        JLabel label = (JLabel)super.getTableCellRendererComponent(   
	            table, value, isSelected, hasFocus, row, column   
	        );   
	        
	        if (value instanceof Icon)   
	        {   
	        		label.setText(null);   
	            	label.setIcon((ImageIcon) value);
	            	//new ImageIcon("pear.jpg"));   
	        	
	        }   
	        
	        return label;
	    }   
	}  
/*
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			
			ImageIcon three = new ImageIcon("pear.jpg");
			ImageIcon four = new ImageIcon("pepper.jpg");
			
			
			JLabel label3 = new JLabel();
			label3.setIcon(three);
			label3.setText(null);
			
			JLabel label4 = new JLabel();
			label4.setIcon(four);
			label4.setText(null);
			
			JPanel panel3 = new JPanel();
			panel3.add(label3);
			
			JPanel panel4 = new JPanel();
			panel4.add(label4);
			
			final String[] names = 
			{
			  	"Movie Introduction",
			  	"Movie Poster"
			};
			
			
			
			final Object[][] data = 
			{
				{
					"but ", three
				},
				{
					"12", four
				}				
			};
		//12	javax.swing.JLabel[,0,0,0x0,invalid,alignmentX=0.0,alignmentY=0.0,border=,flags=8388608,maximumSize=,minimumSize=,preferredSize=,defaultIcon=4.gif,disabledIcon=,horizontalAlignment=LEADING,horizontalTextPosition=TRAILING,iconTextGap=4,labelFor=,text=,verticalAlignment=CENTER,verticalTextPosition=CENTER]	
			TableModel dataModel = new AbstractTableModel()
			{
				public int getColumnCount() 
	            { 
	            	return names.length; 
	            }
	            public int getRowCount() 
	            { 
	            	return data.length;
	            }
				public Object getValueAt(int row, int col) 
	            {
	            	return data[row][col];
	            }
	            public void setValueAt(Object aValue, int row, int column) 
	            {
	            	data[row][column] = aValue; 
	            }
			};
			
			tableView = new JTable(dataModel);
			BigPanel.add(tableView);
			//ImageIcon poster = new ImageIcon("3.gif");
			//imageLabel.setIcon(poster);
			//imageLabel.setText(null);
			
		//	text.setText("12-year-old Dre Parker could've been the most"
		//				+ " popular kid in Detroit, but his mother's latest "
		//				+ "career move has landed him in China.");
			pack();
		}
		
		
	}
*/
	
	class ColumnLayout implements LayoutManager {
		int xInset = 5;
		int yInset = 5;
		int yGap = 2;
		
		public void addLayoutComponent(String s, Component c) {}
		
		public void layoutContainer(Container c) {
		    Insets insets = c.getInsets();
		    int height = yInset + insets.top;
		    
		    Component[] children = c.getComponents();
		    Dimension compSize = null;
		    for (int i = 0; i < children.length; i++) {
			compSize = children[i].getPreferredSize();
			children[i].setSize(compSize.width, compSize.height);
			children[i].setLocation( xInset + insets.left, height);
			height += compSize.height + yGap;
		    }
		    
		}
		
		public Dimension minimumLayoutSize(Container c) {
		    Insets insets = c.getInsets();
		    int height = yInset + insets.top;
		    int width = 0 + insets.left + insets.right;
		    
		    Component[] children = c.getComponents();
		    Dimension compSize = null;
		    for (int i = 0; i < children.length; i++) {
			compSize = children[i].getPreferredSize();
			height += compSize.height + yGap;
			width = Math.max(width, compSize.width + insets.left + insets.right + xInset*2);
		    }
		    height += insets.bottom;
		    return new Dimension( width, height);
		}
		
		public Dimension preferredLayoutSize(Container c) {
		    return minimumLayoutSize(c);
		}
		
		public void removeLayoutComponent(Component c) {}
    }
	
	
	public static void main(String[] args)
	{
		MoviePoster mp = new MoviePoster();
	}
}