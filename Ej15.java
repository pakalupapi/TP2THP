package ejercicios;
import java.util.Scanner;
public class Ej15 {
	private static Scanner input=new Scanner(System.in);
	final static int MINIMO_NUM_CLIENTE=100001, MAXIMO_NUM_CLIENTE=999999;
	final static Double DURACION_MAX=9999.0, DURACION_MIN=0.0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroCliente;
		Double cuenta=0.0;
		Double duracionLlamada;
		Double duracion[]=new Double[2];
		Double importePorLlamada, importeTotal=0.0, precioPromedio=0.0;
		Double aRecaudarA=0.0, aRecaudarB=0.0, aRecaudarC=0.0;
		Double llamadaMasLarga=0.0, llamadaMasCorta=0.0;
		String tipoDeAbono="";
		boolean salir;
	
		duracion[0]=DURACION_MAX;
		duracion[1]=DURACION_MIN;
		do {
		numeroCliente=bienvenida(cuenta);
		duracionLlamada=obtenerDuracion();
		duracion[0]=duracionMinMax(duracionLlamada, duracion[0], "min");
		duracion[1]=duracionMinMax(duracionLlamada, duracion[1], "max");
		tipoDeAbono=obtenerAbono();
		importePorLlamada=obtenerFactura(tipoDeAbono, duracionLlamada);
		importeTotal+=importePorLlamada;
		cuenta+=1;
		if(tipoDeAbono.equals("a")) {
			aRecaudarA+=importePorLlamada;
		}
		else if(tipoDeAbono.equals("b")) {
			aRecaudarB+=importePorLlamada;
		}
		else{
			aRecaudarC+=importePorLlamada;
		}
		salir=funcionSalida();
		}while(!salir);
		
		llamadaMasLarga=duracion[1];
		llamadaMasCorta=duracion[0];
		precioPromedio=pedirPromedio(importeTotal, cuenta);
		despedida(aRecaudarA, aRecaudarB, aRecaudarC, importeTotal, llamadaMasLarga, llamadaMasCorta, precioPromedio);
		input.close();
	}
	public static int bienvenida(Double cuenta) {
		int numeroCliente=0;
		boolean numeroValido;
		
		if(cuenta==0.0) {
			System.out.println("Bienvenido al sistema de registro de llamada");
		}
		do {
			System.out.println("Ingrese numero del cliente");
			numeroCliente=Integer.parseInt(input.nextLine());
			numeroValido=numeroCliente>=MINIMO_NUM_CLIENTE && numeroCliente<=MAXIMO_NUM_CLIENTE;
		}while(!numeroValido);
		return numeroCliente;
	}
	public static Double obtenerDuracion() {
		Double duracion;
		do {
		System.out.println("Ingrese duracion de la llamada");
		duracion=Double.parseDouble(input.nextLine());
		}while(duracion<DURACION_MIN || duracion>DURACION_MAX);
		
		return duracion;
	}
	public static String obtenerAbono() {
		String abono;
		boolean abonoValido;
		
		do {
		System.out.println("Ingrese abono");
		abono=input.nextLine();
		abonoValido= abono.equals("a") || abono.equals("b") || abono.equals("c");
		}while(!abonoValido);
		
		return abono;
	}
	public static Double obtenerFactura(String tipoDeAbono, Double duracionLlamada) {
		Double factura=0.0;
		Double precioMinuto=0.0;
		final Double PRECIO_MIN_A=2.0;
		final Double PRECIO_MIN_B=2.0;
		final Double PRECIO_MIN_C=1.0;
		final Double CINCO_MINS_B=5.0;
		final Double PRECIO_PROMO_B=1.5, PRECIO_MAX_C=10.0;
		
		if (tipoDeAbono.equals("a")) {
			factura=precioMinuto*duracionLlamada;
		}
		else if(tipoDeAbono.equals("b")) {
			if (duracionLlamada>CINCO_MINS_B) {
				factura=precioMinuto*CINCO_MINS_B;
				factura+=PRECIO_PROMO_B*(duracionLlamada-CINCO_MINS_B);
			}
			else if(duracionLlamada<CINCO_MINS_B) {
				factura=precioMinuto*duracionLlamada;
			}
		}
		else if(tipoDeAbono.equals("c")) {
			if (duracionLlamada>=10) {
				factura=PRECIO_MAX_C;
			}
			else {
				factura=duracionLlamada*precioMinuto;
			}
		}
		return factura;
	}
	public static boolean funcionSalida() {
		String salida;
		boolean quiereSalir;
		
		System.out.println("Presione enter para seguir o f para salir");
		salida=input.nextLine();
		quiereSalir=salida.equals("f");
		
		return quiereSalir;
	}
	public static Double duracionMinMax(Double duracionLlamada, Double duracionMinMax, String eleccion) {
		Double duracionMax, duracionMin;
		Double min_y_max[]=new Double[2];
		int resultado=0;
		
		if(eleccion.equals("min")) {
			if(duracionLlamada<duracionMinMax) {
				duracionMin=duracionLlamada;
			}
			else {
				duracionMin=duracionMinMax;
			}
			min_y_max[0]=duracionMin;
			resultado=0;
		}
		else if(eleccion.contentEquals("max")){
			if (duracionLlamada>duracionMinMax) {
				duracionMax=duracionLlamada;
			}
			else {
				duracionMax=duracionMinMax;
			}
			min_y_max[1]=duracionMax;
			resultado=1;
		}
		
		return min_y_max[resultado];
	}
	public static Double pedirPromedio(Double importeTotal, Double cantidadDeLlamadas) {
		Double precioPromedio;
		precioPromedio=importeTotal/cantidadDeLlamadas;
		return precioPromedio;
	}
	public static void despedida(Double aRecaudarA, Double aRecaudarB, Double aRecaudarC, Double totalRecaudar, Double llamadaMasLarga, Double llamadaMasCorta, Double precioPromedio) {
		System.out.println("Importe acumulado a recaudar A: $"+ aRecaudarA);
		System.out.println("Importe acumulado a recaudar B: $"+ aRecaudarB);
		System.out.println("Importe acumulado a recaudar C: $"+ aRecaudarC);
		System.out.println("Total a recaudar: $"+ totalRecaudar);
		System.out.println("La llamada mas larga fue de "+ llamadaMasLarga+ " minutos.");
		System.out.println("La llamada mas corta fue de "+ llamadaMasCorta+ " minutos.");
		System.out.println("El precio promedio por llamada es de: $"+ precioPromedio);
	}
}
