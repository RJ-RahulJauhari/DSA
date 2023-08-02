package DataStructures.Heaps;

public class main {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(2);
        heap.insert(10);
        heap.insert(15);
        heap.insert(1);
        heap.printHeap();

        heap.delete(-1);
        heap.printHeap();
    }
}
