package ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;


public class Agenda {
	ArrayList<Persona> contactos = new ArrayList<Persona>();
    Scanner input= new Scanner(System.in);

	public Agenda() {
		
	}
	
	public void agregarPersona() {
		String nombre;
		int celular;
		String direccion;
		System.out.println("Ingrese el nombre de la persona");
		nombre=input.nextLine();
	    System.out.println("Ingrese el celular de la persona");
	    celular=input.nextInt();
	    input.nextLine();
	    System.out.println("Ingrese la direccion de la persona");
	    direccion=input.nextLine();
		contactos.add(new Persona(nombre, celular, direccion));
	}
	
	public void imprimeListaContactos() {
		System.out.println("Su lista de contactos actualizada es: ");
		 for (int i=0; i<contactos.size(); i++) {
				 System.out.println(contactos.get(i).toString());	 
		 }
	}
	
	public void eliminarPersona(String nombre) {
		int resultado = this.getPosicionPersona(nombre);
		if (resultado != -1) {
			contactos.remove(resultado);
		}
		else {
			System.out.println("No existe la persona en la agenda");
		}
	}
	
	public int getPosicionPersona(String nombre) {
		int buscado=-1;
		for (int i=0; i<contactos.size(); i++) {
			 if (nombre.equalsIgnoreCase(
					contactos.get(i).getNombre())){
				 buscado=i;
			 }
		 }
		return buscado;
	}
	
	public void buscarPersonaPorNombre(String nombre) {
		 for (int i=0; i<contactos.size(); i++) {
			 if (nombre.equalsIgnoreCase(contactos.get(i).getNombre())){
				 System.out.println(contactos.get(i).toString());
			 }
			 else {
					System.out.println("No existe la persona en la agenda");
				}
		 }
	}
}
