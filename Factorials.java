public class Factorials {
    /*
    * Iterations ( limits (while) or boundaries (for)): O(n)
    * Recursion( a function calls itself): O(n!)
    * */

    //Iteration Approach:
    public static int fct_it(int n){
        int result=1;
        for(int i=1; i<=n; i++){
            result*=i;
        }
        return result;
    }

    //Recursion  approach:
    public static int fct_rec(int n){
        if (n==0 || n==1){
            return 1;
        } else {
            return n*fct_rec(n-1);
        }
    }

    //Testing in main method:
    public static void main(String[] args) {
        int n= 30;
        System.out.println("Recursion approach");
        int result=fct_rec(n);
        System.out.println("Factorial of " +n+ " using recursion is:" +  result);
        System.out.println();

        System.out.println("Iteration approach");
        int result2=fct_it(n);
        System.out.println("Factorial of " +n+ " using recursion is:" +  result2);
        System.out.println();
    }
}
