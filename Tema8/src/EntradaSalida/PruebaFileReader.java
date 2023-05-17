package EntradaSalida;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebaFileReader {
	final static String RUTA_ARCHIVO = "prueba2.txt";

	public static void main(String[] args) {
		File ruta = new File(RUTA_ARCHIVO);
		FileReader fich1;
		try {
			fich1 = new FileReader(ruta);
			int car;
			while ( (car=fich1.read()) !=-1) {
				System.out.print( (char)car);
			}
			fich1.close();
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no existe."+ ruta.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("Problema leyendo datos del disco.");
		}
		
		
	}

}
