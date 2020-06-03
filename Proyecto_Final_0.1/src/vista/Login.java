package vista;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import conexionBD.ConexionBD;




class Login extends JFrame {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	public Login() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		// setResizable(false);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.white);

		JLabel lb1 = new JLabel("Usuario");
		lb1.setBounds(170, 30, 100, 20);
		add(lb1);

		JTextField t1 = new JTextField();
		t1.setBounds(170, 60, 150, 25);
		add(t1);

		JLabel lb2 = new JLabel("Contraseña");
		lb2.setBounds(170, 95, 100, 20);
		add(lb2);

		JTextField t2 = new JTextField();
		t2.setBounds(170, 115, 150, 25);
		add(t2);

		JButton b1 = new JButton("Ingresar");
		b1.setBounds(190, 155, 100, 25);
		add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String user = t1.getText();
			String pasw= t2.getText();
			if (user.equals("")||pasw.equals("")) {
				JOptionPane.showMessageDialog(getParent(), 
						"LLENAR DATOS");
			} else {
				try {
					 con= ConexionBD.getConnection();
					 pst = con.prepareStatement("SELECT * FROM usuario WHERE user=? and pass=?");
					 pst.setString(1, user);
					 pst.setString(2, pasw);
					 rs = pst.executeQuery();
					 if (rs.next()) {
						 VistaMenu gui = new VistaMenu();
						 gui.setVisible(true);
						 setVisible(false);
						 
						
					}else
						JOptionPane.showMessageDialog(getParent(), 
								"Contraseña y Usuario Incorrectos Intenta de nuevo");
					
				} catch (Exception e2) {
					// TODO: handle exception
					
				}
			}
			
			
			
			
			}
		});
	}


public static void main(String[] args) {
	
	SwingUtilities.invokeLater(new Runnable() {

		@Override
		public void run() {
			new Login();

		}
	});
	
	
}

}

		
		
		
	