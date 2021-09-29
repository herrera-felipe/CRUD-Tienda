package tienda;

import java.util.Scanner;

import tienda.servicio.FabricanteService;
import tienda.servicio.ProductoService;

/**
 * 
 * @author Felipe Herrera
 *
 */
public class MainClass {

	public static void main(String[] args) {

		FabricanteService fabricanteService = new FabricanteService(); // Instanciamos el Service
		
		ProductoService productoService = new ProductoService(); // Instanciamos el service

		Scanner sc = new Scanner(System.in).useDelimiter("\n");

		int codigo;
		String nombre;

		// A) Listamos los nombres de los productos
		try {
			System.out.println("[ NOMBRES PRODUCTOS ]");
			productoService.imprimirNombreProductos();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error del sistema por \n" + e.getMessage());
		}
		
		// B) Lista los nombres y los precios de los productos
		try {
			System.out.println("[ PRODUCTOS CON PRECIO ]");
			productoService.imprimirNombrePrecioProductos();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error del sistema por \n" + e.getMessage());
		}

		// G) Creamos un nuevo Fabricante
//		try {
//
//			System.out.println("Ingrese el codigo del Fabricante:");
//			codigo = Integer.parseInt(sc.nextLine());
//
//			System.out.println("Ingrese el nombre del Fabricante:");
//			nombre = sc.next();
//
//			fabricanteService.crearFabricante(codigo, nombre); // Llamada del metodo mediante el service
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error del sistema por \n" + e.getMessage());
//		}

	} // fin main

} // fin class
