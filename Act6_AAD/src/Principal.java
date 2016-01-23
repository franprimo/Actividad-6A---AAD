import java.util.Scanner;


public class Principal {

	static GestionPersistencia gp = new GestionPersistencia();
	static Persona persona = new Persona();
	static Scanner sc = new Scanner(System.in);
	private static String opcion = null;
	
	public static void main(String[] args) {
		
		menuInicial();

	}
	
	public static void menuInicial(){
		System.out.println("--BD4O--");
		System.out.println("Insertar una persona - 1");
		System.out.println("Buscar una persona por su nombre - 2");
		System.out.println("Buscar una persona por su inicial - 3");
		System.out.println("Buscar una persona por su DNI - 4");
		System.out.println("Buscar una persona por su edad - 5");
		System.out.println("Busqueda avanzada - 6");
		System.out.println("Que quieres hacer?");
		opcion = sc.nextLine();
		
		switch(opcion){
		case "1":
			System.out.println("Nombre: ");
			String n = sc.nextLine();
			System.out.println("Edad: ");
			String edad = sc.nextLine();
			System.out.println("DNI: ");
			String dni = sc.nextLine();
			
			Persona p = new Persona(n, edad, dni);
			
			gp.insertarPersona(p);
			break;
		case "2":
			System.out.println("Nombre: ");
			String nombre = sc.nextLine();
			
			gp.recuperarPersonaPorNombre(nombre);
			persona.print();
			break;
		case "3":
			System.out.println("Inicial: ");
			String inicial = sc.nextLine();
			
			gp.recuperarPersonaPorInicial(inicial);
			break;
		case "4":
			System.out.println("DNI: ");
			String dniPersona = sc.nextLine();
			
			gp.recuperarPersonaPorDni(dniPersona);
			break;
		case "5":
			System.out.println("Edad minima: ");
			String edadMin = sc.nextLine();
			System.out.println("Edad maxima: ");
			String edadMax = sc.nextLine();
			
			gp.recuperarPersonaPorEdad(edadMin, edadMax);
			break;
		case "6":
			System.out.println("Realizando busqueda avanzada");
			gp.recuperarPersonaAvanzada();
		}
	}

}
