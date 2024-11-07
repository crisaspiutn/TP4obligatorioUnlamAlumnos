package tp4com;

import java.util.Iterator;
import java.util.Scanner;

import tp4com.Alumno;
import tp4com.App;
import tp4com.Curso;
import tp4com.Data;
import tp4com.TipoNivel;

public class Menu {
	private static final int CREAR_NUEVO_CURSO=1,VER_CURSOS=2,
			INSCRIBIR_UN_ALUMNO=3,DESINSCRIBIR_UN_ALUMNO=4,VER_LISTA_INSCRIPTOS=5,
			ASIGNAR_UN_DOCENTE=6,DESPEDIR_DOCENTE=7,
			TOMAR_ASISTENCIA=8,VER_PORCENTAJE_DE_ASISTENCIA=9,
			PONER_NOTA=10,VER_LISTA_NOTAS=11,
			INICIAR_GESTION=12,SALIR=0;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Data.cursos_jardin[0]=new Curso(2,"salita celeste a",2,20,1);
		Data.cursos_jardin[1]=new Curso(2,"salita celeste b",2,20,1);
		Data.cursos_jardin[2]=new Curso(3,"salita verde a",2,20,1);
		Data.cursos_jardin[3]=new Curso(4,"salita azul a",2,20,1);
		Data.cursos_jardin[4]=new Curso(5,"salita roja a",2,20,1);
		Data.cursos_primaria[0]=new Curso(6,"primero a",1,20,1);
		Data.cursos_primaria[1]=new Curso(7,"segundo a",1,20,1);
		Data.cursos_primaria[2]=new Curso(8,"tercero a",1,20,1);
		Data.cursos_primaria[3]=new Curso(9,"cuarto a",1,20,1);
		Data.cursos_primaria[4]=new Curso(10,"quinto a",1,20,1);
		Data.cursos_primaria[5]=new Curso(11,"sexto a",1,20,1);
		Data.cursos_secundaria[0]=new Curso(12,"1ro 1ra",1,20,1);
		Data.cursos_secundaria[1]=new Curso(13,"2do 1ra",1,20,1);
		Data.cursos_secundaria[2]=new Curso(14,"3ro 1ra",1,20,1);
		Data.cursos_secundaria[3]=new Curso(15,"4to 1ra",1,20,1);
		Data.cursos_secundaria[4]=new Curso(16,"5to 1ra",1,20,1);
		Data.cursos_secundaria[5]=new Curso(17,"6to 1ra",1,20,1);
		mostrarMenu(sc);
	}
	static private void mostrarMenu(Scanner sc) {
		Integer opcion;
		do {
			Mensaje.mostrarListaDeOpcionesConOpSalir(Mensaje.opcionesPrincipales);
			// System.out.print("ingrese una opcion:  ");
			opcion=sc.nextInt();
//			opcion=Validador.leerEnteroMinMaxOp(sc, 1, Mensaje.opcionesPrincipales.length, 0);
			switch(opcion) {
				case CREAR_NUEVO_CURSO:
					crearNuevoCurso(sc);
					break;
				case VER_CURSOS:
					ver_cursos(sc);
					break;
				case INSCRIBIR_UN_ALUMNO:
					System.out.println("inscribir un alumno");
					inscribirUnAlumno(sc);
					break;
				case DESINSCRIBIR_UN_ALUMNO:
					desinscribir_un_alumno(sc);
					break;
				case VER_LISTA_INSCRIPTOS:
					verListaInscriptos();
					break;
				case ASIGNAR_UN_DOCENTE:
					asignarUnDocente(sc);
					break;
				case DESPEDIR_DOCENTE:
					break;
				case TOMAR_ASISTENCIA:
					break;
				case VER_PORCENTAJE_DE_ASISTENCIA:
					break;
				case PONER_NOTA:
					break;
				case VER_LISTA_NOTAS:
					break;
				case INICIAR_GESTION:
					break;
				case SALIR:
					System.out.print("salio del programa");
				default:
					continue;
			}
			System.out.print("ingrese [enter] para continuar o cualquier valor");
			sc.nextLine();
			sc.nextLine();
			System.out.println("___________________________________________________________");
		}while(opcion!=0);
	}
	private static void crearNuevoCurso(Scanner sc) {
		Curso nuevoCurso,cursosElegidos[]=null;
		System.out.print("ingrese la edad minima permitida en el curso entre [2-17]: ");
		Integer edadMinima=Validador.leerEnteroMinMax(sc, 2, 17);
		String nombreDelCurso="",alias;
		if(edadMinima>=2&&edadMinima<=5) {
			cursosElegidos=Data.cursos_jardin;
		}
		else if(edadMinima>=6&&edadMinima<=11) {
			cursosElegidos=Data.cursos_primaria;
		}
		if(edadMinima>=12&&edadMinima<=17) {
			cursosElegidos=Data.cursos_secundaria;
		}
		if(cursosElegidos==null) {
			System.out.println("no hay espacio asignado para ese tipo de cursos");
			return;
		}
		if(Curso.siListaDeCursosEstaLleno(cursosElegidos)) {
			System.out.println("no hay espacio en la lista de cursos para este tipo de curso");
			return;
		}
		System.out.println("el curso se llamara: "+TipoNivel.obtenerDescripcion(edadMinima));
		nombreDelCurso=TipoNivel.obtenerDescripcion(edadMinima);
		String aliasSugerido=App.pedirSugerenciaValidaParaNombreDeCurso(nombreDelCurso,cursosElegidos);
		if(aliasSugerido==null) {			
			System.out.print("ingrese el alias dinstintivo del curso: ");
		}else {			
		}
		do {
			System.out.print("ingrese el alias dinstintivo del curso o presione [enter] para usar el sugerido \""+aliasSugerido+"\": ");
			sc.nextLine();
			alias=sc.nextLine();
			if(alias.equals(""))nombreDelCurso=nombreDelCurso + " "+ aliasSugerido;
			else nombreDelCurso=nombreDelCurso + " "+ alias;
		}while(alias.equals(" ")||Curso.siExisteEsteNombreEnLaListaDeCursos(nombreDelCurso, cursosElegidos));
		System.out.println("el nombre del curso sera: \""+nombreDelCurso+"\"");
		Integer cantidadDocentes,cantidadAlumnos,cantidadMaterias;
		System.out.print("ingrese la cantidad de Docentes: ");
		cantidadDocentes=Validador.leerEnteroMin(sc, 1);
		System.out.print("ingrese la cantidad de Alumnos: ");
		cantidadAlumnos=Validador.leerEnteroMin(sc, 1);
		System.out.print("ingrese la cantidad de Materias: ");
		cantidadMaterias=Validador.leerEnteroMin(sc, 1);
		nuevoCurso=new Curso(edadMinima,nombreDelCurso,cantidadDocentes,cantidadAlumnos,cantidadMaterias);
		if(Curso.siAgregoCursoEnListaDeCursos(nuevoCurso, cursosElegidos))System.out.println("curso agregado");
		else System.out.println("no se pudo agregar el curso");
	}
	private static void ver_cursos(Scanner sc) {
		String opciones_de_visualizacion[]= {
				"ver cursos de jardin","ver cursos de primaria","ver cursos de secundaria","volver al menu principal"
		};
		Mensaje.mostrarListaDeOpcionesConOpSalir(opciones_de_visualizacion);
		Integer opcion=Validador.leerEnteroMinMaxOp(sc, 1, opciones_de_visualizacion.length-1, 0);
		if(opcion==0) {System.out.println("salio de la seleccion de tipo de curso");return;}
		Curso listaDeCursosElegido[]=null;
		if(opcion==1)listaDeCursosElegido=Data.cursos_jardin;
		else if(opcion==2)listaDeCursosElegido=Data.cursos_primaria;
		else if(opcion==3)listaDeCursosElegido=Data.cursos_secundaria;
		if(listaDeCursosElegido==null) {System.out.println("no hay cursos en su eleccion");return;}
		
		System.out.println(Curso.getTitulosEnFila());
		for (int i = 0; i < listaDeCursosElegido.length; i++) {
			if(listaDeCursosElegido[i]!=null) {
				System.out.println(listaDeCursosElegido[i].getFilaComoOpcion());
			}
		}
	}
	private static void inscribirUnAlumno(Scanner sc) {
		String opciones_de_incripcion[]= {
				"inscribir al jardin","inscribir a primaria","inscribir a secundaria","regresar atras"
		};
		Mensaje.mostrarListaDeOpcionesConOpSalir(opciones_de_incripcion);
		Integer opcion=Validador.leerEnteroMinMaxOp(sc, 1, opciones_de_incripcion.length-1, 0);
		if(opcion==0) {System.out.println("salio de la seleccion de tipo de curso");return;}
		Curso listaDeCursosElegido[]=null;
		if(opcion==1) listaDeCursosElegido=Data.cursos_jardin;
		else if(opcion==2) listaDeCursosElegido=Data.cursos_primaria;
		else if(opcion==3) listaDeCursosElegido=Data.cursos_secundaria;
		if(listaDeCursosElegido==null) {System.out.println("no hay cursos en su eleccion");return;}
		
		Integer edad,minimaEdad,maximaEdad;
		minimaEdad=App.minimaEdadEnLosCursos(listaDeCursosElegido);
		maximaEdad=App.maximaEdadEnLosCursos(listaDeCursosElegido);
		System.out.print("ingrese una edad valida entre ["+minimaEdad+"-"+maximaEdad+"] o [0] para cancelar: ");
		edad=Validador.leerEnteroMinMaxOp(sc, minimaEdad, maximaEdad,0);
		if(edad==0) {System.out.println("cencelo la agregacion de un alumno al ingresar la edad");return;}
//			Curso cursoAdecuado=Data.cursos_jardin[indiceDelCursoAdecuado];
		// 2 formas | copiando las adecuadas en una lista || guardar indices de las adecuadas
		Integer listaDeIndicesDeCursos[]=App.obtieneIndicesDeLosCursosDisponiblesSegunEdad(listaDeCursosElegido,edad);
		if(listaDeIndicesDeCursos==null) {				
			System.out.println("no hay cupos disponibles en ningun curso para su edad");
			return;
		}
//			else {
		Mensaje.mostrarListaDeOpcionesSegunIndices(listaDeIndicesDeCursos, listaDeCursosElegido);
		opcion=Validador.leerEnteroMinMaxOp(sc, 1, listaDeIndicesDeCursos.length, 0);
		if(opcion==0) {
			System.out.println("cancela seleccion de curso");
			return;
		}
//				else {
		Curso cursoElegido=listaDeCursosElegido[listaDeIndicesDeCursos[opcion-1]];
		//Alumno lista_alumnos[]=cursoAdecuado.getAlumnos();
		System.out.print("ingrese el DNI o [0] para cancelar:  ");
		Integer dni;
		Boolean siExisteAlumno;
		do {
			dni=sc.nextInt();
			if(dni!=0) {
//				siExisteAlumno=Alumno.yaExisteAlumnoConEsteDni(dni, cursoElegido.getAlumnos());
				siExisteAlumno=App.siExisteEsteDniEnAlgunCurso(dni);
				if(siExisteAlumno)System.out.print("Este DNI ya existe. Ingrese otro o [0] para cancelar: ");
			}else {
				siExisteAlumno=false;
			}
		}while(siExisteAlumno);
		if(dni==0) {System.out.println("cencelo la agregacion de un alumno al ingresar DNI");return;}
		System.out.print("ingresa el nombre: ");
		String nombre=sc.next();
		System.out.print("ingresa el apellido: ");
		String apellido=sc.next();
		Alumno nuevoAlumno=new Alumno(dni,nombre,apellido);
		if(cursoElegido.siAgregaAlumno(nuevoAlumno))
			System.out.println("agregado al salon");
		else 
			System.out.println("no hay espacio en el salon");
//				}
//			}
//		}
	}
	private static void desinscribir_un_alumno(Scanner sc) {
//		String opciones_de_busqueda[]= {
//				"listar que tengan cierto numero en el dni",
//				"listar que posean cierto nombre",
//				"listar poseedores de cierto apellido",
//				"regresar atras"
//		};
//		Mensaje.mostrarListaDeOpcionesConOpSalir(opciones_de_busqueda);
//		Integer opcion=Validador.leerEnteroMinMaxOp(sc, 1, opciones_de_busqueda.length-1, 0);
//		if(opcion==0) {System.out.println("salio de la seleccion de tipo de curso");return;}
//		else if(opcion==1) {
//			
//		}
//		else if(opcion==2) {
//			
//		}
//		else if(opcion==3) {
//			
//		}
		System.out.println("selecciona alumno para desinscribir");
		Curso listas_de_cursos[][]= {
				Data.cursos_jardin,Data.cursos_primaria,Data.cursos_secundaria
		};
		Integer cantidadTotalInscriptos=sumTotalInscriptosDesdeListaDeListasDeCursos(listas_de_cursos);
		Alumno listaAlumnosInscriptos[]=new Alumno[cantidadTotalInscriptos];
		System.out.println("cantidad total de inscriptos: "+listaAlumnosInscriptos.length);
		listaAlumnosInscriptos=getListaAlumnosInscriptosDesdeListaDeListasDeCursos(listaAlumnosInscriptos, listas_de_cursos);
		System.out.println("OP   "+Alumno.titulos);
		Mensaje.mostrarListaDeOpcionesSinOpSalir(listaAlumnosInscriptos);
		Integer opcion=Validador.leerEnteroMinMaxOp(sc, 1, listaAlumnosInscriptos.length, 0);
		if(opcion==0) {System.out.println("cencelo la seleccion de alumno para desinscribir");return;}
		System.out.println("alumno seleccionado");
		System.out.println(Alumno.titulos);
		System.out.println(listaAlumnosInscriptos[opcion-1]);
		listas_de_cursos=removeAlumnoFromListaDeListasDeCursos(listaAlumnosInscriptos[opcion-1],listas_de_cursos);
	}
	private static Integer sumTotalInscriptosDesdeListaDeListasDeCursos(Curso[][] listas_de_cursos) {
		Integer cantidadTotalInscriptos=0;
		for (int i = 0; i < listas_de_cursos.length; i++) if(listas_de_cursos[i]!=null)
		for (int j = 0; j < listas_de_cursos[i].length; j++) if(listas_de_cursos[i][j]!=null)
		cantidadTotalInscriptos+=listas_de_cursos[i][j].getCantidadAlumnosInscriptos();
		return cantidadTotalInscriptos;
	}
	private static Alumno[] getListaAlumnosInscriptosDesdeListaDeListasDeCursos(Alumno listaAlumnosInscriptos[],Curso[][] listas_de_cursos) {
		Integer indice=0;
		for (int i = 0; i < listas_de_cursos.length; i++)
		if(listas_de_cursos[i]!=null)
		for (int j = 0; j < listas_de_cursos[i].length; j++)
		if(listas_de_cursos[i][j]!=null)
		if(listas_de_cursos[i][j].getAlumnos()!=null)
		for (int k = 0; k < listas_de_cursos[i][j].getAlumnos().length; k++) 
			if(listas_de_cursos[i][j].getAlumnos()[k]!=null) {					
				listaAlumnosInscriptos[indice]=listas_de_cursos[i][j].getAlumnos()[k];
				indice++;
			}
		return listaAlumnosInscriptos;
	}
	private static Curso[][] removeAlumnoFromListaDeListasDeCursos(Alumno alumnoElegido,Curso[][] listas_de_cursos) {
		for (int i = 0; i < listas_de_cursos.length; i++)
			if(listas_de_cursos[i]!=null)
				for (int j = 0; j < listas_de_cursos[i].length; j++)
					if(listas_de_cursos[i][j]!=null)
						if(listas_de_cursos[i][j].getAlumnos()!=null) {
							Alumno[] alumnos=listas_de_cursos[i][j].getAlumnos();
							for (int k = 0; k < alumnos.length; k++) 
								if(alumnos[k]!=null) {
									if(alumnoElegido.getDni().equals(alumnos[k].getDni()))
										System.out.println(listas_de_cursos[i][j].deleteAlumno(k));
									
										//alumnos[k]=null;
								}
						}
		return listas_de_cursos;
	}
	private static void verListaInscriptos() {
		Curso listas_de_cursos[][]= {
				Data.cursos_jardin,Data.cursos_primaria,Data.cursos_secundaria
		};
		Integer cantidadTotalInscriptos=sumTotalInscriptosDesdeListaDeListasDeCursos(listas_de_cursos);
		Alumno listaAlumnosInscriptos[]=new Alumno[cantidadTotalInscriptos];
		System.out.println("cantidad total de inscriptos: "+listaAlumnosInscriptos.length);
		listaAlumnosInscriptos=getListaAlumnosInscriptosDesdeListaDeListasDeCursos(listaAlumnosInscriptos, listas_de_cursos);
		System.out.println(Alumno.titulos);
		for (int i = 0; i < listaAlumnosInscriptos.length; i++) System.out.println(listaAlumnosInscriptos[i]);		
	}
	private static void asignarUnDocente(Scanner sc) {
		String opciones_de_incripcion[]= {
				"inscribir al jardin","inscribir a primaria","inscribir a secundaria","regresar atras"
		};
		Mensaje.mostrarListaDeOpcionesConOpSalir(opciones_de_incripcion);
		Integer opcion=Validador.leerEnteroMinMaxOp(sc, 1, opciones_de_incripcion.length-1, 0);
		if(opcion==0) {System.out.println("salio de la seleccion de tipo de curso");return;}
		Curso listaDeCursosElegido[]=null;
		if(opcion==1) listaDeCursosElegido=Data.cursos_jardin;
		else if(opcion==2) listaDeCursosElegido=Data.cursos_primaria;
		else if(opcion==3) listaDeCursosElegido=Data.cursos_secundaria;
		if(listaDeCursosElegido==null) {System.out.println("no hay cursos en su eleccion");return;}
		System.out.println("Op  "+Curso.getTitulosEnFila());
		Integer maximoValor=Mensaje.mostrarListaDeOpcionesSinOpSalir(listaDeCursosElegido);
		opcion=Validador.leerEnteroMinMaxOp(sc, 1, maximoValor, 0);
		if(opcion==0) {System.out.println("salio de la seleccion de un curso");return;}
		System.out.println("curso elegido");
		System.out.println(Curso.getTitulosEnFila());
		System.out.println(App.buscarElementoContandoNoNulosDesdeLista(opcion-1,listaDeCursosElegido));
	}
	
}
