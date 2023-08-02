package DataStructures.Stacks;
    public class UsingTwoStacksInArray {

        int[] arr;
        int capacity;

        public UsingTwoStacksInArray(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            top2 = capacity;
        }
        public UsingTwoStacksInArray() {
            capacity = 5;
            top2 = 5;
            arr = new int[capacity];
            System.out.println("The Initial Capacity is set to 5");
        }

        int top1 = -1;
        int top2 = capacity;

        public void push1(int ele){
            if(top1+1 < top2){
                top1++;
                arr[top1] = ele;
            }else{
                System.out.println("Stack 1 Overflow");
            }
        }

        public void push2(int ele){
            if(top2-1 > top1){
                top2--;
                arr[top2] = ele;
            }else{
                System.out.println("Stack 2 Overflow");
            }
        }

        public int pop1() {
            if(top1-1 < 0){
                System.out.println("Stack 1 Underflow");
                return -404;
            }else{
                int res = arr[top1];
                top1--;
                return res;
            }
        }

        public int pop2(){
            if(top2+1 == capacity){
                System.out.println("Stack 2 Underflow");
                return -404;
            }else{
                int res = arr[top2];
                top2++;
                return res;
            }
        }

        public void printStack(){
            for(int i = 0; i<=top1; i++){
                System.out.print(arr[i]+" ");
            }
            for(int j = capacity-1;j>top1;j--){
                System.out.print(arr[j]+" ");
            }
            System.out.println();
        }

        public void printStack1(){
            for(int i = 0; i<=top1; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.print("<-- Top 1");
            System.out.println();
        }

        public void printStack2(){
            for(int j = capacity-1;j>top1;j--){
                System.out.print(arr[j]+" ");
            }
            System.out.print("<-- Top 2");
            System.out.println();
        }

        public void printStackNormally(){
            for(int ele:arr){
                if(String.valueOf(ele).isEmpty()){
                    continue;
                }else{
                    System.out.println(ele+" ");
                }
            }
        }
    }
