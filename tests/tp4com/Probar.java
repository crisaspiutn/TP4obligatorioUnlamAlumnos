package tp4com;

import static org.junit.Assert.*;

import org.junit.Test;

public class Probar {

	@Test
	public void test() {
		Alumno nuevoAlumno1=new Alumno(1,"Carlos","b");
		Alumno nuevoAlumno2=new Alumno(2,"Ana","b");
		Alumno nuevoAlumno3=new Alumno(3,"Bruno","b");
		Integer edadMinima=2;
		String nombre="salita celeste a";
		Integer cantidadDocentes=2;
		Integer cantidadAlumnos=5;
		Integer cantidadMaterias=1;
		Curso curso=new Curso(edadMinima,nombre,cantidadDocentes,cantidadAlumnos,cantidadMaterias);
		curso.siAgregaAlumno(nuevoAlumno2);
		curso.siAgregaAlumno(nuevoAlumno3);
		curso.siAgregaAlumno(nuevoAlumno1);
		Alumno alumnos[]=curso.getAlumnos();
		
		assertEquals("Ana", curso.getAlumnos()[0].getNombre());
		assertEquals("Bruno", curso.getAlumnos()[1].getNombre());
		assertEquals("Carlos", curso.getAlumnos()[2].getNombre());
		assertNotNull(curso);
	}

}
