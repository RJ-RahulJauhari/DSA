package DataStructures.Stacks;

import java.util.ArrayDeque;

public class DequeStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();


    void push(int ele){
        stack.add(ele);
    }

    int pop() throws Exception{
        if(stack.size()==0){
            throw new Exception("Stack is Empty");
        }else{
            return stack.removeLast();
        }
    }

    int peek() throws Exception {
        if(stack.size()==0){
            throw new Exception("Stack is Empty");
        }else{
            return stack.peekLast();
        }
    }

    void print(){
        System.out.println("Stack:");
        for(int ele: stack){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    int getSize(){
        return stack.size();
    }
}
