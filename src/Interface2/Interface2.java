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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JFileChooser;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JPanel panel;
	
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
			e1.printStackTrace();
		}
		if(myReader.hasNextLine())
			studentFilePath = myReader.nextLine();
		else studentFilePath = "";
		if(myReader.hasNextLine())
			hostFilePath = myReader.nextLine();
		else hostFilePath = "";
		if(myReader.hasNextLine())
			groupName = myReader.nextLine();
		else groupName = "";
		
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
				fileWriter.println(groupName);
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
		welcome.setBounds(40, 21, 350, 50);
		welcome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		welcome.setEditable(false);
		welcome.setBackground(new Color(0, 37, 84));
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setBorder(BorderFactory.createEmptyBorder());
		getContentPane().add(welcome);
		
		JEditorPane topBar = new JEditorPane();
		topBar.setBounds(0, 0, 444, 90);
		topBar.setEnabled(false);
		topBar.setEditable(false);
		topBar.setBackground(new Color(0, 37, 84));
		getContentPane().add(topBar);
		
		panel = new JPanel();
		panel.setBackground(new Color(226, 204, 168));
		panel.setBounds(54, 119, 336, 269);
		panel.setBorder(new LineBorder(Color.GRAY));
		holder.add(panel);
		panel.setLayout(null);
		
		JLabel studentLabel = new JLabel("File Location For Student");
		studentLabel.setBounds(20, 22, 200, 14);
		panel.add(studentLabel);
		studentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		studentLocation = new JTextField();
		studentLocation.setBounds(20, 47, 200, 20);
		panel.add(studentLocation);
		studentLocation.setColumns(10);
		studentLocation.setText(studentFilePath);
		
		JLabel hostLabel = new JLabel("File Location For Hosts");
		hostLabel.setBounds(20, 90, 200, 14);
		panel.add(hostLabel);
		hostLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hostLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton studentBrowse = new JButton("Browse...");
		studentBrowse.setBounds(230, 46, 89, 23);
		panel.add(studentBrowse);
		
		hostLocation = new JTextField();
		hostLocation.setBounds(20, 115, 200, 20);
		panel.add(hostLocation);
		hostLocation.setColumns(10);
		hostLocation.setText(hostFilePath);
		
		JButton hostBrowse = new JButton("Browse...");
		hostBrowse.setBounds(230, 114, 89, 23);
		panel.add(hostBrowse);
		
		JLabel groupLabel = new JLabel("Group Name");
		groupLabel.setBounds(20, 160, 200, 18);
		panel.add(groupLabel);
		groupLabel.setHorizontalAlignment(SwingConstants.LEFT);
		groupLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		groupHolder = new JComboBox<String>();
		groupHolder.setBounds(20, 189, 125, 20);
		panel.add(groupHolder);
		groupHolder.setModel(new DefaultComboBoxModel<String>(new String[] {"", "UCO", "Women's Choir", "New Song", "Male Choral"}));
		switch(groupName)
		{
		case "":
			groupHolder.setSelectedIndex(0);
			break;
		case "UCO":
			groupHolder.setSelectedIndex(1);
			break;
		case "Women's Choir":
			groupHolder.setSelectedIndex(2);
			break;
		case "New Song":
			groupHolder.setSelectedIndex(3);
			break;
		case "Male Choral":
			groupHolder.setSelectedIndex(4);
			break;
		}
		
		JButton algorithmButton = new JButton("Create Groups");
		algorithmButton.setEnabled(false);
		checkCreateGroupButton(algorithmButton);
		algorithmButton.setBounds(199, 224, 120, 23);
		panel.add(algorithmButton);
		algorithmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(algorithmButton.isEnabled())
				{
					studentFilePath = studentLocation.getText();
					hostFilePath = hostLocation.getText();
					importCall.runAlgorithm(groupName, studentFilePath, hostFilePath);
					fileWriter.println(studentFilePath);
					fileWriter.println(hostFilePath);
					fileWriter.println(groupName);
					fileWriter.close();
				}
			}
		});
		
		studentLocation.getDocument().addDocumentListener(new DocumentListener() {

		     public void removeUpdate(DocumentEvent e) {
		    	 doSomething();
		     }

		     public void insertUpdate(DocumentEvent e) {
		    	 doSomething();
		     }

		     public void changedUpdate(DocumentEvent e) {
		    	 doSomething();
		     }
		     
		     public void doSomething()
		     {
				studentFilePath = studentLocation.getText();
				checkCreateGroupButton(algorithmButton);
		     }
		  });
		
		hostLocation.getDocument().addDocumentListener(new DocumentListener() {

		     public void removeUpdate(DocumentEvent e) {
		    	 doSomething();
		     }

		     public void insertUpdate(DocumentEvent e) {
		    	 doSomething();
		     }

		     public void changedUpdate(DocumentEvent e) {
		    	 doSomething();
		     }
		     
		     public void doSomething()
		     {
				hostFilePath = hostLocation.getText();
				checkCreateGroupButton(algorithmButton);
		     }
		  });
		
		groupHolder.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				groupName = (String) groupHolder.getSelectedItem();
				checkCreateGroupButton(algorithmButton);
			}
		});
		
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
	}
	
	public void checkCreateGroupButton(JButton myButton)
	{
		if(!studentFilePath.equals("") && !hostFilePath.equals("") && !groupName.equals(""))
			myButton.setEnabled(true);
		else myButton.setEnabled(false);
	}
	
	public Color getPanelBackground() {
		return panel.getBackground();
	}
	public void setPanelBackground(Color background) {
		panel.setBackground(background);
	}
}
