
package Implementaciones;
import API.HeapTDA;



public class HeapIMP implements HeapTDA {


class Elemento {
    int valor;
    int prioridad;
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

public void HeapSort() {
		
    HeapIMP copia = new HeapIMP();
    copia.inicializarHeap();

    for (int i = 0; i < cant; i++) {
        copia.Acolar(heap[i].valor ,heap[i].prioridad);
    }

    System.out.println("Elementos en orden de valor:");
    while (!copia.ColaVacia()) {
        System.out.println("Valor: " + copia.primero());
        copia.Desacolar();
    }
}


public boolean ColaVacia(){
    return (cant == 0);
}



@Override
public int primero(){
    if (ColaVacia()) {
        return -1;
    }
    return heap[0].valor;

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
    int menor = i;  // se inicializa menor como el nodo actual (recibido como parametro)

    if(hijoIzq < cant && heap[hijoIzq].prioridad < heap[menor].prioridad) {   // si la prioridad del hijo izquierdo de la pos (menor) es menor que la de menor propiamente dicho, menor pasa a ser hijoIzq 
        menor = hijoIzq;
    }

    if (hijoDer < cant && heap[hijoDer].prioridad < heap[menor].prioridad) {
        menor = hijoDer;  // mismo proeso para hijo derecho
}
    if (menor != i) {
        intercambiar(i, menor);
        intercambiarHaciaAbajo(menor);  // se vuelve a repetir el proceso con el elemento que fue intercambiado con sus nuevos hijos
    }
}


}


