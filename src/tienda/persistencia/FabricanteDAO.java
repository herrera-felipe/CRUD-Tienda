package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;

import tienda.entidades.Fabricante;

/**
 * 
 * @author Felipe Herrera
 *
 */
public final class FabricanteDAO extends DAO {

	/**
	 * Recibe un fabricante por parametros, valida que este no sea null. Y si esta
	 * todo Ok lo almacenara en la BD.
	 * 
	 * @param fabricante equivale a Obj de tipo Fabricante creado por usuario.
	 */
	public void guardarFabricante(Fabricante fabricante) throws Exception {

		try {
			// Si el usuario es null lanzamos una excepcion
			if (fabricante == null) {
				throw new Exception("Debe indicar un Fabricante.");
			}

			// Sentencia Sql a ejecutar para hacer el INSERT en la BD
			String sql = "INSERT INTO fabricante (codigo, nombre)" 
					+ " VALUES ( '" + fabricante.getCodigo() + "' , '" + fabricante.getNombre() + "' );";

			/*
			 * Llamada al metodo heredado de la clase DAO, para modificar insertar o eliminar.
			 * Y pasamos como parametro nuestra sentencia sql de Insert
			 */
			insertarModificarEliminar(sql);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Recibe el fabricante a modificar, valida que no sea null.
	 * Y si esta Ok realiza los cambios en la BD
	 * @param fabricante
	 * @throws Exception
	 */
	public void modificarFabricante(Fabricante fabricante) throws Exception {

		try {
			// Si el usuario es null lanzamos una excepcion
			if (fabricante == null) {
				throw new Exception("Debe indicar el Fabricante a modificar.");
			}

			// Sentencia Sql a ejecutar para hacer el UPDATE en la BD
			String sql = "UPDATE fabricante SET" 
					+ "nombre = '" + fabricante.getNombre() + "' "
					+ "WHERE codigo = '" + fabricante.getCodigo() + "';";

			/*
			 * Llamada al metodo heredado de la clase DAO, para modificar insertar o eliminar.
			 * Y pasamos como parametro nuestra sentencia sql de UPDATE
			 */
			insertarModificarEliminar(sql);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Recibe el codigo del fabricante por parametro que se desea eliminar de la BD.
	 * 
	 * @param codigo equivalente al codigo del fabricante
	 * @throws Exception
	 */
	public void eliminarFabricante(int codigo) throws Exception {

		try {

			// Sentencia Sql a ejecutar para hacer el UPDATE en la BD
			String sql = "DELETE FROM fabricante WHERE codigo = '" + codigo + "';";

			/*
			 * Llamada al metodo heredado de la clase DAO, para modificar insertar o eliminar.
			 * Y pasamos como parametro nuestra sentencia sql de DELETE
			 */
			insertarModificarEliminar(sql); 
			
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Trae los datos del fabricante de la BD que coincidan con el codigo pasado
	 * por parametro.
	 * 
	 * @param codigo equivale al codigo del fabricante a consultar
	 * @return fabricante con los datos traidos de la BD
	 * @throws Exception
	 */
	public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception {

		try {
			
			// Hacemos la consulta SQL
			String sql = "SELECT * FROM fabricante" 
					+ " WHERE codigo = '" + codigo + "';";
			
			consultarBaseDeDatos(sql); // Llamada al metodo heredado para hacer la consulta
			
			// Creamos un Objeto que recibira los datos traidos de la BD
			Fabricante fabricante = null;
			
			// Bucle while para llenar los datos al obj usando la variable resultado de la clase padre DAO
			while (resultado.next()) {
				// si en resultado hay algun valor proximo continua la iteracion del bucle y asignamos los valores
				
				fabricante = new Fabricante(); // Se instancia el Objeto
				fabricante.setCodigo(resultado.getInt(1)); // 1 equivale a la primera columna de la tabla
				fabricante.setNombre(resultado.getString("nombre")); // tambien lo podemos asignar escribiendo directamente el nombre de la columna de la tabla
			}
			
			desconectarBaseDeDatos();
			
			return fabricante;
			
		} catch (Exception e) {
			// Si hay un error 1ro desconectamos la BD y luego lanzamos la excepcion
			desconectarBaseDeDatos();
			throw e;
		}
		
	}

	/**
	 * Trae todos los datos de la tabla y los almacena en un ArrayList.
	 * 
	 * @return listaFabricantes equivale a todos los datos traidos de la BD
	 * @throws Exception
	 */
	public Collection<Fabricante> listarFabricantes() throws Exception {
		
		try {
			// Consulta SQL que traera todos los datos de la tabla
			String sql = "SELECT codigo, nombre FROM fabricante;";
			
			consultarBaseDeDatos(sql); // Llamada al metodo Heredado
			
			Fabricante fabricante = null; // Creamos un objeto Fabricante que se usara para construir la lista con los datos obtenidos
			
			Collection<Fabricante> listaFabricantes = new ArrayList<>(); // Instanciamos la lista
			
			// Bucle para cargar los datos
			while (resultado.next()) {
				fabricante = new Fabricante(); // Instanciamos el Objeto
				fabricante.setCodigo(resultado.getInt(1));
				fabricante.setNombre(resultado.getString(2));
				listaFabricantes.add(fabricante); // Cargamos el objeto a la lista
			}
			
			// terminada la consulta desconectamos la BD
			desconectarBaseDeDatos();
			
			return listaFabricantes;
			
		} catch (Exception e) {
			e.printStackTrace();
			desconectarBaseDeDatos();
			throw new Exception("Error del sistema.");
		}
		
	}

}


