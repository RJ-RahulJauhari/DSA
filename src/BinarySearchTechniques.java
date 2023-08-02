public class BinarySearchTechniques {


    public static void PrintArrayInRange(int[] arr,int start,int end){
        for(int i = start; i<=end; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int BinarySearch_InSortedArray_Iterative(int[] arr, int element){
        int left = 0;
        // Testing
        int right = arr.length-1;
        System.out.println("Element to be found is :"+element);
        PrintArrayInRange(arr,left,right);

        while(left<=right){
            int mid = left+(right-left)/2;
            if(element>arr[mid]){
                left = mid+1;
                PrintArrayInRange(arr,left,right);
            }else{
                right = mid-1;
                PrintArrayInRange(arr,left,right);
            }
            if(arr[mid] == element){
                PrintArrayInRange(arr,mid,mid);
                return mid;
            }
        }
        return -1;
    }

    public static int minOf(int number1,int number2){
        if(number1<number2){
            return number1;
        }else{
            return number2;
        }
    }

    public static double MedianOfTwoArrays(int[] arr1, int[] arr2){
        int size1 = arr1.length;
        int size2 = arr2.length;
        if(size2<size1) return MedianOfTwoArrays(arr2,arr1);
        int Bucket1Size, Bucket2Size;
        double median = 0.0;


        int left = 0;
        int right = size1;
        while(left<=right) {
            int mid;

            if (size1 + size2 % 2 == 0) {
                mid = (right - left) / 2;
                Bucket1Size = Bucket2Size = (size1 + size2) / 2;
            } else {
                mid = ((right - left) / 2) + 1;
                Bucket1Size = ((size1 + size2) / 2) + 1;
                Bucket2Size = (size1 + size2) - Bucket1Size;
            }

            int LeftMax1 = arr1[mid - 1];
            int LeftMax2 = arr2[Bucket1Size - mid];

            int RightMin1 = arr1[mid];
            int RightMin2 = arr2[Bucket1Size-mid+1];

            if (LeftMax1 <= RightMin2 && LeftMax2 <= RightMin1) {
                median = (Math.min(RightMin1,RightMin2) + Math.max(LeftMax1,LeftMax2))/2;
            }else if(LeftMax1 > RightMin2){
                right = mid;
            }else if(LeftMax2 > RightMin1){
                left = mid;
            }
        }
        return median;
    }

    public static boolean isEnough(int[] trees, int k, int CuttingHeight){
        int sum = 0;
        for(int i = 0; i < trees.length;i++){
            if(trees[i]>CuttingHeight){
                sum = sum +(trees[i]-CuttingHeight);
            }
        }
        return sum >= k;
    }

    public static int WoodCutting(int[] trees, int k){
        int low,high;
        low = 0;
        high = -1;
        for(int height: trees){
            high = Math.max(high,height);
        }
        int ans = -1;

        while(low<=high){
            int CuttingHeight = (low+high)/2;
            if(isEnough(trees,k,CuttingHeight)){
                low = CuttingHeight + 1;
                ans = CuttingHeight;
            }else{
                high = CuttingHeight - 1;
            }
        }
        return ans;
    }

    public static boolean isSafe(int[] books, int students, int pages){
        int count = 1;
        int current = 0;
        for(int i = 0; i<books.length; i++){
            if(books[i]>pages) return false;
            current = current + books[i];
            if(current>pages){
                count++;
                current = books[i];
            }
        }
        return count<=students;
    }

    public static int AllocateBooks(int[] books, int students){
        int low,high,mid;
        low = 0;
        high = 0;
        for(int pgs:books){
            high = high + pgs;
        }
        int MaxPagesPerStudent = 0;
        while(low<=high){
            mid = (low+high)/2;
            if(isSafe(books,students,mid)){
                high = mid-1;
                MaxPagesPerStudent = mid;
            }else{
                low = mid+1;
            }
        }
        return MaxPagesPerStudent;
    }
}
