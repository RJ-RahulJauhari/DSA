package DataStructures.LinkedList;

public class LinkedListDS<Type>{
    private Node<Type> Head = new Node<>();
    private int size = 0;

    public void add(Type data){
        if(Head.getData() == null && Head.getNext() == null){
            Head.setData(data);
        }else {
            Node<Type> node = new Node<>(data);
            Node<Type> cur = Head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(node);
            size++;
        }
    }

    public void insert(Type data, int index){
        Node<Type> cur = Head;
        for(int i = 0; i<index; i++){
            cur = cur.getNext();
        }
        Node<Type> node = new Node<>(data);
        node.setNext(cur.getNext());
        cur.setNext(node);
        size++;
    }

    public void remove(int index) {
        if (size == 0) {
            System.out.println("Can't remove from an empty list");
        } else if(index>size){
            System.out.println("Invalid Index");
        } else {
            Node<Type> cur = Head;
            for (int i = 0; i < index; i++) {
                cur = cur.getNext();
            }
            Node<Type> next = cur.getNext().getNext();
            cur.getNext().setNext(null);
            cur.setNext(next);
            size--;
        }
    }

    public void remove() {
        if (size == 0) {
            System.out.println("Can't remove from an empty list");
        } else {
            Node<Type> cur = Head;
            while(cur.getNext().getNext()!=null){
                cur = cur.getNext();
            }
            cur.getNext().setData(null);
            cur.setNext(null);
            size--;

        }
    }

    public void print(){
        Node<Type> cur = Head;

        while(cur!=null){
            System.out.print(cur.getData()+" --> ");
            cur = cur.getNext();
        }
//        System.out.print(cur.getData()+" --> ");
        System.out.print("End");
        System.out.println();
    }

    public static void print(Node<Integer> Head){
        Node<Integer> cur = Head;

        while(cur!=null){
            System.out.print(cur.getData()+" --> ");
            cur = cur.getNext();
        }
//        System.out.print(cur.getData()+" --> ");
        System.out.print("End");
        System.out.println();
    }

    public static void printBetweenNodes(Node<Integer> start, Node<Integer> end){
        Node<Integer> cur = start;
        while(cur != end){
            System.out.print(cur.getData() + " --> ");
            cur = cur.getNext();
        }
        System.out.print(end.getData()+" --> END");
        System.out.println();
    }

    public String getHead() {
        return Head.getData()+" is present at Head";
    }

    public String getSize() {
        return "Size: "+size;
    }
    public int getSize(boolean PrintOnConsole) {
        if(PrintOnConsole){
            System.out.println(getSize());
        }
        return size;
    }
    public Node<Type> getHead(boolean PrintOnConsole) {
        if(PrintOnConsole){
            System.out.println(getHead());
        }
        return Head;
    }

    public void setHead(Node<Type> head) {
        Head = head;
    }
}
