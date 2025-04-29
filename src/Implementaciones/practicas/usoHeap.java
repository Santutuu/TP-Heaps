package Implementaciones.practicas;

import Implementaciones.HeapIMP;

public class usoHeap {

	class Elemento {
		int valor;
		int prioridad;
	}
    
    public static void mostrarHeap (HeapIMP h) {
		HeapIMP.Elemento prim;
		
		System.out.println(h.primero());
		int p, v;
        while(!h.ColaVacia()) {
			
			prim = h.primero();
            p = prim.prioridad;
            v = prim.valor;
            System.out.println("prioridad: "+p+ " valor: "+v);
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
        mostrarHeap(heap);
	
		
	}

}

