package Reto2UT8;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ap1ArrayEnt {
	final static String RUTA = "datos.bin";
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		//1.
		List<Integer> enteros = new ArrayList<Integer> (20);
		
		//2.
		//Si existe, lee:
		try (DataInputStream entrada = 
				new DataInputStream(new FileInputStream(RUTA))) {
			for (int i=0; i<20; i++) {
				//recorro el arrayList y añado lo que lee con .readInt().
				enteros.add(entrada.readInt());				
			}//for
		}//try
		
		//3.
		//si no existe, dentro del catch:
		//insert 0 en array creado con .add() y escribe en disco con .writeInt().
		catch (FileNotFoundException e) {
			
			try (DataOutputStream salida = 
					new DataOutputStream(new FileOutputStream(RUTA))) {				
				for (int i=0; i<20; i++) {
					enteros.add(0);
					salida.writeInt(0);
				}//for
			}// try
			catch (IOException e1) {
				e1.printStackTrace();
			}//catch
			
		}//catch
		catch (IOException e) {
			e.printStackTrace();
		}//catch
		
		//4. Paso por parámetro la ruta del archivo, y el modo "rws" antes estába "rwd".
		try (RandomAccessFile fichero = 
				new RandomAccessFile(RUTA,"rws")){
			
			//5 y 6.
			while (true){
				System.out.println("Contenido de la lista: "+enteros);
				
				/*
				 * Para la posición, calculamos el nºde enteros que
				 * tiene el fichero ( con .length() ).
				 * y como cada int ocupa 4bytes, se divide el total de bytes
				 * entre 4 para obtener el nº de enteros del fichero.
				 */
				
				long size = fichero.length();
				size = size/4;
				System.out.println("\nEl fichero tiene " + size + " enteros.");
							
				System.out.println("Dime una posición entre el 1 y el "+ size+" (negativo para salir): ");
				int pos = in.nextInt();
				
				// si la la pos es < 1 o > al tamaño de la lista, se sale del bucle.
				if (pos < 1 || pos > enteros.size()) {
					System.out.println("Adiós.");
					break;
				}//if
								
				/*
				 * nos situamos en la pos del nº a modificar con .seek().
				 * y como el entero ocupa 4 bytes, ponemos *4.
				 */
				
				pos--;//posición 1 es la 0, entonces decrementamos en 1.
				fichero.seek(pos*4);
				
				//Leemos y mostramos el valor de dicha pos con .readInt().
				System.out.println("Valor actual: "+fichero.readInt());
				
				//Pido nuevo valor para actualizar con él la posición ya solicitada.
				System.out.println("Dame un nuevo valor:");
				int valor = in.nextInt();
				
				//Actualizamos con este valor el arrayList con .set(index,int).
				//Y actualizamos también la posición del disco con .writeInt() y colocándonos 
				//primero en la posición ya solicitada con .seek() y *4 nuevamente.
				enteros.set(pos, valor);
				fichero.seek(pos*4);
				fichero.writeInt(valor);				
				
												
			}//while
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}//main

}//class
