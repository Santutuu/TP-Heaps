package Implementaciones.practicas;
import API.HeapTDA;
import Implementaciones.HeapIMP;

public class usoHeap {
    

    public static void main(String[] args) {
		
		HeapTDA heap = new HeapIMP();
		
		heap.inicializarHeap();
		
		System.out.println(heap.ColaVacia());

		heap.Acolar(20, 5);
		heap.Acolar(10, 8);
		heap.Acolar(30, 4);
		heap.Acolar(25, 7);

		System.out.println(heap.primero());

		heap.Desacolar();
		heap.Acolar(45,20);
		heap.Acolar(15, 25);
		heap.Acolar(35, 10);

		System.out.println(heap.ColaVacia());
		
		heap.HeapSort();
		
	}

}

