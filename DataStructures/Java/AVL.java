public class AVL {
  private class Node {
    int key;
    int height;
    Node left;
    Node right;

    public Node(int k) {
      key = k;
      height = 1;
    }
  }

  Node root;

  int height(Node N) {
    if (N == null)
      return 0;
    return N.height;
  }

  Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;

    x.right = y;
    y.left = T2;

    // Update heights
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;

    return x;
  }

  int max(int a, int b) {
    if (a > b) {
      return a;
    }
    return b;
  }

  Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    y.left = x;
    x.right = T2;

    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  int getBalance(Node N) {
    if (N == null) {
      return 0;
    }
    return height(N.left) - height(N.right);
  }

  Node insert(Node node, int key) {
    if (node == null) {
      return (new Node(key));
    }
    if (key < node.key) {
      node.left = insert(node.left, key);
    } else if (key > node.key) {
      node.right = insert(node.left, key);
    } else {
      return node;
    }

    node.height = 1 + max(height(node.left), height(node.right));
    int balance = getBalance(node);

    // If this node becomes unbalanced, 4 criteria
    if (balance > 1 && key < node.left.key)
      return rightRotate(node);

    // RR criteria
    if (balance < -1 && key > node.right.key)
      return leftRotate(node);

    // LR criteria
    if (balance > 1 && key > node.left.key) {
      node.left = leftRotate(node.left);
      return rightRotate(node);
    }

    // RL criteria
    if (balance < -1 && key < node.right.key) {
      node.right = rightRotate(node.right);
      return leftRotate(node);
    }
    return node;
  }

  Node minValueNode(Node node) {
    Node current = node;

    while (current.left != null)
      current = current.left;

    return current;
  }

  Node deleteNode(Node root, int key) {
    // implementing bst delete
    if (root == null)
      return root;

    // If the key is smaller than root's key, left subtree
    if (key < root.key)
      root.left = deleteNode(root.left, key);

    // If the key is greater than root's key, right subtree
    else if (key > root.key)
      root.right = deleteNode(root.right, key);

    // if key is same as root's key, the node is deleted
    else {
      if ((root.left == null) || (root.right == null)) {
        Node temp = null;
        if (temp == root.left)
          temp = root.right;
        else
          temp = root.left;
        if (temp == null) {
          temp = root;
          root = null;
        } else
          root = temp;
      } else {
        Node temp = minValueNode(root.right);
        root.key = temp.key;
        root.right = deleteNode(root.right, temp.key);
      }
    }

    // If the tree had only one node then return
    if (root == null)
      return root;

    // update height of current node
    root.height = max(height(root.left), height(root.right)) + 1;

    // find the balance factor
    int balance = getBalance(root);

    // If this node becomes unbalanced, then there are 4 criteria
    // LL criteria
    if (balance > 1 && getBalance(root.left) >= 0)
      return rightRotate(root);

    // LR criteria
    if (balance > 1 && getBalance(root.left) < 0) {
      root.left = leftRotate(root.left);
      return rightRotate(root);
    }

    // RR criteria
    if (balance < -1 && getBalance(root.right) <= 0)
      return leftRotate(root);

    // RiL criteria
    if (balance < -1 && getBalance(root.right) > 0) {
      root.right = rightRotate(root.right);
      return leftRotate(root);
    }

    return root;
  }
}
