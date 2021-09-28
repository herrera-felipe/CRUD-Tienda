package tienda.servicio;

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
}
