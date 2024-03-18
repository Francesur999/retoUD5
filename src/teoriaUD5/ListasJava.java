package teoriaUD5;

public class ListasJava {

    public static void main(String[] args) {

        Listaint miLista = new Listaint( "Lista");
        
    }
    
}

class NodoListaInt{

    public int numero;
    public NodoListaInt sig;

    public NodoListaInt ( int num, NodoListaInt sig){

        this.numero = num;
        this.sig = sig;
    }

    public void add (NodoListaInt nodo){
        if(this.sig == null){
            this.sig = nodo;
        }else{
            this.sig.add(nodo);
        }
    }
}

class Listaint{

    public String nombre;
    public NodoListaInt inicio;

    public Listaint(String nombre ){

        this.inicio = null;
        this.nombre = nombre;
    }

    public void insertar(int num){

        NodoListaInt nuevoNodo = new NodoListaInt(num, null); 

        if (inicio == null){

          
          inicio = nuevoNodo;
       

        }else{

        add(NodoListaInt nodo);

        }

       
    
    }

}
