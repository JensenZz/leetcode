public class IsSymmetric {
    //此题直接序列化不可取  有些用例走不通  只能递归遍历
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }


    public Boolean helper(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.val == b.val) && helper(a.left, b.right) && helper(a.right, b.left);

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
