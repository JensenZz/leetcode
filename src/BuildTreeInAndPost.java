public class BuildTreeInAndPost {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }


    public static TreeNode buildTree(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        //base
        if (instart > inend) {
            return null;
        }
        //构造root  后序遍历 root一定在postorder最后一个值
        TreeNode root = new TreeNode(postorder[postend]);
        //找到中序遍历的下标转换
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == root.val) break;
        }
        int size = index - instart;


        root.left = buildTree(inorder, instart, index - 1,
                postorder, poststart, poststart + size - 1);

        root.right = buildTree(inorder, index + 1, inend,
                postorder, poststart + size, postend - 1);

        return root;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
