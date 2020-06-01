package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexionBD.ConexionBD;
import modelo.Doctores;;

public class DoctoresDAO {
	public boolean agregarPaciente(Doctores a) {
		String sql = "INSERT INTO Datos_Doctores VALUES('"+a.getCedProf()+"',"
				                                 + "'"+a.getNombreDoc()+"',"
				                                 + "'"+a.getpApDoc()+"','"
				                                 +a.getsApDoc()+"','"
				                                 +a.getEspecialidad()+"');";	
		
		
		boolean resultado =  new ConexionBD().ejecutarInstrucciones(sql);
		System.out.println(resultado);
		
		return resultado; 
	}
	
    public boolean eliminarPaciente(String numFolio) {
    	//DELETE FROM Alumnos WHERE Num_Control = '3';
    			String sql = "DELETE FROM Datos_Doctores WHERE cd_prof = '"+numFolio+"'";
    			return new ConexionBD().ejecutarInstrucciones(sql);
		
	}
    public ArrayList<Doctores> buscarPa(String filtro){
    	ArrayList<Doctores>listaPacientes=new ArrayList<>();
    	String sql = "SELECT * FROM Datos_Pacientes";
    	ResultSet rs = new ConexionBD().ejecutarConsultaDeRegistros(sql);
    	
    	try {
    		rs.first();
    		
    		do {
    			listaPacientes.add(new Doctores(rs.getString("cd_prof"),
    	                rs.getString(2),
    	                rs.getString(3),
    	                rs.getString(4),
    	                rs.getString(5)
    	                ));
    			
    			
    		}while(rs.next());
    		
    		
    		
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	return listaPacientes;

}
}
