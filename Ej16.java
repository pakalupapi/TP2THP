package ejercicios;
import java.util.Scanner;
public class Ej16 {
	private static Scanner input=new Scanner(System.in);
	final static char ENTRADA='s', SALIDA='n';
	final static int PRECIO_CLASICO=300, PRECIO_CELIACO=310, PRECIO_KOSHER=430, PRECIO_LIGHT=290;
	final static int COSTO_BEBIDA=30;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean entrar;
		int count=0;
		int cantInvitados, totalBebida;
		int cantXMenu[]=new int[4];
		int tarifa[]=new int[4];
		
		entrar=entrar(count);
		while(entrar) {
			cantInvitados=obtenerInvitados();
			cantXMenu=obtenerCantidades(cantInvitados);
			tarifa=obtenerTarifas(cantXMenu);
			totalBebida=cantInvitados*COSTO_BEBIDA;
			mostrarResultados(tarifa, totalBebida);
			count+=1;
			entrar=entrar(count);
		}
		despedida();
		input.close();
	}
	public static boolean entrar(int count) {
		char decision='a';
		boolean quiereEntrar=true;
		boolean quiereSalir=true;
		
		if(count==0) {
			do {
				System.out.println("Bienvenido");
				System.out.println("Desea calcular el precio total del catering? s/n");
				decision=input.next().charAt(0);
				quiereEntrar= decision==ENTRADA;
				quiereSalir= decision==SALIDA;
			}while(!quiereEntrar && !quiereSalir);
		}
		else if(count>=0) {
			do {
			System.out.println("Desea volver a calcular el precio total del catering? s/n");
			decision=input.next().charAt(0);
			quiereEntrar= decision==ENTRADA;
			quiereSalir= decision==ENTRADA;
			}while(!quiereEntrar && !quiereSalir);
		}
		return quiereEntrar;
		
	}
	public static int obtenerInvitados() {
		int cantInvitados;
		boolean cantValida;
		
		do {
			input.nextLine();
			System.out.println("Ingrese cantidad de invitados");
			System.out.println("Ingrese 0 para salir");
			cantInvitados=Integer.parseInt(input.nextLine());
			cantValida=cantInvitados>=0;
		}while(!cantValida);
		
		return cantInvitados;
	}
	public static int[] obtenerCantidades(int cantInvitados) {
		int cantXMenu[]=new int[4];
		int cantClasicos=0, cantCeliacos=0, cantKosher=0, cantLight=0;
		int menu, invitados=cantInvitados;
		boolean salida;
		
		if(cantInvitados>0) {
			do {
				menu=seleccionMenu();
				switch(menu) {
				case 1: cantClasicos=obtenerCantidadCubiertos("clásico.");
					cantXMenu[0]=cantClasicos;
					invitados-=cantClasicos;
					break;
				case 2: cantCeliacos=obtenerCantidadCubiertos("para celíacos.");
					cantXMenu[1]=cantCeliacos;
					invitados-=cantCeliacos;
					break;
				case 3: cantKosher=obtenerCantidadCubiertos("Kosher.");
					cantXMenu[2]=cantKosher;
					invitados-=cantKosher;
					break;
				case 4: cantLight=obtenerCantidadCubiertos("light.");
					cantXMenu[3]=cantLight;
					invitados-=cantLight;
					break;
				}
				if (invitados<=0) {
					System.out.println("Ha ingresado las cantidades incorrectamente.");
					System.out.println("Los valores se reiniciaran a cero");
					invitados=cantInvitados;
					cantXMenu[0]=0;
					cantXMenu[1]=0;
					cantXMenu[2]=0;
					cantXMenu[3]=0;
				}
				salida=menu==5;
			}while(!salida);
		}
		return cantXMenu;
	}
	public static int seleccionMenu() {
		final int clasico=1, celiaco=2, kosher=3, light=4;
		int seleccion;
		boolean seleccionValida, salida;
		
		do {
		System.out.println("Seleccione un menu por su numero");
		System.out.println("Clasico (1), Para celiacos (2), Kosher (3), Light (4)");
		System.out.println("Ingrese 5 para finalizar.(5)");
		seleccion=Integer.parseInt(input.nextLine());
		seleccionValida=seleccion==clasico || seleccion==celiaco || seleccion==kosher || seleccion==light;
		salida=seleccion==5;
		}while(!seleccionValida && !salida);
		
		return seleccion;
	}
	public static int obtenerCantidadCubiertos(String plato) {
		int cantCubiertos=0;
		
		do {
		System.out.println("Ingrese cantidad de cubiertos para el plato "+ plato);
		cantCubiertos=Integer.parseInt(input.nextLine());
		}while(cantCubiertos<=0);
		
		return cantCubiertos;
	}
	public static int[] obtenerTarifas(int[] cantXMenu) {
		int tarifas[]=new int[4];
		
		tarifas[0]=0;
		tarifas[1]=0;
		tarifas[2]=0;
		tarifas[3]=0;
		for(int menu=0; menu==3; menu++) {
			switch(menu) {
			case 0: tarifas[menu]+=PRECIO_CLASICO*cantXMenu[menu];
				break;
			case 1: tarifas[menu]+=PRECIO_CELIACO*cantXMenu[menu];
				break;
			case 2: tarifas[menu]+=PRECIO_KOSHER*cantXMenu[menu];
				break;
			case 3: tarifas[menu]+=PRECIO_LIGHT*cantXMenu[menu];
				break;
			}
		}
		return tarifas;
	}
	public static void mostrarResultados(int tarifas[], int totalBebida) {
		int tarifa=0, totalComida=0;
		int i=0;
		boolean tarifaClasico, tarifaCeliaco, tarifaKosher, tarifaLight;
		
		for(i=0; i==3; i++) {
			tarifa=0;
			tarifaClasico=tarifas[0]!=0;
			tarifaCeliaco=tarifas[1]!=0;
			tarifaKosher=tarifas[2]!=0;
			tarifaLight=tarifas[3]!=0;
			if(tarifaClasico) {
				tarifa=tarifas[i];
				System.out.println("Clásico: "+ tarifa);
			}
			else if(tarifaCeliaco) {
				tarifa=tarifas[i];
				System.out.println("para celiacos: "+ tarifa);
			}
			else if(tarifaKosher) {
				tarifa=tarifas[i];
				System.out.println("Kosher: "+ tarifa);
			}
			else if(tarifaLight) {
				tarifa=tarifas[i];
				System.out.println("Light: "+ tarifa);
			}
			totalComida+=tarifa;
		}
		System.out.println("El coste total de la comida es de: $"+ totalComida);
		System.out.println("EL coste total de la bebida es de: $"+ totalBebida);
		System.out.println("l coste toal es de : $"+ (totalComida+totalBebida));
	}
	public static void despedida() {
		System.out.println("Hasta pronto");
	}
}
