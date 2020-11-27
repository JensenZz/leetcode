public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        return travale(root, sum);
    }
    //终止条件 sum -自己的值==0 刚好 且自己为子叶  其他就是左子树的值 + val = sum即可
    public boolean travale(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }

      return travale(root.left, sum- root.val)||travale(root.right, sum- root.val);
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
