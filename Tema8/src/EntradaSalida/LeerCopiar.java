package EntradaSalida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class LeerCopiar {
	final static String RUTA_ORIGEN = "prueba3";
	final static String RUTA_DESTINO = "prueba3bis";

	public static void main(String[] args) {
		File ruta = new File(RUTA_ORIGEN);
		File ruta2 = new File(RUTA_DESTINO);
		
		try (BufferedReader entrada = new BufferedReader(new FileReader(ruta,Charset.forName("UTF-8")));
				FileWriter salida = new FileWriter (ruta2,Charset.forName("ISO-8859-1"));
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
