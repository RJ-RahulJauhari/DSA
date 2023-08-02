package DataStructures.Stacks;

import java.util.Stack;

public class StackQuestions {

    public static boolean areParenthesisValid(String expression){
        Stack<Character> stack = new Stack<>();
        for(char c: expression.toCharArray()){
            switch (c) {
                case '(': case'{': case'[':
                        stack.push(c);
                        break;
                case')': case'}': case ']':
                    if (isValidCapsulatorPair(stack.peek(), c)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isValidCapsulatorPair(char a, char b){
        return a=='(' && b==')' || a=='{' && b=='}' || a=='[' && b==']';
    }

    public static boolean ValidCapsulators(String exp){
        Stack<Character> stack = new Stack<>();
        char[] ExpChars = exp.toCharArray();

        for (char c : ExpChars) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                switch (c) {
                    case '}', ']', ')' -> {
                        if (isValidCapsulatorPair(stack.peek(), c)) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                }
            }
        }

        if(stack.size() != 0){
            return false;
        }else{
            return true;
        }
    }

    public static int[] PreviousSmaller(int[] arr){
        int size = arr.length;

        int[] res = new int[size];
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        res[0] = -1;

        for(int i = 1; i<size;i++){
            int top = stack.peek();
            if(arr[i] > top){
                res[i] = top;
            }else{
                while(arr[i] < top){
                    if(stack.size()==0){
                        res[i] = -1;
                        break;
                    }
                    stack.pop();
                }
                res[i] = top;
                stack.push(arr[i]);
            }
        }
        return res;
    }

    public static int getPrecedence(char c){
        if(c == '^'){
            return 4;
        }else if(c == '*' || c == '/'){
            return 3;
        }else if (c == '+'||c == '-') {
            return 2;
        }else{
            return 1;
        }
    }

    public static boolean isOperator(char c){
        return c == '*' || c == '+' || c == '-' || c == '/' || c == '^';
    }

    public static boolean isOpeningBraces(char c){
        return c == '(' ||c == '{' ||c == '[';
    }

    public static boolean isClosingBraces(char c){
        return c == ')' ||c == '}' ||c == ']';
    }
    public static void InfixToPostfixConverter(String Infix){
        char[] InfixArr = Infix.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder s = new StringBuilder();

        for(char ele: InfixArr){
            if(isOpeningBraces(ele)){
                stack.push(ele);
            }else if(isOperator(ele)){

                int topPrecedence;
                if(stack.isEmpty()){
                    topPrecedence = 1;
                }else{
                    topPrecedence = getPrecedence(stack.peek());
                }
                int currentPrecedence = getPrecedence(ele);

                if(topPrecedence >= currentPrecedence){
                    while(currentPrecedence <= topPrecedence){
                        char op = stack.pop();
                        s.append(op);
                        topPrecedence = getPrecedence(stack.peek());
                    }
                    stack.push(ele);
                }else {
                    stack.push(ele);
                }
            }else if(isClosingBraces(ele)){
                char top = stack.peek();
                while(!isOpeningBraces(top)){
                    s.append(stack.pop());
                    top = stack.peek();
                }
                stack.pop();
            }else{
                s.append(ele);
            }
        }
        if(stack.isEmpty()){
            System.out.println(s);
        }else{
            while (!stack.isEmpty()){
                s.append(stack.pop());
            }
            System.out.println(s);
        }
    }

    public static int FindingMaximumAreaOfHistogram(int[] arr){
        int n = arr.length;
        int max  = 0;
        for(int i = 0; i<n; i++){
            int l = i;
            int r = i;
            while(l >= 0 && (arr[l] >= arr[i])){
                l--;
            }
            while(r < arr.length && (arr[r] >= arr[i])){
                r++;
            }

            int width = r-l-1;
            int curArea = arr[i]*width;
            max = Math.max(max,curArea);
        }
        return max;
    }



}
