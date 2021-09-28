package tienda;

import java.util.Scanner;
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
		
		// Creamos un nuevo Fabricante
		try {
			
			System.out.println("Ingrese el codigo del Fabricante:");
			codigo = Integer.parseInt(sc.nextLine());
			
			System.out.println("Ingrese el nombre del Fabricante:");
			nombre = sc.next();
			
			fabricanteService.crearFabricante(codigo, nombre); // Llamada del metodo mediante el service
			
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
		}
		
		// Eliminamos un fabricante
		try {
			
			System.out.println("Ingrese el codigo del fabricante a eliminar:");
			codigo = Integer.parseInt(sc.nextLine());
			
			fabricanteService.eliminarFabricante(codigo);
			
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
		}
		
		// Listamos los fabricantes
		try {
			
			fabricanteService.imprimirFabricantes();
			
		} catch (Exception e) {
			e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
		}
		
	}

}
