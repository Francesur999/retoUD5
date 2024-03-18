package ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercico4 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Persona persona=new Persona();
        List<Persona>personas=new ArrayList<Persona>();

        char continuar = 'S';

        System.out.println("Quieres meter  alguna persona");

        continuar = teclado.nextLine().toUpperCase().charAt(0);

        while (continuar=='S') {

            System.out.println("Escribe el nombre de la persona");
    
            persona.setNombre(teclado.nextLine());
    
            System.out.println("Escribe sus apellidos");
            persona.setApellidos(teclado.nextLine());
    
            System.out.println("Escribe su dni");
            persona.setDni(teclado.nextLine());
    
            System.out.println("Escribe la edad");
            persona.setEdad(teclado.nextInt());
            teclado.nextLine();

            personas.add(persona);
            System.out.println("Hasta ahora has introducido "+personas.size()+"personas");
    
        

            System.out.println("Quieres meter otra persona ");

            continuar = teclado.nextLine().toUpperCase().charAt(0);
            
        }
        for (Persona personaActual : personas) {
            System.out.println(personaActual.toString());
            
        }
        teclado.close();
    }
       
    
}
