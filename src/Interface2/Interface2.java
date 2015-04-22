package Interface2;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Interface2 extends JFrame {
	private static final long serialVersionUID = 1;
	
	private JPanel holder;
	private JTextField studentLocation;
	private JTextField hostLocation;
	

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
					Desktop.getDesktop().open(new File("c:\\"));
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
					Desktop.getDesktop().open(new File("c:\\"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		hostBrowse.setBounds(308, 319, 89, 23);
		holder.add(hostBrowse);
	}
}
