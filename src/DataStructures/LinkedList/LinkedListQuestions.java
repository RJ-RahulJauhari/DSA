package DataStructures.LinkedList;

public class LinkedListQuestions {

    public static int FindMidElementInLinkedList(LinkedListDS<Integer> list){
        Node<Integer> head,fast,slow;
        head = list.getHead(false);
        fast = head;
        slow = head;

        while(fast != null && fast.getNext() != null){
            /* Slow pointer is traveling one by one, whereas the fast pointer is going twice as fast.*/
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow.getData();
    }

    public static void ReverseALinkedList(LinkedListDS<Integer> list){
        Node<Integer> prev, current;
        prev = null;
        current = list.getHead(false);

        while(current != null){
            Node temp = current.getNext();

            current.setNext(prev);
            prev = current;
            current = temp;
        }
        list.setHead(prev);
        list.print();
    }

    public static LinkedListDS<Integer>  ReverseKNodes(LinkedListDS<Integer> list, int k){
        Node<Integer> cur, newHead, prevFirst;
        prevFirst = null;
        newHead = null;
        cur = list.getHead(false);
        while(cur != null){
            /* This part of code reverses 'k' nodes, the following code keeps a count of number of nodes reversed
               then by incrementing the 'count' variable after each pointer reversal.
               We also use 'first' variable to keep track of the very first node on this window of k nodes, if
               we don't keep track of the first node it will get lost and can not be accessed, the cur pointer moves forward. */
            int count = 0;
            Node<Integer> prev = null;
            Node<Integer> first = cur;
            while(cur != null && count < k) {
                Node<Integer> temp = cur.getNext();
                cur.setNext(prev);
                prev = cur;
                cur = temp;
                count++;
            }
            /* Here once 'k' group of nodes are reversed using the conditions bellow we have to attach 2 windows of 'k' bits.
               For the very first reversal iteration, we have to re-initialize the head to the kth node of the first window,
               as now that node will be our new head, therefore in the first if condition we initialize our 'newHead' to
               the 'prev' pointer.
               Second window reversal onward our newHead will not be null, so we always fall into the 'else'
               part, where for the 1st window and 2nd window the prevFirst points to null and is then made to point to last element of
               the non-reversed kth element of the 2nd window.
               After every window iteration we reinitialize the prevFirst to the second window's first element, so that we can connect the
               2nd and 3rd windows prevFirst and prev in the next iteration.
             */
            if(newHead == null){
                newHead = prev;
            }else{
                prevFirst.setNext(prev);
            }
            prevFirst = first;
        }
        // After all the iterations we reinitialize our head to the newHead, so that while iterating through the reversed list we start from the new head.
        list.setHead(newHead);
        return list;
    }

    public static boolean isCyclePresent(LinkedListDS<Integer> list){
        Node<Integer> cur = list.getHead(false);
        Node<Integer> slow,fast;
        slow = cur;
        fast = cur;
        boolean found = false;
        while(fast != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean isCyclePresent(Node<Integer> head){
        Node<Integer> cur = head;
        Node<Integer> slow,fast;
        slow = cur;
        fast = cur;
        boolean found = false;
        while(fast != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(slow == fast){
                found = true;
                break;
            }
        }
        return found;
    }

    // Floyds Cycle Detection Algorithm:
    public static Node<Integer> DetectMatchingPoint(Node<Integer> head){
        Node<Integer> fast,slow;
        fast = head;
        slow = head;
        while(fast != slow){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    public static Node<Integer> DetectStartingPointOfCycle(Node<Integer> head,boolean DeCyclizeList){
        Node<Integer> matchingPoint = DetectMatchingPoint(head);
        if(matchingPoint == null){
            return null;
        }else {
            Node<Integer> p1, p2, prev;
            p1 = head;
            p2 = matchingPoint;
            prev = null;
            while (p1 != p2) {
                p1 = p1.getNext();
                prev = p2;
                p2 = p2.getNext();
            }
            if (DeCyclizeList) {
                prev.setNext(null);
            }
            return p1;
        }
    }

    public static Node<Integer> MergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2){
        Node<Integer> base = head1;
        Node<Integer> secondary = head2;
        Node<Integer> prev1 = null;

        Node<Integer> newHead = head1;
        while(base != null && secondary != null){
            int baseData = base.getData();
            int secondaryData = secondary.getData();
            Node<Integer> secondaryNext = secondary.getNext();
            if(secondaryData<baseData){
                if(prev1 == null){
                    prev1 = secondary;
                    prev1.setNext(base);
                    newHead = prev1;
                    prev1 = base;
                }else{
                    prev1.setNext(secondary);
                    secondary.setNext(base);
                    prev1 = secondary;
                }
                secondary = secondaryNext;
            }else{
                prev1 = base;
                base = base.getNext();
            }
        }
        if(base == null){
            prev1.setNext(secondary);
        }else{
            secondary.setNext(base);
        }
        return newHead;

    }

    public static Node<Integer> MergeTwoSortedLinkedList2(Node<Integer> head1,Node<Integer> head2) {
        Node<Integer> a = head1;
        Node<Integer> b = head2;
        Node<Integer> head;
        Node<Integer> prev;

        if(head1 == null){
            return head2;
        }else if(head2 == null){
            return head1;
        }else{
            if (a.getData() <= b.getData()) {
                head = a;
                prev = head;
                a = a.getNext();

                if(a.getNext() == null) prev.setNext(b);
                if(b.getNext() == null) prev.setNext(a);

                while (a.getNext() != null || b.getNext() != null) {
                    if (a.getData() <= b.getData()) {
                        prev.setNext(a);
                        a = a.getNext();
                    } else {
                        prev.setNext(b);
                        b = b.getNext();
                    }
                    prev = prev.getNext();
                }
                return head;
            } else {
                return MergeTwoSortedLinkedList2(b, a);
            }
        }
    }

    public static Node<Integer> Merge2SortedLinkedListInBlocks(Node<Integer> head1,Node<Integer> head2){
        if(head1.getData()<=head2.getData()){

            // Initializing Intervals
            Node<Integer> start = head1;
            Node<Integer> end = start.getNext();


            // Setting 2nd Pointer
            Node<Integer> cur = head2;

            while(end != null && cur != null) {

                // Initializing block intervals
                Node<Integer> backOfBlock = cur;
                Node<Integer> frontOfBlock;

                if(cur.getData() <= end.getData()) {
                    // When data lies between the start and end interval range
                    if (cur.getNext().getData() >= start.getData() && cur.getNext().getData() <= end.getData()) {
                        cur = cur.getNext();
                    } else {
                        frontOfBlock = cur;
                        start.setNext(backOfBlock);
                        cur = cur.getNext();
                        frontOfBlock.setNext(end);

                        start = end;
                        end = start.getNext();
                    }
                }else{
                    start = end;
                    end = start.getNext();
                }

                if(cur.getNext() == null) {
                    frontOfBlock = cur;
                    backOfBlock = cur;
                    start.setNext(backOfBlock);
                    frontOfBlock.setNext(end);
                    break;
                }
            }


            System.out.println("Merged List:");
            LinkedListDS.print(head1);
            return head1;
        }else{
            return Merge2SortedLinkedListInBlocks(head2,head1);
        }
    }

    public static void PalindromeLinkedList(Node<Integer> head){
        // First we find the middle element using Fast and Slow pointers...
        Node<Integer> fast = head,slow = head;
        while(fast.getNext()!=null){
            if(fast.getNext().getNext() == null){
                fast = fast.getNext();
                break;
            }
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        Node<Integer> mid = slow;
        System.out.println("Slow Pointer Value :"+mid.getData());
        Node<Integer> tail = fast;
        System.out.println("Fast Pointer Value :"+tail.getData());

        // Now we reverse half of the linked list

        Node<Integer> prev = mid;
        Node<Integer> cur = prev.getNext();
        Node<Integer> next = cur.getNext();

        while(next != null){
            if(prev == mid){
                prev.setNext(null);
            }
            cur.setNext(prev);
            prev = cur;
            cur = next;
            next = cur.getNext();
        }
        cur.setNext(prev);

        LinkedListDS.printBetweenNodes(tail,mid);
        LinkedListDS.printBetweenNodes(head,mid);


        Node<Integer> pointer = head;
        boolean isPalindrome = true;

        while(pointer.getNext() != mid){
            if(pointer.getData() == tail.getData()){
                pointer = pointer.getNext();
                tail = tail.getNext();
            }else{
                isPalindrome = false;
                break;
            }
        }

        if(isPalindrome){
            System.out.println("The LinkedList is a Palindrome");
        }else{
            System.out.println("The LinkedList is not a Palindrome");
        }
    }

    public static Node<Integer> ReversingList(Node<Integer> head){
        Node<Integer> prev,cur,next;
        prev = head;
        cur = prev.getNext();
        next = cur.getNext();


        while(next != null){
            if (prev == head) {
                prev.setNext(null);
                cur.setNext(prev);
                prev = cur;
                cur = next;
                next = cur.getNext();
            }else {
                cur.setNext(prev);
                prev = cur;
                cur = next;
                next = cur.getNext();
            }
        }
        cur.setNext(prev);
        LinkedListDS.print(cur);
        return cur;

    }

}
