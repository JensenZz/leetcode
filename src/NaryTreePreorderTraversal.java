import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {

    //    void traverse(TreeNode root) {
//        for (TreeNode child : root.children)
//            traverse(child);
//    }
    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }


    List<Integer> res = new ArrayList<>();

    void traverse(Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children)
            traverse(child);
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
