package Binarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ModeloYo.Producto;

public class PruebaSerializar2 {
	static final String RUTA_SER = "productos.ser";

	public static void main(String[] args) {
		try (ObjectInputStream entrada = 
				new ObjectInputStream(new FileInputStream(RUTA_SER));)
		{
			try {
				ArrayList<Producto> prods = (ArrayList<Producto>) entrada.readObject();
				System.out.println(prods);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}

}
