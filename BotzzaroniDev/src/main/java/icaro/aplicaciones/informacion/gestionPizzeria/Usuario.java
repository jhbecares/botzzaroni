package icaro.aplicaciones.informacion.gestionPizzeria;

public class Usuario {
	
	public String username;
	private String nombre;
	private String apellidos;
	private Direccion direccion;
	private String movil;
	private long tiempo;

	public Usuario() {
		tiempo = System.currentTimeMillis();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	} 
	
	public void actividad() {
		tiempo = System.currentTimeMillis();
	}
	
	public boolean inactividad(int i) {
		long tim = ((System.currentTimeMillis() - tiempo) / 1000) / 60;
		return tim >= i;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion="
				+ direccion + ", movil=" + movil + ", tiempo=" + tiempo + "]";
	}
	
	
	
}
