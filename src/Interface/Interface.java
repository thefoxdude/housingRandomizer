package Interface;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Interface extends JFrame {
	private static final long serialVersionUID = 1;
	
	private int numOfStudents = 0;
	private int numOfHosts = 0;
	
	private JPanel holder;
	private Home home = new Home();
	private Students students = new Students();
	private Hosts hosts = new Hosts();
	
	private JButton enter = new JButton();
	private JButton moveToHosts = new JButton();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 1015, 600);
		holder = new JPanel();
		holder.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(holder);
		holder.setLayout(null);
		
		enter = home.getEnter();
		enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				numOfStudents = home.getNumOfStudents();
				try {
					students.populateStudents();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				students.setNumOfStudents(numOfStudents);
				home.setVisible(false);
				students.setVisible(true);
				hosts.setVisible(false);
			}
		});
		
		moveToHosts = students.getMoveToHosts();
		moveToHosts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				numOfHosts = home.getNumOfHosts();
				try {
					hosts.populateHosts();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				hosts.setNumOfHosts(numOfHosts);
				home.setVisible(false);
				students.setVisible(false);
				hosts.setVisible(true);
			}
		});
		
		// adding the panels
		add(home);
		add(students);
		add(hosts);
		
		// setting visibility
		home.setVisible(true);
		students.setVisible(false);
		hosts.setVisible(false);
	}
}
