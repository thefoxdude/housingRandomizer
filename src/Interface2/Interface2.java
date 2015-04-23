package Interface2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Interface2 extends JFrame {
	private static final long serialVersionUID = 1;
	
	private JPanel holder;
	private JTextField studentLocation;
	private JTextField hostLocation;
	private JComboBox<String> groupHolder;
	String groupName;

	PrintWriter fileWriter;
	Scanner myReader;
	String studentFilePath;
	String hostFilePath;
	JFileChooser myChooser;
	
	private ImportFromExcel2 importCall = new ImportFromExcel2();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface2 frame = new Interface2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface2() {
		//Start by reading the file names that are listed in the file.  If there are no files (it is the first time using the system)
		//the locations are defaulted to empty strings.
		try {
			myReader = new Scanner(new File("ExcelFileLocations.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(myReader.hasNextLine())
			studentFilePath = myReader.nextLine();
		else studentFilePath = "";
		if(myReader.hasNextLine())
			hostFilePath = myReader.nextLine();
		else hostFilePath = "";
		
		//Clears the file and opens up the file for writing
		try {
			fileWriter = new PrintWriter(new FileWriter("ExcelFileLocations.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		myChooser = new JFileChooser();
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				fileWriter.println(studentFilePath);
				fileWriter.println(hostFilePath);
				fileWriter.close();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150,100,460,500);
		holder = new JPanel();
		holder.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(holder);
		holder.setBackground(new Color(226, 204, 168));
		holder.setBounds(0, 0, 1000, 600);
		holder.setLayout(null);
		
		JTextField welcome = new JTextField("Welcome to the Housing Randomizer");
		welcome.setForeground(new Color(255, 255, 255));
		welcome.setBounds(40, 40, 350, 50);
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		welcome.setEditable(false);
		welcome.setBackground(new Color(0, 37, 84));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(welcome);
		
		JEditorPane topBar = new JEditorPane();
		topBar.setBounds(0, 0, 984, 150);
		topBar.setEnabled(false);
		topBar.setEditable(false);
		topBar.setBackground(new Color(0, 37, 84));
		getContentPane().add(topBar);
		
		JLabel studentLabel = new JLabel("File Location For Student");
		studentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		studentLabel.setBounds(98, 161, 200, 14);
		holder.add(studentLabel);
		
		JLabel hostLabel = new JLabel("File Location For Hosts");
		hostLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hostLabel.setBounds(98, 230, 200, 14);
		holder.add(hostLabel);
		
		studentLocation = new JTextField();
		studentLocation.setBounds(98, 186, 200, 20);
		holder.add(studentLocation);
		studentLocation.setColumns(10);
		studentLocation.setText(studentFilePath);
		
		hostLocation = new JTextField();
		hostLocation.setColumns(10);
		hostLocation.setBounds(98, 255, 200, 20);
		holder.add(hostLocation);
		hostLocation.setText(hostFilePath);
		
		JButton studentBrowse = new JButton("Browse...");
		studentBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

					//Read in the file name.  Open the explorer to that path, or open the
					//user folder if it does not find one.
					if(studentFilePath.equals(""))	
						myChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					else myChooser.setCurrentDirectory(new File(studentFilePath));
					int result = myChooser.showOpenDialog(studentBrowse);
					if (result == JFileChooser.APPROVE_OPTION)
						studentFilePath = myChooser.getSelectedFile().getAbsolutePath();
					studentLocation.setText(studentFilePath);
			}
		});
		studentBrowse.setBounds(308, 185, 89, 23);
		holder.add(studentBrowse);
		
		JButton hostBrowse = new JButton("Browse...");
		hostBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					//Read in the file name.  Open the explorer to that path, or open the
					//user folder if it does not find one.
					if(hostFilePath.equals(""))	
						myChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					else myChooser.setCurrentDirectory(new File(hostFilePath));
					int result = myChooser.showOpenDialog(hostBrowse);
					if (result == JFileChooser.APPROVE_OPTION)
						hostFilePath = myChooser.getSelectedFile().getAbsolutePath();
					hostLocation.setText(hostFilePath);

			}
		});
		hostBrowse.setBounds(308, 254, 89, 23);
		holder.add(hostBrowse);
		
		JLabel groupLabel = new JLabel("Group Name");
		groupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		groupLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		groupLabel.setBounds(98, 294, 200, 18);
		holder.add(groupLabel);
		
		groupHolder = new JComboBox<String>();
		groupHolder.setModel(new DefaultComboBoxModel<String>(new String[] {"", "UCO", "Women's Choir", "New Song", "Male Choral"}));
		groupHolder.setBounds(98, 323, 200, 20);
		holder.add(groupHolder);
		
		JButton groupBrowse = new JButton("Browse...");
		groupBrowse.setBounds(308, 322, 89, 23);
		holder.add(groupBrowse);
		
		JButton algorithmButton = new JButton("Create Groups");
		algorithmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentFilePath = studentLocation.getText();
				hostFilePath = hostLocation.getText();
				groupName = (String) groupHolder.getSelectedItem();
				importCall.runAlgorithm(groupName, studentFilePath, hostFilePath);
				fileWriter.println(studentFilePath);
				fileWriter.println(hostFilePath);
				fileWriter.close();
			}
		});
		algorithmButton.setBounds(154, 404, 160, 23);
		holder.add(algorithmButton);
	}
}
