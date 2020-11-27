public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }

//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        String Bstr = traverse(B);
//        Set<String> res = new HashSet<>();
//        traverse(A, Bstr, res);
//        return !res.isEmpty();
//    }
//
//    String traverse(TreeNode root, String s, Set<String> set) {
//        if (root == null) return "#";
//
//        String left = traverse(root.left,s,set);
//        String right = traverse(root.right,s,set);
//        String ss = left + root.val + right;
//        if (ss.equals(s)) set.add(ss);
//        return ss;
//    }
//
//    String traverse(TreeNode root) {
//        if (root == null) return "#";
//
//        String left = traverse(root.left);
//        String right = traverse(root.right);
//        return left + root.val + right;
//    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
