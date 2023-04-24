package Binarios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ModeloYo.Producto;

public class PruebaSerializar {
	static final String RUTA_SER = "productos.ser";

	public static void main(String[] args) {
		
		Producto p1 = new Producto(1,"Peras",30,34,12.23);
		Producto p2 = new Producto(2,"Fresas",40,44,42.23);
		List<Producto> stock = new ArrayList<Producto>();
		stock.add(p1);
		stock.add(p2);
		
		try (ObjectOutputStream salida = 
				new ObjectOutputStream(new FileOutputStream(RUTA_SER)))
		{
			salida.writeObject(stock);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
