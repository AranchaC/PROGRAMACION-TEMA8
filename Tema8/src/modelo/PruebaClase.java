package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import modelo.Alumno;
import modelo.Clase;
import modelo.ES_Alumnos;

public class PruebaClase {

	public static final String csvFileName = "alumnos.csv";
	public static final String ficheroSalidaTxt = "alumnos.txt";
	public static final String binarioSalida = "alumnos.bin";
	public static final String ficheroSerial = "alumnos.dat";
	
	public static void main(String[] args) {
		Clase daw1 = null;
		try {
			//daw1 = ES_Alumnos.leerClaseDeCsv(new File(csvFileName));
			File archivoBinario = new File(binarioSalida);
			File archivoSerial = new File(ficheroSerial);
			daw1 = ES_Alumnos.leerClaseDeBin(archivoBinario);
			System.out.println("Alumnos leídos: " + daw1);
			Alumno a;
			while ( (a=ES_Alumnos.leeAlumnoDeTeclado())!=null) {
				daw1.insertar(a);
			}
			System.out.println(daw1);
			ES_Alumnos.imprimeClaseATxt(new File(ficheroSalidaTxt), daw1);
			ES_Alumnos.guardaClaseSerial(archivoSerial,daw1);
			//ES_Alumnos.guardaClaseBin(archivoBinario,daw1);
		} catch (IOException e) {
			System.err.println("Problemas con el disco");
			System.err.println(e.getMessage());
		}
	} // main
	
} // class PruebaClase
