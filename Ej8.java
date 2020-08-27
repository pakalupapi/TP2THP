package ejercicios;

public class Ej8 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=5;
		int num2=3;
		System.out.println(esMultiplo(num1, num2));
		
		num1=15;
		num2=3;
		System.out.println(esMultiplo(num1, num2));

	}
	public static boolean esMultiplo(int num1, int num2) {
		int resto;
		boolean esMultiplo;
		
		resto=num1%num2;
		esMultiplo=resto==0;
		
		return esMultiplo;
	}
}