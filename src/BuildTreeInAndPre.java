public class BuildTreeInAndPre {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        int a[] = new int[]{3, 9, 20, 15, 7};
        int b[] = new int[]{9, 3, 15, 20, 7};
        TreeNode aa = buildTree(a, b);
    }


    public static TreeNode buildTree(int[] preorder, int prestart, int preend,
                                     int[] inorder, int instart, int inend) {
        //base
        if (prestart > preend) {
            return null;
        }
        //构造root  前序遍历 root一定在preorder第一个值
        TreeNode root = new TreeNode(preorder[prestart]);
        //找到中序遍历的下标转换
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == root.val) break;
        }
        int size = index - instart;


        root.left = buildTree(preorder, prestart + 1, prestart + size,
                inorder, instart, index - 1);

        root.right = buildTree(preorder, prestart + size + 1, preend,
                inorder, index + 1, inend);

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
