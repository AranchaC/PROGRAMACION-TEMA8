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
					Pattern patron1 = Pattern.compile(".*<(\\w+) periodo=\"14\" .*\"(\\w+)\">(\\d+).*");
					Matcher concuerda1 = patron1.matcher(inputLine);
					if (concuerda1.matches()) {
						System.out.println(concuerda1.group(1)+": "+concuerda1.group(2)+" "+concuerda1.group(3));
					}//if
					Pattern patron2 = Pattern.compile(".*<(\\w+) periodo=\"14\">(\\d+).*");
					Matcher concuerda2 = patron2.matcher(inputLine);
					if (concuerda2.matches()) {
						System.out.println(concuerda2.group(1)+": "+concuerda2.group(2));
					}//if

				}//while
				
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
