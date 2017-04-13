package icaro.aplicaciones.informacion.gestionPizzeria;

public class Direccion {

	private String nombreCalle;
	private int numero;
	private int piso;
	private String puerta;
	private int codigoPostal;
	private String ciudad;
	public Direccion(String nombreCalle, int numero, int piso, String puerta, int codigoPostal) {
		super();
		this.nombreCalle = nombreCalle;
		this.numero = numero;
		this.piso = piso;
		this.puerta = puerta;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
	}
	public String getNombreCalle() {
		return nombreCalle;
	}
	public void setNombreCalle(String nombreCalle) {
		this.nombreCalle = nombreCalle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getPuerta() {
		return puerta;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	@Override
	public String toString() {
		return " calle " + nombreCalle + " número " + numero + ", " + piso + " " + puerta
				+ ", " + codigoPostal;
	}	
	
	
	
}
