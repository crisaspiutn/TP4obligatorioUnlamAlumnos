package tp4com;

import java.util.Scanner;

public class Validador {
	static Integer leerEnteroMinMaxOp(Scanner sc,Integer min,Integer max, Integer op) {
		Integer valor,error=0;
		do {
			if(error==1)System.out.print("Error. ingrese valor entre ["+min+"-"+max+"] o [0] para salir: ");
			valor=sc.nextInt();
			error=1;
		}while((valor<min||valor>max)&&valor!=op);
		return valor;
	}
	static Integer leerEnteroMinMax(Scanner sc,Integer min,Integer max) {
		Integer valor,error=0;
		do {
			if(error==1)System.out.print("Error. ingrese valor entre ["+min+"-"+max+"]: ");
			valor=sc.nextInt();
			error=1;
		}while(valor<min||valor>max);
		return valor;
	}
	static Integer leerEnteroMin(Scanner sc,Integer min) {
		Integer valor,error=0;
		do {
			if(error==1)System.out.print("Error. ingrese valor mayor o igual a ["+min+"]: ");
			valor=sc.nextInt();
			error=1;
		}while(valor<min);
		return valor;
	}
}
