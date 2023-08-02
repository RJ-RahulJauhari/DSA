package DataStructures.Stacks;

import DataStructures.LinkedList.LinkedListDS;

public class LinkedStack {

    private LinkedListDS<Integer> stack = new LinkedListDS<>();
    private int capacity;
    private int top;
    private int prev;
    public LinkedStack(int capacity) {
        this.capacity = capacity;
    }
    boolean isFilled(){
        return stack.getSize(false)+1 >= capacity;
    }

    boolean isEmpty(){
        return stack.getSize(false)+1 == 0;
    }
    void push(int ele) throws Exception{
        if(isFilled()){
            throw new Exception("The stack is full");
        }else{
            if(stack.getSize(false) == 0){
                stack.add(ele);
                top = ele;
                prev = ele;
            }else{
                stack.add(ele);
                prev = top;
                top = ele;
            }
        }
    }

    int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }else{
            stack.remove();
            int removed = top;
            top = prev;
            return removed;
        }
    }

    int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }else{
            return top;
        }
    }

    void print(){
        stack.print();
    }
    public int getCapacity() {
        return capacity;
    }

}
