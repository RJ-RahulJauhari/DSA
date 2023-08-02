import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static void Swap(int[] array,int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static List<Integer> BubbleSort(List<Integer> array){
        for(int i = 0; i<array.size(); i++){
            for(int j =0; j< array.size()-i-1;j++){
                int temp;
                if(array.get(j) > array.get(j+1)){
                    temp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1,temp);
                    System.out.println(array);
                }
            }
            System.out.println();
        }
        return array;
    }

    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static int[] InsertionSort(int[] array){
        for(int i = 1; i< array.length; i++){
            int j = i-1;
            int temp = array[i];
            for(;j>=0;j--){
                if(temp<array[j]){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = temp;
            printArray(array);
        }
        return array;
    }

    public static int[] SelectionSort(int[] array){
        for(int i = 0; i<array.length; i++){
            int min = array[i];
            int minIndex = i;
            for(int j = i; j< array.length;j++){
                if(array[j] < min){
                    min = array[j];
                    minIndex = j;
                }
            }
            int temp;
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
            printArray(array);
        }
        return array;
    }

    public static ArrayList<Integer> IntersectionOf2Arrays(int[] arr1,int[] arr2){
        int i = 0;
        int j = 0;

        ArrayList<Integer> result = new ArrayList<>();

        while(i < arr1.length && j < arr2.length){
            if(i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            if(arr1[i] == arr2[j]){
                result.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i]<arr2[j]) {
                i++;
            } else if (arr2[j]<arr1[i]) {
                j++;
            }
        }

//        for(Integer ele : result){
//            System.out.println(ele);
//        }
        return result;

    }

    public static int[] Sort_Array_With_3_Types_Of_Elements(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;

        while(mid != high+1){
            switch (arr[mid]){
                case 0:
                    Swap(arr,mid,low);
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    Swap(arr,mid,high);
                    high--;
            }
        }
        printArray(arr);
        return arr;
    }

//    public static int Partition(int[] arr,int start,int end){
//        int i = start;
//        int j = end;
//        int pivot = arr[start];
//
//        while(i<j){
//            while(i<j && arr[i]<pivot){
//                i++;
//            }
//            while(arr[j]>pivot){
//                j--;
//            }
//            if(arr[i]>arr[j]){
//                Swap(arr,i,j);
//            }
//        }
//        Swap(arr,start,j);
//        return j;
//    }

    public static int Partition(int[] arr,int start,int end){
        int i = start;
        int j = end;
        int pivot = arr[start];

        while(i<j){
            while(i<j && arr[i]<=pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<j){
                Swap(arr,i,j);
            }
        }
        Swap(arr,j,start);
        printArray(arr);
        return j;
    }

    public static int PartitionOptimized(int[] arr,int start,int end){
        int i = start;
        int j = end;
        RandomIndexSwap(arr,start,end);
        int pivot = arr[start];

        while(i<j){
            while(i<j && arr[i]<=pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<j){
                Swap(arr,i,j);
            }
        }
        Swap(arr,j,start);
        printArray(arr);
        return j;
    }

    public static void RandomIndexSwap(int[] arr,int start,int end){
        int randomIndex = (int)(Math.random()*(end-start+1));
        Swap(arr,start,randomIndex);
    }

    public static int[] QuickSortOptimized(int[] arr,int start,int end){
        if(start<end) {
            int pivot = PartitionOptimized(arr, start, end);
            QuickSort(arr, start, pivot - 1);
            QuickSort(arr, pivot + 1, end);
        }
        return arr;
    }

    public static int[] QuickSort(int[] arr,int start,int end){
        if(start<end) {
            int pivot = Partition(arr, start, end);
            QuickSort(arr, start, pivot - 1);
            QuickSort(arr, pivot + 1, end);
        }
        return arr;
    }

    public static void Merge(int[] arr,int start,int mid,int end){
        int[] merged = new int[end-start+1];
        int k = 0;

        int i = start;
        int j = mid;

        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                merged[k] = arr[i];
                i++;
            }else{
                merged[k] = arr[j];
                j++;
            }
            k++;
        }

        if(i == mid-1){

        }

    }

    public static void MergeSort(int[] arr,int start,int end){
        int mid = (start+end)/2;
        MergeSort(arr,start,mid);
        MergeSort(arr,mid+1,end);
        Merge(arr,start,mid,end);
    }


}
