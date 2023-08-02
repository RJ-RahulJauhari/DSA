package DataStructures.Stacks;

import java.util.ArrayDeque;

public class Implementation {
    public static void main(String[] args) throws Exception {
//        ArrayStack stack = new ArrayStack(5);
//        DequeStack stack = new DequeStack();
//        System.out.println( StackQuestions.areParenthesisValid("[{(9+2)+(3*4)}+(5-8)]"));
//        int[] arr = {5,1,2,3,9,6,1,4,3};
//        print(StackQuestions.PreviousSmaller(arr));

//        String exp = "[(a*b)-(4^6/5-6+7)]";
//        StackQuestions.InfixToPostfixConverter(exp);
        int[] arr = {4,2,1,4,3,0,2,3};
        int ans = StackQuestions.FindingMaximumAreaOfHistogram(arr);
        System.out.println(ans);






    }

    public static void print(int[] arr){
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}