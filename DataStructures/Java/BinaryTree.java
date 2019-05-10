import java.util.Iterator;
import java.util.Stack;

public class BinaryTree {
    Node root;

    private class Node {
        private int data;
        private Node right;
        private Node left;

        public Node(int d) {
            this.data = d;
            this.right = null;
            this.left = null;
        }
    }

    public String printPreOrder() {
        return __printPreOrder(root, 0);
    }

    private String __printPreOrder(Node n, int depth) {
        String ret = "";
        if (n == null) {
            return ret;
        }
        int i = 0;
        while (i < depth) {
            ret += " ";
            i++;
        }
        ret += n.data + "/n";
        ret += __printPreOrder(n.left, depth + 1);
        ret += __printPreOrder(n.right, depth + 1);
        return ret;
    }

    public String printPostOrder() {
        return __printPostOrder(root, 0);
    }

    private String __printPostOrder(Node n, int depth) {
        String ret = "";
        if (n == null) {
            return ret;
        }
        ret += __printPostOrder(n.left, depth + 1);
        ret += __printPostOrder(n.right, depth + 1);

        int i = 0;
        while (i < depth) {
            ret += " ";
            i++;
        }
        ret += n.data + "/n";
        return ret;
    }

    public int getSum() {
        return __getSum(root);
    }

    private int __getSum(Node n) {
        int ret = 0;
        if (n == null) {
            return ret;
        }
        ret += n.data;
        ret += __getSum(n.left);
        ret += __getSum(n.right);
        return ret;
    }

    public int height() {
        return __height(root);
    }

    private int __height(Node n) {
        if (n == null) {
            return 0;
        } else {
            int rightHeight = __height(n.right);
            int leftHeight = __height(n.left);

            if (rightHeight > leftHeight) {
                return rightHeight + 1;
            } else {
                return leftHeight + 1;
            }
        }
    }

    public int findMax() {
        return _findMax(root);

    }

    private int _findMax(Node n) {
        if (n == null)
            return Integer.MIN_VALUE;
        int rootValue = n.data;
        int leftPart = _findMax(n.left);
        int rightPart = _findMax(n.right);
        return Math.max(Math.max(rootValue, leftPart), rightPart);
    }

    public int findMin() {
        return _findMin(root);

    }

    private int _findMin(Node n) {
        if (n == null)
            return Integer.MIN_VALUE;
        int rootValue = n.data;
        int leftPart = _findMin(n.left);
        int rightPart = _findMin(n.right);
        return Math.min(Math.min(rootValue, leftPart), rightPart);
    }
}
