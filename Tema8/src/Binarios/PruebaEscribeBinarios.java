package Binarios;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PruebaEscribeBinarios {
	final static String RUTA_BINARIO = "data.bin";

	public static void main(String[] args) {
		
		try (DataOutputStream salida = 
				new DataOutputStream(new FileOutputStream(RUTA_BINARIO)))
		{
			salida.writeInt(34);
			salida.writeBoolean(false);
			salida.writeDouble(12.12);
			salida.writeUTF("Hola");
			salida.writeLong(Integer.MAX_VALUE);
		} 
		//Importante el orden de las excepciones.
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
////
	}//

}
