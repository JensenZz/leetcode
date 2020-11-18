import java.util.HashSet;
import java.util.Set;

public class BalancedBinaryTree {


    // void traverse(TreeNode root) {
    //            // 前序遍历
    //            traverse(root.left)
    //            // 中序遍历
    //            traverse(root.right)
    //            // 后序遍历
    //        }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        Set<Boolean> booleans = new HashSet<>();
        leangth(root, booleans);
        //代码逻辑
        return !booleans.contains(false);
    }

    public static int leangth(TreeNode root, Set<Boolean> flag) {
        if (root == null) {
            return 0;
        }
        int left = leangth(root.left, flag);
        int right = leangth(root.right, flag);
        if (Math.abs(left - right) > 1) {
            flag.add(false);
        } else flag.add(true);
        return 1 + Math.max(left, right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
