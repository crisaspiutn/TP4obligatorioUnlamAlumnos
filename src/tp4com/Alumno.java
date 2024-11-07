package tp4com;

import java.util.Date;
import java.util.Scanner;

public class Alumno {
	private Integer maximoGradoAlcanzado=0;
	private Integer maximoAnioAlcanzado=0;
	private String nombre;
	private String apellido;
	private Integer dni;
	private Date asistencia;
	public Alumno(Integer dni,String nombre,String apellido) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
	}
	public Integer getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	static Integer ValidaEdad(Scanner sc,Integer min,Integer max) {
		Integer valor,error=0;
		do {
			if(error==1)System.out.println("ingrese un valor entre ["+min+"-"+max+"]: ");
			error=1;
			valor=sc.nextInt();
		}while(valor<min||valor>max);
		return valor;
	}
	static Boolean yaExisteAlumnoConEsteDni(Integer dni, Alumno[] alumnos) {
		if(dni!=null)
		for (int i = 0; i < alumnos.length; i++) {
			if(alumnos[i]!=null) {				
				if(alumnos[i].getDni()!=null&&alumnos[i].getDni().equals(dni)) {
					return true;
				}
			}
		}
		return false;
	}
	static String titulos="DNI\tNombre\tApellido";
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// System.out.println(super.toString());// tp0com.Alumno@3c5a99da
		return this.getDni()+" \t"+this.getNombre()+"\t"+this.getApellido();
	}
}
