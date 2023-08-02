import DataStructures.LinkedList.LinkedListDS;
import DataStructures.LinkedList.LinkedListQuestions;

public class Main {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();


        int[] arr = new int[]{3,90,93,23,32,98,75};

        int[] a = {1,6,8,19,32,37,41};
        int[] b = {1,7,8,19,41,63,98,100};
        int[] d = {4,6,7,3,5,17,90,81};
        int[] c = {1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0,1,2,1,0,2,0,0,2,1,2,0};
        int[] e = {2,3,4,5};
        int[] f = {3,4,5,6,7,8,9,10};
        //             0 1 2 3 4 5 6  7
        int[] books = {1,7,4,1,3,6,10,5};
        int[] g = {-2,4,-1,-1,2,61,16,-9,-7};


//        System.out.println(HashMapDS.LongestConsecutiveSubSequence(d));
//        System.out.println(HashMapDS.FourSum(books,14));

        LinkedListDS<Integer> list1 = new LinkedListDS<>();
        LinkedListDS<Integer> list2 = new LinkedListDS<>();
        int count = 1;
        for(int i = 1; i<=50; i++){
            if(i%5 == 0 || i%5 == 3){
                list1.add(i);
            }else if(i%5 == 4) {
                list2.add(i);
            }

        }

        list1.print();
        list2.print();
        LinkedListQuestions.Merge2SortedLinkedListInBlocks(list1.getHead(false),list2.getHead(false));
//        LinkedListQuestions.PalindromeLinkedList(list1.getHead(false));
//        LinkedListQuestions.ReversingList(list1.getHead(false));
//        LinkedListQuestions.PalindromeLinkedList(list1.getHead(false));

//        LinkedListDS.print(LinkedListQuestions.MergeTwoSortedLinkedList2(list1.getHead(false),list2.getHead(false)));

        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("Time taken: "+(t2-t1));



    }
}