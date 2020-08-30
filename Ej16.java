package ejercicios;
import java.util.Scanner;
public class Ej16 {
	private static Scanner input=new Scanner(System.in);
	final static char ENTRADA='y', SALIDA='n';
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean entrar;
		int count=0;
		
		entrar=entrar();
		while(entrar) {
			
		}
	}
	public static boolean entrar() {
		char decision='a';
		boolean quiereEntrar= decision==ENTRADA;
		
		System.out.println("Bienvenido");
		System.out.println("Desea calcular el precio total de un catering? s/n");
		decision=input.next().charAt(0);

		return quiereEntrar;
		
	}
}
