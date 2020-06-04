package controlador;
import conexionBD.ConexionBD;
import modelo.Paciente;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PacienteDAO {
	static PreparedStatement pst;
	static ResultSet rs;
	//metodos que permite realizar las operaciones ABCC
	
	public boolean agregarPaciente(Paciente a) {
		String sql = "INSERT INTO Datos_Pacientes VALUES('"+a.getFolioPaciente()+"',"
				                                 + "'"+a.getNomPaciente()+"',"
				                                 + "'"+a.getPrimApPa()+"','"
				                                 +a.getSegApPa()+"','"
				                                 +a.getDomicilio()+"','"
				                                 +a.getNumeroCel()+"');";	
		
		
		boolean resultado =  new ConexionBD().ejecutarInstrucciones(sql);
		//System.out.println(resultado);
		
		return resultado; 
	}
	
    public boolean eliminarPaciente(String numFolio) {
    	//DELETE FROM Alumnos WHERE Num_Control = '3';
    			String sql = "DELETE FROM Datos_Pacientes WHERE Folio_Pa = '"+numFolio+"'";
    			return new ConexionBD().ejecutarInstrucciones(sql);
		
	}
    public boolean modificarPaciente(Paciente a) {
    	//UPDATE Alumnos SET Nombre_Alumno='Juanito', Primer_Ap_Alumno='x', Segundo_Ap_Alumno='x', 
    			//Edad_Alumno=5, Semestre=4, Carrera='ISC' WHERE Num_Control = '180';
    			String sql = "UPDATE Datos_Pacientes SET Nom_Paciente='"+a.getNomPaciente()+"', "
    					     + "Prim_Ap_Paciente='"+a.getPrimApPa()
    					     +"',Seg_Ap_Paciente='"+a.getSegApPa()
    					     +"', Num_Cel= "+a.getNumeroCel()
    					     +", Domicilio_Pa='"+a.getDomicilio()
    					     +"' WHERE Folio_Pa = '"+a.getFolioPaciente()+"'";
    			boolean res = new ConexionBD().ejecutarInstrucciones(sql);
    			//System.out.println("Paciente DAO: " + res);
    			return res; 
	
    }
    public static Paciente buscar_re(String folio) {
		Paciente r= null;
		String sql= "SELECT * FROM Datos_Pacientes WHERE Folio_Pa= '"+folio+"'";
		try {
			
			 rs= pst.executeQuery(sql);
			//JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					//JOptionPane.ERROR_MESSAGE);

		} catch (Exception e) {
			// TODO: handle exception
		}
		r=asignar();
		return r;
	}
    
    public static Paciente asignar() {
    	Paciente r= null;
    	String folio;
    	String nombre;
    	String pAp;
    	String sAp;
    	String dom;
    	String numcel;
    	try {
			if(rs.first()) {
				folio=rs.getString("Folio_Pa");
				nombre= rs.getString("Nom_Paciente");
				pAp= rs.getString("Prim_Ap_Paciente");
				sAp= rs.getString("Seg_Ap_Paciente");
				dom= rs.getString("Domicilio_Pa");
				numcel= rs.getString("Num_Cel");
				
				r= new Paciente(folio,nombre,pAp,sAp,dom,numcel);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return r;
    }
  
public Paciente buscarPaciente(String folioPa) {
	//SELECT * FROM Alumno WHERE Num_Control='2';
	String sql= "SELECT * FROM Datos_Pacientes WHERE Folio_Pa= '"+folioPa+"'";	
	
	ResultSet res= new ConexionBD().ejecutarConsultaDeRegistros(sql);
	
	try {
		res.last();
		
		return new Paciente(res.getString("Folio_Pa"),
				res.getString(2),
				res.getString(3),
				res.getString(4),
				res.getString(5),
				res.getString(6)
				);
				
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
		
	}


public ArrayList<Paciente> buscarUsuariosConMatriz() {

	ConexionBD conex = new ConexionBD();
	ArrayList<Paciente> miLista = new ArrayList<Paciente>();
	Paciente persona;
	try {
		Statement estatuto = conex.getConnection().createStatement();
		ResultSet rs = estatuto.executeQuery("SELECT * FROM Datos_Pacientes ");

		while (rs.next()) {
			persona = new Paciente();
			persona.setFolioPaciente(rs.getString("Folio_Pa"));
			persona.setNomPaciente(rs.getString("Nom_Paciente"));
			persona.setPrimApPa(rs.getString("Prim_Ap_Paciente"));
			persona.setSegApPa(rs.getString("Seg_Ap_Paciente"));
			persona.setDomicilio(rs.getString("Domicilio_Pa"));
			persona.setNumeroCel(rs.getString("Num_Cel"));
			miLista.add(persona);
		}
		rs.close();
		estatuto.close();
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
				JOptionPane.ERROR_MESSAGE);

	}
	return miLista;
}

public void buscarUsuariosConTableModel(DefaultTableModel model) {

	ConexionBD conex = new ConexionBD();
	try {
		Statement estatuto = conex.getConnection().createStatement();
		ResultSet rs = estatuto.executeQuery("SELECT * FROM Datos_Pacientes ");

		while (rs.next()) {
			// es para obtener los datos y almacenar las filas
			Object[] fila = new Object[6];
			// para llenar cada columna con lo datos almacenados
			for (int i = 0; i < 6; i++)
				fila[i] = rs.getObject(i + 1);
			// es para cargar los datos en filas a la tabla modelo
			model.addRow(fila);

		}
	

	} catch (SQLException e) {
		System.out.println(e.getMessage());
		JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
				JOptionPane.ERROR_MESSAGE);

	}
}

}
