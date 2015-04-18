package Interface;

import javax.swing.JEditorPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Hosts extends JPanel {
	private static final long serialVersionUID = 1;
	
	JPanel allHosts = new JPanel();
	
	private JTextField lastName;
	private JTextField gender;
	private JTextField alergies;
	private JTextField numberTaking;
	
	private ArrayList<String[]> hostsInfo = new ArrayList<String[]>();
	
	private int numOfHosts = 0;
	
	private ArrayList<JTextField> slots = new ArrayList<JTextField>();
	
	ImportFromExcel importInfo = new ImportFromExcel();
	
	JButton algorithmize = new JButton("Algorithmize!");
	/**
	 * Create the panel.
	 */
	public Hosts() {
		setBackground(new Color(240, 230, 140));
		setBounds(0, 0, 1000, 600);
		setLayout(null);
		
		JTextField welcome = new JTextField("Please Enter the Students");
		welcome.setBounds(375, 50, 250, 30);
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
		
		allHosts.setPreferredSize(new Dimension(1000, 1000));
		allHosts.setBackground(Color.lightGray);
		add(allHosts);
		allHosts.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(allHosts);
		
		lastName = new JTextField();
		lastName.setEditable(false);
		lastName.setText("Last Name");
		lastName.setBounds(100, 25, 125, 25);
		lastName.setColumns(10);
		lastName.setHorizontalAlignment(SwingConstants.CENTER);
		
		gender = new JTextField();
		gender.setEditable(false);
		gender.setText("Gender");
		gender.setBounds(325, 25, 125, 25);
		gender.setColumns(10);
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		
		alergies = new JTextField();
		alergies.setEditable(false);
		alergies.setText("Alergies");
		alergies.setBounds(550, 25, 125, 25);
		alergies.setColumns(10);
		alergies.setHorizontalAlignment(SwingConstants.CENTER);
		
		numberTaking = new JTextField();
		numberTaking.setEditable(false);
		numberTaking.setText("Number Of Students");
		numberTaking.setBounds(775, 25, 125, 25);
		numberTaking.setColumns(25);
		numberTaking.setHorizontalAlignment(SwingConstants.CENTER);
		
		allHosts.add(lastName);
		allHosts.add(gender);
		allHosts.add(alergies);
		allHosts.add(numberTaking);
		
		scrollPane.setBounds(0, 150, 1000, 350);
		scrollPane.getVerticalScrollBar().setUnitIncrement(6);
		add(scrollPane);		
		
		algorithmize.setBounds(475, 520, 100, 25);
		add(algorithmize);
	}
	
	public void setNumOfHosts(int number) {
		numOfHosts = number;
		for (int i = 0; i < numOfHosts * 4; i++) {
			slots.add(new JTextField());
		}
		int xPosition = 100;
		int yPosition = 75;
		int hostNum = 0;
		int hostInfoNum = 0;
		for (JTextField currentSlot : slots) {
			currentSlot.setBounds(xPosition, yPosition, 125, 25);
			currentSlot.setHorizontalAlignment(SwingConstants.CENTER);
			currentSlot.setText(hostsInfo.get(hostNum)[hostInfoNum]);
			hostInfoNum++;
			if (hostInfoNum == 4) {
				hostInfoNum = 0;
				hostNum++;
			}
			allHosts.add(currentSlot);
			xPosition += 225;
			if (xPosition == 1000) {
				xPosition = 100;
				yPosition += 50;
			}
		}
	}
	
	public void populateHosts() throws FileNotFoundException {
		importInfo.grabHosts(hostsInfo);
	}
	
	public JButton getAlgorithmize() {
		return algorithmize;
	}
}
