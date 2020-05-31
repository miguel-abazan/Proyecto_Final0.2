package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import modelo.Paciente;;

public class PacienteDAO {
	
	//metodos que permite realizar las operaciones ABCC
	
	public boolean agregarPaciente(Paciente a) {
		String sql = "INSERT INTO Datos_Pacientes VALUES('"+a.getFolioPaciente()+"',"
				                                 + "'"+a.getNomPaciente()+"',"
				                                 + "'"+a.getPrimApPa()+"','"
				                                 +a.getSegApPa()+"','"
				                                 +a.getDomicilio()+"','"
				                                 +a.getNumeroCel()+"');";	
		
		
		boolean resultado =  new ConexionBD().ejecutarInstrucciones(sql);
		System.out.println(resultado);
		
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
    					     +"',Segundo_Ap_Alumno='"+a.getSegApPa()
    					     +"', Num_Cel= "+a.getNumeroCel()
    					     +", Domicilio_Pa='"+a.getDomicilio()
    					     +"' WHERE Folio_Pa = '"+a.getFolioPaciente()+"'";
    			boolean res = new ConexionBD().ejecutarInstrucciones(sql);
    			System.out.println("Paciente DAO: " + res);
    			return res; 
	
    }
public Paciente buscarAlumno(String folioPa) {
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
				res.getInt(6)
				);
				
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return null;
		
	}
public ArrayList<Paciente> buscarAlumnos(String filtro){
	ArrayList<Paciente>listaPacientes=new ArrayList<>();
	String sql = "SELECT * FROM Datos_Pacientes";
	ResultSet rs = new ConexionBD().ejecutarConsultaDeRegistros(sql);
	
	try {
		rs.first();
		
		do {
			listaPacientes.add(new Paciente(rs.getString("Folio_Pa"),
	                rs.getString(2),
	                rs.getString(3),
	                rs.getString(4),
	                rs.getString(5),
	                rs.getInt(6)
	                ));
			
			
		}while(rs.next());
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listaPacientes;
	
}



}
