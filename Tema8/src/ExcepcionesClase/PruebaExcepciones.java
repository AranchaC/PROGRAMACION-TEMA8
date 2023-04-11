package ExcepcionesClase;

public class PruebaExcepciones {

	public static void main(String[] args) {
		String linea = " 354";
		int num;
		
		num = stringAEntero(linea, Integer.MIN_VALUE);
		if (num!=Integer.MIN_VALUE) {
			System.out.println("Has introducido: "+ num);
		}
		else {
			System.err.println("Numero incorrecto.");
		}
		
		/*try {
			num = Integer.parseInt(linea);
			System.out.println("Tu número es: "+num);
		}
		catch (Exception e){
			num = 0;
			System.out.println("Número inváldo.");
		}*/
				
	}
	
	public static int stringAEntero(String texto, int numPorDefecto) {
		try {
			return Integer.parseInt(texto);
		}
		catch (NumberFormatException e) {
			return numPorDefecto;
		}
		
	}

}
