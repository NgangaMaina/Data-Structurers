public class Peak {
    public static void main(String[] args) {
        int[] pik ={13, 18, 26, 34, 27, 19, 19}; //Creating the array.
        int p= pik.length; // Creating a variable(p) for the length of the array.
        int peak = 0; //Creating a variable(peak) to store the peak value and is initially the first value of the array.

        //Case when the array has only one element and if so that element is printed, and we exit the program.
        if(p==1){
            System.out.print(pik[0]);
        }

        //For loop to traverse the array:
        for(int i=0; i<p; i++){
            //Checking for peak property for the value present at index 0 in the array:
            if(i==0){
                //There is no left neighbour, and so we only check for the right hand-side element:
                if(pik[i+1] > pik[i])
                    peak = pik[i+1];
            }

            //Checking for the peak property of the value present at index p-1 in the array:
            else if(i==p-1){
                //There is no right neighbour, and so we only check for the left hand-side neighbour:
                if(pik[i-1] < pik[i])
                    peak = pik[i];
            }

            //Checking for the peak property of the rest of the elements in the array:
            else{
                if(pik[i-1] < pik[i] && pik[i+1] < pik[i])
                    peak = pik[i];
            }

        }

        //Printing the peak value:
        System.out.println(peak);
    }

}
