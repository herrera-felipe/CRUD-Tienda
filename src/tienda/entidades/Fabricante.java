package tienda.entidades;

/**
 * 
 * @author Felipe Herrera
 *
 */
public class Fabricante {

	// Atributos
	private int codigo;
	private String nombre;
	
	// Constructores
	public Fabricante() {
	}

	public Fabricante(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	//  Get & Set
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "[ Fabricante ] \ncodigo = " + codigo + " \nnombre = " + nombre;
	}
	
}
