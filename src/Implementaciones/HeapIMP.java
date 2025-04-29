
package Implementaciones;
import API.HeapTDA;



public class HeapIMP implements HeapTDA {


public class Elemento {
    public int valor;
    public int prioridad;
}

Elemento[] heap;  // Reservo el nombre para el arreglo de objetos del tipo Elemento (el heap)
int cant;


@Override
public void inicializarHeap(){

    heap = new Elemento[100];
    cant = 0;

}

@Override

public void Acolar(int x, int prioridad){

    Elemento nuevo = new Elemento(); // origino el nuevo elemento
    nuevo.valor = x;
    nuevo.prioridad = prioridad;

    heap[cant] = nuevo; 
    
    intercambiarHaciaArriba(cant);

    cant++;

}

@Override
public void Desacolar(){
    if (ColaVacia()) return;

    heap[0] = heap[cant - 1];  // se pisa el primer elemento (elemento a eliminar) con el ultimo

    cant--;                    // se reduce el tamanio del arreglo.

    intercambiarHaciaAbajo(0);  // se invoca intercambiarHaciaAbajo con el indice 0 (elemento) para que vuelva a acomodar el ultimo elemento
}


    



public boolean ColaVacia(){
    return (cant == 0);
}




public Elemento primero() {
    if (ColaVacia()) {
        return null;
    }
    return heap[0];
} 




private void intercambiar (int i, int j) { // Intercambia de lugar un nodo padre con su hijo
    Elemento aux = heap[i]; // se crea un objeto con referencia al guardado en la posicion i del heap (funciona como auxiliar)
    heap[i] = heap[j]; 
    heap[j] = aux;
}

private void intercambiarHaciaArriba (int i) { // Intercambia el lugar del nodo actual con el padre en caso de que este ultimo sea mayor.
    while(i > 0){
        int padre = (i - 1) / 2;

        if (heap[i].prioridad > heap[padre].prioridad) {
            intercambiar (i, padre);
            i = padre;

        } else {
            break;
        }
        }
    }


private void intercambiarHaciaAbajo(int i){
    int hijoIzq = 2 * i + 1;
    int hijoDer = 2 * i + 2; // guardan la posicion del hijo izquierdo y derecho respectivamente
    int mayor = i;  // se inicializa mayor como el nodo actual (recibido como parametro)

    if(hijoIzq < cant && heap[hijoIzq].prioridad > heap[mayor].prioridad) {   // si la prioridad del hijo izquierdo de la pos (mayor) es mayor que la de mayor propiamente dicho, mayor pasa a ser hijoIzq 
        mayor = hijoIzq;
    }

    if (hijoDer < cant && heap[hijoDer].prioridad > heap[mayor].prioridad) {
        mayor = hijoDer;  // mismo proeso para hijo derecho
}
    if (mayor != i) {
        intercambiar(i, mayor);
        intercambiarHaciaAbajo(mayor);  // se vuelve a repetir el proceso con el elemento que fue intercambiado con sus nuevos hijos
    }
}


}


