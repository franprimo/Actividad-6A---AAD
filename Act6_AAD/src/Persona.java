
public class Persona {

	String nombre;
	String edad;
	String dni;
	
	public Persona(){
		
	}
	
	public Persona(String nom, String age, String dni){
		this.nombre = nom;
		this.edad = age;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public void print(){
		System.out.println("Nombre: "+nombre+", DNI: "+dni+", Edad: "+edad);
	}
	
}
