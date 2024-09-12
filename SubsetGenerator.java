import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class SubsetGenerator<T> {

    public static void main(String[] args) {
        //input set:
        Integer[] nums = {1, 2, 3, 4, 5};
        Character[] chars = {'m', 'n', 'o', 'p', 'q'};

        List<List<Integer>> intSubsets = generateSubsets(nums);
        System.out.println("All integer subsets:");
        for (List<Integer> subset : intSubsets) {
            System.out.println(subset);
        }

        List<List<Character>> charSubsets = generateSubsets(chars);
        System.out.println("All character subsets:");
        for (List<Character> subset : charSubsets) {
            System.out.println(subset);
        }
    }

    public static <T> List<List<T>> generateSubsets(T[] set){
        List<List<T>> subset = new ArrayList<>();
        Stack<T> stack = new Stack<>();
        backtrack(subset, stack, set, 0);

        return subset;
    }

    private static <T> void backtrack( List<List<T>> subset,  Stack<T> stack, T[] set, int start){
        subset.add(new ArrayList<>(stack));
        for (int i=start; i<set.length; i++){
            stack.push(set[i]);
            backtrack(subset, stack, set, i + 1);
            stack.pop();
        }
    }
}
