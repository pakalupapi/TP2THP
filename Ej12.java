package ejercicios;
import java.util.Scanner;
public class Ej12 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2;
		int resultado;
		String operacion;
		
		System.out.println("Ingrese primer numero");
		num1=Integer.parseInt(input.nextLine());
		System.out.println("Ingrese segundo numero");
		num2=Integer.parseInt(input.nextLine());
		
		operacion=seleccionOperacion();
		
		if(operacion.equals("f")){
			System.out.println("Hasta pronto");
		}
		else {
			resultado=cuenta(num1, num2, operacion);
			System.out.println("El resultado es:"+ resultado);
		}
		
	}
	public static String seleccionOperacion() {
		String operacion;
		boolean entradaValida;
		
		do {
			System.out.println("Ingrese +, -, /, o * para sumar, restar, dividir o multiplicar respectivamente");
			System.out.println("Ingrese % para obtener el resto");
			System.out.println("Ingrese f para salir");
			operacion=input.nextLine();
			entradaValida= operacion.equals("+") || operacion.equals("-") || operacion.equals("/") || operacion.equals("*");
		}while(!entradaValida);
		
		return operacion;
		
	}
	public static int cuenta(int num1, int num2, String operacion) {
		int resultado=0;
		
		while(operacion!="f") {
			switch(operacion) {
			case "+": resultado=suma(num1, num2);
				break;
			case "-": resultado=resta(num1, num2);
				break;
			case "/": resultado=division(num1, num2);
				break;
			case "*": resultado=multi(num1, num2);
				break;
			default: resultado=resto(num1, num2);
			}
		}
		return resultado;
	}
	public static int suma(int num1, int num2) {
		int resultado;
		resultado=num1+num2;
		
		return resultado;
	}
	public static int resta(int num1, int num2) {
		int resultado;
		resultado=num1-num2;
		
		return resultado;
	}
	public static int division(int num1, int num2) {)
		int resultado;
		resultado=num1/num2;
		
		return resultado;
	}
	public static int multi(int num1, int num2) {
		int resultado;
		resultado=num1*num2;
		
		return resultado;
	}
	public static int resto(int num1, int num2) {
		int resultado;
		resultado=num1%num2;
		
		return resultado;
	}
}
