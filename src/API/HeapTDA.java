package API;

public interface HeapTDA {

    void inicializarHeap();
    void Acolar(int x, int prioridad);
    void Desacolar();
    void HeapSort();
    boolean ColaVacia();
    int primero();


}