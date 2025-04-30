package Implementaciones.practicas;

import Implementaciones.HeapIMP;

public class usoHeap {

	class Elemento {
		int valor;
		int prioridad;
	}
    
	public static void mostrarCola (int valor, int prioridad) {

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
			mostrarCola(v, p);
           
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

