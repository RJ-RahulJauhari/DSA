package DataStructures.Queues;

public class QueueUsingArray {
    int capacity;
    int[] arr;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public QueueUsingArray(int[] arr) {
        this.arr = arr;
        capacity = arr.length;
    }
    int front, rear = 0;
    int size = 0;

    public void Enqueue(int data){
        if(front == 0 && rear == 0){
            arr[0] = data;
        }else if(front == rear){
            rear++;
            arr[rear] = data;
        }else if(rear == capacity){
            System.out.println("Queue is full...");
        }
        size++;
    }

    public void Dequeue(){

    }

}
