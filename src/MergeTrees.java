public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        TreeNode treeNode = new TreeNode(t1 != null ? t2 != null ? t1.val + t2.val : t1.val : t2.val);
        TreeNode newLeft = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        TreeNode newRight = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        treeNode.left = newLeft;
        treeNode.right = newRight;
        return treeNode;
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
