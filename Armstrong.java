
/*Armstrong/Narcissistic/ Plenary number  of order n is an n-digit number that is equal to the sum of its own digits
each raised to the power of n.
  For example: 371 -> 3-digit number
               3^3 +7^3 + 1^3=371
               371 is therefore an armstrong number.
 */


import java.util.ArrayList; //An import to store the digits of our input number.

public class Armstrong {
    public int num;
        //Creating a method that will check if a number is an Armstrong number:
        public static boolean numberIsArmstrong(int num){
            int p = num;  //Variable to maintain the original value of our number even as we do some operations on num.

            ArrayList<Integer> n =new ArrayList<>(); //Linear structure to store the digits of the number which is initially empty.

            //Creating a loop that will continue as long as p is greater than 0.
            while(p>0) {
                n.add(p % 10); //Extracting the last digit of p using modulo and adds it to our n arraylist.
                p /=10; //Moving to the next digit in the number.
            }
            //Calculating the sum of the digits raised to the number of the digits in the number:
            int numOfDigits = n.size(); //Calculating number of digits in the input by getting the size of our arraylist.

            int sum = 0; //stores sum of digits raised to the power of the number of digits.

            //Loop to iterate over our arraylist
            for(int digit: n){

                sum += Math.pow(digit, numOfDigits);

            }
            return sum== num; //This will check if the sum calculated is equal to the original number and returns true if so.

        }

    public static void main(String[] args) {
        int nars= 371; //Using 371 as our example.
        if(numberIsArmstrong(nars)){
            System.out.println(nars + " is an Armstrong number");

        } else {
            System.out.println(nars + "is not an Armstrong number");
        }
    }

    }

