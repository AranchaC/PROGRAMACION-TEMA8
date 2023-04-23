package EntradaSalida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class LeerCopiar {

	public static void main(String[] args) {
		final String rutaOrigen = "prueba3";
		final String rutaDestino = rutaOrigen + "bis";
		final String charSetOrigen = "UTF-8";
		final String charSetDestino = "ISO-8859-1";	
		
		try (BufferedReader entrada = 
				new BufferedReader
				(new FileReader(rutaOrigen,Charset.forName(charSetOrigen)));
				FileWriter salida = 
						new FileWriter 
						(rutaDestino,Charset.forName(charSetDestino));
				){
			String linea;
			while ( (linea = entrada.readLine()) !=null) {
				System.out.println(linea);				
				salida.write(linea+"\n");
			}//while

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
