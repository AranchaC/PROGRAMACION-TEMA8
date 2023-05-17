package EntradaSalida;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class PruebaPrintWriter {
	private final static String RUTA_ARCHIVO = "prueba2.txt";
	
	public static void main(String[] args) {
		//System.out.println(System.out.getClass());
		
		try (PrintWriter salida = new PrintWriter(
				new FileWriter (RUTA_ARCHIVO,Charset.forName
						("UTF-8"),true))){			
			salida.println("Buenos días.");
			salida.println("Soy pepito arancha.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aquí seguimos.");
		
		

	}

}