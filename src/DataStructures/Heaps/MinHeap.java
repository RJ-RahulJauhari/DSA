package DataStructures.Heaps;

import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> HeapArr = new ArrayList<>();
    public MinHeap(){

    }

    public void insert(int key){
        HeapArr.add(key);
        if(HeapArr.size()==1) return;

        int n = HeapArr.size()-1;
        int parent = n/2;

        while(key < HeapArr.get(parent) && n != 0){
            swap(HeapArr,n,parent);
            n = parent;
            parent = n/2;
        }
    }

    public void delete(int key){

        int finder = 0;
        int lastele = HeapArr.size()-1;

        int cur = HeapArr.get(finder);

        while(key != cur && finder != HeapArr.size()-1){
            finder++;
            cur = HeapArr.get(finder);
        }

        if(finder < HeapArr.size()-1) {
            swap(HeapArr, finder, lastele);
            HeapArr.remove(HeapArr.size() - 1);
            heapify(HeapArr, finder);
        }else{
            System.out.println("Element to be deleted was NOT FOUND!!!");
        }
    }

    public static void heapify(ArrayList<Integer> heap,int keyIndex){

        int key = heap.get(keyIndex);
        int left = 2*keyIndex+1;
        int right = 2*keyIndex+2;

        while(left < heap.size() && right < heap.size()){
            if(key > heap.get(left)){
                swap(heap,left,keyIndex);
                keyIndex = left;
            }else if(key > heap.get(right)){
                swap(heap,right,keyIndex);
                keyIndex = right;
            }else{
                break;
            }
        }
    }

    public void sort(){
        for(int i = 0; i < HeapArr.size();i++){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int cur = HeapArr.get(i);

            if(right >= HeapArr.size() || left >= HeapArr.size()) break;

            if((cur > HeapArr.get(left) || cur > HeapArr.get(right))){
                heapify(HeapArr,i);
            }
        }
        printHeap();
    }

    public static void swap(ArrayList<Integer> arr,int ind1, int ind2){
        int temp = arr.get(ind1);
        arr.set(ind1,arr.get(ind2));
        arr.set(ind2,temp);
    }

    public void printHeap(){
        System.out.println(HeapArr);
    }

    public int getHeapSize(){
        System.out.println(HeapArr.size());
        return HeapArr.size();
    }

}
