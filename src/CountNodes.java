public class CountNodes {
    public int countNodes(TreeNode root) {
        return traverse(root);
    }

    int traverse(TreeNode root) {
        if (root == null) return 0;
        // 前序遍历
        int right = traverse(root.left);
        // 中序遍历
        int left = traverse(root.right);
        // 后序遍历

        return right + left + 1;
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
