import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Gui extends JFrame{
	
	private JList list;
	private static String[] colornames = {"black", "red", "blue", "green", "yellow", "white", "orange", "pink"};
	private static Color[] colors = {Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.WHITE, Color.ORANGE, Color.PINK};
	
	public Gui(){
		
		super("color list");
		setLayout(new FlowLayout());
		
		list = new JList(colornames);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		
		list.addListSelectionListener(
			new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent event) {
					// TODO Auto-generated method stub
					getContentPane().setBackground(colors[list.getSelectedIndex()]);
				}
			}
		);
	}

}
