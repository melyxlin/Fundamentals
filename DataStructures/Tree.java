import java.util.LinkedList;
public class Trees
{
    public Node root;
    private class Node
    {
        private static final LinkedList LINKED_LIST = new LinkedList();
		private int data;
        private LinkedList<Node> children;

        public Node(int d)
        {
            data = d;
            children = LINKED_LIST;
        }

        public addChild(Node child)
        {
            children.add(child);
        }
    }

    public String printPreOrder()
    {
        return __printPreOrder(root, 0);
    }

    private String __printPreOrder(Node n, int depth)
    {
        String ret = "";
        int i = 0;
        while (i < depth)
        {
            ret += " ";
            i++;
        }

        ret += n.data + "/n";
        for (Node child : n.children)
        {
            ret += __printPreOrder(child, depth + 1);
        }
        return ret;
        
    }

    public String __printPostOrder()
    {
        return __printPostOrder(root, 0);
    }

    private String __printPostOrder(Node n, int depth)
    {
        String ret = "";
        for (Node child : n.children)
        {
            ret += __printPostOrder(child, depth + 1);
        }
        int i = 0;
        while (i < depth)
        {
            ret += " ";
            i++;
        }
        ret += n.data + "/n";
        return ret;
    }
}