package Binarios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PruebaBMP {
	final static String RUTA_IMAGEN = "imagen.bmp";

	public static void main(String[] args) {
		//18, 22
		
		try (RandomAccessFile fichero = 
				new RandomAccessFile(RUTA_IMAGEN,"rw");) 
		//se pone nombre de la ruta de la imagen + modo.
		//r=read/lectura, w=write/escritura
		{
			if (fichero.readByte()== 0x42 && fichero.readByte()== 0x4D ) {
				System.out.println("Fichero BMP correcto");
			} else {
				System.out.println("Fichero BMP incorrecto");
			}			
			System.out.println("Tamaño: " + Integer.reverseBytes(fichero.readInt()));
			fichero.seek(18);
			//System.out.println("Ancho: "+ Integer.reverseBytes(fichero.readInt()) );
			//System.out.println("Alto: "+ Integer.reverseBytes(fichero.readInt()));
			
			//con esto decimos que la imagen es de 10x10, cuando en realidad es de 60x50.
			//Entonces, hay un error, la imagen está corrupta.
			fichero.writeInt(Integer.reverseBytes(10));
			fichero.writeInt(Integer.reverseBytes(10));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
