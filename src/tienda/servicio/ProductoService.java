package tienda.servicio;

import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.ProductoDAO;

/**
 * Control la logica para manejar Productos
 * 
 * @author Felipe Herrera
 *
 */
public class ProductoService {

	private ProductoDAO dao; // Hacemos una relacion con el DAO del producto
	
	// Constructor
	public ProductoService() {
		this.dao = new ProductoDAO(); // Inicializamos el DAO
	}
	
	 
	/**
	 * Valida los datos pasados por parametro, y si todo esta Ok, crea un nuevo
	 * producto; llama al metodo guardarProducto de la clase productoDAO, 
	 * y este hace el registro en la Base De datos.
	 * 
	 */
	public void crearProducto(Integer codigo, String nombre, Double precio, Integer codigo_fabricante) {
		
		try {
			// Validamos que el codigo no sea null o valor negativo
			if (codigo == null || codigo < 0) {
				throw new Exception("Deber indicar un codigo valido de Producto.");
			}
			
			// Validamos que el nombre no este vacio
			if (nombre == null || nombre.trim().isEmpty()) {
				throw new Exception("Debe indicar un nombre para el Producto.");
			}
			
			// Validamos que no exista un producto con el mismo nombre
			if (buscarProductoPorNombre(nombre) != null) {
				throw new Exception("Ya existe un Producto con el nombre indicado.");
			}
			
			// Validamos que el precio no sea null o negativo
			if (precio == null || precio <= 0) {
				throw new Exception("Debe indicar un precio valido para el Producto.");
			}
			
			if (codigo_fabricante == null || codigo_fabricante < 0) {
				throw new Exception("Debe indicar el codigo del fabricante del Producto.");
			}
			
			// Si no lanza ninguna excepcion creamos el Producto
			Producto nuevoProducto = new Producto();
			nuevoProducto.setCodigo(codigo);
			nuevoProducto.setNombre(nombre);
			nuevoProducto.setPrecio(precio);
			nuevoProducto.setCodigoFabricante(codigo_fabricante);
			
			// Y con el DAO llamamos al metodo guardarProducto, para crear el registro en la BD
			dao.guardarProducto(nuevoProducto);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Recibe un nombre por parametro y valida si existe o no el resgistro en la BD.
	 * Llamando al metodo buscarProductoPorNombre de la clase ProductoDAO
	 * 
	 * @param nombre
	 * @return Obj Producto si existe en la BD
	 * @throws Exception
	 */
	public Producto buscarProductoPorNombre(String nombre) throws Exception {
		
		try {
			
			// Validamos
			if (nombre == null || nombre.trim().isEmpty()) {
				throw new Exception("Debe indicar el nombre del Producto.");
			}
			
			// Usamos el dao para llamar al metodo y traer el resultado.
			Producto producto = dao.buscarProductoPorNombre(nombre);
			
			return producto;
			
		} catch (Exception e) {
			throw e;
		}
	}
}
