package tienda;

import java.util.Scanner;
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
		
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		
		int codigo;
		String nombre;
		
		try {
			// Creamos un nuevo Fabricante
//			System.out.println("Ingrese el codigo del Fabricante:");
//			codigo = Integer.parseInt(sc.nextLine());
//			
//			System.out.println("Ingrese el nombre del Fabricante:");
//			nombre = sc.next();
//			
//			// Prueba de Metodos
//			fabricanteService.crearFabricante(codigo, nombre); // Llamada del metodo mediante el service
			
//			fabricanteService.eliminarFabricante(codigo);
			
			fabricanteService.imprimirFabricantes();
		} catch (Exception e) {
			Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, e);
		}
	}

}
