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
		double precio;
		int codigo_fabricante;

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
			System.out.println("\n[ PRODUCTOS CON PRECIO ]");
			productoService.imprimirNombrePrecioProductos();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error del sistema por \n" + e.getMessage());
		}
		
		
		// H) Modificar producto a medias, el usuario debe seleccionar que valor modificar
		try {
			System.out.println("\n[ MODIFICACION DE PRODUCTO ]");
			System.out.println("Ingrese el codigo del producto que desea modificar:");
			codigo = Integer.parseInt(sc.nextLine());
			
			System.out.println("[ DATOS DEL PRODUCTO A MODIFICAR ]");
			System.out.println(productoService.buscarProductoPorCodigo(codigo));
			
			System.out.println("\nIngrese el nuevo nombre del producto:");
			nombre = sc.nextLine();
			
			System.out.println("Ingrese el precio del producto:");
			precio = Double.parseDouble(sc.nextLine());
			
			System.out.println("Ingrese el codigo del fabricante del producto:");
			codigo_fabricante = Integer.parseInt(sc.nextLine());
			
			productoService.modificarProducto(codigo, nombre, precio, codigo_fabricante);
			productoService.imprimirNombreProductos();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error del sistema por \n" + e.getMessage());
		}

		// G) Creamos un nuevo Fabricante
		try {

			System.out.println("Ingrese el codigo del Fabricante:");
			codigo_fabricante = Integer.parseInt(sc.nextLine());

			System.out.println("Ingrese el nombre del Fabricante:");
			nombre = sc.next();

			fabricanteService.crearFabricante(codigo_fabricante, nombre); // Llamada del metodo mediante el service

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error del sistema por \n" + e.getMessage());
		}

	} // fin main

} // fin class
