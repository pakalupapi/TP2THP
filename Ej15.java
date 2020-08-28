package ejercicios;
import java.util.Scanner;
public class Ej15 {
	private static Scanner input=new Scanner(System.in);
	final static int MINIMO_NUM_CLIENTE=100001, MAXIMO_NUM_CLIENTE=999999;
	final static int MINIMO_DURACION_LLAMADA=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroCliente;
		Double duracionLlamada;
		Double importePorLlamada;
		Double aRecaudarA=0.0, aRecaudarB=0.0, aRecaudarC=0.0;
		String tipoDeAbono="";
	
		numeroCliente=bienvenida();
		duracionLlamada=obtenerDuracion();
		tipoDeAbono=obtenerAbono();
		importePorLlamada=obtenerFactura(tipoDeAbono, duracionLlamada);
		if(tipoDeAbono.equals("a")) {
			aRecaudarA+=importePorLlamada;
		}
		else if(tipoDeAbono.equals("b")) {
			aRecaudarB+=importePorLlamada;
		}
		else{
			aRecaudarC+=importePorLlamada;
		}
	}
	public static int bienvenida() {
		int numeroCliente=0;
		boolean numeroValido;
		
		System.out.println("Bienvenido al sistema de registro de llamada");
		do {
			System.out.println("Ingrese numero del cliente");
			numeroCliente=Integer.parseInt(input.nextLine());
			numeroValido=numeroCliente<=MINIMO_NUM_CLIENTE && numeroCliente<=MAXIMO_NUM_CLIENTE;
		}while(!numeroValido);
		return numeroCliente;
	}
	public static Double obtenerDuracion() {
		Double duracion;
		do {
		System.out.println("Ingrese duracion de la llamada");
		duracion=Double.parseDouble(input.nextLine());
		}while(duracion<MINIMO_DURACION_LLAMADA);
		
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
		String abono="";
		final Double PRECIO_MIN_A=2.0;
		final Double PRECIO_MIN_B=2.0;
		final Double PRECIO_MIN_C=1.0;
		final Double CINCO_MINS_B=5.0;
		final Double PRECIO_PROMO_B=1.5, PRECIO_MAX_C=10.0;
		
		switch(tipoDeAbono) {
		case "a": precioMinuto=PRECIO_MIN_A;
			abono=tipoDeAbono;
			break;
		case "b": precioMinuto=PRECIO_MIN_B;
			abono=tipoDeAbono;
			break;
		case "c": precioMinuto=PRECIO_MIN_C;
			abono=tipoDeAbono;
			break;
		}
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
			if (duracionLlamada<=10) {
				factura=PRECIO_MAX_C;
			}
			else {
				factura=duracionLlamada*precioMinuto;
			}
		}
		return factura;
	}
}
