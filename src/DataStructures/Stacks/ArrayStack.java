package DataStructures.Stacks;

public class ArrayStack{
    private final int[] stack;
    private int capacity;
    private int top = -1;
    public ArrayStack(int capacity){
        this.capacity = capacity;
        stack = new int[capacity];
    }

    int pop() throws Exception {
        if(top != -1){
            int val = stack[top];
            top--;
            return val;
        }else{
            throw new Exception("Stack is Empty");
        }
    }

    void push(int ele) throws Exception {
        if(top == capacity-1){
            throw new Exception("Stack is Full");
        }else{
            top++;
            stack[top] = ele;
        }
    }

    void print(){
        System.out.println("Stack Elements: ");
        for(int i = 0; i<=top; i++){
            System.out.print(stack[i]+" ");
        }
    }

    int peek() throws Exception {
        if(isEmpty()){
            throw new Exception("Empty Stack");
        }else{
            return stack[top];
        }
    }

    boolean isEmpty(){
        return top == -1;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTop() {
        return top;
    }
}
