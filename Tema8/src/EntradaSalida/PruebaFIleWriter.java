package EntradaSalida;

import java.io.FileWriter;
import java.io.IOException;

public class PruebaFIleWriter {
	private final static String RUTA_ARCHIVO = "prueba2.txt";
	
	public static void main(String[] args) {
		
		try (FileWriter salida = new FileWriter (RUTA_ARCHIVO,true);){
			//segundo parámetro de tipo booleano permite, reescribir el archivo o escribir después de lo que tenemos.
			
			salida.write("\nBuenos días.\n");
			salida.write("Soy pepito grillo.\n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

}
/**/