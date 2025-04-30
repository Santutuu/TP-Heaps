package Practicas;

import Implementaciones.HeapIMP;


public class colaPrioridad_ {

	public static void mostrarArreglo (int valor, int prioridad) {
		System.out.println("Valor: "+valor+"  Prioridad: "+prioridad);
	}
	
    public static void colaPrioridad (HeapIMP h) {
		HeapIMP.Elemento prim;
		
		System.out.println(h.primero());
		int p, v;
        while(!h.ColaVacia()) {
			
			prim = h.primero();
            p = prim.prioridad;
            v = prim.valor;
			mostrarArreglo(v, p);
           
            h.Desacolar();
        }
		
	}
    public static void main(String[] args) {
		
		HeapIMP heap = new HeapIMP();
		
		heap.inicializarHeap();
	

		heap.Acolar(20, 5);
		heap.Acolar(10, 8);
		heap.Acolar(30, 4);
		heap.Acolar(25, 7);
		heap.Acolar(45, 9);
		heap.Acolar(15, 25);
		heap.Acolar(35, 10);
        
		System.out.println(heap.ColaVacia());
        colaPrioridad(heap);
	
		
	}

}
	
/*
 Costos de los metodos de cola con Heap:
    Primero() // O(1)
	Acolar()  // O(logn)
	Desacolar() // O(logn)
	ColaVacia() // O(1)
 */




