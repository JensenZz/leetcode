public class Tree2str {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left.equals("") && right.equals("")) return t.val + "";
        return t.val + (left.equals("") ? "()" : "(" + left + ")") + (right.equals("") ? "" : "(" + right + ")");
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
