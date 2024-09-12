public class Sort {
    public static void insertionSort(int[] data){
        int n = data.length;
        for (int i = 1; i<n; i++){
            int key = data[i];
            int x = i-1;
            while (x>=0 && key<data[x]){
                data[x+1] = data[x];
                x--;
            }
            data[x+1]= key;
        }

    }

    public static void selectionSort(int[] data){
        int n = data.length;
        for(int i = 0; i<n; i++){
            int minIdx = i;
            for(int j = i; j<n; j++){
                if(data[j] < data[minIdx]){
                    minIdx = j;
                }
            }
            int temp = data[i];
            data[i] = data[minIdx];
            data[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {23, 12, 11, 18, 19, 26};
       // insertionSort(numbers);
        selectionSort(numbers);
        for (int i :  numbers){
            System.out.println(i + " ");
        }
    }
}
