import java.util.ArrayList;
import java.util.List;

public class PathSum {

    int count = 0;

    public int pathSum(TreeNode root, int sum) {

        List<Integer> sumAll = pathSumAll(root, sum);
        return count;
    }

    public List<Integer> pathSumAll(TreeNode root, int sum) {
        if (root == null) return new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);

        List<Integer> left = pathSumAll(root.left, sum);
        for (Integer integer : left) {
            integer = integer + root.val;
            temp.add(integer);

        }
        List<Integer> right = pathSumAll(root.right, sum);
        for (Integer integer : right) {
            integer = integer + root.val;
            temp.add(integer);
        }
        count = count + (int) temp.stream().filter(x -> x == sum).count();

        return temp;
    }


    int ans = 0;

    public int newpathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }
    //优化上面代码  用深度优先方式 判断以根节点为主  向下sum递减寻址  由于后面还有计算需要归还sum原值 所以sum = sum+root.val
    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) ans++;
        dfs(root.left, sum);
        dfs(root.right, sum);
        sum += root.val;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
