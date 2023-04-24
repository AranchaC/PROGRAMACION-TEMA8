
package Reto1UT8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AgendaList {

	protected static final int TAMANO_POR_DEFECTO = 100;

	protected List<Contacto> contactos; // A sustituir por un ArrayLIst
	protected int numElementos;

	public AgendaList(int tamano) {
		contactos = new ArrayList<Contacto> (TAMANO_POR_DEFECTO);
		numElementos = 0;
	}

	public AgendaList() { this(TAMANO_POR_DEFECTO); }
	
	public int numContactos() {
		return contactos.size();
	}
	
	public boolean vacia() {
		return contactos.isEmpty();
	}
	
	public String listaContactos() {
		contactos.sort(null);
		StringBuilder res = new StringBuilder();
		for (int i=0; i<contactos.size(); i++) {
			// Muestra posiciones de 1 a numelementos
			res.append(i+1);
			res.append(": ");
			res.append(contactos.get(i));
			res.append("\n");
		}
		return res.toString();
		//return contactos.toString();
	}

	public boolean anadeContacto(Contacto c) {
		return contactos.add(c);
	}

	public boolean borraContacto(int posicion) {
		return contactos.remove(posicion) != null;
	}

	public boolean reemplazaContacto(int posicion, Contacto c) {
		return contactos.set(posicion, c) != null;
	}

	public Contacto getContacto(int posicion) {
		return contactos.get(posicion);
	}

	public int buscaContacto (Contacto c) {
		return contactos.indexOf(c);
	}
	
	public boolean cargaDesdeCSV (String fileName){
		File ruta = new File (fileName);
		
		try (BufferedReader entrada = 
				new BufferedReader (new FileReader(ruta))){
			String linea;
			String nombre, telef;
			
			while ((linea=entrada.readLine()) != null) {				
				String[] lineaSep = linea.split(",");
				nombre =lineaSep[0];
				telef = lineaSep[1];
				
				Contacto contacto = new Contacto (nombre,telef);
				contactos.add(contacto);	

			}//while
			return true;
			
		} //try
		catch (IOException e) {
			return false;
		}//catch			
	}//cargaCSV
	
	public boolean guardaEnCSV (String fileName) {
		try (PrintWriter salida = 
				new PrintWriter(new FileWriter (fileName));) {
			for (int i=0; i<contactos.size(); i++) {
				salida.println(contactos.get(i).formatoAgenda() );
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return false;	
	}//guardaCSV

}
