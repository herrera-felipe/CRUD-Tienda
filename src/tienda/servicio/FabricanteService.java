package tienda.servicio;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 * Controla la logica para manejar Fabricantes
 * 
 * @author Felipe Herrera
 *
 */
public class FabricanteService {

	
	private FabricanteDAO dao; // Hacemos una relacion con el Dao de fabricante
	
	// Constructor
	public FabricanteService() {
		this.dao = new FabricanteDAO(); // Inicializamos el dao
	}
	
	/**
	 * Valida los datos pasados por parametro, y si todo esta Ok, crea un nuevo
	 * fabricante, llama al metodo guardarFabricante de la clase fabricanteDAO, 
	 * y este hace el registro en la Base De datos.
	 * 
	 * @param codigo
	 * @param nombre
	 * @throws Exception
	 */
	public void crearFabricante(Integer codigo, String nombre) throws Exception {
		
		try {
			// Validamos que el codigo no este vacio o tenga un valor negativo
			if (codigo == null || codigo < 0) {
				throw new Exception("Debe indicar un codigo valido de Fabricante");
			}
			
			// Validamos que el nombre no este vacio
			if (nombre == null || nombre.trim().isEmpty()) {
				throw new Exception("Debe indicar un nombre de Fabricante.");
			}
			
			// Validamos que el fabricante no exista en la BD
			if (buscarFabricantePorNombre(nombre) != null) {
				throw new Exception("Ya existe un fabricante con el nombre indicado.");
			}
			
			// Si no lanza excepcion Creamos el fabricante
			Fabricante nuevoFabricante = new Fabricante();
			nuevoFabricante.setCodigo(codigo);
			nuevoFabricante.setNombre(nombre);
			
			// Y con el dao llamamos al metodo guardar, para registrar el nuevoFabricante a la BD
			dao.guardarFabricante(nuevoFabricante);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
//	public void modificarNombreFabricante(Integer codigo, String nombre) {
//		
//	}
	
	/**
	 * Recibe un nombre por parametro y valida si existe o no el resgistro en la BD.
	 * Llamando al metodo buscarfabricantePorNombre de la clase FabricanteDAO
	 * 
	 * @param nombre
	 * @return Obj Fabricante si existe en la BD
	 * @throws Exception
	 */
	public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
		
		try {
			
			// Validamos
			if (nombre == null || nombre.trim().isEmpty()) {
				throw new Exception("Debe indicar el nombre del Fabricante.");
			}
			
			// Usamos el dao para llamar al metodo y traer el resultado.
			Fabricante fabricante = dao.buscarFabricantePorNombre(nombre);
			
			return fabricante;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Recibe un nombre por parametro y valida si existe o no el resgistro en la BD.
	 * Llamando al metodo buscarfabricantePorNombre de la clase FabricanteDAO
	 * 
	 * @param nombre
	 * @return Obj Fabricante si existe en la BD
	 * @throws Exception
	 */
	public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {
		
		try {
			
			// Validamos
			if (codigo == null) {
				throw new Exception("Debe indicar el codigo del Fabricante.");
			}
			
			// Usamos el dao para llamar al metodo y traer el resultado.
			Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);
			
			return fabricante;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Recibe el codigo por parameto y llama al metodo eliminarFabricante
	 * de la clase FabricanteDAO
	 * 
	 * @param codigo
	 * @throws Exception
	 */
	public void eliminarFabricante(Integer codigo) throws Exception {
		
		try {
			
			// Validamos
			if (codigo == null) {
				throw new Exception("Debe indicar el codigo del Fabricante a eliminar.");
			}
			
			// Usamos el dao para llamar al metodo y eliminar el registro
			dao.eliminarFabricante(codigo);
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * llama al metodo listarFabricantes del DAO y crea la lista con los registros de la tabla.
	 * Dicha lista servira para imprimir o mostrar los registros por pantalla.
	 * 
	 * @return fabricantes equivale a una lista con todos los registros de la tabla
	 * @throws Exception
	 */
	public Collection<Fabricante> listarFabricantes() throws Exception {
		
		try {
			
			Collection<Fabricante> fabricantes = dao.listarFabricantes();
			
			return fabricantes;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Llama al metodo listarFabricantes del service, para mostrar los registros de la tabla Fabricante
	 */
	public void imprimirFabricantes() throws Exception {
		
		try {
			
			// Listamos los fabricantes
			Collection<Fabricante> fabricantes = listarFabricantes();
			
			// Imprimimos o mostramos los fabricantes
			if (fabricantes.isEmpty()) {
				throw new Exception("No existen fabricantes para imprimir.");
			} else {
				// iteramos en un for para mostrar todos los registros
				for (Fabricante f : fabricantes) {
					System.out.println(f);
				}
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
}
