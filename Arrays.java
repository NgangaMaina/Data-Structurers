public class Arrays {
   //print method.
    //1D array.
    //Big O notation= Linear time.
    public static void print1D(int[] array){
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
    //Big O notation Quadratic time.
    public static void print2D(int [][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[i].length; j++){
                System.out.print(array [i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int [] [] numbers2D= {
                {1, 2, 3, 4, 5},  //0
                {6, 7, 8, 9, 10}, //1
                {11, 12, 13, 14, 15}, //2
        };
        //To print 13; row2 clo 2. ie:
       // System.out.println(numbers2D[2][2]);
      /*  System.out.println("1D Printout");
        print1D(numbers);*/
        //An increase in problem (array) size= increase in algorithm runtime.

        System.out.println("2D Printout");
        print2D(numbers2D);
    }
}

//1D= linear time. One for loop. items in a line.
//2D= Quadratic time. Two level-nested for loop. itens in a square.(l*w)
//3D= cubic time. 3-level-nested for loop. items in a cube. (l*w*h)

