package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class VistaMenu extends JFrame{
	JMenuBar menuBar;
	JMenu menuInicio;
	JMenuItem menuAltas, menuBajas, menuCambios, menuConsultas;
	JInternalFrame IF_Altas, IF_Bajas, IF_Consultas,IF_Cambios;
	
	public VistaMenu() {
		
			getContentPane().setLayout(new BorderLayout());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("======== Centro de Salud ========");
			
			setSize(700, 600);
			setLocationRelativeTo(null);
			setVisible(true);
			getContentPane().setBackground(Color.WHITE);	
		
			menuBar = new JMenuBar();
			menuInicio = new JMenu("PACIENTES");
			menuAltas = new JMenuItem("ALTAS");
			
			
			menuAltas.setMnemonic(KeyEvent.VK_A);
			menuAltas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
				menuAltas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Altas.setVisible(true);
					}
				});
			menuInicio.add(menuAltas);	
			
			
			
			menuBajas = new JMenuItem("BAJAS"); 
			menuBajas.setMnemonic(KeyEvent.VK_B);
			menuBajas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
			menuBajas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Bajas.setVisible(true);
					}
				});
			menuInicio.add(menuBajas);
			
			menuCambios = new JMenuItem("CAMBIOS");
			menuCambios.setMnemonic(KeyEvent.VK_C);
			menuCambios.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			menuCambios.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Cambios.setVisible(true);
					}
				});
			
			menuInicio.add(menuCambios);
			
			
			
			menuConsultas = new JMenuItem("CONSULTAS");
			menuConsultas.setMnemonic(KeyEvent.VK_S);
			menuConsultas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			menuConsultas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menuConsultas.setVisible(true);
					}
				});
			menuInicio.add(menuConsultas);
			
			
			menuBar.add(menuInicio);
			setJMenuBar(menuBar);
			

}
public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new VistaMenu();

			}
		});
		
		
	}

}

