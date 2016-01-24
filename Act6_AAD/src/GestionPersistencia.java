import java.util.ArrayList;
import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Predicate;
import com.db4o.query.Query;


public class GestionPersistencia {
	
	ObjectContainer bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");;

	public void insertarPersona(Persona p){
		//bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");
		
		try{
			bbdd.store(p);
			bbdd.commit();
			System.out.println("Guardado correctamente.");
		}finally{
			bbdd.close();
		}
	}
	
	public List<Persona> recuperarPersonaPorNombre(String n){
		List<Persona> listaNombre = new ArrayList<Persona>();
		
		try{
			Query q = bbdd.query();
			q.constrain(Persona.class);
			q.descend("nombre").constrain(n);
			
			ObjectSet<Persona> res = q.execute();
			for(Persona p: res){
				p.print();
				listaNombre.add(p);
			}
		}finally{
			bbdd.close();
		}
		
		return listaNombre;
			
	}
	
	
	public List<Persona> recuperarPersonaPorInicial(String ini){
		List<Persona> listaIniciales = new ArrayList<Persona>();
		
		try{
			Query q = bbdd.query();
			q.constrain(Persona.class);
			q.descend("nombre").constrain(ini).startsWith(true);
			
			ObjectSet<Persona> res = q.execute();
			for(Persona p: res){
				p.print();
				listaIniciales.add(p);
			}
		}finally{
			bbdd.close();
		}
		
		return listaIniciales;
	}
	
	public List<Persona> recuperarPersonaPorDni(String dni){
		List<Persona> listaDni = new ArrayList<Persona>();
		
		try{
			Query q = bbdd.query();
			q.constrain(Persona.class);
			q.descend("dni").constrain(dni);
			
			ObjectSet<Persona> res = q.execute();
			for(Persona p: res){
				p.print();
				listaDni.add(p);
			}
		}finally{
			bbdd.close();
		}
		
		return listaDni;
	}
	
	public List<Persona> recuperarPersonaPorEdad(int menor, int mayor){
		List<Persona> listaEdad = new ArrayList<Persona>();
		
		try{
			Query q = bbdd.query();
			q.constrain(Persona.class);
			q.descend("edad").constrain(menor).greater();
			q.descend("edad").constrain(mayor).smaller();
			
			ObjectSet<Persona> res = q.execute();
			for(Persona p: res){
				p.print();
				listaEdad.add(p);
			}
		}finally{
			bbdd.close();
		}
		
		return listaEdad;
	}
	
	public List<Persona> recuperarPersonaAvanzada(){
		List<Persona> listaAvanzada = new ArrayList<Persona>();
		int edad = 30;
		String dni = "20";
		String letraF = "o";
		
		try{
			ObjectSet<Persona> set = bbdd.query(new Predicate<Persona>(){
				public boolean match(Persona p){
					return p.getNombre().endsWith(letraF) || p.getDni().startsWith(dni) || p.getEdad() > edad;
				}
			});
			
			for(Persona p: set){
				p.print();
				listaAvanzada.add(p);
			}
			
		}finally{
			bbdd.close();
		}
		
		return listaAvanzada;
	}
}
