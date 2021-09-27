package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;

/**
 * 
 * @author Felipe Herrera
 *
 */
public final class ProductoDAO extends DAO {

	/**
	 * Recibe un Obj Producto por parametro para agregarlo a la BD.
	 * 
	 * @param producto nuevo Obj Producto creado por el usuario
	 * @throws Exception
	 */
	public void guardarProducto(Producto producto) throws Exception {

		try {
			// Si el producto es null, lanzamos excepcion
			if (producto == null) {
				throw new Exception("Debe indicar un Producto.");
			}

			// Sentencia SQL de INSERT
			String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante)" 
					+ " VALUES ( '" + producto.getCodigo() + "' , '" + producto.getNombre() 
					+ "' , '" + producto.getPrecio() + "' , '" + producto.getCodigoFabricante() + "' );";

			insertarModificarEliminar(sql); // Llamada al metodo heredado de la Clase DAO

		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Recibe el producto por parametro y lo modifica en la BD
	 * 
	 * @param producto
	 * @throws Exception
	 */
	public void modificarProducto(Producto producto) throws Exception {

		try {
			// Validamos que el producto recibido no este en null
			if (producto == null) {
				throw new Exception("Debe indicar un producto a modificar.");
			}

			// Sentencia SQL para modificar el producto
			String sql = "UPDATE producto SET" 
					+ "nombre = '" + producto.getNombre() + "' " 
					+ "precio = '" + producto.getPrecio() + "' " 
					+ "codigo_fabricante = '" + producto.getCodigoFabricante() + "' "
					+ "WHERE codigo = '" + producto.getCodigo() + "';" ;
			
			// Llamada al metodo heredado de la Clase DAO para pasar la sentencia
			insertarModificarEliminar(sql);
			
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Recibe el codigo de un producto por parametro, y si coincide con un 
	 * registro, lo Elimina de la BD.
	 * 
	 * @param codigo equivale al codigo del producto a eliminar
	 * @throws Exception
	 */
	public void eliminarProducto(int codigo) throws Exception {
		
		try {
			
			// Sentencia SQL
			String sql = "DELETE FROM producto WHERE codigo = '" + codigo + "';";
			
			insertarModificarEliminar(sql); // Pasamos la sentencia
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Recibe el nombre de un producto a buscar en la Base de Datos, 
	 * y construye un objeto con los datos traidos de la BD.
	 * 
	 * @param nombre que equivale al nombre del producto a buscar
	 * @return Un Obj producto con todos los datos traidos de la BD.
	 * @throws Exception
	 */
	public Producto buscarProductoPorNombre(String nombre) throws Exception {
		
		try {
			// Hacemos la consulta SQL
			String sql = "SELECT * FROM producto"
					+ "WHERE nombre LIKE = '%" + nombre + "%';";
			
			consultarBaseDeDatos(sql); // Pasamos la sentencia al metodo
			
			// Creamos un Obj que recibira los datos de la consulta
			Producto producto = null; 
			
			// Rellenamos el objeto con los datos traidos por el ResultSet
			while (resultado.next()) {
				// si en resultado hay algun valor proximo continua la iteracion del bucle y asignamos los valores
				
				producto = new Producto(); // Instanciamos el objeto
				
				// Asignamos los valores
				producto.setCodigo(resultado.getInt("codigo"));
				producto.setNombre(resultado.getString("nombre"));
				producto.setPrecio(resultado.getInt("precio"));
				producto.setCodigoFabricante(resultado.getInt("codigo_fabricante"));
			}
			
			desconectarBaseDeDatos(); // desconectamos al terminar la consulta
			
			return producto;
			
		} catch (Exception e) {
			// si hay error desconectamos de la BD y lanzamos la excepcion
			desconectarBaseDeDatos();
			throw e;
		}
	}
	
	/**
	 * Trae todos los datos de la tabla de la BD, y los almacena en un ArrayList.
	 * 
	 * @return listaProductos con todos los datos de la tabla.
	 * @throws Exception
	 */
	public Collection<Producto> listarProductos() throws Exception {
		
		try {
			// Consulta SQL para listar
			String sql = "SELECT * FROM producto;";
			
			consultarBaseDeDatos(sql); // Pasamos la consulta al metodo
			
			Producto producto = null; //Obj. que contendra los datos traidos para construir la lista
			
			Collection<Producto> listaProductos = new ArrayList<Producto>();
			
			// Iteramos el bucle para obtener los datos y rellenar la lista
			while (resultado.next()) {
				producto = new Producto();
				producto.setCodigo(resultado.getInt(1));
				producto.setNombre(resultado.getString(2));
				producto.setPrecio(resultado.getDouble(3));
				producto.setCodigoFabricante(resultado.getInt(4));
				
				// Agregamos el obj. a la lista
				listaProductos.add(producto);
			}
			
			// Terminada la consulta desconectamos de la BD
			desconectarBaseDeDatos();
			
			return listaProductos;
			
		} catch (Exception e) {
			e.printStackTrace(); // Imprime la pila de excepcion
			desconectarBaseDeDatos(); // desconectamos de bd
			throw new Exception("Error del Sistema."); // Lanzamos la Excepcion
		}
	}
}

