
public class Persona {

	String nombre;
	int edad;
	String dni;
	
	public Persona(){
		
	}
	
	public Persona(String nom, int age, String dni){
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
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
