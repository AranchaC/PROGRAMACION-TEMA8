package Reto2UT8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ap1ArrayEnt {
	final static String RUTA = "datos.bin";

	public static void main(String[] args) {
		//1.
		ArrayList<Integer> enteros = new ArrayList<Integer> (20);
		
		//2.
		//Si existe, lee:
		try (DataInputStream entrada = 
				new DataInputStream(new FileInputStream(RUTA))) {
			for (int i=0; i<20; i++) {
				System.out.println(entrada.readInt()); 
			}//for
			
		}//try
		
		//3.
		//si no existe, dentro del catch:
		//inserta 0 en array creado y escribe en disco.
		catch (FileNotFoundException e) {
			
			try (DataOutputStream salida = 
					new DataOutputStream(new FileOutputStream(RUTA))) {
				
				for (int i=0; i<20; i++) {
					enteros.add(0);
					salida.writeInt(0);
					System.out.println(salida);
				}//for
				
			}// try
			catch (FileNotFoundException e1) {
				e.printStackTrace();
			}
			catch (IOException e1) {
				e1.printStackTrace();
			}//catch
			
		}//catch
		catch (IOException e) {
			e.printStackTrace();
		}//catch
		
		//4.
		try (RandomAccessFile fichero = 
				new RandomAccessFile(RUTA,"rwd")){
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
