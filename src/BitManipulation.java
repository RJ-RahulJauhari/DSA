import DataStructures.LinkedList.Pair;

import java.util.ArrayList;

public class BitManipulation {

    public static int ithBitOfANumber(int number, int i){
        int mask = 1 << i;
        int result = number&mask;
        if(result != 0){
            return 1;
        }else{
            return 0;
        }
    }

    public static int ithBitToggle(int number, int i){
        int mask = 1 << i;
        int result = number^mask;

        return result;
    }

    public static boolean isNumberAPowerOf2(int number){
        int result = number&(number-1);

        if(result == 0){
            return true;
        }else{
            return false;
        }
    }

    public static int countOfTheNumberOfSetBits(int number){
        int shiftingNumber = number;
        int count = 0;
        while(shiftingNumber!=0){
            if((shiftingNumber&1) == 1 ){
                count++;
            }
            shiftingNumber = shiftingNumber>>1;
        }
        return count;
    }

    public static int SetBitToOne(int number, int i){
        int mask = 1<<i;
        int result = number;
        if((number&mask) == 0){
            result = number^mask;
        }
        return result;
    }

    public static int findNonRepeatingElementInArrayContainingElementThatRepeatTwiceExceptOne(ArrayList<Integer> array){
        int result = array.get(0);
        for(int i = 1; i<array.size();i++){
            result = array.get(i)^result;
        }
        return result;
    }

    public static Pair<Integer> findTwoNonRepeatingElementInArrayContainingElementThatRepeatTwiceExceptOne(ArrayList<Integer> array){

        int xor = 0;
        for(int element:array){
            xor = xor^element;
        }

        int mask = xor & (~(xor-1));

        int ZerosNumber = 0,OnesNumber = 0;

        for(int element:array){
            if((element&mask) == 0){
                ZerosNumber = ZerosNumber ^ element;
            }else{
                OnesNumber = OnesNumber ^ element;
            }
        }

        return new Pair<>(ZerosNumber,OnesNumber);

    }

    public static int SwapTheBits(int number, int i, int j){

        int result = number;
        int mask1 = 1<<i;
        int mask2 = 1<<j;

        if(mask1 == mask2){
            return number;
        }
        if((((number & mask1) == 0) & ((number & mask2) == 0)) || (!((number & mask1) == 0) & !((number & mask2) == 0))){
            return number;
        }else{
            result = result^mask1;
            result = result^mask2;
        }
        return result;
    }
    
}
