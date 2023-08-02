package DataStructures.HashMap;

import DataStructures.LinkedList.Pair;

import java.util.*;

public class HashMapDS<Type> {

    public static HashMap<Integer, Integer> CountOfDistinctElements(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int element : arr) {
            if (count.containsKey(element)) {
                count.put(element, count.get(element) + 1);
            } else {
                count.put(element, 1);
            }
        }
        return count;
    }



    public void AddAll(Type[] from, Collection<Type> to) {
        for (Type element : from) {
            to.add(element);
        }
    }

    public static Set<Pair> PairWithGivenSumInAUnsortedArray(List<Integer> arr, int GivenSum, boolean FlippedPairAllowed) {
        /* If the set contains the complement element then we form a Pair of these 2 values,
           and we add this pair only when there does not exist a duplicate pair in the 'result'
           set. */

        Set<Integer> set = new HashSet<>();
        Set<Pair> result = new HashSet<>();
        set.addAll(arr);
        for (int i : arr) {
            if (set.contains(GivenSum - i)) {
                Pair<Integer> pair = new Pair<>(i, GivenSum - i);
                if (FlippedPairAllowed) {
                    if (pair.DoesNotContainDuplicateIn(result)) {
                        result.add(pair);
                    }
                } else {
                    if (pair.DoesNotContainDuplicateOrFlippedDuplicatedIn(result)) {
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    public static Set<Pair> PairWithGivenSumInAUnsortedArray(int[] arr, int sum){
        HashSet<Integer> set = new HashSet<>();
        HashSet<Pair> result = new HashSet<>();
        for(int element:arr){
            if(set.contains(sum-element)){
                result.add(new Pair(element,sum-element));
            }else{
                set.add(element);
            }
        }
        return result;
    }


    public ArrayList<Type> SubArrayBetweenIndexes(int start, int end, Type[] arr){
        ArrayList<Type> output = new ArrayList<>();
        for(int i = start; i<=end; i++){
            output.add(arr[i]);
        }
        return output;
    }


    public static HashSet<int[]> ZeroSumSubArray(int[] arr){
        HashSet<Integer> CumulativeSum = new HashSet<>();
        HashSet<int[]> result = new HashSet<>();
        int sum = 0;

        for(int i = 0; i< arr.length; i++){
            int element = arr[i];
            sum = sum + element;
            System.out.print(sum+" ");

            if(CumulativeSum.contains(sum)){
                int j = i;
                int temp = sum;
                boolean PrevIndexFound = false;
                while(!PrevIndexFound){
                    temp = temp - arr[j];
                    if(temp == sum){
                        PrevIndexFound = true;
                    }else{
                        j--;
                    }
                }
                result.add(Arrays.copyOfRange(arr,j,i+1));
            }

            if(sum == 0){
                result.add(Arrays.copyOfRange(arr,0,i+1));
            }
            CumulativeSum.add(sum);
        }
        System.out.println();
        return result;
    }

    public static int LongestConsecutiveSubSequence(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        for(int element: arr){
            set.add(element);
        }
        int size = 0;

        for(int element:arr){
            if(!set.contains(element-1)){
                int tsize = 0;
                while(set.contains(element = element+1)){
                    tsize++;
                }
                size = Math.max(tsize,size);
            }
        }
        return size+1;
    }

    public static void FourSumOutPut(Pair<Pair> pair){
        Pair Pair1 = pair.getElement1();
        Pair Pair2 = pair.getElement2();
        System.out.println("["+Pair1.getElement1()+", "+Pair1.getElement2()+", "+Pair2.getElement1()+", "+Pair2.getElement2()+"]");
    }

    public static ArrayList<Pair> FourSum(int[] arr, int Sum){
        HashMap<Integer, Pair> TwoSumsMap = new HashMap<>();
        ArrayList<Integer> TwoSumArray = new ArrayList<>();
        ArrayList<Pair> Result = new ArrayList<>();
        for(int i = 0; i< arr.length;i++){
            for(int j = i+1; j< arr.length;j++){
                int s = arr[i]+arr[j];
                TwoSumArray.add(s);
                TwoSumsMap.put(s,new Pair(i,j));
            }
        }

        for(int TwoSum: TwoSumArray){
            if(TwoSumsMap.containsKey(Sum-TwoSum)){
                Pair Pair1 = TwoSumsMap.get(TwoSum);
                Pair Pair2 = TwoSumsMap.get(Sum-TwoSum);
                TwoSumsMap.remove(TwoSum);
                TwoSumsMap.remove(Sum-TwoSum);
                if(!Pair1.Compare(Pair2,false)){
                    Pair pair = new Pair(Pair1,Pair2);
                    FourSumOutPut(pair);
                    Result.add(pair);
                }
            }
        }

        return Result;

    }
}
