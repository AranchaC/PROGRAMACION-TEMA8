package EntradaSalida;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//MUESTRA USUARIOS//

public class EjercicioClase1 {
	final static String RUTA_PASSWD = "/etc/passwd";

	public static void main(String[] args) {
		
		try (BufferedReader usuarios = new BufferedReader(new FileReader(RUTA_PASSWD))){
			String linea;
			while ( (linea = usuarios.readLine()) !=null) {
				String[] campos = linea.split(":");
				if (campos[6].contains("sh")) {
					System.out.println(campos[0]+" - "+ campos[4]);
				}//if				
			}//while
		}//try 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
