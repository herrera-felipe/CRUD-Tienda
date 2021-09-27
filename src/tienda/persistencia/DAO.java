/*
 * DAO = Data Access Object
 * Va ser nuestro orden o criterio para acceder a la informacion
 * de potenciales o futuros objetos.
 * Esta clase debera ser abstracta ya que no debe instanciarse.
 */

package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Felipe Herrera
 *
 */
public abstract class DAO {
	
	// Atributos
	protected Connection conexion = null;
	protected ResultSet resultado = null;
	protected Statement sentencia = null;
	
	// Constantes para conectarnos a la base de datos
	private final String USER = "root";
	private final String PASSOWORD = "root";
	private final String DATABASE = "tienda"; // nombre de la base de datos que vamos a usar
	private final String DRIVER = "com.mysql.jdbc.Driver"; // conector de base de datos
	
	// Metodos de la clase DAO
	
	/**
	 * Establece la conexion a la Base De datos
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected void conectarBaseDeDatos() throws ClassNotFoundException, SQLException {
		// planteamos que todo estara envuelto en un try/catch
		try {
			
			Class.forName(DRIVER); //Cargamos o registramos el driver.
			
			// se define la url de la BD
			String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE +"?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; 
			
			// Establecemos la conexion a la bd con la funcionalidad del DriverManager y el metodo getConnection
			conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSOWORD);
			
		} catch (ClassNotFoundException | SQLException ex) {
			throw ex;
		}
	}
	
	/**
	 * Valida si existen consultas abiertas para cerrarlas y desconectar la BD.
	 * Cierra el ResultSet, Statement y Connection.
	 * @throws Exception
	 */
	protected void desconectarBaseDeDatos() throws Exception {
		try {
			
			if (resultado != null) {
				resultado.close();
			}
			
			if (sentencia != null) {
				sentencia.close();
			}
			
			if (conexion != null) {
				conexion.close();
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * El metodo recibe una Query por parametro para ejecutar.
	 * @param sql equivale a la consulta sql a ejecutar, sea modificar, insertar o eliminar un registro
	 * @throws SQLException, ClassNotFoundException 
	 */
	protected void insertarModificarEliminar(String sql) throws Exception {
		try {
			
			conectarBaseDeDatos(); // 1ro llamado al metodo para conectar a la BD
			
			// 2do preparamos en el Statement la creacion de una sentencia SQL,
			// Usamos la variable conexion y llamamos el metodo .createStatement() 
			sentencia = conexion.createStatement();
			
			sentencia.executeUpdate(sql); // 3ro finalmente en la sentencia que se creo, la ejecutamos con el metodo .executeUpdate().
			
		} catch (SQLException | ClassNotFoundException ex) {
			throw ex;
		} finally {
			desconectarBaseDeDatos(); // 4to siempre despues de ejecutar una sentencia nos descaonectamos de la BD
		}
	}
	
	/**
	 * El metodo recibe la consulta sql para traer datos de la BD y los almacena en el ResultSet variable resultado.
	 * @param sqlequivale a la consulta a ejecutar para leer algun registro
	 * @throws Exception
	 */
	protected void consultarBaseDeDatos(String sql) throws Exception {
		try {
			conectarBaseDeDatos(); // Conectamos a la BD
			
			sentencia = conexion.createStatement(); // Preparamos la sentencia
			
			resultado = sentencia.executeQuery(sql); // Almacenamos el resultado de la consulta en el ResulSet
		} catch (Exception e) {
			throw e;
		}
		
	}
}
