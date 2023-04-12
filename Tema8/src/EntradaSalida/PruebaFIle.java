package EntradaSalida;

import java.io.File;

public class PruebaFIle {

	public static void main(String[] args) {
		File archivo = new File("prueba.txt");
		File carpeta = new File ("carpetaPrueba");
		
		System.out.println(archivo.exists());
		System.out.println(archivo.canExecute());
		System.out.println(archivo.getName());
		System.out.println(archivo.getAbsolutePath());
		System.out.println(carpeta.mkdir());

	}

}
