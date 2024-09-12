import java.util.concurrent.TimeUnit;
import java.util.*;

public class MergeSort {
    /*We will need an extra amount of storage to execute this.
     *This  will always take O(log 'n').
     */
    /*
     * 1. sort the left half.
     * 2. sort the right half.
     * 3. Merge the two sub-arrays of arr[].
     *  First sub-array is arr[l..m]
     * Second sub-array is arr[m+1..r]
     */
    public void merge(int arr[], int l, int m, int r){
        //find sizes (lengths) of two sub-arrays to be merged.
        int n1 = m - l + 1;
        int n2 = r - m;

        //Create temporary arrays:
        int L[] = new int[n1];
        int[] R = new int[n2];

        //Copy the data to the temporary arrays:
        for (int i = 0; i<n1; ++i){
            L[i] = arr[l + i];
        }

        for (int j = 0; j<n2; ++j){
            R[j] = arr[m + l + j];
        }

        //Merge the temp arrays :
        int i = 0, j = 0; //Initial indices of the first and second sub-arrays.
        int k = 1; //initial index of the merged sub-array array.
        while (i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
        }
        //Copying the remining elements of L[] if any:
        while (i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
       //Copying the remaining elements of R[] if any:
        while (j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r){
        if (l < r){ //If the left index is less than the right index:
            //find the middle point
            int m = (l+r)/2;

            //Sort the first(left) and second (right) halves:
            sort (arr, l, m);
            sort (arr, m + l, r);

            //Merge the sorted halves by comparing index values and selecting the desired i.e. Upwards or Downwards order:
            merge(arr, l, m, r);
        }
    }

    //A utility function to print the array size n:
    public static void printArray(int arr[]){
        int n = arr.length;
        for(int i = 0; i<n; i++){
            System.out.println(arr[i] + " ");
            System.out.println();
        }
    }

     //Randomise test data:
    private static void shuffleArray(int[] array){
        int index, temp;
        Random random = new Random();
        for(int i = array.length - 1; i>0; i-- ){
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    //Driver method:
    public static void main(String[] args) throws InterruptedException {
        int[] numbers = new int[100];
        //Sorted array of ints 1 - 100000:
        for (int a = 0; a<numbers.length; a++){
            numbers[a] = a+1;
        }
        shuffleArray(numbers);
        long startTime = System.nanoTime();
        System.out.print("Stock: ");
        printArray(numbers);
        MergeSort object = new MergeSort();

        //Create a new object to sort out items:
        object.sort(numbers, 0, numbers.length - 1);
        System.out.print("sorted: ");
        printArray(numbers);
        TimeUnit.SECONDS.sleep(1);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Merge-sort execution time in nanoseconds: " + timeElapsed);

    }
}
