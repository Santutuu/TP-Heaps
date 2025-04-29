
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


}

@Override
public void Desacolar(){
    if (cant == 0) return;

    heap[0] = heap[cant - 1];

    cant--;



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
    if (cant == 0) {
        return -1;
    }
    return heap[0].valor;

}

private void intercambiar (int i, int j) { // Intercambia de lugar un nodo padre con su hijo
    Elemento aux = heap[i]; // se crea un objeto con referencia al guardado en la posicion i del heap (funciona como auxiliar)
    heap[i] = heap[j]; 
    heap[j] = aux;
}

private void intercambiarHaciaArriba (int i) {
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
    int hijoDer = 2 * i + 2;
    int mayor = i;

    if(hijoIzq < cant && heap[hijoIzq].prioridad > heap[mayor].prioridad) {
        mayor = hijoIzq;
    }

    if (hijoDer < cant && heap[hijoDer].prioridad > heap[mayor].prioridad) {
        mayor = hijoDer;

    if (mayor != i) {
        intercambiar(i, mayor);
        intercambiarHaciaAbajo(mayor);
    }
}


}
}

