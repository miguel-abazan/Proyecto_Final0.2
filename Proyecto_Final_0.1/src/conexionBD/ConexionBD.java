package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private String r;

	static Connection conexion;
	//private Statement stm;// PROBLEMA: permite SQL INJECTION
	
	private PreparedStatement ps;
	
	private ResultSet rs;
	//Singlenton
	public static Connection getConnection () {
		//verifica que exista el conector de BD entre java y MySql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String URL = "jdbc:mysql://localhost:3306/registros_pacientes";
			String url = "jdbc:mysql://localhost:3306/registros_pacientes?useTimezone=true&serverTimezone=UTC";
			conexion = DriverManager.getConnection(url,"root","losdec211299");
			
			/*System.out.println("Conexion establecida!!!");
			System.out.println("Ya casi soy ISC =) ");*/
			
			
		} catch (ClassNotFoundException e) {
			//System.out.println("Error del DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			//System.out.println("Error en conexion  a MySQL");
			e.printStackTrace();
		}
		return conexion;
				
	}

	
	//metodo para ejecutar instrucciones DOL y DML (Altas, Bajas y Cambios, entre iotras)
	public boolean ejecutarInstrucciones(String sql) {
		
		try {
			
			ps = conexion.prepareStatement(sql);
			
			//stm = con.createStatement();
			
			int r = ps.executeUpdate(sql);
				return r == 1 ? true : false ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return false;
		
	}
	
	//metodos para Consultas(Instrucciones SQL, por ejemplo Selecte* from)
	public ResultSet ejecutarConsultaDeRegistros(String sql){
		ResultSet rs= null;
		try {
			ps = conexion.prepareStatement(sql);
		//stm = con.createStatement();
		
		return ps.executeQuery(sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return rs;
		}
		
	}
	
	public void cerrarConexion() {
		try {
			ps.close();
			conexion.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		new ConexionBD();

	}

	

	

}
