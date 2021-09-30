package tienda.servicio;

import java.util.Collection;
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
	
	/**
	 * Recibe un codigo por parametro y valida si existe o no el resgistro en la BD.
	 * Llamando al metodo buscarProductoPorCodigo de la clase ProductoDAO
	 * 
	 * @param codigo
	 * @return Obj Producto si existe en la BD
	 * @throws Exception
	 */
	public Producto buscarProductoPorCodigo(Integer codigo) throws Exception {
		
		try {
			// Validamos
			if (codigo == null) {
				throw new Exception("Debe indicar el codigo del Producto.");
			}
			
			// Usamos el dao para llamar al metodo y traer el resultado.
			Producto producto = dao.buscarProductoPorCodigo(codigo);
			
			return producto;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * llama al metodo listarProductos del DAO y crea la lista con los registros de la tabla.
	 * Dicha lista servira para imprimir o mostrar solo los nombres de los  registros por pantalla.
	 * 
	 * @return productos equivale a una lista con todos los registros de la tabla
	 * @throws Exception
	 */
	public Collection<Producto> listarProductos() throws Exception {
		
		try {
			
			Collection<Producto> productos = dao.listarProductos();
			
			return productos;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Llama al metodo listarPorNombre de la clase DAO y le pasa el parametro nombre
	 * 
	 * @param nombre para filtrar la busqueda
	 * @return
	 * @throws Exception
	 */
	public Collection<Producto> listarPorNombre(String nombre) throws Exception {
		
		try {
			
			Collection<Producto> productos = dao.listarPorNombre(nombre);
			
			return productos;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 
	 * @param nombre
	 * @throws Exception
	 */
	public void imprimirPorNombre(String nombre) throws Exception {

		try {

			// Listamos los fabricantes
			Collection<Producto> nombreProductos = listarPorNombre(nombre);

			// Imprimimos o mostramos los fabricantes
			if (nombreProductos.isEmpty()) {
				throw new Exception("No existen productos para imprimir.");
			} else {
				// iteramos en un for para mostrar los nombres de los productos
				for (Producto producto : nombreProductos) {
					System.out.println(producto.getNombre() + " = $" + producto.getPrecio());
				}
			}

		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Llama al metodo listarProductos del service, para mostrar solo los nombres de Producto
	 */
	public void imprimirNombreProductos() throws Exception {
		
		try {
			
			// Listamos los fabricantes
			Collection<Producto> nombreProductos = listarProductos();
			
			// Imprimimos o mostramos los fabricantes
			if (nombreProductos.isEmpty()) {
				throw new Exception("No existen productos para imprimir.");
			} else {
				// iteramos en un for para mostrar los nombres de los productos
				for (Producto producto : nombreProductos) {
					System.out.println(producto.getNombre());
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Imprime todos los datos de la tabla producto
	 */
	public void imprimirProductos() throws Exception {
		
		try {
			
			// Listamos los fabricantes
			Collection<Producto> nombreProductos = listarProductos();
			
			// Imprimimos o mostramos los fabricantes
			if (nombreProductos.isEmpty()) {
				throw new Exception("No existen productos para imprimir.");
			} else {
				// iteramos en un for para mostrar los nombres de los productos
				for (Producto producto : nombreProductos) {
					System.out.println(producto);
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Imprime todos los datos de la tabla producto
	 */
	public void imprimirNombrePrecioProductos() throws Exception {
		
		try {
			
			// Listamos los fabricantes
			Collection<Producto> nombreProductos = listarProductos();
			
			// Imprimimos o mostramos los fabricantes
			if (nombreProductos.isEmpty()) {
				throw new Exception("No existen productos para imprimir.");
			} else {
				// iteramos en un for para mostrar los nombres de los productos
				for (Producto producto : nombreProductos) {
					System.out.println(producto.getNombre() + " = $ " + producto.getPrecio());
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Imprime los productos filtrando por rango de precio
	 * 
	 * @param num1 equivale al rango de precio desde
	 * @param num2 equivale al rango de precio hasta
	 */
	public void imprimirPorRangoPrecio(Integer num1, Integer num2) throws Exception {
		
		try {
			// Validamos
			if (num1 == null || num2 == null || num1 <= 0 || num2 <= 0) {
				throw new Exception("Debe indicar un rango de precio valido.");
			}
			
			// Listamos los fabricantes
			Collection<Producto> nombreProductos = listarProductos();
			
			// Imprimimos o mostramos los fabricantes
			if (nombreProductos.isEmpty()) {
				throw new Exception("No existen productos para imprimir.");
			} else {
				// iteramos en un for para mostrar los nombres de los productos
				for (Producto producto : nombreProductos) {
					if (producto.getPrecio() >= num1 && producto.getPrecio() <= num2) {
						System.out.println("Nombre: " + producto.getNombre() + " = $" + producto.getPrecio());
					}
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void modificarProducto(Integer codigo, String nombre, Double precio, Integer codigo_fabricante) {
		try {
			// Validamos
			if (codigo == null) {
				throw new Exception("Debe indicar un codigo de Producto");
			}
			
			if (nombre == null || nombre.trim().isEmpty()) {
				throw new Exception("Debe indicar un nombre para el Producto.");
			}
			
			if (precio == null || precio <= 0) {
				throw new Exception("Debe indicar un precio valido para el producto.");
			}
			
			if (codigo_fabricante == null || codigo_fabricante <= 0) {
				throw new Exception("Debe indicar un codigo de fabricante valido.");
			}
			
			// Buscamos
			Producto producto = buscarProductoPorCodigo(codigo);
			
			// Validamos el codigo
			if (producto.getCodigo() != codigo) {
				throw new Exception("El codigo ingresado no esta registrado en la Base de Datos.");
			}
			
			// Modificamos
			producto.setNombre(nombre);
			producto.setPrecio(precio);
			producto.setCodigoFabricante(codigo_fabricante);
			
			dao.modificarProducto(producto);
			
		} catch (Exception e) {
		}
	}
}
