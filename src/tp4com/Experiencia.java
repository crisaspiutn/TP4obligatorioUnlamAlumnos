package tp4com;

import java.util.Arrays;

public class Experiencia {
	private Boolean experienciaEnJardin;
	private Boolean experienciaEnPrimaria[]=new Boolean[6];
	private Boolean experienciaEnSecundaria[]=new Boolean[6];
	public Experiencia() {
		this.experienciaEnJardin=false;
		Arrays.fill(experienciaEnPrimaria, false);
		Arrays.fill(experienciaEnSecundaria, false);
	}
	
	public String getExperienciaEnFila() {
		return experienciaEnJardin?"si":"no"+"\t";
	}
	public static String getTitulosEnFila() {
		return "jardin\t1º\t2º\t3º\t4º\t5º\t6º\t1 año\t2 año\t3 año\t4 año\t5 año\t6 año";
	}
}
