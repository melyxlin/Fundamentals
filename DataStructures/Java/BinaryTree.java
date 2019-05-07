import java.util.Iterator;
import java.util.Stack;

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

    public int height()
    {
        return __height(root);
    }

    private int __height(Node n)
    {
        if (n == null)
        {
            return 0;
        }
        else
        {
            rightHeight = __height(n.right);
            leftHeight = __height(n.left);

            if(rightHeight > leftHeight)
            {
                return rightHeight + 1;
            }
            else
            {
                return leftHeight + 1;
            }
        }
    }

    public int findMax()
	{
		return _findMax(root);
		
	}

	private int _findMax(Node n)
	{
		if (n==null)
			return Integer.MIN_VALUE;
		int rootValue=n.data;
		int leftPart=_findMax(n.left);
		int rightPart=_findMax(n.right);
		return Math.max(Math.max(rootValue, leftPart),rightPart);
	}
	

    public Iterator iterator()
    {
        return new BinaryTreeIterator();
    }

    private class BinaryTreeIterator implements Iterable
    {
        private Stack<Node> s;
        public BinaryTreeIterator()
        {
            if (root != null)
            {
                s.push(root);
            }
        }

        public boolean hasNext()
        {
            if (s.isEmpty())
            {
                return false;
            }
            return true;
        }

        public int next()
        {
            if (hasNext())
            {
                Node ret = s.pop();
                if(ret.right != null)
                {
                    s.push(ret.right);
                }
                if(ret.left != null)
                {
                    s.push(r.left);
                }
                return ret.data;
            }
            return null;
        }
    }
}
