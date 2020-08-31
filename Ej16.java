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
		int cantidadXMenu[]= new int[4];
		int tarifas[]= new int[4];
		
		cantidadXMenu[0]=0;
		cantidadXMenu[1]=0;
		cantidadXMenu[2]=0;
		cantidadXMenu[3]=0;
		tarifas[0]=0;
		tarifas[1]=0;
		tarifas[2]=0;
		tarifas[3]=0;
		
		entrar=entrar(count);
		while(entrar) {
			cantInvitados=obtenerInvitados();
			cantidadXMenu=obtenerCantidades(cantInvitados);
			tarifas=obtenerTarifas(cantidadXMenu[0], cantidadXMenu[1], cantidadXMenu[2], cantidadXMenu[3]);
			totalBebida=cantInvitados*COSTO_BEBIDA;
			mostrarResultados(tarifas[0], tarifas[1], tarifas[2], tarifas[3], totalBebida);
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
				input.nextLine();
			}while(!quiereEntrar && !quiereSalir);
		}
		else if(count>0) {
			do {
			System.out.println("Desea volver a calcular el precio total del catering? s/n");
			decision=input.next().charAt(0);
			quiereEntrar= decision==ENTRADA;
			quiereSalir= decision==SALIDA;
			input.nextLine();
			}while(!quiereEntrar && !quiereSalir);
		}
		return quiereEntrar;
		
	}
	public static int obtenerInvitados() {
		int cantInvitados;
		boolean cantValida;
		
		do {
			System.out.println("Ingrese cantidad de invitados");
			System.out.println("Ingrese 0 para salir");
			cantInvitados=Integer.parseInt(input.nextLine());
			cantValida=cantInvitados>0;
		}while(!cantValida);
		
		return cantInvitados;
	}
	public static int[] obtenerCantidades(int cantInvitados) {
		int cantXMenu[]= new int[4];
		int menu, invitados=cantInvitados;
		boolean salida;
		
		cantXMenu[0]=0;
		cantXMenu[1]=0;
		cantXMenu[2]=0;
		cantXMenu[3]=0;
			do {
				menu=seleccionMenu();
				switch(menu) {
					case 0: cantXMenu[menu]=obtenerCantidadCubiertos("clásico.");
							invitados-=cantXMenu[menu];
							break;
					case 1: cantXMenu[menu]=obtenerCantidadCubiertos("para celíacos.");
							invitados-=cantXMenu[menu];
							break;
					case 2: cantXMenu[menu]=obtenerCantidadCubiertos("Kosher.");
							invitados-=cantXMenu[menu];
							break;
					case 3: cantXMenu[menu]=obtenerCantidadCubiertos("light.");
							invitados-=cantXMenu[menu];
							break;
				}
				salida= menu==4;
				if (invitados!=0 && salida) {
					System.out.println("Ha ingresado las cantidades incorrectamente.");
					System.out.println("Los valores se reiniciaran a cero");
					invitados=cantInvitados;
					cantXMenu[0]=0;
					cantXMenu[1]=0;
					cantXMenu[2]=0;
					cantXMenu[3]=0;
				}
			}while(!salida || invitados!=0);
		return cantXMenu;
	}
	public static int seleccionMenu() {
		final int clasico=0, celiaco=1, kosher=2, light=3;
		int seleccion;
		boolean seleccionValida, salida;
		
		do {
		System.out.println("Seleccione un menu por su numero");
		System.out.println("Clasico (1), Para celiacos (2), Kosher (3), Light (4)");
		System.out.println("Ingrese 5 para finalizar.(5)");
		seleccion=Integer.parseInt(input.nextLine());
		seleccion-=1;
		seleccionValida=seleccion==clasico || seleccion==celiaco || seleccion==kosher || seleccion==light;
		salida=seleccion==4;
		}while(!seleccionValida && !salida);
		
		return seleccion;
	}
	public static int obtenerCantidadCubiertos(String plato) {
		int cantCubiertos=0;

		do {
		System.out.println("Ingrese cantidad de cubiertos para el plato "+ plato);
		cantCubiertos=Integer.parseInt(input.nextLine());
		}while(!(cantCubiertos>=0));
		
		return cantCubiertos;
	}
	public static int[] obtenerTarifas(int cantXMenu0, int cantXMenu1, int cantXMenu2, int cantXMenu3) {
		int tarifa[]= new int[4];

		tarifa[0]=0;
		tarifa[1]=0;
		tarifa[2]=0;
		tarifa[3]=0;
		for(int menu=0; menu==3; menu++) {
			switch(menu) {
			case 0: tarifa[menu]=PRECIO_CLASICO*cantXMenu0;
				break;
			case 1: tarifa[menu]=PRECIO_CELIACO*cantXMenu1;
				break;
			case 2: tarifa[menu]=PRECIO_KOSHER*cantXMenu2;
				break;
			case 3: tarifa[menu]=PRECIO_LIGHT*cantXMenu3;
				break;
			}
		}
		return tarifa;
	}
	public static void mostrarResultados(int tarifas0, int tarifas1, int tarifas2, int tarifas3, int totalBebida) {
		int totalComida=0;
		boolean tarifaClasico=tarifas0>0, tarifaCeliaco=tarifas1>0, tarifaKosher=tarifas2>0, tarifaLight=tarifas3>0;
		int tarifas[]=new int[4];
		boolean booleanList[]=new boolean[4];
		
		tarifas[0]=tarifas0;
		tarifas[1]=tarifas1;
		tarifas[2]=tarifas2;
		tarifas[3]=tarifas3;
		booleanList[0]=tarifaClasico;
		booleanList[1]=tarifaCeliaco;
		booleanList[2]=tarifaKosher;
		booleanList[3]=tarifaLight;
		
		for(int menu=0; menu==3; menu++) {
			if(booleanList[menu]) {
				System.out.println("Clásico: "+ tarifas[menu]);
			}
			totalComida+=tarifas[menu];
		}
		System.out.println("El coste total de la comida es de: $"+ totalComida);
		System.out.println("EL coste total de la bebida es de: $"+ totalBebida);
		System.out.println("l coste toal es de : $"+ (totalComida+totalBebida));
	}
	public static void despedida() {
		System.out.println("Hasta pronto");
	}
}
