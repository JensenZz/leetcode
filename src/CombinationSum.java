import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        dfs(candidates, target, arrayList, new ArrayList<>(), 0);
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> allSum, List<Integer> sum, int index) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            allSum.add(new ArrayList<>(sum));
            return;
        }
        // 选择当前数
        if (target - candidates[index] >= 0) {
            sum.add(candidates[index]);
            dfs(candidates, target - candidates[index], allSum, sum, index);
            sum.remove(sum.size() - 1);
        }
        //跳过
        dfs(candidates, target, allSum, sum, index + 1);
    }
}
