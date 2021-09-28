package tienda;

import java.util.logging.Level;
import java.util.logging.Logger;

import tienda.servicio.FabricanteService;

/**
 * 
 * @author Felipe Herrera
 *
 */
public class MainClass {

	
	public static void main(String[] args) {

		FabricanteService fabricanteService = new FabricanteService(); // Instanciamos el Service
		
		try {
			// Creamos un nuevo Fabricante
			fabricanteService.crearFabricante(10, "Nuevo Fabricante");
			
		} catch (Exception e) {
			Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
