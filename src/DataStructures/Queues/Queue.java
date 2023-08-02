package DataStructures.Queues;

public class Queue<Type> {

    private Node<Type> front,rear;
    int size = 0;

    public Queue() {
    }

    public void Enqueue(Type data){
        Node<Type> node = new Node<>(data);
        if(size == 0){
            node.setNext(null);
            node.setPrev(null);
            front = rear = node;
        }else{
            node.setNext(rear);
            node.setPrev(null);
            rear.setPrev(node);
            rear = node;
        }
        size++;
    }

    public Type Dequeue() {
        if(size == 0){
            System.out.println("illegal delete from Empty Queue!");
            return null;
        }else if(size == 1){
            front = rear = null;
            System.out.println("Empty Queue");
            size = 0;
            return null;
        }else{
            Node<Type> prev = front.getPrev();
            Type data = front.getData();
            front.setPrev(null);
            front = prev;
            front.setNext(null);
            size--;
            return data;
        }

    }

    public void print(){
        if(size == 0){
            System.out.println("Empty Queue....");
        }else {
            Node<Type> cur = front;
            while (cur.getPrev() != null) {
                System.out.print(cur.getData() + " ");
                cur = cur.getPrev();
            }
            System.out.print(cur.getData() + " ");
            System.out.println();
        }
    }
}
