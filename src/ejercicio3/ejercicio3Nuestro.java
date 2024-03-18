package ejercicio3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;


public class ejercicio3Nuestro {

    public static void main(String[] args) throws IOException {

        Scanner teclado = new Scanner(System.in);
        Alumno[]alumnos = new Alumno[3];
        String[]asignatura = new String[3];
        String nombre;

        for(int al = 0 ; al <3 ; al++){
            System.out.println("Alumno"+ al);
            System.out.println("Nombre del alumno: ");
            nombre = teclado.nextLine();

            for(int j = 0; j<3; j++){

                System.out.println("Asignatura "+j+":");
                asignatura[j]=teclado.nextLine();
            }
            alumnos[al]=new Alumno(nombre, asignatura);
        }
        teclado.close();
        
       ObjectOutputStream salida =null;
       String pathFichero = "src//ejercicio3//tres.dat";

        try {
            salida = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pathFichero,true)));
            salida.writeObject(alumnos[0]);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        } finally {

            if (salida !=null) {
                salida.close();
            }
            
        }
        alumnos [0]= null;
        alumnos [1]= null;
        alumnos [2]= null;
        ObjectInputStream lector = null;
    
         try {
            lector = new ObjectInputStream(new FileInputStream(pathFichero));
            int cont = 0;

            while (lector.available()>0){
              alumnos[cont] = (Alumno) lector.readObject();
              System.out.println(alumnos[cont].getNombre());
              cont++;
              
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
      
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {

            if (lector !=null) {
                lector.close();
            }
            
        }

        System.out.println("** PROGRAMA TERMINADO **");
   
    }

}

class Alumno implements Serializable{
 

private static int idActual = 0;
   private int id;
    private String nombre;
    private String []asignatura = new String[3];

    public Alumno(String nombre , String[]asignatura) {
        idActual++;
        this.id = idActual;
        this.nombre = nombre;
        this.asignatura=asignatura;
    }

    public static int getidActual(){
        return idActual;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String[] asignatura) {
        this.asignatura = asignatura;
    }

    
    public void toStrings() {
         System.out.println("Alumno [id=" + id + ", nombre=" + nombre + ", asignatura=" + Arrays.toString(asignatura) + "]");
    }
  
  
    
}