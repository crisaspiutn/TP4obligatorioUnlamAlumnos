package tp4com;

public class Materia {
	private Docente docentes[];
	private Integer cantidadDocentes;
//	private Integer cantidadAlumnos;
//	private Integer cantidadDeClases;
//	public Materia(Integer cantidadDocentes,Integer cantidadAlumnos,Integer cantidadDeClases) {
	public Materia(Integer cantidadDocentes) {
		this.cantidadDocentes=cantidadDocentes;
//		this.cantidadAlumnos=cantidadAlumnos;
//		this.cantidadDeClases=cantidadDeClases;
		this.docentes=new Docente[cantidadDocentes];
	}
	public Docente[] getDocentes() {
		return docentes;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}
}
