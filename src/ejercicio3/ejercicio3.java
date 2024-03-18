package ejercicio3;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ejercicio3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int num;
        String pathFichero = "src//ejercicio3//tresEj.dat";
        String pathFichero2 = "src//ejercicio3//tresCopia.dat";
        Scanner teclado = new Scanner(System.in);

        ObjectOutputStream escritor = null;
        try {
            escritor = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pathFichero, true)));

            System.out.println("Escribe un numero hasta que sea negativo");
            num = teclado.nextInt();

            while (num >= 0) {

                escritor.writeObject((Integer)num);;;

                System.out.println("Escribe otro numero hasta que sea negativo");
                num = teclado.nextInt();
                
            }

        } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }finally{
            if (escritor!=null) {
                escritor.close();
            }
        }
        ObjectInputStream lector = null;
        escritor = null;
       

        try {
            
         lector = new ObjectInputStream(new FileInputStream(pathFichero));
         escritor = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pathFichero2, true)));
         int num2 = (int) lector.readObject();

        while (true){

            System.out.println(num2);
            num2 = (int)lector.readObject();
        }
         

        } catch (FileNotFoundException e) {
          System.out.println(e.getMessage());
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }finally{
            if (lector!=null) {
                lector.close();
            }
        }
        
    }
    
}
