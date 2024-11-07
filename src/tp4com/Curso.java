package tp4com;

import java.util.Arrays;

public class Curso {
	private Integer edadMinima;
	private Integer cantidadDocentes;
	private Integer cantidadAlumnos;
	private Integer cantidadMaterias;
	private String nombre;
	private Materia materias [];
	private Alumno alumnos[];
	public Curso(Integer edadMinima,String nombre,Integer cantidadDocentes,Integer cantidadAlumnos,Integer cantidadMaterias) {
		this.edadMinima=edadMinima;
		this.nombre=nombre;
		this.cantidadDocentes=cantidadDocentes;
		this.cantidadAlumnos=cantidadAlumnos;
		this.cantidadMaterias=cantidadMaterias;
		this.materias=new Materia[cantidadMaterias];
		this.alumnos=new Alumno[cantidadAlumnos];
		Arrays.fill(materias, new Materia(this.cantidadDocentes));
	}
	public Integer getEdadMinima() {
		return edadMinima;
	}
	public Integer getCantidadAlumnos() {
		return cantidadAlumnos;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getCantidadDeDocentesAsignados() {
		Integer contDeDocentesAsignados=0;
		for (int i = 0; i < materias.length; i++) {
			if(materias[i]!=null) {
				for (int j = 0; j < materias[i].getDocentes().length; j++) {
					if(materias[i].getDocentes()[j]!=null)contDeDocentesAsignados++;
				}
			}
		}
		return contDeDocentesAsignados;
	}
	public Integer getCantidadDeDocentesPosibles() {
		Integer sumDeDocentesPosibles=0;
		for (int i = 0; i < materias.length; i++) {
			if(materias[i]!=null) {
				sumDeDocentesPosibles+=materias[i].getDocentes().length;
			}
		}
		return sumDeDocentesPosibles;
	}
	public Alumno[] getAlumnos() {
		return alumnos;
	}
	public Boolean deleteAlumno(Integer index) {
		if(this.alumnos[index]==null)return false;
		this.alumnos[index]=null;
		return true;
	}
	public Integer getCantidadAlumnosInscriptos() {
		Integer contarExistentes=0;
		for (int i = 0; i < this.alumnos.length; i++) {
			if(this.alumnos[i]!=null)contarExistentes++;
		}
		return contarExistentes;
	}
	public Boolean siAgregaAlumno(Alumno nuevo) {
		for (int i = 0; i < this.alumnos.length; i++) {
			if(this.alumnos[i]==null) {
				this.alumnos[i]=nuevo;
				return true;
			}
		}
		return false;
	}
	public static String getTitulosEnFila() {
		return fill("Nombre",20)+"Inscriptos\t\tMinima_edad\tDocentes\tMaterias";
	}
	public String getFilaComoOpcion() {
		return fill(this.nombre,20)+getCantidadAlumnosInscriptos()+"/"+this.cantidadAlumnos+"\t\t"+this.edadMinima+"\t\t"+this.getCantidadDeDocentesAsignados()+"/"+this.getCantidadDeDocentesPosibles()+"\t\t"+this.cantidadMaterias;
	}
	@Override
	public String toString() {
		return getFilaComoOpcion();
	}
	public static String fill(String cadena,Integer largo) {
		while(cadena.length()<largo)cadena=cadena+" ";
		return cadena;
	}
//	public Boolean yaExisteAlumno(Alumno alumno, Alumno[] alumnos) {
//		for (int i = 0; i < alumnos.length; i++) {
//			if(alumnos[i].getDni().equals(alumno.getDni())) {
//				return true;
//			}
//		}
//		return false;
//	}
	public static Boolean siListaDeCursosEstaLleno(Curso listaDeCursos[]) {
		for (int i = 0; i < listaDeCursos.length; i++) {
			if(listaDeCursos[i]==null)return false;
		}
		return true;
	}
	public static Boolean siExisteEsteNombreEnLaListaDeCursos(String nombre,Curso listaDeCursos[]) {
		for (int i = 0; i < listaDeCursos.length; i++) {
			if(listaDeCursos[i]!=null) {
//				System.out.println("comparacion");
//				System.out.println(listaDeCursos[i].nombre.toLowerCase());
//				System.out.println(nombre.toLowerCase());
				if(listaDeCursos[i].nombre.toLowerCase().equals(nombre.toLowerCase()))return true;
			}
		}
		return false;
	}
	public static Boolean siAgregoCursoEnListaDeCursos(Curso nuevoCurso,Curso listaDeCursos[]) {
		for (int i = 0; i < listaDeCursos.length; i++) {
			if(listaDeCursos[i]==null) {
				listaDeCursos[i]=nuevoCurso;
				return true;
			}
		}
		return false;
	}
}
