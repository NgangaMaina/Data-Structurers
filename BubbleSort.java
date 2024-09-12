import java.util.Random;

public class BubbleSort {
    public static void swapOrder(int[] array, int x, int y){
        double temp = array[x];
        array[x] = array[y];
        array[y] = (int) temp;
    }

    public static void printArray(int array[]){
        int n = array.length;
        for(int i = 0; i<n; ++i ){
            System.out.print(array[i] + " ");
        }
    }
    public static void sort(int[] array){
        boolean sort_Complete = false;
        while(!sort_Complete){
            sort_Complete = true;
            for(int i = 0; i< array.length - 1; i++){
                if(array[i] > array[i + 1]){
                    swapOrder(array, i, i+1);
                    sort_Complete = false;
                }
            }
        }
    }

    public static void shuffleArray(int [] array){
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i>0; i--){
            index = random.nextInt(i +1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }


    }

    public static void main(String[] args) {
        int [] numbers = new int[20];
        for (int a = 0; a<20; a++){
            numbers[a] = a+1;
        }
        shuffleArray(numbers);
        System.out.println("Before sorting");
        printArray(numbers);
        System.out.println(" ");
        System.out.println("After sorting");
        sort(numbers);
        printArray(numbers);
    }
}
