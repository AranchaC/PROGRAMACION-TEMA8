package Textos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pruebaPatternMatcher {

	public static void main(String[] args) {
		String texto1 = "Hola soy arancha, ¡no quiero estudiar!";
		String texto2 = "<usuario>acm</usuario>";
		
		String [] texto = texto1.split(" ¡");
		
		
		System.out.println(texto[1]);
		Pattern patron1 = Pattern.compile
				("\\w*\\s*¡(\\w*)!");
		Matcher mat1 = patron1.matcher(texto1);
		if (mat1.matches()) {
			System.out.println(mat1.group(1));
		}

	}

}
