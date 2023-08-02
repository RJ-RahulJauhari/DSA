package DataStructures.Stacks;

public class TwoStacksOneArray {
    int[] arr;
    int top1, top2;
    int count;
    public TwoStacksOneArray(int capacity) {
        arr = new int[capacity];
        top1 = -1;
        top2 = capacity-1;
        count = 0;
    }

    public void shifter(){
        if(top1 == 0 && top2 != arr.length){
            for(int i = top2; i >= 0; i--){
                arr[i+1] = arr[i];
            }
        }else if(top2 == arr.length && top1 != 0){
            for(int i = top1; i <= top2; i++){
                arr[i-1] = arr[i];
            }
        }else{
            System.out.println("Shifting Operation can not be performed...\n");
        }
    }

    public void shifter(int k){
        if(top1 == 0 && top2 != arr.length){
            for(int i = top2; i >= 0; i--){
                arr[i+k] = arr[i];
            }
        }else if(top2 == arr.length && top1 != 0){
            for(int i = top1; i <= top2; i++){
                arr[i-k] = arr[i];
            }
        }else{
            System.out.println("Shifting Operation can not be performed...\n");
        }
    }

    public void push1(int ele){
        if(top1 > 0){
            top1--;
            arr[top1] = ele;
        }else if(top1 == 0 && top2 != count){
            shifter();
            push1(ele);
        }else{
            System.out.println("Stack 1 Overflow");
        }
    }

    public void push2(int ele) {
        if (top2 < count) {
            top2++;
            arr[top2] = ele;
        }
    }

}
