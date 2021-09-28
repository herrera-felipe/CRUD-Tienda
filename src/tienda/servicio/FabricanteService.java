package tienda.servicio;

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
	 * fabricante y lo guarda en la BD
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
	
	
	/**
	 * Recibe un nombre por parametro y valida si existe o no el resgistro en la BD.
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
}
