package tp4com;

public enum TipoNivel {
	CELESTE(2, "salita celeste"),
	VERDE(3, "salita verde"),
	AZUL(4, "salita azul"),
	ROJA(5, "salita roja"),
    PRIMERO(6, "primero"),
    SEGUNDO(7, "segundo"),
	TERCERO(8, "tercero"),
	CUARTO(9, "cuarto"),
	QUINTO(10, "quinto"),
	SEXTO(11, "sexto"),
	PRIMER_ANIO(12, "primer anio"),
	SEGUNDO_ANIO(13, "segundo anio"),
	TERCER_ANIO(14, "tercer anio"),
	CUARTO_ANIO(15, "cuarto anio"),
	QUINTO_ANIO(16, "quinto anio"),
	SEXTO_ANIO(17, "sexto anio");

    private int codigo;
    private String descripcion;

    // Constructor del enum
    TipoNivel(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    // Método para obtener la descripción a partir del código numérico
    public static String obtenerDescripcion(int codigo) {
        for (TipoNivel nivel : TipoNivel.values()) {
            if (nivel.codigo == codigo) {
                return nivel.descripcion;
            }
        }
        return "Código no válido";
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	for (TipoNivel nivel : TipoNivel.values()) {
            if (nivel.codigo == codigo) {
                return nivel.descripcion;
            }
        }
        return "Código no válido";
//    	return super.toString();
    }
}