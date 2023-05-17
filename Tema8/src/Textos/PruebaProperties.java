package Textos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PruebaProperties {
	final static String RUTA_CONFIG ="config.xml";

	public static void main(String[] args) {
		Properties props = new Properties();
		
		File fich = new File(RUTA_CONFIG);
		if (fich.canRead()) {
			//cargo datos de un fichero xml.
			try (FileInputStream entrada = new FileInputStream(fich);){	
				System.out.println("Usuarios: ");
				props.loadFromXML(entrada);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			//si no puedo leerles, los creo
			props.setProperty("achicharro", "Arancha Chicharro");
			props.setProperty("slinan", "Sara Liñan");
			props.setProperty("layllon", "Luis Ayllon");
			props.setProperty("rsanchez", "Ruben Sanchez");
		}
				
		System.out.println(props);
		try (FileOutputStream salida = new FileOutputStream(RUTA_CONFIG))
		{
			props.storeToXML(salida, "Usuarios de la app");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
