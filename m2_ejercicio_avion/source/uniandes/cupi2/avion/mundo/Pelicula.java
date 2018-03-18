package uniandes.cupi2.avion.mundo;

public class Pelicula {
	private String nombre;
	private String genero;
	private int duracion;
	private String director;
	
	public static final String COMEDIA = "Comedia",
			ACCION = "Acción",
			DRAMA = "Drama", 
			INFANTIL = "Infantil",
			ROMANCE = "Romance";
	
	public Pelicula(String nombre, String genero, int duracion, String director) {
		this.nombre = nombre;
		this.genero = genero;
		this.duracion = duracion;
		this.director = director;
	}
	
	public String darNombre() {
		return nombre;
	}
	
	public String darGenero() {
		return genero;
	}
	
	public int darDuracion() {
		return duracion;
	}
	
	public String darDirector() {
		return director;
	}

	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void cambiarGenero(String genero) {
		this.genero = genero;
	}
	
	public void cambiarDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public void cambiarDirector(String director) {
		this.director = director;
	}
	
	public String toString() {
		return "<" + darNombre() + "> (<" + darGenero() + ">). <" + darDuracion() + "> minutos - " + darDirector();
	}
}
