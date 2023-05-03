package Reto2UT8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ap2PruebaAemet {

	public static void main(String[] args) {
		URL aemet;
		try  {
			aemet = new URL ("https://www.aemet.es/xml/municipios_h/localidad_h_28079.xml");
			try {
				BufferedReader in = new BufferedReader (new InputStreamReader(aemet.openStream()));
				
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					if (! inputLine.matches(".*periodo=\"14\".*")) continue;
					Pattern patron = Pattern.compile(".*periodo=\"14\" (\\w+)=\"(\\w+)\">(\\d+).*");
					Matcher concuerda = patron.matcher(inputLine);
					if (concuerda.matches()) {
						System.out.println(concuerda.group(1)); 
						System.out.println(concuerda.group(2));
						System.out.println(concuerda.group(3));
					}//if
				}//while
				
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
