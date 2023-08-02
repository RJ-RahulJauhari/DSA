import java.util.Comparator;

public class SortNumbersInArrayListAccendingOrder implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1>o2){
            return 1;
        }
        else if(o2 > o1){
            return -1;
        }
        else{
            return 0;
        }
    }

    @Override
    public Comparator<Integer> reversed() {
        return Comparator.super.reversed();
    }
}
