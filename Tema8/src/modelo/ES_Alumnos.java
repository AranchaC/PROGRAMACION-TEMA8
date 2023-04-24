package modelo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import modelo.Alumno.Nivel;

public class ES_Alumnos {
	private static Scanner teclado = new Scanner(System.in);
	
	public static void guardaClaseSerial(File archivo, Clase clase) throws FileNotFoundException, IOException {
		ObjectOutputStream salida = new ObjectOutputStream(
							new FileOutputStream(archivo));
		salida.writeObject(clase);
		salida.close();
	} // guardaClaseSerial
	
	public static Clase leerClaseDeSerial(File archivo) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream entrada = new ObjectInputStream(
				new FileInputStream(archivo));
		Clase clase = (Clase)entrada.readObject();
		entrada.close();
		return clase;
	} // leerClaseDeSerial
	
	public static Clase leerClaseDeBin(File archivo) throws IOException {
		DataInputStream entrada = new DataInputStream(
								new FileInputStream(archivo));
		Clase clase = new Clase();
		while (entrada.available()>0) {
			String dni = entrada.readUTF();
			String nombre = entrada.readUTF();
			Float nota = entrada.readFloat();
			Nivel nivel = Nivel.values()[entrada.readByte()];
			clase.insertar( new Alumno(dni,nombre,nota,nivel) );
		}
		entrada.close();
		return clase;
	} // leerClaseDeBin
	
	/*public static void guardaClaseBin(File archivo, Clase clase) throws IOException {
		DataOutputStream salida = new DataOutputStream(
									new FileOutputStream(archivo));
		for (int pos=0; pos<clase.size() ; pos++) {
			Alumno a = clase.getAlumno(pos);
			salida.writeUTF(a.getDni());
			salida.writeUTF(a.getNombre());
			salida.writeFloat(a.getNota());
			salida.writeByte(a.getNivel().ordinal());
		}
		salida.close();		
	} // guardaClaseBin*/
	
	public static Alumno leeAlumnoDeTeclado() {
		Alumno a;
		System.out.print("Dame el dni (vacío para fin): ");
		String dni = teclado.nextLine();
		if (dni.isBlank()) return null;
		System.out.print("Dame el nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("Dame la nota: ");
		String notaStr = teclado.nextLine();
		float nota;
		try { 
			nota = Float.parseFloat(notaStr);
		}
		catch (Exception e) { nota = 0.0f; }
		a = new Alumno(dni,nombre);
		a.setNota(nota);
		return a;
	} // leeAlumnoDeTeclado
	
	public static void imprimeClaseATxt(File fichero, Clase clase) throws IOException {
		FileWriter salida = new FileWriter(fichero);
		salida.write(clase.toString());
		salida.close();
	} // imprimeClaseATxt
	
	// método estático para leer de un archivo los datos
	// de los alumnos
	public static Clase leerClaseDeCsv(File fichero) throws IOException {
		Clase miClase = new Clase();
		FileReader fr = new FileReader(fichero,StandardCharsets.UTF_8);
		BufferedReader br = new BufferedReader(fr);
		String línea;
		while (  (línea=br.readLine()) != null) {
			String campos[] = línea.split(",");
			Alumno a = new Alumno(campos[0],campos[1]);
			a.setNota( Float.parseFloat(campos[2]));
			miClase.insertar(a);
		}
		br.close();
		return miClase;
	} // leerClaseDeCsv

	
} // class
