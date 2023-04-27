package Textos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PruebaXML {
	final static String RUTA_XML="intro1.xml";

	public static void main(String[] args) {
		try (BufferedReader entrada = new BufferedReader (new FileReader(RUTA_XML));) {
			String linea;
			Pattern patron1 = Pattern.compile("\\s*<\\w*>(.*)<\\/\\w*>");
			Pattern patron2 = Pattern.compile("\\s*<\\w* (\\w*)=\"(\\w*)\">(.*)<\\/\\w*>");
			
			while ( (linea = entrada.readLine()) != null ) {
				Matcher m1 = patron1.matcher(linea);
				if (m1.matches()) {
					System.out.println(m1.group(1));
					System.out.println();
				}else {
					Matcher m2 = patron2.matcher(linea);
					if (m2.matches()) {
						//System.out.println(m2.groupCount());
						System.out.println(m2.group(1) + ": " + m2.group(2) + ": " + m2.group(3));
						//System.out.println();
					}					
				}
				
				/*Matcher m2 = patron2.matcher(linea);
				if (m2.matches()) {
					//System.out.println(m2.groupCount());
					//System.out.println(m2.group(1) + ": " + m2.group(2) + ": " + m2.group(3));
					for (int i=1; i<= m2.groupCount(); i++) {
						System.out.println(m2.group(i)+ ": ");
					}
					System.out.println();
				}*/	
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
