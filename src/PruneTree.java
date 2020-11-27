public class PruneTree {
    public TreeNode pruneTree(TreeNode root) {

        return traverse(root);
    }

    TreeNode traverse(TreeNode root) {
        if (root == null) return null;
        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);
        //先考虑叶子节点  所以是后序遍历  自底向上 先将剪好的左右子树拼装好 再开始重新判断剪枝
        root.left = left;
        root.right = right;
        //当遇到本身为0 左右子节点为null时  开始剪枝  否则返回原树即可
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }


    public class TreeNode {
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
