package tp4com;

import java.util.Arrays;

import tp4com.Curso;

public class App {
	public static Integer[] obtieneIndicesDeLosCursosDisponiblesSegunEdad(Curso listaDeCursos[],Integer edad) {
		Integer cantidadDeAptos=0;
		for (int i = 0; i < listaDeCursos.length; i++) {
			if(listaDeCursos[i]!=null)
			if(listaDeCursos[i].getEdadMinima()<=edad) {
				cantidadDeAptos++;
			}
		}
//		Arrays.fill(listaDeIndices,null);
//		Integer listaDeIndices[]=new Integer[Data.CANTIDAD_CURSOS];
		if(cantidadDeAptos==0)return null;
		Integer listaDeIndices[]=new Integer[cantidadDeAptos];
		Integer indiceParaGuardar=0;
		for (int i = 0; i < listaDeCursos.length; i++) {
			if(listaDeCursos[i]!=null)
			if(listaDeCursos[i].getEdadMinima()<=edad&&listaDeCursos[i].getCantidadAlumnosInscriptos()<listaDeCursos[i].getCantidadAlumnos()) {
				listaDeIndices[indiceParaGuardar]=i;
				indiceParaGuardar++;
			}
		}
		return listaDeIndices;
	}
	public static Integer maximaEdadEnLosCursos(Curso listaDeCursos[]) {
		Integer maximo=0;
		for (int i = 0; i < listaDeCursos.length; i++) {
			if(listaDeCursos[i]!=null)
			if(listaDeCursos[i].getEdadMinima()>=maximo)maximo=listaDeCursos[i].getEdadMinima();
		}
		return maximo;
	}
	public static Integer minimaEdadEnLosCursos(Curso listaDeCursos[]) {
		Integer minima=10000;
		for (int i = 0; i < listaDeCursos.length; i++) {
			if(listaDeCursos[i]!=null)
			if(listaDeCursos[i].getEdadMinima()<=minima)minima=listaDeCursos[i].getEdadMinima();
		}
		return minima;
	}
	public static String pedirSugerenciaValidaParaNombreDeCurso(String nombre,Curso listaDeCursos[]) {
		Integer codigoAsci=(int)'a';
		while(codigoAsci!=((int)'z')){
			//System.out.println(codigoAsci);
			codigoAsci++;
			Character alias=Character.valueOf((char)(int)codigoAsci);
			String nuevoNombre=nombre+" "+alias;
			if(!Curso.siExisteEsteNombreEnLaListaDeCursos(nuevoNombre,listaDeCursos))return String.valueOf(alias);
		}
		return null;
	}
	public static Boolean siExisteEsteDniEnAlgunCurso(Integer dni) {
		Curso listaDeListasDeCursos[][]= {
				Data.cursos_jardin,Data.cursos_primaria,Data.cursos_secundaria
		};
		for (int x = 0; x < listaDeListasDeCursos.length; x++) 
		if(listaDeListasDeCursos[x]!=null)
		for (int y = 0; y < listaDeListasDeCursos[x].length; y++) 
		if(listaDeListasDeCursos[x][y]!=null) 
		if(listaDeListasDeCursos[x][y].getAlumnos()!=null)
		for (int j = 0; j < listaDeListasDeCursos[x][y].getAlumnos().length; j++) {
			if(listaDeListasDeCursos[x][y].getAlumnos()[j]!=null) {
				if(dni.equals( listaDeListasDeCursos[x][y].getAlumnos()[j].getDni() )) {
					return true;
				}
			}
		}
		return false;
	}
	public static Object buscarElementoContandoNoNulosDesdeLista(Integer index,Object lista[]) {
		Integer cont=0;
		for (int i = 0; i < lista.length; i++) {
			if(lista[i]!=null) {
				if(cont==index)return lista[index];
				cont++;
			}
		}
		return null;
	}
}
//public static Integer[] obtieneIndicesDeLosCursosDisponiblesSegunEdad(Curso listaDeCursos[],Integer edad) {
//	
//	Integer cantidadDeAptos=0;
//	System.out.println("listaDeCursos.length");
//	System.out.println(listaDeCursos.length);
//	for (int i = 0; i < listaDeCursos.length; i++) {
//		
//		if(listaDeCursos[i]!=null) {				
//			System.out.println("edad");
//			System.out.println(edad);
//			System.out.println(listaDeCursos[i].getEdadMinima());
//			if(edad>=listaDeCursos[i].getEdadMinima()) {
//				cantidadDeAptos++;
//				System.out.println(listaDeCursos[i].getEdadMinima());
//				System.out.println("agrego cantidad de indices aptos");
//			}
//		}
//	}
////	Integer listaDeIndices[]=new Integer[Data.CANTIDAD_CURSOS];
//	System.out.println("cantidad de aptos es: "+cantidadDeAptos);
//	if(cantidadDeAptos==0)return null;
//	Integer listaDeIndices[]=new Integer[cantidadDeAptos];
//	Arrays.fill(listaDeIndices,null);
//	Integer indiceParaGuardar=0;
//	for (int i = 0; i < listaDeCursos.length; i++) {
//		if(listaDeCursos[i]==null)System.out.println("es null");
//		if(listaDeCursos[i]!=null)
//		if(listaDeCursos[i].getEdadMinima()>=edad&&listaDeCursos[i].getCantidadAlumnosInscriptos()<listaDeCursos[i].getCantidadAlumnos()) {
//			System.out.println("agrego "+i);
//			listaDeIndices[indiceParaGuardar]=i;
//			indiceParaGuardar++;
//		}
//	}
//	return listaDeIndices;
//}
