import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Tree {
    public Node root;

    private class Node {
        private int data;
        private LinkedList<Node> children;

        public Node(int d) {
            data = d;
        }

        public void addChild(Node child)
        {
            children.add(child);
        }
    }

    public String printPreOrder() {
        return __printPreOrder(root, 0);
    }

    private String __printPreOrder(Node n, int depth) {
        String ret = "";
        int i = 0;
        while (i < depth) {
            ret += " ";
            i++;
        }

        ret += n.data + "/n";
        for (Node child : n.children) {
            ret += __printPreOrder(child, depth + 1);
        }
        return ret;

    }

    public String __printPostOrder() {
        return __printPostOrder(root, 0);
    }

    private String __printPostOrder(Node n, int depth) {
        String ret = "";
        for (Node child : n.children) {
            ret += __printPostOrder(child, depth + 1);
        }
        int i = 0;
        while (i < depth) {
            ret += " ";
            i++;
        }
        ret += n.data + "/n";
        return ret;
    }

    public Iterator iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator {
        private Stack<Node> s;

        public TreeIterator() {
            if (root != null) {
                s.push(root);
            }
        }

        public boolean hasNext()
        {
            if(s.isEmpty())
            {
                return false;
            }
            return true;
        }

        public Object next() {
            if (hasNext()) {
                Node ret = s.pop();
                for (Node child : ret.children) {
                    s.push(child);
                }
                return ret.data;
            } else {
                return 0;
            }
        }
    }
}