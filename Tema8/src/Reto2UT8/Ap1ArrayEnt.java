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
				enteros.add(entrada.readInt());				
			}//for	
			System.out.println("Contenido de la lista: "+enteros);
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
				}//for
				System.out.println("Números en la lista: "+enteros);
			}// try
			catch (IOException e1) {
				e1.printStackTrace();
			}//catch
			
		}//catch
		catch (IOException e) {
			e.printStackTrace();
		}//catch
		
		//4.
		try (RandomAccessFile fichero = 
				new RandomAccessFile(RUTA,"rws")){
			
			//5 y 6.
			while (fichero != null){
				System.out.println("Contenido de la lista: "+enteros);
				//enteros.toString();
				
				/*
				 * Para la posición, calculamos el nºde enteros que
				 * tiene el fichero ( con .length() ).
				 * y como cada int ocupa 4bytes, se divide el total de bytes
				 * entre 4 para obtener el nº de enteros del fichero.
				 */
				
				int pos;
				long size = fichero.length();
				size = size/4;
				System.out.println("\nEl fichero tiene " + size + " enteros.");
							
				System.out.println("Dime una posición entre el 1 y el "+ size+" (negativo para salir): ");
				pos = in.nextInt();
				if (pos < 1 || pos > enteros.size()) {
					break;
				}//if
				pos--;//posición 1 es la 0, entonces decrementamos en 1.
								
				/*
				 * nos situamos en la pos del nº a modificar.
				 * y como el entero ocupa 4 bytes, ponemos *4.
				 */
				
				fichero.seek(pos*4);
				
				//Leemos y mostramos el valor de dicha pos.
				System.out.println("Valor actual: "+fichero.readInt());
				
				System.out.println("Dame un número.");
				int valor = in.nextInt();
				
				//Nos colocamos otra vez en la posición a modificar.
				//Y escribimos en nuevo número en el archivo.
				enteros.set(pos, valor);
				fichero.seek(pos*4);
				fichero.writeInt(valor);
				
								
			}//while
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}

}
