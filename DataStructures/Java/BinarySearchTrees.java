public class BinarySearchTrees {
    public Node root;

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

    public void add(int item) {
        root = __add(root, item);
    }

    private void __add(Node n, int item) {
        Node newNode = new Node(item);
        if (n == null) {
            n = newNode;
        }
        if (item < n.data) {
            __add(n.left, item);
        } else {
            __add(n.right, item);
        }
    }

    public int search(int item) {
        return __search(n, item);
    }

    private int __search(Node n, int item) {
        if (n == null) {
            return null;
        } else if (n.data == item) {
            return item;
        } else if (item < n.data) {
            return __search(n.left, item);
        } else {
            return __search(n.right, item);
        }
    }

    public int findMax() {
        if (root == null) {
            return null;
        }
        int max = root.data;
        Node currentNode = root.right;
        while (currentNode != null) {
            max = currentNode.data;
            currentNode = currentNode.right;
        }
        return max;
    }

    public int findMin() {
        if (root == null) {
            return null;
        }
        int min = root.data;
        Node currentNode = root.left;
        while (currentNode != null) {
            min = currentNode.data;
            currentNode = currentNode.left;
        }
        return min;
    }
}