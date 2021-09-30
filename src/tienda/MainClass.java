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

		int codigo, codigo_fabricante ,num1, num2;
		String nombre;
		double precio;

		// A) Listamos los nombres de los productos
//		try {
//			System.out.println("[ NOMBRES PRODUCTOS ]");
//			productoService.imprimirNombreProductos();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error del sistema por \n" + e.getMessage());
//		}
//		
//		
//		// B) Lista los nombres y los precios de los productos
//		try {
//			System.out.println("\n[ PRODUCTOS CON PRECIO ]");
//			productoService.imprimirNombrePrecioProductos();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error del sistema por \n" + e.getMessage());
//		}
		
//		// C) Listar por rango de precio
//		try {
//			System.out.println("\n[ PRODUCTOS POR RANGO DE PRECIO ]");
//			System.out.println("Ingrese los valores de rango de precio entre los que quiere filtrar los productos:");
//			num1 = Integer.parseInt(sc.nextLine());
//			num2 = Integer.parseInt(sc.nextLine());
//			
//			productoService.imprimirPorRangoPrecio(num1, num2);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error del sistema por \n" + e.getMessage());
//		}
		
		// D) Buscar producto por nombre
		try {
			System.out.println("\n[ BUSCAR PRODUCTO POR NOMBRE ]");
			System.out.println("Ingrese el nombre del producto:");
			nombre = sc.nextLine();

			productoService.imprimirPorNombre(nombre);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// H) Modificar producto a medias, el usuario debe seleccionar que valor modificar
//		try {
//			System.out.println("\n[ MODIFICACION DE PRODUCTO ]");
//			System.out.println("Ingrese el codigo del producto que desea modificar:");
//			codigo = Integer.parseInt(sc.nextLine());
//			
//			System.out.println("[ DATOS DEL PRODUCTO A MODIFICAR ]");
//			System.out.println(productoService.buscarProductoPorCodigo(codigo));
//			
//			System.out.println("\nIngrese el nuevo nombre del producto:");
//			nombre = sc.nextLine();
//			
//			System.out.println("Ingrese el precio del producto:");
//			precio = Double.parseDouble(sc.nextLine());
//			
//			System.out.println("Ingrese el codigo del fabricante del producto:");
//			codigo_fabricante = Integer.parseInt(sc.nextLine());
//			
//			productoService.modificarProducto(codigo, nombre, precio, codigo_fabricante);
//			productoService.imprimirNombreProductos();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error del sistema por \n" + e.getMessage());
//		}
//
//		// G) Creamos un nuevo Fabricante
//		try {
//
//			System.out.println("Ingrese el codigo del Fabricante:");
//			codigo_fabricante = Integer.parseInt(sc.nextLine());
//
//			System.out.println("Ingrese el nombre del Fabricante:");
//			nombre = sc.next();
//
//			fabricanteService.crearFabricante(codigo_fabricante, nombre); // Llamada del metodo mediante el service
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("Error del sistema por \n" + e.getMessage());
//		}

	} // fin main

} // fin class
