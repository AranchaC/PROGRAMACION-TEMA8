
package Reto1UT8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AgendaList implements Serializable {

	private static final long serialVersionUID = 1L;

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
		contactos.sort(null) ;
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
			while ((linea=entrada.readLine()) != null) {								
				Contacto contacto = Contacto.contactoFromCSV(linea);
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
			}//for	
		} catch (IOException e) {
			e.printStackTrace();
		}//catch				
		return false;	
	}//guardaCSV
	
	public boolean guardaEnArchivoSerializado (String fileName) {
		try (ObjectOutputStream salida = 
				new ObjectOutputStream(new FileOutputStream(fileName))){
			salida.writeObject(contactos);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;	
		} catch (IOException e) {
			e.printStackTrace();
			return false;	
		}
	}//guardaSerial
	
	public boolean cargaDesdeArchivoSerializado(String fileName) {
		File ruta = new File (fileName);
		try (ObjectInputStream entrada = new ObjectInputStream(
				new FileInputStream(ruta))) {
				ArrayList<Contacto> contact =
						(ArrayList<Contacto>) entrada.readObject();
				contactos.addAll(contact);								
				return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;		
	}//cargaSerial

}
