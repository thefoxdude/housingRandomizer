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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Interface2 extends JFrame {
	private static final long serialVersionUID = 1;
	
	private JPanel holder;
	private JTextField studentLocation;
	private JTextField hostLocation;
	
	PrintWriter fileWriter;
	FileReader excelFileLocationReader;
	BufferedReader myReader;
	String studentFilePath;
	String hostFilePath;
	JFileChooser myChooser;
	
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
		try {
			fileWriter = new PrintWriter("ExcelFileLocations.txt");
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			excelFileLocationReader = new FileReader("ExcelFileLocations.txt");
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		myReader = new BufferedReader(excelFileLocationReader);
		studentFilePath = "";
		hostFilePath = "";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,460,460);
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
		studentLabel.setBounds(98, 178, 200, 14);
		holder.add(studentLabel);
		
		JLabel hostLabel = new JLabel("File Location For Hosts");
		hostLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hostLabel.setBounds(98, 295, 200, 14);
		holder.add(hostLabel);
		
		studentLocation = new JTextField();
		studentLocation.setBounds(98, 215, 200, 20);
		holder.add(studentLocation);
		studentLocation.setColumns(10);
		
		hostLocation = new JTextField();
		hostLocation.setColumns(10);
		hostLocation.setBounds(98, 320, 200, 20);
		holder.add(hostLocation);
		
		JButton studentBrowse = new JButton("Browse...");
		studentBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					//Read in the file name.  Open the explorer to that path, or open the
					//c drive if it does not find one.
					studentFilePath = myReader.readLine( );                                     
					if(myReader.readLine( ) == null)	
						myChooser = new JFileChooser("c:\\");
					else myChooser = new JFileChooser(studentFilePath);
					myChooser.showOpenDialog(studentBrowse);
					studentFilePath = myChooser.getSelectedFile().getAbsolutePath();
					fileWriter.write(studentFilePath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		studentBrowse.setBounds(308, 214, 89, 23);
		holder.add(studentBrowse);
		
		JButton hostBrowse = new JButton("Browse...");
		hostBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					//Read in the file name.  Open the explorer to that path, or open the
					//c drive if it does not find one.
					hostFilePath = myReader.readLine( );                                     
					if(myReader.readLine( ) == null)	
						myChooser = new JFileChooser("c:\\");
					else myChooser = new JFileChooser(hostFilePath);
					myChooser.showOpenDialog(hostBrowse);
					studentFilePath = myChooser.getSelectedFile().getAbsolutePath();

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		hostBrowse.setBounds(308, 319, 89, 23);
		holder.add(hostBrowse);
	}
}
