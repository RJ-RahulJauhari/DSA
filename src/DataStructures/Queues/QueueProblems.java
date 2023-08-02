package DataStructures.Queues;

import java.util.Queue;
import java.util.Stack;

public class QueueProblems {

    public static Queue<Integer> ReverseKElementsOfQueue(Queue<Integer> queue, int k){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<k;i++){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            queue.offer(stack.pop());
        }

        for(int i = 0; i < (queue.size()-k);i++){
            queue.offer(queue.poll());
        }
        return queue;
    }
}
