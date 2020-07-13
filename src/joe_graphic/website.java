package joe_graphic;

//a very basic UI design of a login page i was creating

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class website {

	private JFrame frame;
	private JTextField username;
	private JLabel lblUsername;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					website window = new website();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public website() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 255, 47));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(117, 118, 56, 14);
		
		username = new JTextField();
		username.setBounds(180, 115, 105, 20);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(117, 164, 51, 14);
		
		JLabel lblLoginDetails = new JLabel("Login here:");
		lblLoginDetails.setBounds(191, 90, 80, 14);
		
		JCheckBox rememberDetails = new JCheckBox("Remember my details");
		rememberDetails.setBounds(174, 194, 127, 23);
		panel.setLayout(null);
		panel.add(lblUsername);
		panel.add(username);
		panel.add(lblNewLabel);
		panel.add(lblLoginDetails);
		panel.add(rememberDetails);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				String msg = "papa";
				if (username.getText().isEmpty() || username.isValid() == false)
				{    msg = "Please enter username";		}
				else if (password.getPassword().length == 0 || password.isValid() == false)
				{   msg = "Please enter password";		}
				else
				{	msg = "You have successfully logged in!";		}
				JOptionPane.showMessageDialog(null, msg);
			}
		});
		btnLogin.setBounds(180, 227, 89, 23);
		panel.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(324, 31, 89, 23);
		panel.add(btnSignUp);
		
		password = new JPasswordField();
		password.setBounds(180, 161, 105, 20);
		panel.add(password);
	}
}
