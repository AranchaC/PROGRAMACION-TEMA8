package Reto1UT8;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Contacto implements Comparable<Contacto>, Serializable {
	
	private static final long serialVersionUID = -3545287747348204339L;
	protected String nombre;
	protected String telefono;

	public Contacto(String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}
		
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Telefono: " + telefono;
	}
	
	public String formatoAgenda() {
		return nombre+","+telefono;
	}
		
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		return Objects.equals(nombre, other.nombre);
	}	

	// Lee un nuevo Contacto desde teclado.
	// Devuelve null si se dejan vacíos el nombre o el teléfono
	public static Contacto deTeclado(Scanner entrada) {
		System.out.print("Dame el nombre: ");
		String nombre = entrada.nextLine();
		if (nombre.isBlank()) return null;
		System.out.print("Dame el teléfono: ");
		String telefono = entrada.nextLine();
		if (telefono.isBlank()) return null;
		return new Contacto(nombre,telefono);
	}

	@Override
	public int compareTo(Contacto o) {
		return this.nombre.compareToIgnoreCase(o.nombre);
	}
	
	public static Contacto contactoFromCSV(String linea) {
		String nombre, telef;
		Contacto contacto = new Contacto (null,null);
		
		String[] lineaSep = linea.split(",");
		if (lineaSep != null) {
			nombre =lineaSep[0];
			telef = lineaSep[1];
			contacto = new Contacto(nombre,telef);
		}

		return contacto;
	}
}
