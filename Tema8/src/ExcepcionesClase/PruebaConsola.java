package ExcepcionesClase;

import java.io.IOException;

public class PruebaConsola {

	public static void main(String[] args) {
		int n;
		try {
			while ( (n = leeCaracter() )>=0){
				System.out.println((char)n);
			}
		} catch (IOException e) {
			System.out.println("Se ha producido un error.");;
		}

	}
	
	public static int leeCaracter() throws IOException {
		return System.in.read();
		
	}
	

}
