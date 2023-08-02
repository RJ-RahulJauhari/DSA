package DataStructures.LinkedList;

public class DoublyLinkedListDS<Type> {
    DoubleSidedNode<Type> head;
    int size = 0;

    public void insert(Type data,int position){
        /* Handling the end cases insertion at the first position and the last position */
        if(position == 0 & size != 0){
            DoubleSidedNode<Type> node = new DoubleSidedNode<>(data);
            DoubleSidedNode<Type> firstnode = head;
            head.setPrev(node);
            node.setNext(firstnode);
            head = node;
            size++;
        }

        if(position == size-1){
            DoubleSidedNode<Type> cur = head;
            while(cur.getNext() != null){
                cur = cur.getNext();
            }
            DoubleSidedNode<Type> node = new DoubleSidedNode<>(data);
            cur.setNext(node);
            node.setPrev(cur);
            size++;
        }

        /* Insertion at some place in between the first and last nodes */
        if(position>size-1 || position < 0){
            System.out.println("Invalid Index");
        }else if(position == 0 && head.getNext() == null || head == null){
            head = new DoubleSidedNode<>(data);
            size++;
        }else {
            DoubleSidedNode<Type> cur = head;
            for (int i = 0; i < position; i++) {
                cur = cur.getNext();
            }
            DoubleSidedNode<Type> node = new DoubleSidedNode<>(data);
            DoubleSidedNode<Type> prev = cur;
            DoubleSidedNode<Type> next = cur.getNext();

            /* Setting the pointers of previous node and next node to point to the newly created node. */
            prev.setNext(node);
            next.setPrev(node);

            /* Setting the pointer of the newly created node to point to the previous and next node respectively */
            node.setPrev(prev);
            node.setNext(next);
            size++;
        }
    }

    public void insert(Type data){
        DoubleSidedNode<Type> cur = head;
        if(head == null){
            head = new DoubleSidedNode<>(data);
        }else {
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            DoubleSidedNode<Type> node = new DoubleSidedNode<>(data);
            node.setPrev(cur);
            cur.setNext(node);
        }
        size++;
    }

    public void delete(int position){

        if(position == 0 && size != 0){
            DoubleSidedNode<Type> secondnode = head.getNext();
            head.setNext(null);
            secondnode.setPrev(null);
            head = secondnode;
            size--;
        }

        if(position == size-1){
            DoubleSidedNode<Type> cur = head;
            while(cur.getNext().getNext() != null){
                cur = cur.getNext();
            }
            DoubleSidedNode<Type> secondlast = cur;
            DoubleSidedNode<Type> last = secondlast.getNext();
            last.setPrev(null);
            secondlast.setNext(null);
            size--;
        }

        if(position > size-1 || position < 0){
            System.out.println("Invalid Index");
        }else if(size == 0){
            System.out.println("Underflow, the List is empty");
        }else{
            DoubleSidedNode<Type> cur = head;
            for (int i = 0; i < position; i++) {
                cur = cur.getNext();
            }
            DoubleSidedNode<Type> node = cur.getNext();
            DoubleSidedNode<Type> after = node.getNext();
            DoubleSidedNode<Type> before = cur;

            before.setNext(after);
            after.setPrev(before);

            node.setNext(null);
            node.setPrev(null);
            size--;
        }
    }

    public DoubleSidedNode<Type> search(Type data){
        DoubleSidedNode<Type> cur = head;
        while(cur.getNext() != null){
            if(cur.getData() == data){
                System.out.println("Data Found");
                break;
            }else{
                cur = cur.getNext();
            }
        }

        if(cur.getData() != data){
            System.out.println(data+" was not found in the list");
            return null;
        }
        return cur;
    }

    public int getSize() {
        return size;
    }

    public Type getHeadValue(){
        return head.getData();
    }
    public void print(){
        DoubleSidedNode<Type> cur = head;
        System.out.print("Start <--> ");
        while(cur.getNext() != null){
            System.out.print(cur.getData()+" <--> ");
            cur = cur.getNext();
        }
        System.out.print(cur.getData()+" <--> ");
        System.out.print("End");
        System.out.println();
    }

}