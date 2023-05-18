package EntradaSalida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class PruebaBufferedReader {
	final static String RUTA_ARCHIVO = "prueba.txt";

	public static void main(String[] args) {
		File ruta = new File(RUTA_ARCHIVO);
		//Charset.availableCharsets().forEach( (a,b) -> System.out.println(a+" : "+b) );
		//System.out.println(Charset.availableCharsets().keySet());
		System.out.println("Por defecto: "+ Charset.defaultCharset().toString());
				
		try (BufferedReader entrada = new BufferedReader(
				new FileReader(ruta,Charset.forName("ISO-8859-1")))) {
			String linea;
			while ( (linea = entrada.readLine()) !=null) {
				System.out.println(linea);
			}//while
		}//try
		catch (FileNotFoundException e) {
			System.err.println("El archivo no existe."+ ruta.getAbsolutePath());
		}//catch 
		catch (IOException e) {
			System.err.println("Problema leyendo datos del disco.");
		}//catch
		
		
		/*
		 * 1. abrir archivo para lectura:
		 * 	- file para decir qué archivo.
		 *  - filereader para obtener sus datos.
		 *  - bufferedreader para leer por líneas.
		 * 2. leer mientras haya datos.
		 *  - leo y comparo el valor leído con un dato determinado.
		 * 3. cerrar archivo.
		 *  - dentro del paréntesis del try (try con recursos, siempre cierra.).
		 *  - y si no se pone paréntesis, hay que poner el .close.
		 * 
		 * 
		 * 
		 * */
		
		
	}

}
