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

import Algorithm.Student;

public class Students extends JPanel {
	private static final long serialVersionUID = 1;
	
	JPanel allStudents = new JPanel();
	ArrayList<Student> student = new ArrayList<Student>();
	
	private JTextField firstName;
	private JTextField lastName;
	private JTextField gender;
	private JTextField year;
	private JTextField alergies;
	private ArrayList<String[]> studentsInfo = new ArrayList<String[]>();
	
	private int numOfStudents = 0;
	
	private ArrayList<JTextField> slots = new ArrayList<JTextField>();
	
	ImportFromExcel importInfo = new ImportFromExcel();
	
	JButton moveToHosts = new JButton("Enter Hosts");
	
	/**
	 * Create the panel.
	 */
	public Students() {
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
		
		allStudents.setBounds(0, 150, 1250, 400);
		allStudents.setPreferredSize(new Dimension(1000, 1000));
		allStudents.setBackground(Color.lightGray);
		add(allStudents);
		allStudents.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(allStudents);
		
		firstName = new JTextField();
		firstName.setEditable(false);
		firstName.setText("First Name");
		firstName.setBounds(100, 25, 80, 25);
		firstName.setColumns(10);
		firstName.setHorizontalAlignment(SwingConstants.CENTER);
		
		lastName = new JTextField();
		lastName.setEditable(false);
		lastName.setText("Last Name");
		lastName.setBounds(280, 25, 80, 25);
		lastName.setColumns(10);
		lastName.setHorizontalAlignment(SwingConstants.CENTER);
		
		gender = new JTextField();
		gender.setEditable(false);
		gender.setText("Gender");
		gender.setBounds(460, 25, 80, 25);
		gender.setColumns(10);
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		
		year = new JTextField();
		year.setEditable(false);
		year.setText("Year");
		year.setBounds(640, 25, 80, 25);
		year.setColumns(10);
		year.setHorizontalAlignment(SwingConstants.CENTER);
		
		alergies = new JTextField();
		alergies.setEditable(false);
		alergies.setText("Alergies");
		alergies.setBounds(820, 25, 80, 25);
		alergies.setColumns(10);
		alergies.setHorizontalAlignment(SwingConstants.CENTER);
		
		allStudents.add(firstName);
		allStudents.add(lastName);
		allStudents.add(gender);
		allStudents.add(year);
		allStudents.add(alergies);
		
		scrollPane.setBounds(0, 150, 1000, 360);
		scrollPane.getVerticalScrollBar().setUnitIncrement(6);
		scrollPane.setHorizontalScrollBar(null);
		add(scrollPane);
		
		moveToHosts.setBounds(475, 520, 100, 25);
		add(moveToHosts);
	}
	
	public void setNumOfStudents(int number) {
		numOfStudents = number;
		for (int i = 0; i < numOfStudents * 5; i++) {
			slots.add(new JTextField());
		}
		int xPosition = 100;
		int yPosition = 75;
		int studentNum = 0;
		int studentInfoNum = 0;
		for (JTextField currentSlot : slots) {
			currentSlot.setBounds(xPosition, yPosition, 80, 25);
			currentSlot.setHorizontalAlignment(SwingConstants.CENTER);
			currentSlot.setText(studentsInfo.get(studentNum)[studentInfoNum]);
			studentInfoNum++;
			if (studentInfoNum == 5) {
				studentInfoNum = 0;
				studentNum++;
			}
			allStudents.add(currentSlot);
			xPosition += 180;
			if (xPosition == 1000) {
				xPosition = 100;
				yPosition += 50;
			}
		}
	}
	
	public void populateStudents() throws FileNotFoundException {
		importInfo.grabStudents(studentsInfo);
	}
	
	public JButton getMoveToHosts() {
		return moveToHosts;
	}
}
