package Binarios;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PruebaLecturaBinarios {
	final static String RUTA_BINARIO = "data.bin";
	
	public static void main(String[] args) {
		try (DataInputStream entrada = new DataInputStream(
				new FileInputStream(RUTA_BINARIO));)
		{			
			System.out.println(entrada.readInt());
			System.out.println(entrada.readBoolean());
			System.out.println(entrada.readDouble());
			System.out.println(entrada.readUTF());
			System.out.println(entrada.readLong());
			System.out.println(entrada.readInt());
			//entrada.readInt();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

	}

}
