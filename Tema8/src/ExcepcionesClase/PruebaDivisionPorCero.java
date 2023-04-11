package ExcepcionesClase;

public class PruebaDivisionPorCero {

	public static void main(String[] args) {
		int[] numeros = {2,3,4};
		 /*
		System.out.println(media(numeros));
		*/
		
		try {
			System.out.println(media( new int[] {} ));
			System.out.println(media(null));
		}
		catch (NullPointerException e) {
			System.out.println(e);
		}
		catch (ArithmeticException e) {
			System.out.println(e);
		}
	}
	
	public static double media (int[] nums)  {
		if (nums==null) throw new NullPointerException("Array nulo");
		if (nums.length==0) throw new ArithmeticException("División por cero");
		int suma = 0;
		for (int i=0; i<nums.length; i++) {
			suma += nums[i];
		}
		return suma/nums.length;
	}

}
