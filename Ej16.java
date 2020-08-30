package ejercicios;
import java.util.Scanner;
public class Ej16 {
	private static Scanner input=new Scanner(System.in);
	final static char ENTRADA='y', SALIDA='n';
	final static int PRECIO_CLASICO=300, PRECIO_CELIACO=310, PRECIO_KOSHER=430, PRECIO_LIGHT=290;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean entrar;
		int count=0;
		int cantInvitados;
		int cantXMenu[]=new int[4];
		int tarifa[]=new int[4];
		
		
		entrar=entrar();
		cantInvitados=obtenerInvitados(entrar);
		cantXMenu=obtenerCantidades(cantInvitados);
		tarifa=obtenerTarifas(cantXMenu);
	}
	public static boolean entrar() {
		char decision='a';
		boolean quiereEntrar= decision==ENTRADA;
		
		System.out.println("Bienvenido");
		System.out.println("Desea calcular el precio total de un catering? s/n");
		decision=input.next().charAt(0);

		return quiereEntrar;
		
	}
	public static int obtenerInvitados(boolean entrar) {
		int cantInvitados=0;
		boolean cantValida;
		while(entrar) {
			do {
				System.out.println("Ingrese cantidad de invitados");
				System.out.println("Ingrese 0 para salir");
				cantInvitados=Integer.parseInt(input.nextLine());
				cantValida=cantInvitados>=0;
			}while(!cantValida);
		}
		return cantInvitados;
	}
	public static int[] obtenerCantidades(int cantInvitados) {
		int cantElegidos=0, cantMenu[]=new int[cantElegidos];
		int cantClasicos=0, cantCeliacos=0, cantKosher=0, cantLight=0;
		int menu, invitados=cantInvitados;
		
		cantMenu[0]=cantClasicos;
		cantMenu[1]=cantCeliacos;
		cantMenu[2]=cantKosher;
		cantMenu[3]=cantLight;
		
		if(cantInvitados>0) {
			do {
				menu=seleccionMenu();
				switch(menu) {
				case 1: cantClasicos=obtenerCantidadCubiertos("clásico.");
					invitados-=cantClasicos;
					break;
				case 2: cantCeliacos=obtenerCantidadCubiertos("para celíacos.");
					invitados-=cantCeliacos;
					break;
				case 3: cantKosher=obtenerCantidadCubiertos("Kosher.");
					invitados-=cantKosher;
					break;
				case 4: cantLight=obtenerCantidadCubiertos("light.");
					invitados-=cantLight;
					break;
				}
				cantElegidos+=1;
			}while(invitados!=0);
		}
		return cantMenu;
	}
	public static int seleccionMenu() {
		final int clasico=1, celiaco=2, kosher=3, light=4;
		int seleccion;
		boolean seleccionValida;
		
		do {
		System.out.println("Seleccione un menu por su numero");
		System.out.println("Clasico (1), Para celiacos (2), Kosher (3), Light (4)");
		seleccion=Integer.parseInt(input.nextLine());
		seleccionValida=seleccion==clasico || seleccion==celiaco || seleccion==kosher || seleccion==light;
		}while(!seleccionValida);
		
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
	public static int[] obtenerTarifas(int cantXMenu[]) {
		int menu;
		int tarifas[]=new int[4];
		for(int i=0; i<=3; i++) {
			menu=i;
			switch(menu) {
			case 0: tarifas[menu]=PRECIO_CLASICO*cantXMenu[menu];
				break;
			case 1: tarifas[menu]=PRECIO_CELIACO*cantXMenu[menu];
				break;
			case 2: tarifas[menu]=PRECIO_KOSHER*cantXMenu[menu];
				break;
			case 3: tarifas[menu]=PRECIO_LIGHT*cantXMenu[menu];
				break;
			}
		}
		return tarifas;
	}
}
