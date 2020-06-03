package controlador;
import conexionBD.ConexionBD;
import modelo.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*


import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;


class consulta implements Runnable {

	boolean valido;
	ResultSet rs;
	String sql;
	
	public consulta(String ntabla) {

		this.sql = ntabla;
		
	}
	
	@Override
	public void run() {
		rs = new ConexionBD().ejecutarConsultaDeRegistros("SELECT * FROM " + sql);
	}

}

class HiloTabla implements Runnable{
	
	JTable table;
	consulta c;
	ResultSet rs;
	
	public HiloTabla(consulta c) {
		this.c = c;
		
	}
	
	@Override
	public void run() {

		rs = c.rs;
		
		CrearTabla tabla = new CrearTabla(rs);
		table = new JTable(tabla);
	}
	
	public JTable retornarTabla() {
		
		
		return table;
		
	}
	
}

class CrearTabla extends AbstractTableModel {

	private ResultSet rsRegistros;
	private java.sql.ResultSetMetaData metaData;

	public CrearTabla(ResultSet unResultSet) {

		this.rsRegistros = unResultSet;
		try { 
			e.printStackTrace();
		}
	}

	@Override
	public int getColumnCount() {

		try {
			return metaData.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int getRowCount() {

		try {
			rsRegistros.last();
			return rsRegistros.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public Object getValueAt(int arg0, int arg1) {

		try {
			rsRegistros.absolute(arg0 + 1);
			return rsRegistros.getObject(arg1 + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public String getColumnName(int c) {

		try {
			return metaData.getColumnName(c + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}*/
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
/*public JTable retornarTabla(String inst) {
	consulta c1 = new consulta(inst);
	HiloTabla ht1 = new HiloTabla(c1);
	
	Thread t1 = new Thread(c1);
	Thread t2 = new Thread(ht1);
	
	t1.start();
	try {
		t1.join();
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	t2.start();
	try {
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//CrearTabla modelo = new CrearTabla(new ConexionBD().ejecutarConsulta("SELECT * FROM " + inst));

	return ht1.retornarTabla();

}*/
public ArrayList<Paciente> buscarPa(String filtro){
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
	                rs.getString(6)
	                ));
			
			
		}while(rs.next());
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return listaPacientes;
	
}



}
