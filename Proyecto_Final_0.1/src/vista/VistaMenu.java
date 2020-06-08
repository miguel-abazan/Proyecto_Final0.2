package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import conexionBD.ConexionBD;
import controlador.DoctoresDAO;
import controlador.PacienteDAO;

import modelo.Paciente;




public class VistaMenu extends JFrame{
	JMenuBar menuBar;
	JMenu menuPacientes, menuDoctores, MenuCitasMedicas;
	JMenuItem menuAltas, menuBajas, menuCambios, menuConsultas,menuAltasDoc, menuBajasDoc;
	JInternalFrame IF_Altas, IF_Bajas, IF_Consultas,IF_Cambios, IF_Bajas_Doc;
	JTable miTabla1, miTabla2, miTabla3, miTabla4;
	JScrollPane miBarra1, miBarra2,miBarra3,miBarra4;
	
	
	public VistaMenu() {
		
			getContentPane().setLayout(new BorderLayout());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("======== Centro de Salud ========");
			
			setSize(700, 600);
			setLocationRelativeTo(null);
			
			setVisible(true);
			getContentPane().setBackground(Color.WHITE);	
		
			menuBar = new JMenuBar();
			menuPacientes = new JMenu("PACIENTES");
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
			menuPacientes.add(menuAltas);	
			
			
			
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
			menuPacientes.add(menuBajas);
			
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
			
			menuPacientes.add(menuCambios);
			
			
			
			menuConsultas = new JMenuItem("CONSULTAS");
			menuConsultas.setMnemonic(KeyEvent.VK_S);
			menuConsultas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			menuConsultas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Consultas.setVisible(true);
					}
				});
			menuPacientes.add(menuConsultas);
			
			
			menuBar.add(menuPacientes);
			
			menuDoctores = new JMenu("DOCTORES");
			menuBajasDoc = new JMenuItem("BAJAS"); 
			menuBajasDoc.setMnemonic(KeyEvent.VK_D);
			menuBajasDoc.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
			menuBajasDoc.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Bajas_Doc.setVisible(true);
					}
				});
			menuDoctores.add(menuBajasDoc);
			menuBar.add(menuDoctores);
			
			
			
			
			setJMenuBar(menuBar);
			
			
JDesktopPane desktopPane = new JDesktopPane();
			
			IF_Altas = new JInternalFrame();
				IF_Altas.getContentPane().setLayout(null);
				IF_Altas.setDefaultCloseOperation(HIDE_ON_CLOSE);
				IF_Altas.setTitle("Altas");
				IF_Altas.setSize(690, 550);
				
				IF_Altas.setMaximizable(true);
				IF_Altas.setIconifiable(true);
				IF_Altas.setClosable(true);
				IF_Altas.setResizable(true);
				IF_Altas.setLayout(null);
				
				JLabel label_fondo, label_txt, label_numCntrl, label_nombres, label_apPaterno, label_apMaterno, label_Domicilio, label_Num_Tel; 
				JTextField caja_folio_Paciente, caja_nombres, caja_apPaterno, caja_apMaterno, caja_domicilio, caja_num_cel;
				JButton btn_agregar, btn_borrar,btn_cancelar;
				
				label_txt = new JLabel("ALTAS PACIENTES");
				label_txt.setFont(new Font("Helvetica", Font.PLAIN, 30));
				label_txt.setForeground(Color.white);
				label_txt.setIcon(new ImageIcon("descarga.png"));
				label_txt.setBounds(60, 0, 684, 60);
				IF_Altas.add(label_txt);
				label_fondo = new JLabel(); 
				label_fondo.setBounds(0, 0, 684, 60); 
				label_fondo.setBackground(Color.GREEN);
				label_fondo.setOpaque(true);
				IF_Altas.add(label_fondo);
				
				label_numCntrl = new JLabel("FOLIO DEL PACIENTE:");
				label_numCntrl.setBounds(100, 95, 150, 10);
				IF_Altas.add(label_numCntrl);
				caja_folio_Paciente = new JTextField();
				caja_folio_Paciente.setBounds(250, 90, 170, 20);
				IF_Altas.add(caja_folio_Paciente);
				
				label_nombres = new JLabel("NOMBRES:");
				label_nombres.setBounds(100, 120, 150, 10);
				IF_Altas.add(label_nombres);
				caja_nombres = new JTextField();
				caja_nombres.setBounds(170, 115, 250, 20);
				IF_Altas.add(caja_nombres);
				
				label_apPaterno = new JLabel("APELLIDO PATERNO:");
				label_apPaterno.setBounds(100, 155, 150, 10);
				IF_Altas.add(label_apPaterno);
				caja_apPaterno = new JTextField();
				caja_apPaterno.setBounds(250, 150, 170, 20);
				IF_Altas.add(caja_apPaterno);
				
				label_apMaterno = new JLabel("APELLIDO MATERNO:");
				label_apMaterno.setBounds(100, 195, 150, 10);
				IF_Altas.add(label_apMaterno);
				caja_apMaterno = new JTextField();
				caja_apMaterno.setBounds(250, 190, 170, 20);
				IF_Altas.add(caja_apMaterno);
					
				label_Domicilio = new JLabel("DOMICILIO:");
				label_Domicilio.setBounds(100, 250, 150, 10);
				IF_Altas.add(label_Domicilio);
				caja_domicilio = new JTextField();
				caja_domicilio.setBounds(250, 245, 170, 20);
				IF_Altas.add(caja_domicilio);
				
				
				label_Num_Tel = new JLabel("NUMERO TELEFONICO:");
				label_Num_Tel.setBounds(100, 280, 150, 10);
				IF_Altas.add(label_Num_Tel);
				caja_num_cel = new JTextField();
				caja_num_cel.setBounds(250, 275, 170, 20);
				IF_Altas.add(caja_num_cel);
				
				miBarra1 = new JScrollPane();
				miBarra1.setBounds(90, 350, 460, 130);
				IF_Altas.add(miBarra1);
				construirTabla1();
				//mostrarDatosConTableModel();// mostramos la tabla
				
				btn_agregar = new JButton("AGREGAR");
				btn_agregar.setIcon(new ImageIcon("Iconos/agregar.png"));
				btn_agregar.setBounds(460, 100, 140, 35);
				IF_Altas.add(btn_agregar);
				btn_agregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(caja_apMaterno.getText().equals("") 
								|| caja_apPaterno.getText().equals("") 
								|| caja_nombres.getText().equals("") 
								|| caja_folio_Paciente.getText().equals("") 
								|| caja_domicilio.getText().equals("") 
								|| caja_num_cel.getText().equals("")){
							JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								boolean resultado = new PacienteDAO().agregarPaciente(new Paciente(caja_folio_Paciente.getText(),caja_nombres.getText(),
										caja_apPaterno.getText(),caja_apMaterno.getText(),caja_domicilio.getText(),caja_num_cel.getText()));
								JOptionPane.showMessageDialog(getParent(), "SE REGISTRO CORRECTAMENTE");
								
							} catch (Exception e) {
							JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);
							}
							construirTabla1();
							construirTabla2();
							construirTabla3();
							construirTabla4();
						}
						//mostrarDatosConTableModel();
						
					}
				}); //ACTION LISTENER AGREGAR
				btn_borrar = new JButton("Restablecer");
				btn_borrar.setIcon(new ImageIcon("Iconos/borrar.png"));

				btn_borrar.setBounds(460, 170, 180, 35);
				IF_Altas.add(btn_borrar);
				btn_borrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						caja_folio_Paciente.setText("");
						caja_nombres.setText("");
						caja_apPaterno.setText("");
						caja_apMaterno.setText("");
						caja_domicilio.setText("");
						caja_num_cel.setText("");
					}
				});//ACTION LISTENER BORRAR
				btn_cancelar = new JButton("CANCELAR");
				btn_cancelar.setIcon(new ImageIcon("Iconos/cancelar.png"));
				btn_cancelar.setBounds(460, 240, 140, 35);
				IF_Altas.add(btn_cancelar);
				
				
				
			desktopPane.add(IF_Altas); // agregar InternalFrame al DesktopPane
			add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal
			
			
			
			
			
			
			

			
			IF_Bajas = new JInternalFrame();
			IF_Bajas.getContentPane().setLayout(null);
			IF_Bajas.setDefaultCloseOperation(HIDE_ON_CLOSE);
			IF_Bajas.setTitle("BAJAS");
			IF_Bajas.setSize(690, 550);
			IF_Bajas.setMaximizable(true);
			IF_Bajas.setIconifiable(true);
			IF_Bajas.setClosable(true);
			IF_Bajas.setResizable(true);
			IF_Bajas.setLayout(null);
				
			JLabel lblF, lbltxtF,lblFolio, lbl_nom, lblpAp, lblApMaterno, lblDom, lblNumC;
			JTextField cajanumFo, cajanombre, cajaapPaterno, cajaapMaterno,cajaDom,cajaNumC;
			JButton btn_Eliminar, btnborrar,btncancelar,btnBuscar;
				
			lbltxtF = new JLabel("BAJAS PACIENTES");
			lbltxtF.setFont(new Font("Helvetica", Font.PLAIN, 30));
			lbltxtF.setForeground(Color.white);
			lbltxtF.setIcon(new ImageIcon("descarga.png"));
			lbltxtF.setBounds(60, 0, 684, 60);
				IF_Bajas.add(lbltxtF);
				lblF = new JLabel(); 
				lblF.setBounds(0, 0, 684, 60); 
				lblF.setBackground(Color.RED);
				lblF.setOpaque(true);
				IF_Bajas.add(lblF);
				
				lblFolio = new JLabel("FOLIO DEL PACIENTE:");
				lblFolio.setBounds(100, 95, 150, 10);
				IF_Bajas.add(lblFolio);
				cajanumFo = new JTextField();
				cajanumFo.setBounds(250, 90, 170, 20);
				IF_Bajas.add(cajanumFo);
				
				lbl_nom = new JLabel("NOMBRES:");
				lbl_nom.setBounds(100, 120, 150, 10);
				IF_Bajas.add(lbl_nom);
				cajanombre = new JTextField();
				cajanombre.setBounds(170, 115, 250, 20);
				IF_Bajas.add(cajanombre);
				
				lblpAp = new JLabel("APELLIDO PATERNO:");
				lblpAp.setBounds(100, 155, 150, 10);
				IF_Bajas.add(lblpAp);
				cajaapPaterno = new JTextField();
				cajaapPaterno.setBounds(250, 150, 170, 20);
				IF_Bajas.add(cajaapPaterno);
				
				lblApMaterno = new JLabel("APELLIDO MATERNO:");
				lblApMaterno.setBounds(100, 195, 150, 10);
				IF_Bajas.add(lblApMaterno);
				cajaapMaterno = new JTextField();
				cajaapMaterno.setBounds(250, 190, 170, 20);
				IF_Bajas.add(cajaapMaterno);
					
				lblDom = new JLabel("DOMICILIO:");
				lblDom.setBounds(100, 250, 150, 10);
				IF_Bajas.add(lblDom);
				cajaDom = new JTextField();
				cajaDom.setBounds(250, 245, 170, 20);
				IF_Bajas.add(cajaDom);
				
				
				lblNumC = new JLabel("NUMERO TELEFONICO:");
				lblNumC.setBounds(100, 280, 150, 10);
				IF_Bajas.add(lblNumC);
				cajaNumC = new JTextField();
				cajaNumC.setBounds(250, 275, 170, 20);
				IF_Bajas.add(cajaNumC);
				
				miBarra2 = new JScrollPane();
				miBarra2.setBounds(90, 350, 460, 130);
				IF_Bajas.add(miBarra2);
				
				construirTabla2();
							
				btn_Eliminar = new JButton("ELIMINAR");
				btn_Eliminar.setIcon(new ImageIcon("Iconos/eliminar1.png"));
				btn_Eliminar.setBounds(460, 100, 140, 35);
				IF_Bajas.add(btn_Eliminar);
				btn_Eliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							boolean res = new PacienteDAO().eliminarPaciente(cajanumFo.getText());
							JOptionPane.showMessageDialog(getParent(), "SE ELIMINO CORRECTAMENTE");
							
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(getParent(), "NO PUEDE DEJAR ESPACIOS VACIOS", "AVISO", JOptionPane.INFORMATION_MESSAGE);
						}
						// mostramos la tabla
						construirTabla1();
						construirTabla2();
						construirTabla3();
						construirTabla4();
					}
				}); //ACTION LISTENER AGREGAR
				btnborrar = new JButton();
				btnborrar.setIcon(new ImageIcon("Iconos/borrar.png"));

				btnborrar.setBounds(460, 170, 40, 35);
				IF_Bajas.add(btnborrar);
				btnborrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						cajanumFo.setText("");
						cajanombre.setText("");
						cajaapPaterno.setText("");
						cajaapMaterno.setText("");
						cajaDom.setText("");
						cajaNumC.setText("");
					}
				});//ACTION LISTENER BORRAR
				btncancelar = new JButton("CANCELAR");
				btncancelar.setIcon(new ImageIcon("Iconos/cancelar.png"));
				btncancelar.setBounds(460, 240, 140, 35);
				IF_Bajas.add(btncancelar);
			desktopPane.add(IF_Bajas); // agregar InternalFrame al DesktopPane
			add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal
			
			
			
			
			IF_Cambios = new JInternalFrame();
			IF_Cambios.getContentPane().setLayout(null);
			IF_Cambios.setDefaultCloseOperation(HIDE_ON_CLOSE);
			IF_Cambios.setTitle("MODIFICACIONES");
			IF_Cambios.setSize(690, 550);
			IF_Cambios.setMaximizable(true);
			IF_Cambios.setIconifiable(true);
			IF_Cambios.setClosable(true);
			IF_Cambios.setResizable(true);
			IF_Cambios.setLayout(null);
			
			JLabel lblf, lblt, lblfolio, lblNom, lblapPaterno, lblapMaterno, lblDomi, lblNumCel1; 
			JTextField cajafo, cajanom, cajapPa, cajaMa, cajadomi, cajanumcel;
			JButton btnMod, btnborr,btncan,btnbus;
			
			lblt = new JLabel("MODIFICAR PACIENTES");
			lblt.setFont(new Font("Helvetica", Font.PLAIN, 30));
			lblt.setForeground(Color.white);
			lblt.setIcon(new ImageIcon("Iconos/descarga.png"));
			lblt.setBounds(60, 0, 684, 60);
			IF_Cambios.add(lblt);
			lblf = new JLabel(); 
			lblf.setBounds(0, 0, 684, 60); 
			lblf.setBackground(Color.BLUE);
			lblf.setOpaque(true);
			IF_Cambios.add(lblf);
			
			lblfolio = new JLabel("FOLIO DEL PACIENTE:");
			lblfolio.setBounds(100, 95, 150, 10);
			IF_Cambios.add(lblfolio);
			cajafo = new JTextField();
			cajafo.setBounds(250, 90, 170, 20);
			IF_Cambios.add(cajafo);
			
			lblNom = new JLabel("NOMBRES:");
			lblNom.setBounds(100, 120, 150, 10);
			IF_Cambios.add(lblNom);
			cajanom = new JTextField();
			cajanom.setBounds(170, 115, 250, 20);
			IF_Cambios.add(cajanom);
			
			lblapPaterno = new JLabel("APELLIDO PATERNO:");
			lblapPaterno.setBounds(100, 155, 150, 10);
			IF_Cambios.add(lblapPaterno);
			cajapPa = new JTextField();
			cajapPa.setBounds(250, 150, 170, 20);
			IF_Cambios.add(cajapPa);
			
			lblapMaterno = new JLabel("APELLIDO MATERNO:");
			lblapMaterno.setBounds(100, 195, 150, 10);
			IF_Cambios.add(lblapMaterno);
			cajaMa = new JTextField();
			cajaMa.setBounds(250, 190, 170, 20);
			IF_Cambios.add(cajaMa);
				
			lblDomi = new JLabel("DOMICILIO:");
			lblDomi.setBounds(100, 250, 150, 10);
			IF_Cambios.add(lblDomi);
			cajadomi = new JTextField();
			cajadomi.setBounds(250, 245, 170, 20);
			IF_Cambios.add(cajadomi);
			  
			
			
			lblNumCel1 = new JLabel("NUMERO TELEFONICO:");
			lblNumCel1.setBounds(100, 280, 150, 10);
			IF_Cambios.add(lblNumCel1);
			cajanumcel = new JTextField();
			cajanumcel.setBounds(250, 275, 170, 20);
			IF_Cambios.add(cajanumcel);
			miBarra3 = new JScrollPane();
			miBarra3.setBounds(90, 350, 460, 130);
			IF_Cambios.add(miBarra3);
			
			construirTabla3();
			
			
			btnMod = new JButton("Modificar");
			btnMod.setIcon(new ImageIcon("Iconos/modificar.png"));
			btnMod.setBounds(460, 100, 140, 35);
			IF_Cambios.add(btnMod);
			btnMod.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						boolean res = new PacienteDAO().modificarPaciente(new Paciente(cajafo.getText(), cajanom.getText(), cajapPa.getText(), cajaMa.getText(),cajadomi.getText(),cajanumcel.getText()));
						JOptionPane.showMessageDialog(getParent(), "SE GUARDARON LOS CAMBIOS");
						} catch (Exception e2) {
						JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);	
						}
					construirTabla1();
					construirTabla2();
					construirTabla3();
					construirTabla4();
				}
			}); //ACTION LISTENER AGREGAR
						btnborr = new JButton();
						btnborr.setIcon(new ImageIcon("Iconos/borrar.png"));

						btnborr.setBounds(460, 170, 100, 35);
			IF_Cambios.add(btnborr);
			btnborr.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					cajafo.setText("");
				cajanom.setText("");
				cajapPa.setText("");
				cajaMa.setText("");
				cajadomi.setText("");
				cajanumcel.setText("");
				}
			});//ACTION LISTENER BORRAR
			btncan = new JButton("CANCELAR");
			btncan.setIcon(new ImageIcon("Iconos/cancelar.png"));
			btncan.setBounds(460, 240, 140, 35);
			IF_Cambios.add(btncan);
		desktopPane.add(IF_Cambios); // agregar InternalFrame al DesktopPane
		add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal
		
		
		
		
		
		
		IF_Consultas = new JInternalFrame();
		IF_Consultas.getContentPane().setLayout(null);
		IF_Consultas.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Consultas.setTitle("CONSULTAS");
		IF_Consultas.setSize(690, 550);
		IF_Consultas.setMaximizable(true);
		IF_Consultas.setIconifiable(true);
		IF_Consultas.setClosable(true);
		IF_Consultas.setResizable(true);
		IF_Consultas.setLayout(null);
		
		JLabel lblf1, lblt1; 
		JTextField cajafo1;
		JButton btnborr1,btncan1;
		
		
		
		lblt1 = new JLabel("CONSULTA PACIENTES");
		lblt1.setFont(new Font("Helvetica", Font.PLAIN, 30));
		lblt1.setForeground(Color.white);
		lblt1.setIcon(new ImageIcon("Iconos/descarga.png"));
		lblt1.setBounds(60, 0, 684, 60);
		IF_Consultas.add(lblt1);
		lblf1 = new JLabel(); 
		lblf1.setBounds(0, 0, 684, 60); 
		lblf1.setBackground(Color.YELLOW);
		lblf1.setOpaque(true);
		IF_Consultas.add(lblf1);
		
		
		
		
		
		cajafo1 = new JTextField();
		cajafo1.setBounds(160, 80, 170, 28);
		cajafo1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				buscarFolio(cajafo1.getText());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		IF_Consultas.add(cajafo1);
		
		miBarra4 = new JScrollPane();
		miBarra4.setBounds(90, 140, 453, 250);
		IF_Consultas.add(miBarra4);
		construirTabla4();
		
		JLabel lblDomi11 = new JLabel("BUSCAR FOLIO:");
		lblDomi11.setIcon(new ImageIcon("Iconos/buscar.png"));
		lblDomi11.setBounds(25, 80, 150, 32);
		IF_Consultas.add(lblDomi11);
		
		
		btnborr1 = new JButton("RESTAURAR");
		btnborr1.setIcon(new ImageIcon("Iconos/restore.png"));

		btnborr1.setBounds(20, 460, 150, 32);
		IF_Consultas.add(btnborr1);
		btnborr1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cajafo1.setText("");
			
			}
		});//ACTION LISTENER BORRAR
		btncan1 = new JButton("CANCELAR");
		btncan1.setIcon(new ImageIcon("Iconos/x.png"));
		btncan1.setBounds(460, 460, 140, 32);
		IF_Consultas.add(btncan1);
	desktopPane.add(IF_Consultas); // agregar InternalFrame al DesktopPane
	add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal
	
			
			

}
	
	
	private void construirTabla1() {
		String titulos[]={ "Folio", "Nombre", "Primer Ap", "Segundo Ap","Domicilio","Numero Cel" };
		String informacion[][]=obtenerMatriz();
		
		miTabla1=new JTable(informacion,titulos);
		miBarra1.setViewportView(miTabla1);
		
	}
	private void construirTabla2() {
		String titulos[]={ "Folio", "Nombre", "Primer Ap", "Segundo Ap","Domicilio","Numero Cel" };
		String informacion[][]=obtenerMatriz();
		
		miTabla2=new JTable(informacion,titulos);
		miBarra2.setViewportView(miTabla2);
		
	}
	private void construirTabla3() {
		String titulos[]={ "Folio", "Nombre", "Primer Ap", "Segundo Ap","Domicilio","Numero Cel" };
		String informacion[][]=obtenerMatriz();
		
		miTabla3=new JTable(informacion,titulos);
		miBarra3.setViewportView(miTabla3);
		
	}
	private void construirTabla4() {
		String titulos[]={ "Folio", "Nombre", "Primer Ap", "Segundo Ap","Domicilio","Numero Cel" };
		String informacion[][]=obtenerMatriz();
		
		miTabla4=new JTable(informacion,titulos);
		miBarra4.setViewportView(miTabla4);
		
	}
	private String[][] obtenerMatriz() {
		
		PacienteDAO miPersonaDao=new PacienteDAO();
		ArrayList<Paciente>miLista=miPersonaDao.buscarUsuariosConMatriz();
		
		String matrizInfo[][]=new String[miLista.size()][6];
		
		for (int i = 0; i < miLista.size(); i++) {
			matrizInfo[i][0]=miLista.get(i).getFolioPaciente()+"";
			matrizInfo[i][1]=miLista.get(i).getNomPaciente()+"";
			matrizInfo[i][2]=miLista.get(i).getPrimApPa()+"";
			matrizInfo[i][3]=miLista.get(i).getSegApPa()+"";
			matrizInfo[i][4]=miLista.get(i).getDomicilio()+"";
			matrizInfo[i][5]=miLista.get(i).getNumeroCel()+"";
		}
			
		return matrizInfo;
	}
	public void buscarFolio(String filtro) {
		DefaultTableModel tabla;
		String t_Columna[]= {"Folio", "Nombre", 
				             "Primer Ap", "Segundo Ap",
				             "Domicilio","Numero Cel"};
		String filas[]= new String [6];
		Connection con;
		PreparedStatement pst;
		ResultSet rs;
		tabla = new DefaultTableModel(null,t_Columna);
		
		
		try {
			
			con= ConexionBD.getConnection();
			String consulta = "SELECT * FROM Datos_Pacientes WHERE Nom_Paciente LIKE"+ '"'+ filtro + "%" +'"';
			pst= con.prepareStatement(consulta);
			rs=pst.executeQuery();
			
			while(rs.next()) {
				
				filas[0]= rs.getString(1);
				filas[1]= rs.getString(2);
				filas[2]= rs.getString(3);
				filas[3]= rs.getString(4);
				filas[4]= rs.getString(5);
				filas[5]= rs.getString(6);
				tabla.addRow(filas);
				
			}
			
			miTabla4.setModel(tabla);
				
		} catch (Exception e) {
			// TODO: handle exception
		}
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

