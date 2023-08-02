package DataStructures.Queues;

public class Implementation {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new Queue<>();
        queue.Enqueue(5);
        queue.Enqueue(6);
        queue.Enqueue(7);
        queue.Enqueue(8);
        queue.print();
        queue.Dequeue();
        queue.print();
        queue.Dequeue();
        queue.print();
        queue.Dequeue();
        queue.print();
        queue.Dequeue();
        queue.print();
        queue.Dequeue();
    }
}
