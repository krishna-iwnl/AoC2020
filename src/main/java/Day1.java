import java.util.ArrayList;
import java.util.Optional;

/*
 * Puzzle 1 : Two Sum
 * Puzzle 2 : Three Sum
 * */
public class Day1 {
    public Optional<ArrayList<Integer>> puzzle1(final ArrayList<Integer> inputNumbers, int low, int high, final int targetSum) {
        if (inputNumbers.size() < 2) return Optional.empty();
        inputNumbers.sort(Integer::compareTo);
        while (low < high) {
            int sum = inputNumbers.get(low) + inputNumbers.get(high);
            if (sum == targetSum) {
                ArrayList<Integer> res = new ArrayList<>(2);
                res.add(inputNumbers.get(low));
                res.add(inputNumbers.get(high));
                return Optional.of(res);
            } else if (sum < targetSum) {
                low++;
            } else {
                high--;
            }
        }
        return Optional.empty();
    }

    public Optional<ArrayList<Integer>> puzzle2(final ArrayList<Integer> inputNumbers, int low, int high, final int targetSum) {
        if (inputNumbers.size() < 3) return Optional.empty();
        for (int i = 0; i < inputNumbers.size() - 3; i++) {
            int curr = inputNumbers.get(i);
            int targetTwoSum = targetSum - curr;
            Optional<ArrayList<Integer>> twoSumRes = puzzle1(inputNumbers, i + 1, high, targetTwoSum);
            if (twoSumRes.isPresent()) {
                ArrayList<Integer> res = twoSumRes.get();
                res.add(curr);
                return Optional.of(res);
            }
        }
        return Optional.empty();
    }
}
