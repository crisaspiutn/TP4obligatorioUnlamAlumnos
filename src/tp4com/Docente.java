package tp4com;

import java.util.Arrays;

public class Docente {
	private Integer dni;
	private Experiencia experiencia;
	public Docente(Integer dni,Experiencia experiencia) {
		this.dni=dni;
		this.experiencia=experiencia;
	}
	public Integer getDni() {
		return dni;
	}
}
