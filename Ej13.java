package ejercicios;
import java.util.Scanner;
public class Ej13 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantAlumnos;
		String claseMasRequerida;
		cantAlumnos=cantidadAlumnos();
		claseMasRequerida=pedirDatos(cantAlumnos);
		resultado(claseMasRequerida);
		input.close();
	}
	public static int cantidadAlumnos() {
		int cantAlumnos;
		System.out.println("Bienvenido");
		System.out.println("Ingrese cantidad de alumnos");
		cantAlumnos=Integer.parseInt(input.nextLine());
		return cantAlumnos;
		
	}
	public static String pedirDatos(int cantAlumnos) {
		int taller=0, mate=0, fundamentos=0;
		String curso="", materia, materiaMasRequerida="";
		boolean cursoValido, materiaValida;
		
		for (int i=1; i<=cantAlumnos; i++) {
			do {
				System.out.println("Ingrese curso del alumno "+i);
				curso=input.nextLine();
				System.out.println("Ingrese materia que desea reforzar");
				materia=input.nextLine();
				cursoValido=curso.equalsIgnoreCase("a") || curso.equalsIgnoreCase("b") || curso.equalsIgnoreCase("c") || curso.equalsIgnoreCase("d");
				materiaValida=materia.equalsIgnoreCase("fundamentos") || materia.equalsIgnoreCase("taller") || materia.equalsIgnoreCase("matematica");
			}while(!cursoValido || !materiaValida);
			
			switch(materia) {
			case "taller": taller+=1;
				break;
			case "matematica": mate+=1;
				break;
			case "fundamentos": fundamentos+=1;
			}
		if (taller>mate && taller>fundamentos) {
			materiaMasRequerida="Taller";
		}
		else if(mate>fundamentos){
			materiaMasRequerida="Matematica";
		}
		else {
			materiaMasRequerida="Fundamentos";
		}
		}
		return materiaMasRequerida;
	}
	public static void resultado(String claseMasRequerida) {
		System.out.println("La materia elegida para refuerzo es: "+claseMasRequerida);
	}

}
