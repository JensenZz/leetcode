public class InsertIntoMaxTree {


    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        //先前序遍历读出列表 插入到最后数组  然后组装最大二叉树即可
        //或者根据最大二叉树定义发现至于右节点相关 找到并插入构建即可
        if (root == null || root.val < val) {
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            return tmp;
        }
        TreeNode right = insertIntoMaxTree(root.right,val);
        root.right = right;
        return root;

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
