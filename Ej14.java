package ejercicios;
import java.util.Scanner;
public class Ej14 {
	private static Scanner input=new Scanner(System.in);
	final static int FACTURA_BASE=8500;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombreEmpresa;
		boolean salida;
		int viajesAdicionales;
		int factura, promFactura, mayorFactura=0, totalFacturado=0;
		int cuenta=1;
		
		do {
			factura=0;
			nombreEmpresa=bienvenida();
			viajesAdicionales=pedirViajes();
			factura=facturaNeta(viajesAdicionales);
			informe(nombreEmpresa, factura);
			totalFacturado+=factura;
			cuenta+=1;
			promFactura=promediarFactura(totalFacturado, cuenta);
			mayorFactura=obtenerFacturaMax(mayorFactura, factura);
			salida=funcionSalida();
		}while(!salida);
		
		despedida(promFactura, mayorFactura);
		input.close();
	}
	public static String bienvenida() {
		String nombreEmpresa;
		System.out.println("Ingrese el nombre de la empresa");
		nombreEmpresa=input.nextLine();
		System.out.println("Bienvenido "+nombreEmpresa);
		return nombreEmpresa;
	}
	public static int pedirViajes() {
		int viajesAdicionales;
		System.out.println("Indique la cantidad de viajes adicionales");
		viajesAdicionales=Integer.parseInt(input.nextLine());
		return viajesAdicionales;
	}
	public static int facturaNeta(int viajesAdicionales) {
		int facturaNeta;
		facturaNeta=FACTURA_BASE+viajesAdicionales*100;
		return facturaNeta;
	}
	public static void informe(String nombreEmpresa, int factura){
		System.out.println("La empresa "+ nombreEmpresa+ " debera pagar $"+factura);
	}
	public static boolean funcionSalida() {
		String salida;
		boolean quiereSalir;
		
		System.out.println("Presione enter para seguir o f para salir");
		salida=input.nextLine();
		quiereSalir=salida.equals("f");
		
		return quiereSalir;
	}
	public static int promediarFactura(int totalFacturado, int cuenta) {
		int promedio;
		promedio=totalFacturado/cuenta;
		return promedio;
	}
	public static int obtenerFacturaMax(int mayorFactura, int factura) {
		
		if (factura>mayorFactura) {
			mayorFactura=factura;
		}
		return mayorFactura;
	}
	public static void despedida(int promFactura, int mayorFactura) {
		System.out.println("El promedio pagado por empresa el pasado mes fue de $"+ promFactura+ ".");
		System.out.println("La mayor factura es por un total de $"+mayorFactura+". ");
	}
}
