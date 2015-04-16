package Interface;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;
import javax.swing.JButton;

public class Home extends JPanel {
	private static final long serialVersionUID = 1;
	
	private JTextField enterNumOfStudents;
	private JTextField numOfStudents;
	JButton enter = new JButton("Enter");
	private JTextField enterNumOfHosts;
	private JTextField numOfHosts;
	/**
	 * Create the panel.
	 */
	public Home() {
		setBackground(new Color(240, 230, 140));
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JTextField welcome = new JTextField("Welcome to the Housing Randomizer");
		welcome.setBounds(325, 50, 350, 30);
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		welcome.setEditable(false);
		welcome.setBackground(new Color(255, 255, 255));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		add(welcome);
		
		JEditorPane topBar = new JEditorPane();
		topBar.setBounds(0, 0, 1250, 150);
		topBar.setEnabled(false);
		topBar.setEditable(false);
		topBar.setBackground(new Color(105, 105, 105));
		add(topBar);
		
		enterNumOfStudents = new JTextField();
		enterNumOfStudents.setHorizontalAlignment(SwingConstants.CENTER);
		enterNumOfStudents.setText("Please Enter the Number of Students");
		enterNumOfStudents.setEditable(false);
		enterNumOfStudents.setBounds(375, 200, 250, 20);
		add(enterNumOfStudents);
		enterNumOfStudents.setColumns(10);
		
		numOfStudents = new JTextField();
		numOfStudents.setBounds(450, 250, 100, 20);
		add(numOfStudents);
		numOfStudents.setColumns(10);
		
		enterNumOfHosts = new JTextField();
		enterNumOfHosts.setText("Please Enter the Number of Hosts");
		enterNumOfHosts.setHorizontalAlignment(SwingConstants.CENTER);
		enterNumOfHosts.setEditable(false);
		enterNumOfHosts.setColumns(10);
		enterNumOfHosts.setBounds(375, 297, 250, 20);
		add(enterNumOfHosts);
		
		numOfHosts = new JTextField();
		numOfHosts.setColumns(10);
		numOfHosts.setBounds(450, 345, 100, 20);
		add(numOfHosts);
		
		enter.setBounds(450, 401, 100, 23);
		add(enter);
	}
	
	public int getNumOfStudents() {
		return Integer.parseInt(numOfStudents.getText());
	}
	
	public int getNumOfHosts() {
		return Integer.parseInt(numOfHosts.getText());
	}
	
	public JButton getEnter() {
		return enter;
	}
}
