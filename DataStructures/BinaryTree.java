public class BinaryTree
{
    Node root;

    private class Node
    {
        private int data;
        private Node right;
        private Node left;

        public Node(int d)
        {
            this.data = d;
            this.right = null;
            this.left = null;
        }
    }

    public String printPreOrder()
    {
        return __printPreOrder(root, 0);
    }

    private String printPreOrder(Node n, int depth)
    {
        String ret = "";
        if (n == null)
        {
            return ret;
        }
        int i = 0;
        while (i < depth)
        {
            ret += " ";
            i++;
        }
        ret += n.data + "/n";
        ret += __prinPreOrder(n.left, depth + 1);
        ret += __printPreOrder(n.right, depth + 1);
        return ret;
    }

    public String printPostOrder()
    {
        return __printPostOrder(root ,0);
    }

    private __String printPostOrder(Node n, int depth)
    {
        String ret = "";
        if(n == null)
        {
            return ret;
        }
        ret += __printPostOrder(n.left, depth + 1);
        ret += __printPostOrder(n.right, depth + 1);

        int i = 0;
        while (i < depth)
        {
            ret += " ";
            i++;
        }
        ret += n.data + "/n";
        return ret;
    }

    public int getSum()
    {
        return __getSum(root);
    }

    private int __getSum(Node n)
    {
        int ret = 0;
        if (n == null)
        {
            return ret;
        }
        ret += n.data;
        ret += __getSum(n.left);
        ret += __getSum(n.right);
        return ret;
    }
}
