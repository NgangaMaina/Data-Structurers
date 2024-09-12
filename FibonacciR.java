public class FibonacciR {
    public static int fib(int n){
        if(n<=1) {
            return n;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        int n=10;
        System.out.println("The fibonacci number at position " +n+ " is:"  +fib(n));


    }


}
