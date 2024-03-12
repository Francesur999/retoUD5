package ejercicio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class ejercicio2 {

    public static void main(String[] args) throws IOException {

        puntoA();
        puntosBc();

    }

    public static void puntoA() throws IOException {
        System.out.println(System.getProperty("user.dir"));

        File directorio = new File("dirEjer2");
        if (directorio.exists()) {

            System.out.println("El directorio ya existe");

        } else {

            directorio.mkdir();
        }

        File fileUno = new File("dirEjer2//uno.txt");
        File fileDos = new File("dirEjer2//dos.txt");

        if (fileUno.exists()) {
            System.out.println("El fichero:" + fileUno.getName() + " ya existe");
        } else {

            fileUno.createNewFile();
        }

        if (fileDos.exists()) {
            System.out.println("El fichero:" + fileDos.getName() + " ya existe");
        } else {

            fileDos.createNewFile();
        }

    }

    public static void puntosBc() throws IOException {
        String nombre;
        Scanner teclado = new Scanner(System.in);

        BufferedWriter escribir = null;
        File fileUno = new File("dirEjer2//uno.txt");

        try {
            escribir = new BufferedWriter(new FileWriter(fileUno,true));

            do {
                System.out.println("Introduce nombre por pantalla: ");
                System.out.println("Introduce - para finalizar ");
                nombre = teclado.nextLine();
                escribir.write(nombre+"\n");

                if (!nombre.equals("-") ) {
                    escribir.write(nombre+"\n");
                }
            } while (!nombre.equals("-"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {

            teclado.close();
            if (escribir != null) {
                escribir.close();
            }
        }

    }

}
