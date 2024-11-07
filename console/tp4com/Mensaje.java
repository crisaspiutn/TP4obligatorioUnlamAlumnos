package tp4com;

import tp4com.Curso;

public class Mensaje {
	static void mostrarListaDeOpcionesConOpSalir(String opciones[]) {// String Object no//bc last item hasnot "salir"
		for (int i = 0; i < opciones.length; i++) {
			if(opciones.length-1==i) {// indice del ultimo lo cual es (ultimo -1)
				System.out.print("[0]: ");//cantidad total menos 1
			}else
				System.out.print("["+(i+1)+"]: ");
			System.out.println(opciones[i]);
		}
		System.out.print("ingresa valor entre [1-"+(opciones.length-1)+"] o [0] para salir: ");
	}
	static Integer mostrarListaDeOpcionesSinOpSalir(Object opciones[]) {
		Integer index=0;
		for (int i = 0; i < opciones.length; i++) {
			if(opciones[i]!=null) {				
				System.out.println("["+(index+1)+"] "+opciones[i]);
				index++;
			}
		}
		System.out.println("[0] salir");//cantidad total menos 1
		System.out.print("ingresa valor entre [1-"+(index)+"]: o [0] para salir: ");
		return index;
	}
	static void mostrarListaDeOpcionesSegunIndices(Integer listaDeIndices[],Curso listaDeCursos[]) {
		System.out.println("Op   "+Curso.getTitulosEnFila());
		for (int i = 0; i < listaDeIndices.length; i++) {
			Curso curso=listaDeCursos[listaDeIndices[i]];
			if(curso!=null) {				
				System.out.print("["+(i+1)+"]: ");
				System.out.println(curso.getFilaComoOpcion());
			}
		}
		System.out.println("[0] salir");//cantidad total menos 1
		System.out.print("ingresa valor entre [1-"+listaDeIndices.length+"]: o [0] para salir: ");
	}
	static public String[] opcionesPrincipales= {
			"crear nuevo curso",
			"ver cursos",
			"inscribir un alumno",
			"desinscribir un alumno",
			"ver lista inscriptos",
			"asignar un docente",
			"despedir docente",
			"tomar asistencia",
			"ver porcentaje de asistencia",
			"poner nota",
			"ver lista notas",
			"iniciar gestion",
			"salir"
//			"abm altas bajas modificaciones español"
	};
	static public String[] opcionesDeTiposDeCursos= {
			"salita Celeste",
			"salita Verde",
			"salita Azul",
			"salita Roja",
			"primer Grado",
			"segundo Grado",
			"tercer Grado",
			"cuarto Grado",
			"quinto Grado",
			"sexto Grado",
			"primer Anio",
			"segundo Anio",
			"tercer Anio",
			"cuarto Anio",
			"quinto Anio",
			"sexto Anio",
			"salir"
//			"abm altas bajas modificaciones español"
	};
}
