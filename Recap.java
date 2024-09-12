import java.util.Scanner;

public class Recap {
    public static int total_sum_alt1(int n){
        int total=0;
        for (int p=1; p<=n; p++){
            total= total +p;
        }
        return total;
    }
    //We use loop invariants above to prove effectiveness. (If correct)
    public static int total_sum_alt2(int n){
        int total= (n* (n+1)/2);
        return  total;
    }
//we use mathematical inductionn (Domino effect) to prove effectiveness. (If correct)

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the value for n:");
        int n=sc.nextInt();
        System.out.println("total= " +total_sum_alt1(n));
        System.out.println("   ");
        System.out.println("total= " +total_sum_alt2(n));
    }
}
