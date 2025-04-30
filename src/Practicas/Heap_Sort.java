package Practicas;
import Implementaciones.HeapIMP;

public class Heap_Sort {
 
    

    public static HeapIMP HeapSort (HeapIMP h) {

        HeapIMP copia = new HeapIMP();
        HeapIMP.Elemento prim;
        copia.inicializarHeap();

        while(!h.ColaVacia()){
            prim = h.primero();
            copia.Acolar(prim.valor, prim.prioridad);
            h.Desacolar();

        }

        return copia;
    }
    

    public static void mostrarArray (HeapIMP arr) {
        while(!arr.ColaVacia()){
            HeapIMP.Elemento prim;
            prim =arr.primero();
            System.out.println("Valor: "+prim.valor+" Prioridad: "+prim.prioridad);
        
            arr.Desacolar();
        }
    }


     public static void main(String[] args) { 

        HeapIMP heap = new HeapIMP();

       
		
		heap.inicializarHeap();
	

		heap.Acolar(5, 1);
		heap.Acolar(8,10);
		heap.Acolar(21, 6);
		heap.Acolar(2, 12);

        HeapIMP SortedArray = HeapSort(heap);

        mostrarArray(SortedArray);
        
     }
   
}