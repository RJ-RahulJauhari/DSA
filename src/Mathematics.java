import java.util.*;

public class Mathematics {

    public static long Factorial(int Number){
        if (Number == 1){
            return 1;
        }
        return Number * Factorial(Number-1);
    }


    public static boolean isPrime(int Number){

        int count = 0;
        for(int i = 2;i<=Number;i++ ){
            if(Number%i==0){
                count++;
            }
        }
        if(count>1){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isPrimeOptimized(int Number) {

        boolean FactorFound = false;
        for (int i = 2; i * i <= Number; i++) {
            if (Number % i == 0) {
                FactorFound = true;
            }
        }
        return !FactorFound;
    }

    public static boolean isPrimeHighlyOptimized(int Number){
        if(Number == 1){
            return false;
        }else if(Number == 2 || Number == 3){
            return true;
        } else if (Number%2 == 0 || Number%3 == 0) {
            return false;
        }else{
            for(int i = 5; i <= Math.sqrt(Number); i = i+6){
                if(Number%i == 0 || Number%(i+2) == 0){
                    return false;
                }
            }
            return true;
        }
    }

    public static int EuclideanGCF(int a, int b){
        if(a==b){
            return a;
        }else if(b>a){
            return EuclideanGCF(b,a);
        }else{
            return EuclideanGCF(a-b,b);
        }
    }

    public static int OptimizedEuclideanGCF(int a,int b){
        if (a%b == 0){
            return b;
        }else if(b>a){
            System.out.println(b+" "+a);
            System.out.println("Correction Made:");
            System.out.println();
            return OptimizedEuclideanGCF(b,a);
        }else{
            System.out.println(a%b+" "+b);
            return OptimizedEuclideanGCF(a%b,b);
        }
    }

    public static int LCM(int a,int b){
        return (a*b)/OptimizedEuclideanGCF(a,b);

    }

    public static int TrailingZerosInAFactorialBruteMethod(int Number){
        long factorial = Factorial(Number);
        int zeroCount = 0;
        boolean allTrailZerosFound = false;
        while(!allTrailZerosFound){
            if(factorial%10 == 0) {
                zeroCount++;
                factorial = factorial/10;
            }else{
                allTrailZerosFound = true;
            }
        }
        return zeroCount;

    }

    public static int TrailingZerosInANumberBruteMethod(long Number){
        long num = Number;
        int zeroCount = 0;
        boolean allTrailZerosFound = false;
        while(!allTrailZerosFound){
            if(num%10 == 0) {
                zeroCount++;
                num = num/10;
            }else{
                allTrailZerosFound = true;
            }
        }
        return zeroCount;
    }

    public static int TrailingZerosInFactorialOptimized(int a){
        int countZeros = 0;
        int num = a;

        while(num>0){
            for(int i = num; i>0; i--){
                if(i%5 == 0){
                    System.out.println("Starting Value is: "+num+"        Number is :"+i);
                    countZeros = countZeros + 1;
                    System.out.println("Count of Zeros: "+countZeros);
                    System.out.println();
                }
            }
            num = num/5;
        }
        return countZeros;
    }

    public static int UniquePathInGrid(int rows,int columns){
        return (int)((Mathematics.Factorial(rows+columns))/(Mathematics.Factorial(columns)*Mathematics.Factorial(rows)));
    }

    public static ArrayList<Integer> AllDivisorsOfNumber(int Number){
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 1; i * i <= Number; i++){
            if(Number%i == 0){
                factors.add(i);
                if(Number/i != i){
                    factors.add(Number/i);
                }
            }
        }
        Collections.sort(factors,new SortNumbersInArrayListAccendingOrder());
        return factors;
    }

    public static ArrayList<Integer> AllDivisorsOfNumberSorted(int Number){
        ArrayList<Integer> factors = new ArrayList<>();

        for(int i = 1; i*i <= Number; i++){
            if(Number%i == 0){
                factors.add(i);
            }
        }
        for(int i = (int)Math.sqrt(Number); i>0;i--){
            if(Number%i == 0 && Number/i != i){
                factors.add(Number/i);
            }
        }
        return factors;
    }

    public static void SieveOfEratosthenes(int n){
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);

        for(int i = 2; i*i <= n; i++){
            if(arr[i]){
                for(int j = i*2; j <= n; j = j + i){
                    arr[j] = false;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(arr[i]){
                System.out.println(i);
            }
        }
    }

    public static int FastPower(int number,int power){
        // Base Condition:
        if(number == 1 || power == 0){
            return 1;
        }

        int halfResult = FastPower(number,power/2);
        int fullResult = halfResult*halfResult;

        if(power%2 != 0){
            return fullResult*number;
        }
        return fullResult;
    }

    public static void MinAndMaxUsingDivideAndConquer(int[] arr, int start, int end){
        int max, min;
        int mid  = start + (end-start)/2;
        if(start == end){
            min = max = arr[start];
        }else if(start+1 == end){
            if(arr[start] > arr[end]){
                max = arr[start];
                min = arr[end];
            }else{
                max = arr[end];
                min = arr[start];
            }
        }else {
            MinAndMaxUsingDivideAndConquer(arr, start, mid);
            MinAndMaxUsingDivideAndConquer(arr, mid + 1, end);
            Merge(arr, start, mid, end);
        }

    }

    public static void Merge(int[] arr,int start, int mid, int end){

    }
}
