package ejercicio4;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
	    celular=ingresaNumero();
	    input.nextLine();
	    System.out.println("Ingrese la direccion de la persona");
	    direccion=input.nextLine();
		contactos.add(new Persona(nombre, celular, direccion));
	}
	
	public int ingresaNumero () {
		int numero=0;
		boolean ok=false;
		while (!ok) {
			try {
				 numero =input.nextInt();
				 ok=true;
				} catch (InputMismatchException ime) {
					input.nextLine();
				 System.out.println("Datos invalidos. Ingrese el celular de la persona");
				} 
		}
		return numero;
	}
	
	
	public void imprimeListaContactos() {
		System.out.println("Su lista de contactos actualizada es:");
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
		boolean buscado = false;
		 for (int i=0; i<contactos.size(); i++) {
			 if (nombre.equalsIgnoreCase(contactos.get(i).getNombre())){
				 System.out.println(contactos.get(i).toString());
				 buscado = true;
			 }	
		 }
		 if (!buscado) {
				System.out.println("No existe la persona en la agenda");
			}
	}
}
