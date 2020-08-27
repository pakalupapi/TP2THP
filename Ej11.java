package ejercicios;

public class Ej11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=5;
		int num2=3;
		
		System.out.println(sumasSucesivas(num1, num2));
	}
	public static int sumasSucesivas(int num1, int num2) {
		int i;
		int resultado=0;
		
		for (i=0; i<num2; i++) {
			resultado+=num1;
		}
		
		return resultado;
	}
}
