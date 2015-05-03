package Interface;

import java.awt.Color;
import java.awt.Desktop;
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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1;
	
	private JPanel base;
	private JPanel controlContainer;

	private JTextField studentLocation;
	private JTextField hostLocation;
	private JTextField outputLocation;

	private JComboBox<String> groupHolder;
	
	PrintWriter fileWriter;
	Scanner myReader;
	String studentFilePath, hostFilePath, outputFilePath, groupName;
	JFileChooser myChooser;
	boolean genNewFile = false;
	
	private ImportFromExcel importCall = new ImportFromExcel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
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
			outputFilePath = myReader.nextLine();
		else outputFilePath = "";
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
				fileWriter.println(outputFilePath);
				fileWriter.println(groupName);
				fileWriter.close();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150,100,460,500);
		base = new JPanel();
		base.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(base);
		base.setBackground(new Color(226, 204, 168));
		base.setBounds(0, 0, 1000, 600);
		base.setLayout(null);
		
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
		
		controlContainer = new JPanel();
		controlContainer.setBackground(new Color(226, 204, 168));
		controlContainer.setBounds(54, 119, 336, 331);
		controlContainer.setBorder(new LineBorder(Color.GRAY));
		base.add(controlContainer);
		controlContainer.setLayout(null);
		
		JLabel studentLabel = new JLabel("File Location For Student");
		studentLabel.setBounds(20, 22, 200, 14);
		controlContainer.add(studentLabel);
		studentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		studentLocation = new JTextField();
		studentLocation.setBounds(20, 47, 200, 20);
		controlContainer.add(studentLocation);
		studentLocation.setColumns(10);
		studentLocation.setText(studentFilePath);
		
		JLabel hostLabel = new JLabel("File Location For Hosts");
		hostLabel.setBounds(20, 90, 200, 14);
		controlContainer.add(hostLabel);
		hostLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hostLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		JButton studentBrowse = new JButton("Browse...");
		studentBrowse.setBounds(230, 46, 89, 23);
		controlContainer.add(studentBrowse);
		
		hostLocation = new JTextField();
		hostLocation.setBounds(20, 115, 200, 20);
		controlContainer.add(hostLocation);
		hostLocation.setColumns(10);
		hostLocation.setText(hostFilePath);
		
		JButton hostBrowse = new JButton("Browse...");
		hostBrowse.setBounds(230, 114, 89, 23);
		controlContainer.add(hostBrowse);
		
		JLabel groupLabel = new JLabel("Group Name");
		groupLabel.setBounds(20, 233, 200, 18);
		controlContainer.add(groupLabel);
		groupLabel.setHorizontalAlignment(SwingConstants.LEFT);
		groupLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		groupHolder = new JComboBox<String>();
		groupHolder.setBounds(20, 262, 125, 20);
		controlContainer.add(groupHolder);
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
		algorithmButton.setBounds(199, 297, 120, 23);
		controlContainer.add(algorithmButton);
		
		JLabel outputLabel = new JLabel("File Location For Output");
		outputLabel.setHorizontalAlignment(SwingConstants.LEFT);
		outputLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		outputLabel.setBounds(20, 165, 200, 14);
		controlContainer.add(outputLabel);
		
		outputLocation = new JTextField();
		outputLocation.setText((String) null);
		outputLocation.setColumns(10);
		outputLocation.setBounds(20, 190, 200, 20);
		outputLocation.setText(outputFilePath);
		controlContainer.add(outputLocation);
		
		JButton outputBrowse = new JButton("Browse...");
		outputBrowse.setBounds(230, 189, 89, 23);
		controlContainer.add(outputBrowse);
		algorithmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(algorithmButton.isEnabled())
				{
					studentFilePath = studentLocation.getText();
					hostFilePath = hostLocation.getText();
					importCall.runAlgorithm(groupName, studentFilePath, hostFilePath, outputFilePath, genNewFile);
					
					try {
						Desktop.getDesktop().open(new File(outputFilePath));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					fileWriter.println(studentFilePath);
					fileWriter.println(hostFilePath);
					fileWriter.println(outputFilePath);
					fileWriter.println(groupName);
					fileWriter.close();
					System.exit(0);
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
		
		outputLocation.getDocument().addDocumentListener(new DocumentListener() {

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
				outputFilePath = outputLocation.getText();
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
					int result = myChooser.showDialog(hostBrowse, "Select");
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
					int result = myChooser.showDialog(studentBrowse, "Select");
					if (result == JFileChooser.APPROVE_OPTION)
						studentFilePath = myChooser.getSelectedFile().getAbsolutePath();
					studentLocation.setText(studentFilePath);
			}
		});
		outputBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					//Read in the file name.  Open the explorer to that path, or open the
					//user folder if it does not find one.
					if(outputFilePath.equals(""))	
						myChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					else myChooser.setCurrentDirectory(new File(outputFilePath));
					int result = myChooser.showDialog(outputBrowse, "Select");
					if (result == JFileChooser.APPROVE_OPTION)
					{
						if(myChooser.getSelectedFile().exists())
							genNewFile = false;
						else genNewFile = true;
						
						outputFilePath = myChooser.getSelectedFile().getAbsolutePath();
						outputLocation.setText(outputFilePath);
					}
			}
		});
	}
	
	public void checkCreateGroupButton(JButton myButton)
	{
		if(!studentFilePath.equals("") && !hostFilePath.equals("") && !outputFilePath.equals("") && !groupName.equals(""))
			myButton.setEnabled(true);
		else myButton.setEnabled(false);
	}
	
	public Color getPanelBackground() {
		return controlContainer.getBackground();
	}
	public void setPanelBackground(Color background) {
		controlContainer.setBackground(background);
	}
}
